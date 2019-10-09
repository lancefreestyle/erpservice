package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.DataTemplateQueryVo;
import com.capgemini.cn.erp.vo.DataTemplateVo;
import com.capgemini.cn.erpmanage.service.DataTemplateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dataTemplate")
public class DataTemplateResource extends BaseController {

    @Autowired
    DataTemplateService dataTemplateService;

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<List<DataTemplateVo>> list(@RequestParam(value = "page", required = true) int page,
                                                   @RequestParam(value = "size", required = true) int size,
                                                   @RequestParam(value = "sysCode", required = false) String sysCode,
                                                   @RequestParam(value = "templateCode", required = false) String templateCode) {
        DataTemplateQueryVo dataTemplateQueryVo = new DataTemplateQueryVo();
        dataTemplateQueryVo.setPage(page);
        dataTemplateQueryVo.setSize(size);
        dataTemplateQueryVo.setSysCode(sysCode);
        dataTemplateQueryVo.setTemplateCode(templateCode);
        return dataTemplateService.list(dataTemplateQueryVo);
    }

    @ApiOperation(value = "create")
    @PostMapping(value = "create", consumes = "application/json", produces = "application/json")
    public DataResponse create(
            @ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid DataTemplateVo dataTemplateVo) {
        return dataTemplateService.add(dataTemplateVo);
    }

    @ApiOperation(value = "update")
    @PostMapping(value = "update", consumes = "application/json", produces = "application/json")
    public DataResponse update(
            @ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid DataTemplateVo dataTemplateVo) {
        return dataTemplateService.update(dataTemplateVo);
    }

    @ApiOperation(value = "delete")
    @PostMapping(value = "delete", produces = "application/json")
    public DataResponse delete(
            @RequestParam(value = "id", required = true) String id) {
        return dataTemplateService.delete(id);
    }

    @ApiOperation(value = "detail")
    @GetMapping(value = "detail", produces = "application/json")
    public DataResponse<DataTemplateVo> detail(
            @RequestParam(value = "id", required = true) String id) {
        return dataTemplateService.detail(id);
    }


}
