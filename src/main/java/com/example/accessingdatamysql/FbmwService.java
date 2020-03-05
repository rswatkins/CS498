package com.example.accessingdatamysql;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FbmwService {
    @Autowired
    private FbmwOrderRepository fbmwOrderRepository;
    @Autowired
    private FbmwOrderItemRepository fbmwOrderItemRepository;

    public void addFbmwOrder(String date,
                             String operator,
                             int salesOrder,
                             String customer,
                             int purchaseOrderNumber) {
        FbmwOrder fbmwOrder = new FbmwOrder();
        fbmwOrder.setDate(date);
        fbmwOrder.setOperator(operator);
        fbmwOrder.setSalesOrder(salesOrder);
        fbmwOrder.setCustomer(customer);
        fbmwOrder.setPurchaseOrderNumber(purchaseOrderNumber);
        fbmwOrderRepository.save(fbmwOrder);
    }

    public void addFbmwOrderItem(String serialNumber,
                             float radial,
                             float axial,
                             float tangential,
                             int fbmwOrder_id) {
        FbmwOrderItem fbmwOrderItem = new FbmwOrderItem();
        fbmwOrderItem.setSerialNumber(serialNumber);
        fbmwOrderItem.setRadial(radial);
        fbmwOrderItem.setTangential(tangential);
        fbmwOrderItem.setFbmwOrder(fbmwOrderRepository.findById(fbmwOrder_id).get());
        fbmwOrderItemRepository.save(fbmwOrderItem);
    }

    public Iterable<FbmwOrder> getAllFbmwOrders() {
        return fbmwOrderRepository.findAll();
    }

    public Iterable<FbmwOrderItem> getAllFbmwOrderItems() {
        return fbmwOrderItemRepository.findAll();
    }
}
