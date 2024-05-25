package gityeong.financeProject.departments.sales.dao;

import gityeong.financeProject.departments.sales.entity.Sale;

import java.util.List;

public interface SaleDAO {

    List<Sale> findAll();
}
