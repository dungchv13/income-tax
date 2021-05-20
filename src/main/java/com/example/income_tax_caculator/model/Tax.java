package com.example.income_tax_caculator.model;

import java.math.BigDecimal;

public class Tax {
    private BigDecimal totalIncome;
    private BigDecimal insuranceSalary;
    private BigDecimal numberDepends;

    public Tax() {
    }

    public Tax(BigDecimal totalIncome, BigDecimal insuranceSalary, BigDecimal numberDepends) {
        this.totalIncome = totalIncome;
        this.insuranceSalary = insuranceSalary;
        this.numberDepends = numberDepends;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getInsuranceSalary() {
        return insuranceSalary;
    }

    public void setInsuranceSalary(BigDecimal insuranceSalary) {
        this.insuranceSalary = insuranceSalary;
    }

    public BigDecimal getNumberDepends() {
        return numberDepends;
    }

    public void setNumberDepends(BigDecimal numberDepends) {
        this.numberDepends = numberDepends;
    }
}
