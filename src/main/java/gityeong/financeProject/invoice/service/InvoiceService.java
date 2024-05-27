package gityeong.financeProject.invoice.service;

import gityeong.financeProject.invoice.dto.InvoiceCustomerDTO;
import gityeong.financeProject.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<InvoiceCustomerDTO> findAll();

    Invoice findById(int theId);

    Invoice create(Invoice theInvoice);

    Invoice update(Invoice theInvoice);

    void deleteById(int theId);
}
