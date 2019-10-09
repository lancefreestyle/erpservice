package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataPage;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.erp.domain.DataManage;
import com.capgemini.cn.erp.domain.DataManageItem;
import com.capgemini.cn.erp.domain.QDataManage;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.DataManageService;
import com.capgemini.cn.erpmanage.util.HttpClientUtil;
import com.google.gson.Gson;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class DataManageServiceImpl implements DataManageService {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;

    private QDataManage qDataManage = QDataManage.dataManage;

    private Gson gson = new Gson();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    @Transactional
    public DataResponse<List<DataManageVo>> list(DataManageQueryVo dataManageQueryVo) {
        DataResponse<List<DataManageVo>> result = new DataResponse<List<DataManageVo>>();
        JPAQuery<DataManage> query = new JPAQuery<DataManage>(em).from(qDataManage);
        Long totalRec = query.fetchCount();
        int offset = dataManageQueryVo.getPage() * dataManageQueryVo.getSize();
        query.offset(offset).limit(dataManageQueryVo.getSize());
        List<DataManage> list = query.fetch();
        List<DataManageVo> resultList = new ArrayList<DataManageVo>();
        if (list != null && list.size() > 0) {
            DataManageVo vo = null;
            for (DataManage entity : list) {
                vo = new DataManageVo();
                BeanUtils.copyProperties(entity, vo);
                resultList.add(vo);
            }
        }

        result.setDataStatus(DataStatus.SUCCESS);
        DataPage page = new DataPage();
        page.setTotalElements(totalRec);
        result.setPages(page);
        result.setResponse(resultList);
        return result;
    }

    @Override
    @Transactional
    public DataResponse updateStatus(DataManageUpdateStatusVo dataManageUpdateStatusVo) {
        JPAQuery<DataManage> query = new JPAQuery<DataManage>(em).from(qDataManage).where(qDataManage.id.eq(dataManageUpdateStatusVo.getId()));
        DataManage entity = query.fetchOne();
        entity.setStatus(dataManageUpdateStatusVo.getStatus());
        em.merge(entity);
        return new DataResponse();
    }

    private  String getTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(now);
    }

    @Override
    @Transactional
    public DataResponse<DataManageSapResponseVo> transferSap(SapTransferVo sapTransferVo) {
        DataResponse<DataManageSapResponseVo> dataManageSapResponseVoDataResponse = new DataResponse<DataManageSapResponseVo>();
        DataManageSapResponseVo dataManageSapResponseVo = new DataManageSapResponseVo();
        dataManageSapResponseVo.setSapCertificateCode("");
        JPAQuery<DataManage> query = new JPAQuery<DataManage>(em).from(qDataManage).where(qDataManage.id.eq(sapTransferVo.getId()));
        DataManage entity = query.fetchOne();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type","application/json");
        requestHeaders.add("Accept","application/json");
        requestHeaders.add("X-Requested-With","XMLHttpRequest");
        String url = "http://54.223.80.88:8700/sap/opu/odata/sap/ZHQYC_FI0001_SRV/HeadSet";
        DataManageSapRequestVo dataManageSapRequestVo = new DataManageSapRequestVo();
        List<DataManageItem> dataManageItems = entity.getDataManageItems();
        if(!CollectionUtils.isEmpty(dataManageItems)){
            String now = getTime();
            dataManageSapRequestVo.setMsgty("");
            dataManageSapRequestVo.setBelnr("");
            dataManageSapRequestVo.setGjahr("");
            dataManageSapRequestVo.setBldat(now);
            dataManageSapRequestVo.setBlart("SA");
            dataManageSapRequestVo.setBukrs("MB01");
            dataManageSapRequestVo.setBudat(now);
            dataManageSapRequestVo.setWaers("CNY");
            dataManageSapRequestVo.setBktxt("抬头文本1");
            List<SapRequestVoItem> head2ItemList = new ArrayList<SapRequestVoItem>();
            for(DataManageItem dataManageItem: dataManageItems){
                SapRequestVoItem sapRequestVoItem = new SapRequestVoItem();
                if(!StringUtils.isEmpty(dataManageItem.getDebitNum())){
                    sapRequestVoItem.setShkzg("S");
                    sapRequestVoItem.setWrbtr(dataManageItem.getDebitNum());
                }else{
                    sapRequestVoItem.setShkzg("H");
                    sapRequestVoItem.setWrbtr(dataManageItem.getCreditNum());
                }
                if("12100000".equals(dataManageItem.getAccountCode()) || "21100000".equals(dataManageItem.getAccountCode())){
                    sapRequestVoItem.setHkont("");
                }else{
                    sapRequestVoItem.setHkont(dataManageItem.getAccountCode());
                }

                sapRequestVoItem.setLifnr("");
                if(!StringUtils.isEmpty(dataManageItem.getSupplyCode())){
                    sapRequestVoItem.setLifnr(dataManageItem.getSupplyCode());
                }
                sapRequestVoItem.setKunnr("");
                if(!StringUtils.isEmpty(dataManageItem.getClientCode())){
                    sapRequestVoItem.setKunnr(dataManageItem.getClientCode());
                }
                sapRequestVoItem.setSaknr("");
                sapRequestVoItem.setSgtxt(dataManageItem.getSummaryName());
                String kemu = dataManageItem.getAccountCode();
                String[] kemuList = {"51000000","61500000","41000001","41000002","41000003"};
                boolean match = false;
                for(String str :kemuList){
                    if(str.equals(kemu)){
                        match = true;
                        break;
                    }
                }
                if(match){
                    sapRequestVoItem.setKostl("MB01");
                }else{
                    sapRequestVoItem.setKostl("");
                }
                sapRequestVoItem.setPrctr("");
                sapRequestVoItem.setGsber("");
                head2ItemList.add(sapRequestVoItem);
            }
            dataManageSapRequestVo.setHead2Item(head2ItemList);

        }else{
            dataManageSapRequestVo.setMsgty("");
            dataManageSapRequestVo.setBelnr("");
            dataManageSapRequestVo.setGjahr("");
            dataManageSapRequestVo.setBldat("20190720");
            dataManageSapRequestVo.setBlart("SA");
            dataManageSapRequestVo.setBukrs("MB01");
            dataManageSapRequestVo.setBudat("20190720");
            dataManageSapRequestVo.setWaers("CNY");
            dataManageSapRequestVo.setBktxt("抬头文本1");
            List<SapRequestVoItem> head2ItemList = new ArrayList<SapRequestVoItem>();
            SapRequestVoItem sapRequestVoItem = new SapRequestVoItem();
            sapRequestVoItem.setShkzg("S");
            sapRequestVoItem.setHkont("6001000001");
            sapRequestVoItem.setLifnr("");
            sapRequestVoItem.setKunnr("");
            sapRequestVoItem.setSaknr("");
            sapRequestVoItem.setWrbtr("1320.76");
            sapRequestVoItem.setSgtxt("123");
            sapRequestVoItem.setKostl("");
            sapRequestVoItem.setPrctr("");
            sapRequestVoItem.setGsber("");
            head2ItemList.add(sapRequestVoItem);
            sapRequestVoItem = new SapRequestVoItem();
            sapRequestVoItem.setShkzg("H");
            sapRequestVoItem.setHkont("22000000");
            sapRequestVoItem.setLifnr("");
            sapRequestVoItem.setKunnr("");
            sapRequestVoItem.setSaknr("");
            sapRequestVoItem.setWrbtr("100");
            sapRequestVoItem.setSgtxt("");
            sapRequestVoItem.setKostl("");
            sapRequestVoItem.setPrctr("");
            sapRequestVoItem.setGsber("");
            head2ItemList.add(sapRequestVoItem);
            sapRequestVoItem = new SapRequestVoItem();
            sapRequestVoItem.setShkzg("H");
            sapRequestVoItem.setHkont("");
            sapRequestVoItem.setLifnr("");
            sapRequestVoItem.setKunnr("ZZ0001");
            sapRequestVoItem.setSaknr("");
            sapRequestVoItem.setWrbtr("1220.76");
            sapRequestVoItem.setSgtxt("");
            sapRequestVoItem.setKostl("");
            sapRequestVoItem.setPrctr("");
            sapRequestVoItem.setGsber("");
            head2ItemList.add(sapRequestVoItem);
            dataManageSapRequestVo.setHead2Item(head2ItemList);
        }
        String body = gson.toJson(dataManageSapRequestVo);
        log.info("sap request:{}", body);
        ResponseEntity response = null;
        int httpCode = 0;
        dataManageSapResponseVoDataResponse.setDataStatus(DataStatus.BUSINESS_ERROR);
        try {
            response = HttpClientUtil.doPost(url, requestHeaders, body, "application/json");
            httpCode = response.getStatusCode().value();
            if(HttpStatus.CREATED.value() == httpCode){
                String resBody = response.getBody().toString();
                log.info("sap response:{}", resBody);
                JSONObject obj = new JSONObject(resBody);
                String sapCode = obj.getJSONObject("d").getString("Belnr");
                String sapFlag = obj.getJSONObject("d").getString("Msgty");
                if("S".equals(sapFlag)){
                    dataManageSapResponseVoDataResponse.setDataStatus(DataStatus.SUCCESS);
                    dataManageSapResponseVo.setSapCertificateCode(sapCode);
                    DataManageUpdateStatusVo dataManageUpdateStatusVo = new DataManageUpdateStatusVo();
                    entity.setStatus("凭证传送成功");
                    entity.setCertificateCode(sapCode);
                    em.merge(entity);
                }else{
                    entity.setStatus("凭证传送失败");
                    em.merge(entity);
                }
            }


        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        dataManageSapResponseVoDataResponse.setResponse(dataManageSapResponseVo);
        return dataManageSapResponseVoDataResponse;
    }

    @Override
    public DataResponse<List<DataManageItemVo>> subjectPreview(String id) {
        DataResponse<List<DataManageItemVo>> result = new DataResponse<>();
        JPAQuery<DataManage> query = new JPAQuery<DataManage>(em).from(qDataManage).where(qDataManage.id.eq(id));
        DataManage entity = query.fetchOne();
        List<DataManageItemVo> vos = new ArrayList<>();
        if (entity != null && !CollectionUtils.isEmpty(entity.getDataManageItems())) {
            for (DataManageItem item : entity.getDataManageItems()) {
                DataManageItemVo vo = new DataManageItemVo();
                BeanUtils.copyProperties(item, vo);
                vos.add(vo);
            }
        }
        result.setDataStatus(DataStatus.SUCCESS);
        result.setResponse(vos);
        return result;
    }

}
