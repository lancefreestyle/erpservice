package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.AmountCalculationDeleteVo;
import com.capgemini.cn.erp.vo.AmountCalculationQueryVo;
import com.capgemini.cn.erp.vo.AmountCalculationVo;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erpmanage.service.AmountCalculationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/amountCalculation")
public class AmountCalculationResource extends BaseController {

	@Autowired
	AmountCalculationService amountCalculationService;

	@ApiOperation(value = "list")
	@GetMapping(value = "list", produces = "application/json")
	public DataResponse<List<AmountCalculationVo>> list(
			@ApiParam(value = "接收数据参数", required = true) AmountCalculationQueryVo queryVo ) {
		return amountCalculationService.list(queryVo);
	}

	@ApiOperation(value = "getCalculations")
	@GetMapping(value = "getCalculations", produces = "application/json")
	public DataResponse<List<KeyValueVo>> getCalculations(
			@ApiParam(value = "接收数据参数", required = true) AmountCalculationQueryVo queryVo ) {
		return amountCalculationService.getCalculations(queryVo);
	}

	@ApiOperation(value = "detail")
	@GetMapping(value = "detail", produces = "application/json")
	public DataResponse<AmountCalculationVo> detail(
			@ApiParam(value = "接收数据参数", required = true) AmountCalculationQueryVo queryVo ) {
		return amountCalculationService.detail(queryVo);
	}


	@ApiOperation(value = "create")
	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public DataResponse create(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid AmountCalculationVo vo ) {
		return amountCalculationService.add(vo);
	}

	@ApiOperation(value = "update")
	@PostMapping(value = "update", consumes = "application/json", produces = "application/json")
	public DataResponse update(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid AmountCalculationVo vo ) {
		return amountCalculationService.update(vo);
	}

	@ApiOperation(value = "delete")
	@PostMapping(value = "delete", produces = "application/json")
	public DataResponse delete(
			@RequestParam(value = "id", required = true) String id ) {
		AmountCalculationDeleteVo deleteVo = new AmountCalculationDeleteVo();
		deleteVo.setId(id);
		return amountCalculationService.delete(deleteVo);
	}



}
