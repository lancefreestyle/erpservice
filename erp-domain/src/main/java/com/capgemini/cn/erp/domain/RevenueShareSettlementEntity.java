package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "revenue_share_settlement", schema = "ubr_service_db1", catalog = "")
public class RevenueShareSettlementEntity {
    private String id;
    private String revenueShareDataId;
    private BigDecimal settlementAmount;
    private Timestamp settlementDate;
    private String status;
    private Timestamp createDate;
    private Timestamp updateDate;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "revenue_share_data_id")
    public String getRevenueShareDataId() {
        return revenueShareDataId;
    }

    public void setRevenueShareDataId(String revenueShareDataId) {
        this.revenueShareDataId = revenueShareDataId;
    }

    @Basic
    @Column(name = "settlement_amount")
    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    @Basic
    @Column(name = "settlement_date")
    public Timestamp getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Timestamp settlementDate) {
        this.settlementDate = settlementDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevenueShareSettlementEntity that = (RevenueShareSettlementEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(revenueShareDataId, that.revenueShareDataId) &&
                Objects.equals(settlementAmount, that.settlementAmount) &&
                Objects.equals(settlementDate, that.settlementDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, revenueShareDataId, settlementAmount, settlementDate, status, createDate, updateDate);
    }
}
