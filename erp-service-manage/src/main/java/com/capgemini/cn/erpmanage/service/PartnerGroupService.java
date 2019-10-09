package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.PartnerGroup;
import com.capgemini.cn.erp.vo.PartnerGroupItemQuerVo;
import com.capgemini.cn.erp.vo.PartnerGroupQueryVo;
import com.capgemini.cn.erp.vo.PartnerGroupVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartnerGroupService {

    DataResponse<List<PartnerGroupVo>> list(PartnerGroupQueryVo queryVo);

    //DataResponse<List<KeyValueVo>> getCalculations(AmountCalculationQueryVo queryVo);

    //DataResponse<AmountCalculationVo> detail(AmountCalculationQueryVo queryVo);

    DataResponse add(PartnerGroupVo vo);

    DataResponse update(PartnerGroupVo vo);

    DataResponse delete(String id);

    DataResponse deleteItem(String id);

    DataResponse detailPage(PartnerGroupItemQuerVo queryVo);

}
