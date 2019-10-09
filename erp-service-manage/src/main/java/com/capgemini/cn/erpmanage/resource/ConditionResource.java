package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.ConditionDeleteVo;
import com.capgemini.cn.erp.vo.ConditionQueryVo;
import com.capgemini.cn.erp.vo.ConditionVo;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erpmanage.service.ConditionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/condition")
public class ConditionResource extends BaseController {

	@Autowired
	ConditionService conditionService;

	@ApiOperation(value = "list")
	@GetMapping(value = "list", produces = "application/json")
	public DataResponse<List<ConditionVo>> list(
			@ApiParam(value = "接收数据参数", required = true) ConditionQueryVo queryVo ) {
		return conditionService.list(queryVo);
	}
	
	@ApiOperation(value = "getConditions")
	@GetMapping(value = "getConditions", produces = "application/json")
	public DataResponse<List<KeyValueVo>> getConditions(
			@ApiParam(value = "接收数据参数", required = true) ConditionQueryVo queryVo ) {
		return conditionService.getConditions(queryVo);
	}

	@ApiOperation(value = "detail")
	@GetMapping(value = "detail", produces = "application/json")
	public DataResponse<ConditionVo> detail(
			@ApiParam(value = "接收数据参数", required = true) ConditionQueryVo queryVo ) {
		return conditionService.detail(queryVo);
	}


	@ApiOperation(value = "create")
	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public DataResponse create(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid ConditionVo vo ) {
		return conditionService.add(vo);
	}

	@ApiOperation(value = "update")
	@PostMapping(value = "update", consumes = "application/json", produces = "application/json")
	public DataResponse update(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid ConditionVo vo ) {
		return conditionService.update(vo);
	}

	@ApiOperation(value = "delete")
	@PostMapping(value = "delete", produces = "application/json")
	public DataResponse delete(
			@RequestParam(value = "id", required = true) String id ) {
		ConditionDeleteVo deleteVo = new ConditionDeleteVo();
		deleteVo.setId(id);
		return conditionService.delete(deleteVo);
	}



}
