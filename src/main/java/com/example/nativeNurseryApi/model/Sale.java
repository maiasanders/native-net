package com.example.nativeNurseryApi.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.lang.NonNull;

import java.beans.Customizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private int saleId;
    @Positive
    private int customerId;
    private Customer customer;
    @Positive
    private int nurseryId;
    private Nursery nursery;
    @NotNull(message = "Field \"order_date\" may not be null")
    private LocalDate orderDate;
    private boolean isDelivery;
    private LocalDate deliveryDate;
    private String pickupLocation;
    private LocalDate pickupDate;
    private List<LineItem> items;

    public Sale() {
        this.items = new ArrayList<>();
    }

    public Sale(int customerId, @NonNull LocalDate orderDate, boolean isDelivery, LocalDate deliveryDate, String pickupLocation, LocalDate pickupDate) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.isDelivery = isDelivery;
        this.deliveryDate = deliveryDate;
        this.pickupLocation = pickupLocation;
        this.pickupDate = pickupDate;
        this.items = new ArrayList<>();
    }
    public void addItemToSale(LineItem item) {
        items.add(item);
    }
}
