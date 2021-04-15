# thd-orders
Expose an endpoint to calculate Order Total

Expose an endpoint to calculate OrderTotal, update the request and return the updated object as response.

1. Order Calculation Logic:
    Order total is the sum of all OrderLine LineTotals
      OrderTotal = (Sum of all CREATED LineTotals) - (Sum of all CANCELLED and RETURNED LineTotals)
2. Taxes and Charges should be added to the LineTotalWithoutTax to get the LineTotals
      LineTotal = LineTotalWithoutTax + (Sum of all Charges) + (Sum of all Taxes)
 
