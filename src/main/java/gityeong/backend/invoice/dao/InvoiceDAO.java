package gityeong.backend.invoice.dao;

import gityeong.backend.invoice.dto.CreateNewInvoiceCustomerDTO;
import gityeong.backend.invoice.dto.InvoiceCustomerDTO;
import gityeong.backend.invoice.dto.UpdateInvoiceDTO;

import java.util.List;

public interface InvoiceDAO {

    List<InvoiceCustomerDTO> findAll();

    List<InvoiceCustomerDTO> findByInvNo(int invoiceNumber);

    void createInv(CreateNewInvoiceCustomerDTO createNewInvoiceCustomerDTO);

    void updateInvoice(int invoiceId, UpdateInvoiceDTO updateInvoiceDTO);

    void deleteInvoice(int invoiceId);
}
