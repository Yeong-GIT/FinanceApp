package gityeong.financeProject.invoice.dao;

import gityeong.financeProject.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceDAO {

    List<Invoice> findAll();

    Invoice findById(int theId);

    Invoice create(Invoice theInvoice);

    Invoice update(Invoice theInvoice);

    void deleteById(int theId);
}
