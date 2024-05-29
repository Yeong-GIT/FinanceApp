package gityeong.backend.departments.sales.dao;

import gityeong.backend.departments.sales.entity.Sale;

import java.util.List;

public interface SaleDAO {

    List<Sale> findAll();
}
