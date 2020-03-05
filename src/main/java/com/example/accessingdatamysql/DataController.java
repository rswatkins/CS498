package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @Autowired
    private FbmwOrderRepository fbmwOrderRepository;
    @Autowired
    private FbmwOrderItemRepository fbmwOrderItemRepository;

    @PostMapping(path="/fbmw-order/add")
    public String addNewOrder(@RequestParam String date,
                                            @RequestParam String operator,
                                            @RequestParam int salesOrder,
                                            @RequestParam String customer,
                                            @RequestParam int purchaseOrderNumber) {

        FbmwOrder fbmwOrder = new FbmwOrder();
        fbmwOrder.setDate(date);
        fbmwOrder.setOperator(operator);
        fbmwOrder.setSalesOrder(salesOrder);
        fbmwOrder.setCustomer(customer);
        fbmwOrder.setPurchaseOrderNumber(purchaseOrderNumber);
        fbmwOrderRepository.save(fbmwOrder);
        return "Saved";
    }

    @PostMapping(path="/fbmw-order-item/add")
    public String addNewItem(@RequestParam String serialNumber,
                                           @RequestParam float radial,
                                           @RequestParam float axial,
                                           @RequestParam float tangential,
                                           @RequestParam int fbmwOrder_id)
    {
        FbmwOrderItem fbmwOrderItem = new FbmwOrderItem();
        fbmwOrderItem.setSerialNumber(serialNumber);
        fbmwOrderItem.setRadial(radial);
        fbmwOrderItem.setTangential(tangential);
        fbmwOrderItem.setFbmwOrder(fbmwOrderRepository.findById(fbmwOrder_id).get());
        fbmwOrderItemRepository.save(fbmwOrderItem);
        return "Saved";
    }

    @GetMapping(path="/fbmw-order/all")
    public Iterable<FbmwOrder> getAllFbmwOrders() {
        return fbmwOrderRepository.findAll();
    }

    @GetMapping(path="/fbmw-order-item/all")
    public Iterable<FbmwOrderItem> getAllFbmwOrderItems() {
        return fbmwOrderItemRepository.findAll();
    }

}
