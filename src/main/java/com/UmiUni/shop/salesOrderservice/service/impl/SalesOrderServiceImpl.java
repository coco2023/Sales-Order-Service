package com.UmiUni.shop.salesOrderservice.service.impl;

import com.UmiUni.shop.salesOrderservice.entity.SalesOrder;
import com.UmiUni.shop.salesOrderservice.repository.SalesOrderRepository;
import com.UmiUni.shop.salesOrderservice.service.SalesOrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Override
    public SalesOrder createSalesOrder(SalesOrder salesOrder) {
        LocalDateTime time = LocalDateTime.now();
        salesOrder.setOrderDate(time);
        salesOrder.setLastUpdated(time);
        salesOrder.setExpirationDate(time.plusMinutes(2));
        log.info("***salesOrder: " + salesOrder);
        return salesOrderRepository.save(salesOrder);
    }

    @Override
    public SalesOrder getSalesOrder(Long id) {
        return salesOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SalesOrder not found with id: " + id));
    }

    @Override
    public List<SalesOrder> getAllSalesOrders() {
        return salesOrderRepository.findAll();
    }

    @Override
    public SalesOrder updateSalesOrder(Long id, SalesOrder salesOrderDetails) {
        SalesOrder salesOrder = getSalesOrder(id);
        salesOrder.setSalesOrderSn(salesOrderDetails.getSalesOrderSn());
        salesOrder.setCustomerId(salesOrderDetails.getCustomerId());
        salesOrder.setOrderDate(salesOrderDetails.getOrderDate());
        salesOrder.setTotalAmount(salesOrderDetails.getTotalAmount());
        salesOrder.setShippingAddress(salesOrderDetails.getShippingAddress());
        salesOrder.setBillingAddress(salesOrderDetails.getBillingAddress());
        salesOrder.setOrderStatus(salesOrderDetails.getOrderStatus());
        salesOrder.setPaymentMethod(salesOrderDetails.getPaymentMethod());
        // other updates as needed
        return salesOrderRepository.save(salesOrder);
    }

    @Override
    public void deleteSalesOrder(Long id) {
        salesOrderRepository.deleteById(id);
    }

    @Override
    public SalesOrder getSalesOrderBySalesOrderSn(String salesOrderSn) {
        return salesOrderRepository.getSalesOrderBySalesOrderSn(salesOrderSn).get();
    }
}
