package edu.uark.registerapp.models.api;

public class LineItemDisplay extends ApiResponse {
    private String lookupCode;
    private double price;
    private double quantity;

    public LineItemDisplay(String lookupCode, double price, double quantity) {
        super();
        this.setLookupCode(lookupCode);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }
    
}