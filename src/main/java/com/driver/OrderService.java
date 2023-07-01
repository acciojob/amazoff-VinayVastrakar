package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    //    @Autowired
    OrderRepository orderRepository = new OrderRepository();
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void addPartner(String partnerId) {
        orderRepository.addPartner(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addOrderPartnerPair(orderId, partnerId);
    }

    public Order getOrderById(String orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return orderRepository.getPartnerById(partnerId);
    }

    public Integer getOrderCountByPartnerId(String partnerId) {
        return orderRepository.getOrderCountByPartnerId(partnerId);
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        return orderRepository.getOrdersByPartnerId(partnerId);
    }

    public List<String> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public Integer getCountOfUnassignedOrders() {
        return orderRepository.getCountOfUnassignedOrders();
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        int lastDeliveryTime = orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
        if(lastDeliveryTime == -1)
            return null;
        String MM = String.valueOf(lastDeliveryTime % 60);
        String HH = String.valueOf(lastDeliveryTime / 60);
        if(HH.length() < 2)
            HH = "0" + HH;
        if(MM.length() < 2)
            MM = "0" + MM;
        return (HH + ":" + MM);
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
        int HH = Integer.parseInt(time.substring(0, 2));
        int MM = Integer.parseInt(time.substring(3, 5));
        int givenTime  = (HH * 60) + MM;
        return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(givenTime, partnerId);
    }

    public void deletePartnerById(String partnerId) {
        orderRepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
        orderRepository.deleteOrderById(orderId);
    }
}