package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FbmwOrderItem {

    @Id
    private String serialNumber;
    private float radial;
    private float axial;
    private float tangential;

    // Automatically creates foreign key
    // fbmwOrder_id using primary key
    // of fbmwOrder
    @ManyToOne
    private FbmwOrder fbmwOrder;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public float getRadial() {
        return radial;
    }

    public void setRadial(float radial) {
        this.radial = radial;
    }

    public float getAxial() {
        return axial;
    }

    public void setAxial(float axial) {
        this.axial = axial;
    }

    public float getTangential() {
        return tangential;
    }

    public void setTangential(float tangential) {
        this.tangential = tangential;
    }

    public FbmwOrder getFbmwOrder() {
        return fbmwOrder;
    }

    public void setFbmwOrder(FbmwOrder fbmwOrder) {
        this.fbmwOrder = fbmwOrder;
    }
}
