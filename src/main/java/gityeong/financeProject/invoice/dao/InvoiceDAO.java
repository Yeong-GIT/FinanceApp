package gityeong.financeProject.invoice.dao;

import gityeong.financeProject.invoice.dto.InvoiceCustomerDTO;
import gityeong.financeProject.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceDAO {

    List<InvoiceCustomerDTO> findAll();

    List<InvoiceCustomerDTO> findByInvNo(int invoiceNumber);
}
