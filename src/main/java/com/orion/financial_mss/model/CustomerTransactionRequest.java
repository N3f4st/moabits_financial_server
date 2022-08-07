package com.orion.financial_mss.model;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CustomerTransactionRequest {

    public CustomerTransactionRequest(Long customerId, Date fromDate, Date toDate, Long page, Long rowsQty) {
        this.customerId = customerId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.page = page;
        this.rowsQty = rowsQty;
    }

    private Long customerId;

    private Date fromDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date toDate;

    private Long page;

    private Long rowsQty;

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getPage() {
        return page;
    }
    public void setPage(Long page) {
        this.page = page;
    }

    public Long getRowsQty() {
        return rowsQty;
    }
    public void setRowsQty(Long rowsQty) {
        this.rowsQty = rowsQty;
    }
}
