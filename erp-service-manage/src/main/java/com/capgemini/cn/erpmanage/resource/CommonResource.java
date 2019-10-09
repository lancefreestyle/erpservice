package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.CommonResponseVo;
import com.capgemini.cn.erpmanage.service.CommonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonResource extends BaseController {

    @Autowired
    CommonService commonService;

    @ApiOperation(value = "queryListByMapId")
    @GetMapping(value = "queryListByMapId", produces = "application/json")
    public DataResponse<List<CommonResponseVo>> queryListByMapId(
            @RequestParam(value="mapCode",required = true) String mapCode) {
        return commonService.queryListByMapId(mapCode);
    }

    @ApiOperation(value = "queryMapList")
    @GetMapping(value = "queryMapList", produces = "application/json")
    public DataResponse<List<CommonResponseVo>> queryMapList(@RequestParam(value="templatecode",required = false) String templatecode) {
        return commonService.queryMapList(templatecode);
    }

    @ApiOperation(value = "queryOriginFiledsByTemplateId")
    @GetMapping(value = "queryOriginFiledsByTemplateId", produces = "application/json")
    public DataResponse<List<CommonResponseVo>> queryOriginFiledsByTemplateId(
            @RequestParam(value="templatecode",required = true) String templatecode) {
        return commonService.queryOriginFiledsByTemplateId(templatecode);
    }

    @ApiOperation(value = "zifulist")
    @GetMapping(value = "zifulist", produces = "application/json")
    public DataResponse<List<CommonResponseVo>> zifulist() {
        return commonService.zifulist();
    }

    @ApiOperation(value = "pingzhenglist")
    @GetMapping(value = "pingzhenglist", produces = "application/json")
    public DataResponse<List<CommonResponseVo>> pingzhenglist() {
        return commonService.pingzhenglist();
    }

    @ApiOperation(value = "syslist")
    @GetMapping(value = "syslist", produces = "application/json")
    public DataResponse<List<CommonResponseVo>> syslist() {
        return commonService.syslist();
    }

    @ApiOperation(value = "templatelist")
    @GetMapping(value = "templatelist", produces = "application/json")
    public DataResponse<List<CommonResponseVo>> templatelist() {
        return commonService.templatelist();
    }

}
