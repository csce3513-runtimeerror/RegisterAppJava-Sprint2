package edu.uark.registerapp.models.api;

import java.util.UUID;

public class TransactionEntryCreate extends ApiResponse {
    private UUID productId;
    public UUID getProductId() {
        return this.productId;
    }
    public TransactionEntryCreate setProductId(UUID productId) {
        this.productId = productId;
        return this;
    }

    private UUID transactionId;
    public UUID getTransactionId() {
        return this.transactionId;
    }
    public TransactionEntryCreate setTransactionId(UUID transactionId){
        this.transactionId = transactionId;
        return this;
    }

    private String itemname;
    public String getItemName() {
        return this.itemname;
    }
    public TransactionEntryCreate setItemName(final String name) {
        this.itemname = name;
        return this;
    }

    public TransactionEntryCreate() {
        this.productId = new UUID(0, 0);
        this.transactionId = new UUID(0, 0);
        this.itemname = "";
    }
}