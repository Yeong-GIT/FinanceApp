package gityeong.financeProject.departments.sales.controller;

import gityeong.financeProject.departments.sales.entity.Sale;
import gityeong.financeProject.departments.sales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleRestController {

    private SaleService saleService;

    @Autowired
    public SaleRestController(SaleService theSaleService){
        saleService = theSaleService;
    }

    @GetMapping("/sales")
    public List<Sale> findAll(){
        return saleService.findAll();
    }
}
