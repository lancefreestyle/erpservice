package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.RuleTypeEntity;
import com.capgemini.cn.erp.domain.SystemBusinessTypeEntity;
import com.capgemini.cn.erpmanage.service.RuleTypeService;
import com.capgemini.cn.erpmanage.service.SourceSystemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/source-system")
public class SourceSystemResource {

    @Autowired
    private SourceSystemService sourceSystemService;
    @Autowired
    private RuleTypeService ruleTypeService;

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<List<SystemBusinessTypeEntity>> allList(){

        return sourceSystemService.allList();
    }
    @ApiOperation(value = "allList")
    @GetMapping(value = "allList", produces = "application/json")
    public DataResponse<List<RuleTypeEntity>> typeAllList(){


        return ruleTypeService.allList();
    }
}
