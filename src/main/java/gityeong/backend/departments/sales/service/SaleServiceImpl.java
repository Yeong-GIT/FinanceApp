package gityeong.backend.departments.sales.service;

import gityeong.backend.departments.sales.dao.SaleDAO;
import gityeong.backend.departments.sales.entity.Sale;
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
