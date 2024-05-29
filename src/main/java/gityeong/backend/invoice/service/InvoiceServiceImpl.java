package gityeong.backend.invoice.service;

import gityeong.backend.invoice.dao.InvoiceDAO;
import gityeong.backend.invoice.dto.CreateNewInvoiceCustomerDTO;
import gityeong.backend.invoice.dto.InvoiceCustomerDTO;
import gityeong.backend.invoice.dto.UpdateInvoiceDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    private InvoiceDAO invoiceDAO;


    public InvoiceServiceImpl(InvoiceDAO theInvoiceDAO) {
        invoiceDAO = theInvoiceDAO;
    }

    @Override
    public List<InvoiceCustomerDTO> findAll() {
        return invoiceDAO.findAll();
    }

    @Override
    public List<InvoiceCustomerDTO> findByInvNo(int invoiceNumber) {
        return invoiceDAO.findByInvNo(invoiceNumber);
    }

    @Override
    public void createNewInvoice(CreateNewInvoiceCustomerDTO createNewInvoiceCustomerDTO) {
        invoiceDAO.createInv(createNewInvoiceCustomerDTO);
    }

    @Override
    @Transactional
    public void updateInvoice(int invoiceId, UpdateInvoiceDTO updateInvoiceDTO) {
        invoiceDAO.updateInvoice(invoiceId, updateInvoiceDTO);
    }

    @Override
    @Transactional
    public void deleteInvoice(int invoiceId) {
        invoiceDAO.deleteInvoice(invoiceId);
    }
}
