package gityeong.financeProject.invoice.dao;

import gityeong.financeProject.invoice.dto.InvoiceCustomerDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceDAOJpaImpl implements InvoiceDAO{

    //define entity manager
    private EntityManager entityManager;

    //constructor injection
    @Autowired
    public InvoiceDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<InvoiceCustomerDTO> findAll() {
        // Create a query to join Invoice and Customer tables and select the required fields
        TypedQuery<InvoiceCustomerDTO> theQuery = entityManager.createQuery(
                "SELECT new gityeong.financeProject.invoice.dto.InvoiceCustomerDTO(i.id, i.invNo, i.createdDate, i.description, i.totalDue, i.invApprovalStatus, c.id, c.accNo, c.firstName, c.lastName, c.address, c.email, c.phoneNo) FROM Invoice i JOIN Customer c ON i.customer.id = c.id\n",
                InvoiceCustomerDTO.class);

        // Execute query and get result list
        List<InvoiceCustomerDTO> invoices = theQuery.getResultList();
        return invoices;
    }

    @Override
    public List<InvoiceCustomerDTO> findByInvNo(int invoiceNumber) {
        TypedQuery<InvoiceCustomerDTO> theQuery = entityManager.createQuery(
                "SELECT new gityeong.financeProject.invoice.dto.InvoiceCustomerDTO(i.id, i.invNo, i.createdDate, i.description, i.totalDue, i.invApprovalStatus, c.id, c.accNo, c.firstName, c.lastName, c.address, c.email, c.phoneNo) FROM Invoice i JOIN Customer c ON i.customer.id = c.id WHERE i.invNo = :invoiceNumber",
                InvoiceCustomerDTO.class);

        // Set the parameter value for the invoice number
        theQuery.setParameter("invoiceNumber", invoiceNumber);

        // Execute query and get result list
        List<InvoiceCustomerDTO> invoices = theQuery.getResultList();
        return invoices;
    }
}
