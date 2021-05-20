package com.example.income_tax_caculator.service;

import com.example.income_tax_caculator.model.Tax;
import com.example.income_tax_caculator.model.TaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class TaxService {
    @Autowired
    HttpSession session;

    public static final int LEVER_ONE = 5000000;
    public static final int LEVER_TWO = 10000000;
    public static final int LEVER_THREE = 18000000;
    public static final int LEVER_FOUR = 32000000;
    public static final int LEVER_FIVE = 52000000;
    public static final int LEVER_SIX = 8000000;

    public TaxResult calculatorTaxPerMonth(Tax tax){
        BigDecimal compulsoryInsurance = tax.getInsuranceSalary().multiply(BigDecimal.valueOf(105)).divide(BigDecimal.valueOf(1000));
        BigDecimal deduction = tax.getNumberDepends().multiply(BigDecimal.valueOf(4400000));
        BigDecimal taxIncome = tax.getTotalIncome().subtract(compulsoryInsurance).subtract(deduction).subtract(BigDecimal.valueOf(11000000));
        BigDecimal result = getTaxHTPaid(taxIncome);
        BigDecimal realIncomePerMonth = tax.getTotalIncome().subtract(result).subtract(compulsoryInsurance);
        return new TaxResult(compulsoryInsurance,taxIncome,result,realIncomePerMonth);
    }

    public BigDecimal calculateAllIncome(int retirementYear, int startYear){
        BigDecimal userIncomePerMonth = ((TaxResult) session.getAttribute("result")).getRealIncomePerMonth();
        Date date = new Date();
        int monthsWorked = (retirementYear - startYear)*12;
        return userIncomePerMonth.multiply(BigDecimal.valueOf(monthsWorked));
    }

    private BigDecimal getTaxHTPaid(BigDecimal taxIncome){
        BigDecimal result;
        if(taxIncome.compareTo(BigDecimal.valueOf(0)) <= 0){
            result = BigDecimal.valueOf(0);
        }else if(taxIncome.compareTo(BigDecimal.valueOf(LEVER_ONE)) <= 0){
            result = taxIncome.multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(100));
        }else if(taxIncome.compareTo(BigDecimal.valueOf(LEVER_TWO)) <= 0){
            result = taxIncome.multiply(BigDecimal.valueOf(10)).divide(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(250000));
        }else if(taxIncome.compareTo(BigDecimal.valueOf(LEVER_THREE)) <= 0){
            result = taxIncome.multiply(BigDecimal.valueOf(15)).divide(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(750000));
        }else if(taxIncome.compareTo(BigDecimal.valueOf(LEVER_FOUR)) <= 0){
            result = taxIncome.multiply(BigDecimal.valueOf(20)).divide(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(1650000));
        }else if(taxIncome.compareTo(BigDecimal.valueOf(LEVER_FIVE)) <= 0){
            result = taxIncome.multiply(BigDecimal.valueOf(25)).divide(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(3250000));
        }else if(taxIncome.compareTo(BigDecimal.valueOf(LEVER_SIX)) <= 0){
            result = taxIncome.multiply(BigDecimal.valueOf(30)).divide(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(5850000));
        }else{
            result = taxIncome.multiply(BigDecimal.valueOf(35)).divide(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(9850000));
        }
        return result;
    }
}
