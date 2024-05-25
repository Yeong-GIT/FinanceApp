package gityeong.financeProject.departments.finance.service;

import gityeong.financeProject.departments.finance.dao.FinanceDAO;
import gityeong.financeProject.departments.finance.dao.FinanceDAOJpaImpl;
import gityeong.financeProject.departments.finance.entity.Finance;
import gityeong.financeProject.departments.sales.dao.SaleDAO;
import gityeong.financeProject.departments.sales.service.SaleService;
import gityeong.financeProject.departments.sales.service.SaleServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService{
    private FinanceDAO financeDAO;
    public FinanceServiceImpl(FinanceDAO theFinanceDAO){
        financeDAO = theFinanceDAO;
    }

    @Override
    public List<Finance> findAll() {
        return financeDAO.findAll();
    }
}
