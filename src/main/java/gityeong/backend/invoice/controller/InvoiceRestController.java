package gityeong.backend.invoice.controller;

import gityeong.backend.customer.dao.CustomerRepository;
import gityeong.backend.invoice.dto.CreateNewInvoiceCustomerDTO;
import gityeong.backend.invoice.dto.InvoiceCustomerDTO;
import gityeong.backend.invoice.dto.UpdateInvoiceDTO;
import gityeong.backend.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceRestController {

    private InvoiceService invoiceService;
    private CustomerRepository customerRepository;

    @Autowired
    public InvoiceRestController(InvoiceService theInvoiceService, CustomerRepository theCustomerRepository) {
        invoiceService = theInvoiceService;
        customerRepository = theCustomerRepository;
    }

    //Expose "*/employees" and return a list of invoices
    @GetMapping("/invoices")
    public List<InvoiceCustomerDTO> findAll(){
        return invoiceService.findAll();
    }

    // Expose "/invoices/{invoiceNumber}" and return invoices by invoice number
    @GetMapping("/invoices/{invoiceNumber}")
    public List<InvoiceCustomerDTO> findByInvNo(@PathVariable int invoiceNumber) {
        return invoiceService.findByInvNo(invoiceNumber);
    }


    @PostMapping("/invoices")
    public ResponseEntity<String> createNewInvoice(@RequestBody CreateNewInvoiceCustomerDTO createNewInvoiceCustomerDTO) {
        invoiceService.createNewInvoice(createNewInvoiceCustomerDTO);
        return ResponseEntity.ok("New invoice created successfully");
    }

    @PutMapping("/invoices/{invoiceId}")
    public String updateInvoice(@PathVariable int invoiceId, @RequestBody UpdateInvoiceDTO updateInvoiceDTO) {
        invoiceService.updateInvoice(invoiceId, updateInvoiceDTO);
        return "Invoice updated successfully.";
    }

    @DeleteMapping("/invoices/{invoiceId}")
    public ResponseEntity<String> deleteInvoice(@PathVariable int invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
        return ResponseEntity.ok("Invoice deleted successfully.");
    }
}
