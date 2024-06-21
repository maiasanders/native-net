package com.example.nativeNurseryApi.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LineItem {
    private int lineItemId;
    @NotNull(message = "Field plant should not be null")
    private Plant plant;
    @Positive(message = "Field order_id should be a positive integer")
    private int orderID;
    @Positive(message = "Field quantity should be a positive integer")
    private int quantity;

    public LineItem() {}

    public LineItem(Plant plant, int orderID, int quantity) {
        this.plant = plant;
        this.orderID = orderID;
        this.quantity = quantity;
    }

    public int getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
