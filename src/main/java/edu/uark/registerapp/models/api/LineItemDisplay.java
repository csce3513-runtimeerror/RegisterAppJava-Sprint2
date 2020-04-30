package edu.uark.registerapp.models.api;

public class LineItemDisplay extends ApiResponse {
     private String lookupCode;
     private double price;
     private double quantity;
     public LineItemDisplay(String lookupCode, double price, double quantity){
        super();
        this.lookupCode = lookupCode;
        this.price = price;
        this.quantity = quantity;
    }
    
}