package com.thd.codetest.controller;

import com.thd.codetest.OrderService;
import com.thd.codetest.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@RestController
public class OrderController {

    @Autowired
    public OrderService service;


    @RequestMapping(method = RequestMethod.POST, value = "/orders/calculate")
    public Order calculateOrder(@RequestBody Order order) {
        return service.calculate(order);
    }

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thd.codetest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Order Calculation")
                .description("API for calculating Order totals based on Line Orders")
                .contact(new Contact("Radhika Dharulkar", "https://www.linkedin.com/in/radhikadharulkar/", "rdk28dh@gmail.com"))
                .build();
    }

}
