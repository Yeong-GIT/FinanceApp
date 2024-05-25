package gityeong.financeProject.departments.sales.service;

import gityeong.financeProject.departments.sales.dao.SaleDAO;
import gityeong.financeProject.departments.sales.entity.Sale;
import gityeong.financeProject.invoice.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{
    private SaleDAO saleDAO;
    public SaleServiceImpl(SaleDAO theSaleDAO){
        saleDAO = theSaleDAO;
    }

    @Override
    public List<Sale> findAll() {
        return saleDAO.findAll();
    }

}
