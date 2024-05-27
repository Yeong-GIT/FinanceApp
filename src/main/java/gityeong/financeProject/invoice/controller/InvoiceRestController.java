package gityeong.financeProject.invoice.controller;

import gityeong.financeProject.invoice.dto.InvoiceCustomerDTO;
import gityeong.financeProject.invoice.entity.Invoice;
import gityeong.financeProject.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<InvoiceCustomerDTO> findAll(){
        return invoiceService.findAll();
    }

    // Expose "/invoices/{invoiceNumber}" and return invoices by invoice number
    @GetMapping("/invoices/{invoiceNumber}")
    public List<InvoiceCustomerDTO> findByInvNo(@PathVariable int invoiceNumber) {
        return invoiceService.findByInvNo(invoiceNumber);
    }
}
