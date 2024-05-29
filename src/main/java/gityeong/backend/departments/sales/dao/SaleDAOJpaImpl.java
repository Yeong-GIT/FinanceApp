package gityeong.backend.departments.sales.dao;

import gityeong.backend.departments.sales.entity.Sale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleDAOJpaImpl implements SaleDAO{
    private EntityManager entityManager;
    @Autowired
    public SaleDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Sale> findAll() {
        TypedQuery<Sale> theQuery = entityManager.createQuery("From Sale", Sale.class);
        List<Sale> sales = theQuery.getResultList();
        return sales;
    }
}
