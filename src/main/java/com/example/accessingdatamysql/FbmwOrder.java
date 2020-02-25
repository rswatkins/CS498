package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class FbmwOrder {

    @Id
    private Integer purchaseOrderNumber;
    private int salesOrder;
    private String date;
    private String customer;
    private String operator;

    @OneToMany(mappedBy="fbmwOrder")
    private Set<FbmwOrderItem> fbmwOrderItems;

    public Integer getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(Integer purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public int getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(int salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
