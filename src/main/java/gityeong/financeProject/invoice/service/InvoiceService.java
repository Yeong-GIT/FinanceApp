package gityeong.financeProject.invoice.service;

import gityeong.financeProject.invoice.dto.CreateNewInvoiceCustomerDTO;
import gityeong.financeProject.invoice.dto.InvoiceCustomerDTO;
import gityeong.financeProject.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<InvoiceCustomerDTO> findAll();

    List<InvoiceCustomerDTO> findByInvNo(int invoiceNumber);

    void createNewInvoice(CreateNewInvoiceCustomerDTO createNewInvoiceCustomerDTO);
}

