package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.EngineSettingDeleteVo;
import com.capgemini.cn.erp.vo.EngineSettingQueryVo;
import com.capgemini.cn.erp.vo.EngineSettingVo;
import com.capgemini.cn.erpmanage.service.EngineSettingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/engineSetting")
public class EngineSettingResource extends BaseController {

	@Autowired
	EngineSettingService engineSettingService;

	@ApiOperation(value = "list")
	@GetMapping(value = "list", produces = "application/json")
	public DataResponse<List<EngineSettingVo>> list(
			@ApiParam(value = "接收数据参数", required = true) EngineSettingQueryVo queryVo ) {
		return engineSettingService.list(queryVo);
	}

	@ApiOperation(value = "detail")
	@GetMapping(value = "detail", produces = "application/json")
	public DataResponse<EngineSettingVo> detail(
			@ApiParam(value = "接收数据参数", required = true) EngineSettingQueryVo queryVo ) {
		return engineSettingService.detail(queryVo);
	}


	@ApiOperation(value = "create")
	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public DataResponse create(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid EngineSettingVo vo ) {
		return engineSettingService.add(vo);
	}

	@ApiOperation(value = "update")
	@PostMapping(value = "update", consumes = "application/json", produces = "application/json")
	public DataResponse update(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid EngineSettingVo vo ) {
		return engineSettingService.update(vo);
	}

	@ApiOperation(value = "delete")
	@PostMapping(value = "delete", produces = "application/json")
	public DataResponse delete(
			@RequestParam(value = "id", required = true) String id ) {
		EngineSettingDeleteVo deleteVo = new EngineSettingDeleteVo();
		deleteVo.setId(id);
		return engineSettingService.delete(deleteVo);
	}



}
