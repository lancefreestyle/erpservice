package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueShareSettlementVo implements Serializable {
    private String id;
    private RevenueShareDataVo revenueShareDataVo;
    private BigDecimal settlementAmount;
    private Timestamp settlementDate;
    private String status;
    private Timestamp createDate;
    private Timestamp updateDate;
}
