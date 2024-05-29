package gityeong.financeProject.invoice.dao;

import gityeong.financeProject.customer.entity.Customer;
import gityeong.financeProject.departments.finance.entity.Finance;
import gityeong.financeProject.departments.sales.entity.Sale;
import gityeong.financeProject.invoice.dto.CreateNewInvoiceCustomerDTO;
import gityeong.financeProject.invoice.dto.InvoiceCustomerDTO;
import gityeong.financeProject.invoice.dto.UpdateInvoiceDTO;
import gityeong.financeProject.invoice.entity.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
        Customer customer = entityManager.find(Customer.class, dto.getCustomerId());

        // Create a new Invoice entity from the DTO
        Invoice invoice = new Invoice();
        invoice.setInvNo(newInvNo);
        invoice.setCreatedDate(new Date(System.currentTimeMillis())); // Use java.sql.Date
        invoice.setDescription(dto.getDescription());
        invoice.setTotalDue(dto.getTotalDue());
        invoice.setInvApprovalStatus(false); // Assuming new invoices are not approved initially
        invoice.setCustomer(customer);

        entityManager.persist(invoice);

        // Find the maximum taskId from the salesdept table
        Integer maxTaskId = entityManager.createQuery("SELECT MAX(s.taskId) FROM Sale s", Integer.class)
                .getSingleResult();
        int newTaskId = (maxTaskId == null ? 0 : maxTaskId) + 1;

        Sale task = new Sale();
        task.setTaskId(newTaskId);
        task.setTaskDescription(dto.getTaskDescription());
        task.setTaskCompleteStatus(dto.isTaskCompleteStatus());
        task.setInvoice(invoice);

        entityManager.persist(task);

        Finance financeTask = new Finance();
        financeTask.setTaskId(newTaskId); // Reuse the task ID or generate a new one if needed
        financeTask.setTaskDescription("Approval task for invoice " + newInvNo);
        financeTask.setTaskCompleteStatus("Pending");
        financeTask.setSale(task);
        entityManager.persist(financeTask);

        // Construct the response message
        String message = "Invoice created for customer with account number " + customer.getAccNo() + ".";
        System.out.println(message);
    }

    @Override
    @Transactional
    public void updateInvoice(int invoiceId, UpdateInvoiceDTO dto) {
        Invoice invoice = entityManager.find(Invoice.class, invoiceId);
        if (invoice == null) {
            throw new IllegalArgumentException("Invoice with ID " + invoiceId + " not found");
        }

        // Update invoice fields
        invoice.setDescription(dto.getDescription());
        invoice.setTotalDue(dto.getTotalDue());
        invoice.setCreatedDate(new Date(System.currentTimeMillis()));

        // If you want to update the associated task as well, do it here
        Sale task = invoice.getTask();
        if (task != null) {
            task.setTaskDescription(dto.getTaskDescription());
            task.setTaskCompleteStatus(dto.isTaskCompleteStatus());
        }
    }


    @Override
    @Transactional
    public void deleteInvoice(int invoiceId) {
        Invoice invoice = entityManager.find(Invoice.class, invoiceId);
        if (invoice == null) {
            throw new EntityNotFoundException("Invoice with ID " + invoiceId + " not found");
        }

        // Delete the associated task if it exists
        Sale task = invoice.getTask();
        if (task != null) {
            entityManager.remove(task);
        }

        // Remove the invoice
        entityManager.remove(invoice);
    }


}
