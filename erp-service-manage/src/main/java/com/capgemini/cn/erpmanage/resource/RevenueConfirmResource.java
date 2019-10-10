package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.core.utils.StringUtil;
import com.capgemini.cn.erp.domain.ProductGroup;
import com.capgemini.cn.erp.domain.ProductGroupItem;
import com.capgemini.cn.erp.domain.RevenueSaleDataEntity;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.ProductGroupItemService;
import com.capgemini.cn.erpmanage.service.ProductGroupService;
import com.capgemini.cn.erpmanage.service.RevenueSaleDataService;
import com.capgemini.cn.erpmanage.service.SourceSystemService;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/revenueConfirmResource")
public class RevenueConfirmResource {

    @Autowired
    private SourceSystemService sourceSystemService;
    @Autowired
    private ProductGroupService productGroupService;
    @Autowired
    private ProductGroupItemService productGroupItemService;
    @Autowired
    private RevenueSaleDataService revenueSaleDataService;

    @ApiOperation(value = "init")
    @GetMapping(value = "init", produces = "application/json")
    public DataResponse<RevenueConfirmInitVo> init() {
        RevenueConfirmInitVo vo = new RevenueConfirmInitVo();

        List<SystemBusinessTypeVo> systemBusinessTypeVos = sourceSystemService.alllist().getResponse();
        vo.setSystemBusinessTypeVos(systemBusinessTypeVos);

        List<ProductGroupVo> productGroupVos = productGroupService.list(new ProductGroupQueryVo()).getResponse();
        vo.setProductGroupVos(productGroupVos);

        List<ProductGroupItemVo> productGroupItemVos = productGroupItemService.selectList();
        vo.setProductGroupItemVos(productGroupItemVos);

        DataResponse<RevenueConfirmInitVo> result = new DataResponse<RevenueConfirmInitVo>();
        result.setResponse(vo);
        return result;
    }

    @ApiOperation(value = "get")
    @GetMapping(value = "get", produces = "application/json")
    public DataResponse<List<RevenueSaleDataVo>> get() {
        List<RevenueSaleDataVo> revenueSaleDataVos = Lists.newArrayList();
        revenueSaleDataService.selectAll().forEach(entity -> {
            RevenueSaleDataVo vo = new RevenueSaleDataVo();
            BeanUtils.copyProperties(entity, vo, "systemBusinessTypeId","productGroupId","productGroupItemId");
            if(StringUtil.isNotBlank(entity.getSystemBusinessTypeId())) {
                SystemBusinessTypeVo systemBusinessTypeVo = sourceSystemService.getById(entity.getSystemBusinessTypeId()).getResponse();
                vo.setSystemBusinessTypeVo(systemBusinessTypeVo);
            }

            if(StringUtil.isNotBlank(entity.getProductGroupId())) {
                ProductGroup productGroup = productGroupService.queryById(entity.getProductGroupId());
                ProductGroupVo productGroupVo = new ProductGroupVo();
                BeanUtils.copyProperties(productGroup, productGroupVo);
                vo.setProductGroupVo(productGroupVo);
            }

            if(StringUtil.isNotBlank(entity.getProductGroupItemId())) {
                ProductGroupItem productGroupItem = productGroupService.queryItemById(entity.getProductGroupItemId());
                ProductGroupItemVo productGroupItemVo = new ProductGroupItemVo();
                BeanUtils.copyProperties(productGroupItem, productGroupItemVo);
                vo.setProductGroupItemVo(productGroupItemVo);
            }

            revenueSaleDataVos.add(vo);
        });
        DataResponse<List<RevenueSaleDataVo>> response = new DataResponse<List<RevenueSaleDataVo>>();
        response.setDataStatus(DataStatus.SUCCESS);
        response.setResponse(revenueSaleDataVos);
        return response;
    }
}
