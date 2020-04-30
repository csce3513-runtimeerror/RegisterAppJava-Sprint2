package edu.uark.registerapp.models.api;

public class LineItemDisplay extends ApiResponse {
     private String lookupCode;
     private double price;
     public LineItemDisplay(String lookupCode, double price){
        super();
        this.lookupCode = lookupCode;
        this.price = price;

    }
    
}