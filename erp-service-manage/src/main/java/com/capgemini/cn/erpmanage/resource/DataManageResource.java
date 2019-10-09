package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.DataManageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dataManage")
public class DataManageResource extends BaseController {

    @Autowired
    DataManageService dataManageService;

    @ApiOperation(value = "list")
    @GetMapping(value = "list", produces = "application/json")
    public DataResponse<List<DataManageVo>> list(@RequestParam(value = "page", required = true) int page,
                                                 @RequestParam(value = "size", required = true) int size,
                                                 @RequestParam(value = "sysCode", required = false) String sysCode,
                                                 @RequestParam(value = "templateCode", required = false) String templateCode) {
        DataManageQueryVo dataManageQueryVo = new DataManageQueryVo();
        dataManageQueryVo.setPage(page);
        dataManageQueryVo.setSize(size);
        dataManageQueryVo.setSysCode(sysCode);
        dataManageQueryVo.setTemplateCode(templateCode);
        return dataManageService.list(dataManageQueryVo);
    }

    @ApiOperation(value = "updateStatus")
    @PostMapping(value = "updateStatus", consumes = "application/json", produces = "application/json")
    public DataResponse updateStatus(
            @ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid DataManageUpdateStatusVo dataManageUpdateStatusVo) {
        return dataManageService.updateStatus(dataManageUpdateStatusVo);
    }

    @ApiOperation(value = "transferSap")
    @PostMapping(value = "transferSap", consumes = "application/json", produces = "application/json")
    public DataResponse<DataManageSapResponseVo> transferSap(
            @ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid SapTransferVo sapTransferVo) {
        return dataManageService.transferSap(sapTransferVo);
    }

    @ApiOperation(value = "subjectPreview")
    @GetMapping(value = "subjectPreview", produces = "application/json")
    public DataResponse<List<DataManageItemVo>> subjectPreview(@RequestParam("id") String id) {
        return dataManageService.subjectPreview(id);
    }

}
