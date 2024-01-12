package com.UmiUni.shop.salesOrderservice.service;

import com.UmiUni.shop.salesOrderservice.entity.SalesOrderDetail;

import java.util.List;

public interface SalesOrderDetailService {
    SalesOrderDetail createSalesOrderDetail(SalesOrderDetail salesOrderDetail);
    SalesOrderDetail getSalesOrderDetail(Long id);
    List<SalesOrderDetail> getAllSalesOrderDetails();
    SalesOrderDetail updateSalesOrderDetail(Long id, SalesOrderDetail salesOrderDetailDetails);
    void deleteSalesOrderDetail(Long id);

    List<SalesOrderDetail> getSalesOrderDetailsBySalesOrderSn(String salesOrderSn);
}
