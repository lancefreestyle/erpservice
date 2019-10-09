package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.ProductGroupService;
import com.capgemini.cn.erpmanage.service.ReconciliationRuleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
@RestController
@RequestMapping("/reconciliationRule")
public class ReconciliationRuleResource {

    @Autowired
    private ReconciliationRuleService reconciliationRuleService;

    @ApiOperation(value = "listAll")
    @GetMapping(value = "listAll", produces = "application/json")
    public DataResponse list() {
        return reconciliationRuleService.list();
    }

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<List<ReconciliationRuleVo>> list(
            @RequestParam(value = "page", required = true) int page,
            @RequestParam(value = "size", required = true) int size,
            @RequestParam(value = "ruleCode", required = false) String ruleCode) {
        ReconciliationRuleQueryVo queryVo = new ReconciliationRuleQueryVo();
        queryVo.setPage(page);
        queryVo.setSize(size);
        queryVo.setRuleCode(ruleCode);
        return reconciliationRuleService.queryByRuleCode(queryVo);
    }

    @ApiOperation(value = "/create")
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public DataResponse create(
            @ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid ReconciliationRuleVo vo) {
        return reconciliationRuleService.add(vo);
    }

    @ApiOperation(value = "delete")
    @PostMapping(value = "delete", produces = "application/json")
    public DataResponse delete(
            @RequestParam(value = "id", required = false) String id) {
        return reconciliationRuleService.delete(id);
    }
}
