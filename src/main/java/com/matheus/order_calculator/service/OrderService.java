package com.matheus.order_calculator.service;

import com.matheus.order_calculator.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total (Order order){
        double shipment = this.shippingService.shipment(order);
        double discount = order.getBasic() * order.getDiscount() / 100;

        return order.getBasic() + shipment - discount;
    }
}
