package com.devsuperior.aula.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.aula.entities.Order;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double basic = order.getBasic();
        double discount = order.getDiscount();
        double shipment = shippingService.shipment(order);

        double valorDesconto = basic * (discount / 100);

        return basic - valorDesconto + shipment;
    }
}
