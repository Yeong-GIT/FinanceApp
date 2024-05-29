package gityeong.backend.invoice.service;

import gityeong.backend.invoice.dto.CreateNewInvoiceCustomerDTO;
import gityeong.backend.invoice.dto.InvoiceCustomerDTO;
import gityeong.backend.invoice.dto.UpdateInvoiceDTO;

import java.util.List;

public interface InvoiceService {
    List<InvoiceCustomerDTO> findAll();

    List<InvoiceCustomerDTO> findByInvNo(int invoiceNumber);

    void createNewInvoice(CreateNewInvoiceCustomerDTO createNewInvoiceCustomerDTO);

    void updateInvoice(int invoiceId, UpdateInvoiceDTO updateInvoiceDTO);

    void deleteInvoice(int invoiceId);
}

