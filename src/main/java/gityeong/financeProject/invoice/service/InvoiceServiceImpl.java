package gityeong.financeProject.invoice.service;

import gityeong.financeProject.invoice.dao.InvoiceDAO;
import gityeong.financeProject.invoice.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    private InvoiceDAO invoiceDAO;
    public InvoiceServiceImpl(InvoiceDAO theInvoiceDAO) {
        invoiceDAO = theInvoiceDAO;
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceDAO.findAll();
    }

    @Override
    public Invoice findById(int theId) {
        return null;
    }

    @Override
    public Invoice create(Invoice theInvoice) {
        return null;
    }

    @Override
    public Invoice update(Invoice theInvoice) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }
}
