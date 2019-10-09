package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.AmountCalculationQueryVo;
import com.capgemini.cn.erp.vo.AmountCalculationVo;
import com.capgemini.cn.erp.vo.RevenueShareRuleQueryOutVo;
import com.capgemini.cn.erp.vo.RevenueShareRuleVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/revenueShareRule")
public class RevenueShareRuleResource extends BaseController {

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<RevenueShareRuleQueryOutVo> list() {
        // TODO service
        return null;
    }

    @ApiOperation(value = "create")
    @PostMapping(value = "create", consumes = "application/json", produces = "application/json")
    public DataResponse create(
            @ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid RevenueShareRuleVo vo ) {
        // TODO service
        return null;
    }
}
