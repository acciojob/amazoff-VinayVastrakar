package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository or=new OrderRepository();
    public void addOrder(Order order) {
        or.addOrder(order);
    }

    public void addPartner(String partnerId) {
        or.addPartner(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        or.addOrderPartnerPair(orderId,partnerId);
    }

    public Order getOrderById(String orderId) {
        return or.getOrderByID(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return or.getPartnerById(partnerId);
    }

    public int getOrderCountByPartnerId(String partnerId) {
        return or.getOrderCountByPartnerId(partnerId);
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        return or.getOrdersByPartnerId(partnerId);
    }

    public List<String> getAllOrders() {
        return or.getAllorders();
    }

    public int getCountOfUnassignedOrders() {
        return or.getCountOfUnassignedOrders();
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(String Dtime, String partnerId) {
        String time[] = Dtime.split(":");//hh:mm
        int newTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);

        return or.getOrdersLeftAfterGivenTimeByPartnerId(newTime, partnerId);

    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        int time = or.getLastDeliveryTimeByPartnerId(partnerId);
        String HH = String.valueOf(time/60);
        String MM = String.valueOf(time%60);
        if(HH.length()< 2){
            HH='0'+HH;
        }
        if(MM.length()<2){
            MM='0'+MM;
        }

        return HH+':'+MM;
    }

    public void deletePartnerById(String partnerId) {
        or.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
        or.deleteOrderById(orderId);
    }
}
