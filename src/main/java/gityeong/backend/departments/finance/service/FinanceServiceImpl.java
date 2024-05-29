package gityeong.backend.departments.finance.service;

import gityeong.backend.departments.finance.dao.FinanceDAO;
import gityeong.backend.departments.finance.entity.Finance;
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
