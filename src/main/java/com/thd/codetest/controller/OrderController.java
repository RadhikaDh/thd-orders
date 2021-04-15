package com.thd.codetest.controller;

import com.thd.codetest.OrderService;
import com.thd.codetest.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    @Autowired
    public OrderService service;


    @RequestMapping(method = RequestMethod.POST, value = "/order/calculate")
    public Order calculateOrder(@RequestBody Order order) {
        return service.calculate(order);
    }

}
