package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.BusinessTypeEntity;
import com.capgemini.cn.erp.domain.SourceSystemEntity;
import com.capgemini.cn.erp.domain.SystemBusinessTypeEntity;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.*;
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
    @Autowired
    private ConditionService conditionService;
    @Autowired
    private AmountCalculationService amountCalculationService;
    @Autowired
    private PartnerGroupService partnerGroupService;
    @Autowired
    private ProductGroupService productGroupService;

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<RevenueShareRuleQueryOutVo> list() {
        RevenueShareRuleQueryOutVo vo = new RevenueShareRuleQueryOutVo();

        List<SystemBusinessTypeVo> systemBusinessTypeVos = sourceSystemService.alllist().getResponse();
        vo.setSystemBusinessTypeVos(systemBusinessTypeVos);

        List<DataTemplateVo> dataTemplateVos = dataTemplateService.list(new DataTemplateQueryVo()).getResponse();
        vo.setDataTemplateVos(dataTemplateVos);

        List<ConditionVo>  conditionVos= conditionService.list(new ConditionQueryVo()).getResponse();
        vo.setConditionVos(conditionVos);

        List<AmountCalculationVo> amountCalculationVos  = amountCalculationService.list(new AmountCalculationQueryVo()).getResponse();
        vo.setAmountCalculationVos(amountCalculationVos);

        List<PartnerGroupVo> partnerGroupVos = partnerGroupService.list(new PartnerGroupQueryVo()).getResponse();
        vo.setPartnerGroupVos(partnerGroupVos);

        List<ProductGroupVo> productGroupVos = productGroupService.list(new ProductGroupQueryVo()).getResponse();
        vo.setProductGroupVos(productGroupVos);

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
