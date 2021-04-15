package com.thd.codetest.models;

import java.math.BigDecimal;
import java.util.List;

public class OrderLine {
    public String OrderLineNumber;
    public String LineStatus;
    public BigDecimal LineTotalWithoutTax;
    public List<LineCharges> LineCharges;
    public List<Taxes> Taxes;
    public BigDecimal LineTotal;

    public void calculateAndSetLineTotal() {
        //LineTotal = LineTotalWithoutTax + (Sum of all Charges) + (Sum of all Taxes)
        BigDecimal total = LineTotalWithoutTax;
        for (LineCharges charge : this.LineCharges) {
            total = total.add(charge.ChargeAmount);
        }
        for (Taxes tax : this.Taxes) {
            total = total.add(tax.TaxAmount);
        }
        this.LineTotal = total;
    }


}
