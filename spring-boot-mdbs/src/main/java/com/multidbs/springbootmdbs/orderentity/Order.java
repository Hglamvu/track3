package com.multidbs.springbootmdbs.orderentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name ="Orders")
public class Order {
    @Id
    private int orderId;
    private String orderfrom;
    private LocalDate orderdate;

    public Order() {
    }

    public Order(int orderId, String orderfrom, LocalDate orderdate) {
        this.orderId = orderId;
        this.orderfrom = orderfrom;
        this.orderdate = orderdate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderfrom() {
        return orderfrom;
    }

    public void setOrderfrom(String orderfrom) {
        this.orderfrom = orderfrom;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }
}
