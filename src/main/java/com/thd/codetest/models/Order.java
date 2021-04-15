package com.thd.codetest.models;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    public String OrderNumber;
    public String OrderType;
    public String OrderDate;
    public List<OrderLine> OrderLines;
    public BigDecimal OrderTotal;


    public void calculateAndSetOrderTotal() {
        //OrderTotal = (Sum of all CREATED LineTotals) - (Sum of all CANCELLED and RETURNED LineTotals)
        BigDecimal createdSum = new BigDecimal("0");
        BigDecimal canOrRetSum = new BigDecimal("0");
        for(OrderLine line : this.OrderLines){
            if(line.LineStatus.equals("CREATED"))
                createdSum = createdSum.add(line.LineTotal);

            else if(line.LineStatus.equals("CANCELLED") || line.LineStatus.equals("RETURNED"))
                canOrRetSum = canOrRetSum.add(line.LineTotal);
            else{
                // do Nothing
            }

        }

        this.OrderTotal = createdSum.subtract(canOrRetSum);
    }

}
