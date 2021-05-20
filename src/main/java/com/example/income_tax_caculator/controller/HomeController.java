package com.example.income_tax_caculator.controller;

import com.example.income_tax_caculator.model.Tax;
import com.example.income_tax_caculator.model.TaxResult;
import com.example.income_tax_caculator.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    TaxService taxService;

    @Autowired
    HttpSession session;


    @GetMapping("/")
    public String home(Model model) {
       model.addAttribute("tax",new Tax());
        return "index";
    }

    @PostMapping("/calculateTaxPerMonth")
    public String calculatorTaxPerMonth(Model model, Tax tax, HttpServletRequest request){
        TaxResult taxResult = taxService.calculatorTaxPerMonth(tax);
        session = request.getSession();

        session.setAttribute("tax",tax);
        session.setAttribute("result",taxResult);

        model.addAttribute("tax",tax);
        model.addAttribute("result",taxResult);
        return "index";
    }

    @PostMapping("/calculateAllIncome")
    public String calculateAllIncome(Model model, int retirementYear, int startYear){

        model.addAttribute("startYear",startYear);
        model.addAttribute("retirementYear",retirementYear);
        model.addAttribute("allIncome",taxService.calculateAllIncome(retirementYear,startYear));
        model.addAttribute("tax",(Tax) session.getAttribute("tax"));
        model.addAttribute("result",(TaxResult) session.getAttribute("result"));
        return "index";
    }
}
