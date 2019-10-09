package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.PartnerGroup;
import com.capgemini.cn.erp.domain.PartnerGroupItem;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.PartnerGroupItemService;
import com.capgemini.cn.erpmanage.service.PartnerGroupService;
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
@RequestMapping("/partnerGroup")
public class PartnerGroupResource extends BaseController {

    @Autowired
    private PartnerGroupService partnerGroupService;
    @Autowired
    private PartnerGroupItemService partnerGroupItemService;

    @ApiOperation(value = "/list")
    @PostMapping(value = "/list", produces = "application/json")
    public DataResponse<List<PartnerGroupVo>> list(
            @ApiParam(value = "jason对象", required = false) PartnerGroupQueryVo queryVo) {
        return partnerGroupService.list(queryVo);
    }

    @ApiOperation(value = "/create")
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public DataResponse create(
            @ApiParam(value = "接收数据参数", required = false) @RequestBody @Valid PartnerGroupVo partnerGroupVo) {
        return partnerGroupService.add(partnerGroupVo);
    }

    @ApiOperation(value = "update")
    @PostMapping(value = "update", consumes = "application/json", produces = "application/json")
    public DataResponse update(
            @ApiParam(value = "接收数据参数", required = false) @RequestBody @Valid PartnerGroupVo partnerGroupVo) {
        return partnerGroupService.update(partnerGroupVo);
    }

    /*@ApiOperation(value = "deleteItem")
    @PostMapping(value = "deleteItem", produces = "application/json")
    public DataResponse deleteItem(
            @ApiParam(value = "jason对象", required = true) @RequestBody PartnerGroup vo) {
        return partnerGroupService.delete(vo.getId());
    }*/

    @ApiOperation(value = "delete")
    @PostMapping(value = "delete", produces = "application/json")
    public DataResponse delete(
            @ApiParam(value = "jason对象", required = false) @RequestBody PartnerGroupItemVo vo) {
        return partnerGroupService.delete(vo.getId());
    }

    @ApiOperation(value = "detail")
    @PostMapping(value = "detail", produces = "application/json")
    public DataResponse<List<PartnerGroupItemVo>> detail(
            @ApiParam(value = "jason对象", required = false) @RequestBody  PartnerGroupItemQuerVo queryVo) {
        return partnerGroupService.detailPage(queryVo);
    }

}
