package com.thd.codetest;

import com.thd.codetest.models.Order;
import com.thd.codetest.models.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public Order calculate(Order order) {
        //first calculate all line totals
        for(OrderLine line : order.OrderLines){
            line.calculateAndSetLineTotal();
        }

        //then calculate order total
        order.calculateAndSetOrderTotal();
        return order;
    }


}
