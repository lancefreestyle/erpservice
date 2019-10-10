package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueConfirmInitVo {
    private List<SystemBusinessTypeVo> systemBusinessTypeVos;
    private List<ProductGroupVo> productGroupVos;
    private List<ProductGroupItemVo> productGroupItemVos;
}
