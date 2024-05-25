package gityeong.financeProject.invoice.controller;

import gityeong.financeProject.invoice.entity.Invoice;
import gityeong.financeProject.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceRestController {

    private InvoiceService invoiceService;

    @Autowired

    public InvoiceRestController(InvoiceService theInvoiceService) {
        invoiceService = theInvoiceService;
    }

    //Expose "*/employees" and return a list of employee
    @GetMapping("/invoices")
    public List<Invoice> findAll(){
        return invoiceService.findAll();
    }
}
