package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.DataTemplateService;
import com.capgemini.cn.erpmanage.service.SourceSystemService;
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
        // TODO
        return null;
    }

    // 会计分摊规则查询接口
    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<AccountingShareRuleVo> list() {
        AccountingShareRuleVo vo = new AccountingShareRuleVo();
        // TODO
        DataResponse<AccountingShareRuleVo> result = new DataResponse<AccountingShareRuleVo>();
        result.setResponse(vo);
        return result;
    }

    // 会计分摊规则删除接口
    @ApiOperation(value = "delete/{id}")
    @DeleteMapping(value = "delete", produces = "application/json")
    public DataResponse delete(
            @PathVariable(value = "id", required = true) String id) {
        // TODO
        return dataTemplateService.delete(id);
    }
}
