package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erp.vo.SummaryDeleteVo;
import com.capgemini.cn.erp.vo.SummaryQueryVo;
import com.capgemini.cn.erp.vo.SummaryVo;
import com.capgemini.cn.erpmanage.service.SummaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/summary")
public class SummaryResource extends BaseController {

	@Autowired
	SummaryService alarmContactService;

	@ApiOperation(value = "list")
	@GetMapping(value = "list",produces = "application/json")
	public DataResponse<List<SummaryVo>> list(
			@ApiParam(value = "接收数据参数", required = true) SummaryQueryVo queryVo ) {
		return alarmContactService.list(queryVo);
	}

	@ApiOperation(value = "getSummarys")
	@GetMapping(value = "getSummarys",produces = "application/json")
	public DataResponse<List<KeyValueVo>> getSummarys(
			@ApiParam(value = "接收数据参数", required = true) SummaryQueryVo queryVo ) {
		return alarmContactService.getSummarys(queryVo);
	}

	@ApiOperation(value = "detail")
	@GetMapping(value = "detail", produces = "application/json")
	public DataResponse<SummaryVo> detail(
			@ApiParam(value = "接收数据参数", required = true) SummaryQueryVo queryVo ) {
		return alarmContactService.detail(queryVo);
	}

	@ApiOperation(value = "create")
	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public DataResponse create(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid SummaryVo vo ) {
		return alarmContactService.add(vo);
	}

	@ApiOperation(value = "update")
	@PostMapping(value = "update", consumes = "application/json", produces = "application/json")
	public DataResponse update(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid SummaryVo vo ) {
		return alarmContactService.update(vo);
	}

	@ApiOperation(value = "delete")
	@PostMapping(value = "delete", consumes = "application/json", produces = "application/json")
	public DataResponse delete(
			@RequestParam(value = "id", required = true) String id ) {
		SummaryDeleteVo deleteVo = new SummaryDeleteVo();
		deleteVo.setId(id);
		return alarmContactService.delete(deleteVo);
	}



}
