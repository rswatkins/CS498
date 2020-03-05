package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FbmwController {
    @Autowired
    private FbmwService fbmwService;

    @PostMapping(path = "/fbmw-order/add")
    public String addNewOrder(@RequestParam String date,
                              @RequestParam String operator,
                              @RequestParam int salesOrder,
                              @RequestParam String customer,
                              @RequestParam int purchaseOrderNumber) {
        fbmwService.addFbmwOrder(date, operator, salesOrder,customer,purchaseOrderNumber);
        return "Saved";
    }

    @PostMapping(path = "/fbmw-order-item/add")
    public String addNewItem(@RequestParam String serialNumber,
                             @RequestParam float radial,
                             @RequestParam float axial,
                             @RequestParam float tangential,
                             @RequestParam int fbmwOrder_id) {
        fbmwService.addFbmwOrderItem(serialNumber, radial, axial, tangential, fbmwOrder_id);
        return "Saved";
    }

    @GetMapping(path = "/fbmw-order/all")
    public Iterable<FbmwOrder> getAllFbmwOrders() {
        return fbmwService.getAllFbmwOrders();
    }

    @GetMapping(path = "/fbmw-order-item/all")
    public Iterable<FbmwOrderItem> getAllFbmwOrderItems() {
        return fbmwService.getAllFbmwOrderItems();
    }

}
