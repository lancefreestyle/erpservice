package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accountingShareRuleResource")
public class AccountingShareRuleResource extends BaseController {

    @Autowired
    private SourceSystemService sourceSystemService;
    @Autowired
    private DataTemplateService dataTemplateService;
    @Autowired
    private AccountingShareRuleService accountingShareRuleService;

    @ApiOperation(value = "init")
    @GetMapping(value = "init", produces = "application/json")
    public DataResponse<AccountingShareRuleInitVo> init() {
        AccountingShareRuleInitVo vo = new AccountingShareRuleInitVo();

        List<SystemBusinessTypeVo> systemBusinessTypeVos = sourceSystemService.alllist().getResponse();
        vo.setSystemBusinessTypeVos(systemBusinessTypeVos);

        List<DataTemplateVo> dataTemplateVos = dataTemplateService.listAll().getResponse();
        vo.setDataTemplateVos(dataTemplateVos);

        DataResponse<AccountingShareRuleInitVo> result = new DataResponse<AccountingShareRuleInitVo>();
        result.setResponse(vo);
        return result;
    }

    @ApiOperation(value = "create")
    @PostMapping(value = "create", consumes = "application/json", produces = "application/json")
    public DataResponse create(
            @ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid AccountingShareRuleVo vo) {
        return accountingShareRuleService.save(vo);
    }

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<List<AccountingShareRuleVo>> list() {
        List<AccountingShareRuleVo> accountingShareRuleVos = accountingShareRuleService.selectList();
        DataResponse<List<AccountingShareRuleVo>> result = new DataResponse<List<AccountingShareRuleVo>>();
        result.setResponse(accountingShareRuleVos);
        return result;
    }

    @ApiOperation(value = "delete/{id}")
    @DeleteMapping(value = "delete/{id}", produces = "application/json")
    public DataResponse delete(
            @PathVariable(value = "id", required = true) String id) {
        return accountingShareRuleService.delete(id);
    }
}
