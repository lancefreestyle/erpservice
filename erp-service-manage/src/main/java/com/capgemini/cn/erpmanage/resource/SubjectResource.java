package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erp.vo.SubjectDeleteVo;
import com.capgemini.cn.erp.vo.SubjectQueryVo;
import com.capgemini.cn.erp.vo.SubjectVo;
import com.capgemini.cn.erpmanage.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/subject")
public class SubjectResource extends BaseController {

	@Autowired
	SubjectService subjectService;

	@ApiOperation(value = "list")
	@GetMapping(value = "list", produces = "application/json")
	public DataResponse<List<SubjectVo>> list(
			@ApiParam(value = "接收数据参数", required = true) SubjectQueryVo queryVo ) {
		return subjectService.list(queryVo);
	}

	@ApiOperation(value = "getSubjects")
	@GetMapping(value = "getSubjects", produces = "application/json")
	public DataResponse<List<KeyValueVo>> getSubjects(
			@ApiParam(value = "接收数据参数", required = true) SubjectQueryVo queryVo ) {
		return subjectService.getSubjects(queryVo);
	}

	@ApiOperation(value = "detail")
	@GetMapping(value = "detail", produces = "application/json")
	public DataResponse<SubjectVo> detail(
			@ApiParam(value = "接收数据参数", required = true) SubjectQueryVo queryVo ) {
		return subjectService.detail(queryVo);
	}

	@ApiOperation(value = "create")
	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public DataResponse create(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid SubjectVo vo ) {
		return subjectService.add(vo);
	}

	@ApiOperation(value = "update")
	@PostMapping(value = "update", consumes = "application/json", produces = "application/json")
	public DataResponse update(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody @Valid SubjectVo vo ) {
		return subjectService.update(vo);
	}

	@ApiOperation(value = "delete")
	@PostMapping(value = "delete", produces = "application/json")
	public DataResponse delete(
			@RequestParam(value = "id", required = true) String id ) {
		SubjectDeleteVo deleteVo = new SubjectDeleteVo();
		deleteVo.setId(id);
		return subjectService.delete(deleteVo);
	}



}
