package com.UmiUni.shop.salesOrderservice.repository;

import com.UmiUni.shop.salesOrderservice.constant.OrderStatus;
import com.UmiUni.shop.salesOrderservice.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

    Optional<SalesOrder> getSalesOrderBySalesOrderSn(String salesOrderSn);

    List<SalesOrder> getSalesOrdersByOrderDateAfterAndOrderStatus(LocalDateTime day, OrderStatus orderStatus);

    List<SalesOrder> findByOrderDateBetweenAndOrderStatus(LocalDateTime startDate, LocalDateTime endDate, OrderStatus orderStatus);


    Optional<SalesOrder> findBySupplierIdAndSalesOrderId(Long supplierId, Long id);

    List<SalesOrder> findAllBySupplierId(Long supplierId);

    Optional<SalesOrder> findBySupplierIdAndSalesOrderSn(Long supplierId, String salesOrderSn);

    void deleteBySalesOrderIdAndSupplierId(Long supplierId, Long id);

    // financial report
    List<SalesOrder> findBySupplierIdAndOrderDateBetweenAndOrderStatus(Long supplierId, LocalDateTime startDate, LocalDateTime endDate, OrderStatus orderStatus);

}
