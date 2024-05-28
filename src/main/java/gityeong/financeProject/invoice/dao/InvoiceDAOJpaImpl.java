package gityeong.financeProject.invoice.dao;

import gityeong.financeProject.customer.entity.Customer;
import gityeong.financeProject.invoice.dto.CreateNewInvoiceCustomerDTO;
import gityeong.financeProject.invoice.dto.InvoiceCustomerDTO;
import gityeong.financeProject.invoice.dto.UpdateInvoiceDTO;
import gityeong.financeProject.invoice.entity.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
        // Find the maximum invNo
        TypedQuery<Integer> maxInvNoQuery = entityManager.createQuery(
                "SELECT COALESCE(MAX(i.invNo), 0) FROM Invoice i", Integer.class);
        int maxInvNo = maxInvNoQuery.getSingleResult();

        // Increment the invNo by 1
        int newInvNo = maxInvNo + 1;

        // Check if the customer exists by account number
        TypedQuery<Customer> customerQuery = entityManager.createQuery(
                "SELECT c FROM Customer c WHERE c.accNo = :accNo", Customer.class);
        customerQuery.setParameter("accNo", dto.getAccNo().intValue());
        List<Customer> customers = customerQuery.getResultList();

        Customer customer;
        boolean isNewCustomer = false;
        if (!customers.isEmpty()) {
            // Use the existing customer if found
            customer = customers.get(0);
        } else {
            // Find the maximum customerId
            TypedQuery<Integer> maxCustomerIdQuery = entityManager.createQuery(
                    "SELECT COALESCE(MAX(c.id), 0) FROM Customer c", Integer.class);
            int maxCustomerId = maxCustomerIdQuery.getSingleResult();

            // Increment the customerId by 1
            int newCustomerId = maxCustomerId + 1;

            // Create a new customer if not found
            customer = new Customer();
            customer.setAccNo(dto.getAccNo().intValue());
            customer.setFirstName(dto.getFirstName());
            customer.setLastName(dto.getLastName());
            customer.setAddress(dto.getAddress());
            customer.setEmail(dto.getEmail());
            customer.setPhoneNo(dto.getPhoneNo());
            entityManager.persist(customer);

            isNewCustomer = true;
        }

        // Create a new Invoice entity from the DTO
        Invoice invoice = new Invoice();
        invoice.setInvNo(newInvNo);
        invoice.setCreatedDate(new Date(System.currentTimeMillis())); // Use java.sql.Date
        invoice.setDescription(dto.getDescription());
        invoice.setTotalDue(dto.getTotalDue());
        invoice.setInvApprovalStatus(false); // Assuming new invoices are not approved initially
        invoice.setCustomer(customer);

        entityManager.persist(invoice);


        // Construct the response message
        String message;
        if (isNewCustomer) {
            message = "New customer created with account number " + dto.getAccNo() + ".";
        } else {
            message = "Existing customer with account number " + dto.getAccNo() + " used.";
        }

        // You can return this message as a part of your API response or log it
        System.out.println(message);
    }

    @Override
    @Transactional
    public void updateInvoice(int invoiceId, UpdateInvoiceDTO dto) {
        Invoice invoice = entityManager.find(Invoice.class, invoiceId);
        if (invoice == null) {
            throw new IllegalArgumentException("Invoice with ID " + invoiceId + " not found");
        }
        invoice.setDescription(dto.getDescription());
        invoice.setTotalDue(dto.getTotalDue());
        invoice.setCreatedDate(new Date(System.currentTimeMillis()));
    }

}
