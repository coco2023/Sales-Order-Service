package com.UmiUni.shop.salesOrderservice.service;


import com.UmiUni.shop.salesOrderservice.entity.SalesOrder;

import java.util.List;

public interface SalesOrderService {
    SalesOrder createSalesOrder(SalesOrder salesOrder);
    SalesOrder getSalesOrder(Long id);
    List<SalesOrder> getAllSalesOrders();
    SalesOrder updateSalesOrder(Long id, SalesOrder salesOrderDetails);
    void deleteSalesOrder(Long id);

    SalesOrder getSalesOrderBySalesOrderSn(String salesOrderSn);
}
