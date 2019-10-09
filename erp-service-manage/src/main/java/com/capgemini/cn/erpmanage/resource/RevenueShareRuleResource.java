package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.BusinessTypeEntity;
import com.capgemini.cn.erp.domain.SourceSystemEntity;
import com.capgemini.cn.erp.domain.SystemBusinessTypeEntity;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.DataTemplateService;
import com.capgemini.cn.erpmanage.service.SourceSystemService;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/revenueShareRule")
public class RevenueShareRuleResource extends BaseController {

    @Autowired
    private SourceSystemService sourceSystemService;
    @Autowired
    private DataTemplateService dataTemplateService;

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<RevenueShareRuleQueryOutVo> list() {
        RevenueShareRuleQueryOutVo vo = new RevenueShareRuleQueryOutVo();

        List<SystemBusinessTypeVo> systemBusinessTypeVos = sourceSystemService.alllist().getResponse();
        vo.setSystemBusinessTypeVos(systemBusinessTypeVos);

        List<DataTemplateVo> dataTemplateVos = dataTemplateService.list(new DataTemplateQueryVo()).getResponse();
        vo.setDataTemplateVos(dataTemplateVos);

        List<ConditionRuleVo> conditionRuleVos = Lists.newArrayList();
        List<AmountCalculationVo> amountCalculationVos = Lists.newArrayList();
        List<PartnerGroupVo> partnerGroupVos = Lists.newArrayList();
        List<ProductGroupVo> productGroupVos = Lists.newArrayList();

        DataResponse<RevenueShareRuleQueryOutVo> result = new DataResponse<RevenueShareRuleQueryOutVo>();
        result.setResponse(vo);
        return result;
    }

    @ApiOperation(value = "create")
    @PostMapping(value = "create", consumes = "application/json", produces = "application/json")
    public DataResponse create(
            @ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid RevenueShareRuleVo vo) {
        // TODO service
        return null;
    }
}
