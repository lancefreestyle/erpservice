package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.AccountingShareRuleVo;
import com.capgemini.cn.erp.vo.RuleTypeVo;
import com.capgemini.cn.erp.vo.SystemBusinessTypeVo;
import com.capgemini.cn.erpmanage.service.AccountingShareRuleService;
import com.capgemini.cn.erpmanage.service.RevenueSaleDataService;
import com.capgemini.cn.erpmanage.service.RuleTypeService;
import com.capgemini.cn.erpmanage.service.SourceSystemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/source-system")
public class SourceSystemResource {

    @Autowired
    private SourceSystemService sourceSystemService;
    @Autowired
    private RuleTypeService ruleTypeService;

    @Autowired
    AccountingShareRuleService accountingShareRuleService;
    @Autowired
    RevenueSaleDataService revenueSaleDataService;

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<List<SystemBusinessTypeVo>> allList() {

        return sourceSystemService.alllist();
    }

    @ApiOperation(value = "deleteAsr")
    @PostMapping(value = "addsharerule", produces = "application/json", consumes = "application/json")
    public DataResponse<String> addShareRule(@RequestBody AccountingShareRuleVo shareRuleVo) {

        return accountingShareRuleService.save(shareRuleVo);
    }

    /*****此处都是测试接口****/
    @ApiOperation(value = "allList")
    @GetMapping(value = "allList", produces = "application/json")
    public DataResponse<List<RuleTypeVo>> typeAllList() {

        DataResponse<List<RuleTypeVo>> response = new DataResponse<>();
        response.setResponse(ruleTypeService.allList());
        return response;
    }

    @ApiOperation(value = "asrlist")
    @GetMapping(value = "asrlist", produces = "application/json")
    public DataResponse<List<AccountingShareRuleVo>> asrList() {

        List<AccountingShareRuleVo> shareRuleVos = accountingShareRuleService.selectList();
        DataResponse<List<AccountingShareRuleVo>> response = new DataResponse<>();
        response.setResponse(shareRuleVos);
        return response;
    }

    @ApiOperation(value = "deleteAsr")
    @GetMapping(value = "deleteAsr", produces = "application/json")
    public DataResponse<String> deleteAsr(String id) {


        return accountingShareRuleService.delete(id);
    }






}
