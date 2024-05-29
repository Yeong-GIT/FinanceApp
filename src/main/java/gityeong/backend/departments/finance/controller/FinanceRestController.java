package gityeong.backend.departments.finance.controller;

import gityeong.backend.departments.finance.entity.Finance;
import gityeong.backend.departments.finance.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FinanceRestController {
    private FinanceService financeService;

    @Autowired
    public FinanceRestController(FinanceService theFinanceService){
        financeService = theFinanceService;
    }

    @GetMapping("/finances")
    public List<Finance> findAll(){
        return financeService.findAll();
    }
}
