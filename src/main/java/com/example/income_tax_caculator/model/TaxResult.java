package com.example.income_tax_caculator.model;

import java.math.BigDecimal;

public class TaxResult {
    private BigDecimal compulsoryInsurance;
    private BigDecimal taxIncome;
    private BigDecimal result;
    private BigDecimal realIncomePerMonth;

    public TaxResult() {
    }

    public TaxResult(BigDecimal compulsoryInsurance, BigDecimal taxIncome, BigDecimal result, BigDecimal realIncomePerMonth) {
        this.compulsoryInsurance = compulsoryInsurance;
        this.taxIncome = taxIncome;
        this.result = result;
        this.realIncomePerMonth = realIncomePerMonth;
    }

    public BigDecimal getRealIncomePerMonth() {
        return realIncomePerMonth;
    }

    public void setRealIncomePerMonth(BigDecimal realIncomePerMonth) {
        this.realIncomePerMonth = realIncomePerMonth;
    }

    public BigDecimal getCompulsoryInsurance() {
        return compulsoryInsurance;
    }

    public void setCompulsoryInsurance(BigDecimal compulsoryInsurance) {
        this.compulsoryInsurance = compulsoryInsurance;
    }

    public BigDecimal getTaxIncome() {
        return taxIncome;
    }

    public void setTaxIncome(BigDecimal taxIncome) {
        this.taxIncome = taxIncome;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }
}
