package gityeong.financeProject.invoice.dao;

import gityeong.financeProject.customer.entity.Customer;
import gityeong.financeProject.invoice.dto.CreateNewInvoiceCustomerDTO;
import gityeong.financeProject.invoice.dto.InvoiceCustomerDTO;
import gityeong.financeProject.invoice.entity.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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

    @Override
    @Transactional
    public void createInv(CreateNewInvoiceCustomerDTO dto) {
        // Check if the customer already exists
        Customer customer = entityManager.find(Customer.class, dto.getCustomerId());
        if (customer == null) {
            // Create a new Customer entity from the DTO
            customer = new Customer(dto.getAccNo().intValue(), dto.getFirstName(), dto.getLastName(), dto.getAddress(), dto.getEmail(), dto.getPhoneNo());
            // Persist the customer entity
            entityManager.persist(customer);
        }

        // Create a new Invoice entity from the DTO
        Invoice invoice = new Invoice();
        invoice.setInvNo((int)(Math.random() * 100000)); // or generate unique number as per requirement
        invoice.setCreatedDate(new Date(System.currentTimeMillis()));
        invoice.setDescription(dto.getDescription());
        invoice.setTotalDue(dto.getTotalDue());
        invoice.setInvApprovalStatus(false); // Default approval status

        // Set the customer for the invoice
        invoice.setCustomer(customer);

        // Persist the invoice entity
        entityManager.persist(invoice);
    }
}
