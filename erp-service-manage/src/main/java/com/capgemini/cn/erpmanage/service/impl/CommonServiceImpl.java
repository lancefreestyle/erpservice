package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.erp.domain.*;
import com.capgemini.cn.erp.vo.CommonResponseVo;
import com.capgemini.cn.erpmanage.service.CommonService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;

    private QSystemConstant qSystemConstant = QSystemConstant.systemConstant;
    private QMapStructure qMapStructure = QMapStructure.mapStructure;
    private QMapValue qMapValue = QMapValue.mapValue;
    private QDataTemplate qDataTemplate = QDataTemplate.dataTemplate;
    private QDataTemplateItem qDataTemplateItem = QDataTemplateItem.dataTemplateItem;


    private Gson gson = new Gson();
    ;

    @Override
    @Transactional
    public DataResponse<List<CommonResponseVo>> queryListByMapId(String mapCode) {
        DataResponse<List<CommonResponseVo>> result = new DataResponse<>();

        JPAQuery<MapStructure> query = new JPAQuery<MapStructure>(em).from(qMapStructure);
        if(!StringUtils.isEmpty(mapCode)){
            query.where(qMapStructure.id.eq(mapCode));
        }
        MapStructure mapStructure = query.fetchOne();
        List<MapValue> list = mapStructure.getMapValues();
        List<CommonResponseVo> resultList = new ArrayList<CommonResponseVo>();
        if (!CollectionUtils.isEmpty(list)) {
            CommonResponseVo vo = null;
            for (MapValue entity : list) {
                vo = new CommonResponseVo();
                vo.setCode(entity.getId());
                vo.setName(entity.getName());
                resultList.add(vo);
            }
        }
        result.setDataStatus(DataStatus.SUCCESS);
        result.setResponse(resultList);
        return result;
    }

    @Override
    @Transactional
    public DataResponse<List<CommonResponseVo>> queryMapList(String templatecode) {
        DataResponse<List<CommonResponseVo>> result = new DataResponse<>();
        JPAQuery<MapStructure> query = new JPAQuery<MapStructure>(em).from(qMapStructure);
        if(!StringUtils.isEmpty(templatecode)){
            query.where(qMapStructure.templateId.eq(templatecode));
        }
        List<MapStructure> list = query.fetch();
        List<CommonResponseVo> resultList = new ArrayList<CommonResponseVo>();
        if (!CollectionUtils.isEmpty(list)) {
            CommonResponseVo vo = null;
            for (MapStructure entity : list) {
                vo = new CommonResponseVo();
                vo.setCode(entity.getId());
                vo.setName(entity.getName());
                resultList.add(vo);
            }
        }
        result.setDataStatus(DataStatus.SUCCESS);
        result.setResponse(resultList);
        return result;
    }

    private String getSysValueByKey(String key) {
        JPAQuery<SystemConstant> query = new JPAQuery<SystemConstant>(em).from(qSystemConstant).where(qSystemConstant.systemName.eq(key));
        SystemConstant entity = query.fetchOne();
        return entity.getSystemValue();
    }

    private DataResponse<List<CommonResponseVo>> queryValueBykey(String key) {
        DataResponse<List<CommonResponseVo>> listDataResponse = new DataResponse();
        List<CommonResponseVo> commonResponseVos = new ArrayList<CommonResponseVo>();
        String mapList = getSysValueByKey(key);
        if (!StringUtils.isEmpty(mapList)) {
            Type listType = new TypeToken<ArrayList<CommonResponseVo>>() {
            }.getType();
            commonResponseVos = gson.fromJson(mapList, listType);
        }
        listDataResponse.setResponse(commonResponseVos);
        return listDataResponse;
    }

    @Override
    @Transactional
    public DataResponse<List<CommonResponseVo>> queryOriginFiledsByTemplateId(String templatecode) {
        DataResponse<List<CommonResponseVo>> result = new DataResponse<>();

        JPAQuery<DataTemplateItem> query = new JPAQuery<DataTemplateItem>(em).from(qDataTemplateItem).where(qDataTemplateItem.dataTemplate.templateCode.eq(templatecode));
        query.where(qDataTemplateItem.fieldName.like("%VALUE%"));
        List<DataTemplateItem> list = query.fetch();
        List<CommonResponseVo> resultList = new ArrayList<CommonResponseVo>();
        if (!CollectionUtils.isEmpty(list)) {
            CommonResponseVo vo = null;
            for (DataTemplateItem entity : list) {
                vo = new CommonResponseVo();
                vo.setCode(entity.getFieldName());
                vo.setName(entity.getFieldTitle());
                resultList.add(vo);
            }
        }
        result.setDataStatus(DataStatus.SUCCESS);
        result.setResponse(resultList);
        return result;
    }

    @Override
    @Transactional
    public DataResponse<List<CommonResponseVo>> zifulist() {
        return queryValueBykey("zifulist");
    }

    @Override
    @Transactional
    public DataResponse<List<CommonResponseVo>> pingzhenglist() {
        return queryValueBykey("pingzhenglist");
    }

    @Override
    @Transactional
    public DataResponse<List<CommonResponseVo>> syslist() {
        return queryValueBykey("syslist");
    }

    @Override
    @Transactional
    public DataResponse<List<CommonResponseVo>> templatelist() {
        return queryValueBykey("templatelist");
    }
}
