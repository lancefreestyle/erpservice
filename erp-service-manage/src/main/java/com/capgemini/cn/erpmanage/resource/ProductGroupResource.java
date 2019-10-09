package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.ProductGroup;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.ProductGroupItemService;
import com.capgemini.cn.erpmanage.service.ProductGroupService;
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
@RequestMapping("/productGroup")
public class ProductGroupResource extends BaseController {

    @Autowired
    private ProductGroupService productGroupService;
    @Autowired
    private ProductGroupItemService productGroupItemService;

    @ApiOperation(value = "/list")
    @PostMapping(value = "/list", produces = "application/json")
    public DataResponse<List<ProductGroupVo>> list(
            @ApiParam(value = "jason对象", required = false)  ProductGroupQueryVo queryVo
    ) {
        return productGroupService.list(queryVo);
    }

    @ApiOperation(value = "/create")
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public DataResponse create(
            @ApiParam(value = "接收数据参数", required = false) ProductGroupVo productGroupVo) {
        return productGroupService.add(productGroupVo);
    }

    @ApiOperation(value = "update")
    @PostMapping(value = "update", consumes = "application/json", produces = "application/json")
    public DataResponse update(
            @ApiParam(value = "接收数据参数", required = false) @RequestBody @Valid ProductGroupVo productGroupVo) {
        return productGroupService.update(productGroupVo);
    }

    /*@ApiOperation(value = "deleteItem")
    @PostMapping(value = "deleteItem", produces = "application/json")
    public DataResponse delete(
            @ApiParam(value = "jason对象", required = true) @RequestBody ProductGroupVo vo) {
        return productGroupService.delete(vo.getId());
    }*/


    @ApiOperation(value = "delete")
    @PostMapping(value = "delete", produces = "application/json")
    public DataResponse deleteItem(
            @ApiParam(value = "jason对象", required = false) @RequestBody ProductGroupItemVo vo) {
        return productGroupItemService.delete(vo.getId());
    }

    @ApiOperation(value = "detail")
    @PostMapping(value = "detail", produces = "application/json")
    public DataResponse<DataTemplateVo> detail(
            @ApiParam(value = "jason对象", required = false) @RequestBody ProductGroupItemQueryVo vo) {
        return productGroupService.detailPage(vo);
    }
}
