package com.capitole.tecnicalTest2.pricesmanagment.logic.api.to;

import java.time.Instant;

public class PricesSearchCriteria {

    private Long productId;
    private Long brandId;
    private String applicationDateStr;
    private Instant applicationDate;

    public PricesSearchCriteria(Long productId, Long brandId, String applicationDateStr) {
        this.productId = productId;
        this.brandId = brandId;
        this.applicationDateStr = applicationDateStr;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Instant getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Instant applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationDateStr() {
        return applicationDateStr;
    }

    public void setApplicationDateStr(String applicationDateStr) {
        this.applicationDateStr = applicationDateStr;
    }
}
