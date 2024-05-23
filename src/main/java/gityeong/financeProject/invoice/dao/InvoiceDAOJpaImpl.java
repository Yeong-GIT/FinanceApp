package gityeong.financeProject.invoice.dao;

import gityeong.financeProject.invoice.entity.Invoice;
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
    public List<Invoice> findAll() {
        //Create a query
        TypedQuery<Invoice> theQuery = entityManager.createQuery("From Invoice", Invoice.class);
        //Execute query and get result list
        List<Invoice> invoices = theQuery.getResultList();
        //return results
        return invoices;
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
