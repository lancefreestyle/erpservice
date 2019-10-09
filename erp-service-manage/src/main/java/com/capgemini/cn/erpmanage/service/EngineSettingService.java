package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.EngineSettingDeleteVo;
import com.capgemini.cn.erp.vo.EngineSettingQueryVo;
import com.capgemini.cn.erp.vo.EngineSettingVo;

import java.util.List;

/**
 * @author jikzhang
 */
public interface EngineSettingService {
	
    DataResponse<List<EngineSettingVo>> list(EngineSettingQueryVo queryVo);

    DataResponse<EngineSettingVo> detail(EngineSettingQueryVo queryVo);

    DataResponse add(EngineSettingVo vo);

    DataResponse update(EngineSettingVo vo);

    DataResponse delete(EngineSettingDeleteVo deleteVo);
}
