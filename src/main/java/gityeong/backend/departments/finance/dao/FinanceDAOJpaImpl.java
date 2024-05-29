package gityeong.backend.departments.finance.dao;

import gityeong.backend.departments.finance.entity.Finance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FinanceDAOJpaImpl implements FinanceDAO{
    private EntityManager entityManager;
    @Autowired
    public FinanceDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Finance> findAll() {
        TypedQuery<Finance> theQuery = entityManager.createQuery("From Finance", Finance.class);
        List<Finance> finances = theQuery.getResultList();
        return finances;
    }
}
