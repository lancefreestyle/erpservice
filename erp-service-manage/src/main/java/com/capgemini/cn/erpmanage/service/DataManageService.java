package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.*;

import java.util.List;

public interface DataManageService {

	public DataResponse<List<DataManageVo>> list(DataManageQueryVo dataManageQueryVo);

	public DataResponse updateStatus(DataManageUpdateStatusVo dataManageUpdateStatusVo);

	public DataResponse<DataManageSapResponseVo> transferSap(SapTransferVo sapTransferVo);

	DataResponse<List<DataManageItemVo>> subjectPreview(String id);


}
