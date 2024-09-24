package com.matheus.order_calculator.service;

import com.matheus.order_calculator.model.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment (Order order) {
        double shippingValue = 0;

        if(order.getBasic() < 100) return 20;
        if(order.getBasic() < 200) return 12;

        return shippingValue;
    }
}
