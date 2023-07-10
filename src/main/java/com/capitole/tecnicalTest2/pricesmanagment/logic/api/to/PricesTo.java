package com.capitole.tecnicalTest2.pricesmanagment.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

public class PricesTo {
    private Long productId;
    private Long brandId;
    private Long rateId;
    private Integer priority;
    private Instant startDate;
    private Instant endDate;
    private BigDecimal price;
    private String currency;

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

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant starDate) {
        this.startDate = starDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
