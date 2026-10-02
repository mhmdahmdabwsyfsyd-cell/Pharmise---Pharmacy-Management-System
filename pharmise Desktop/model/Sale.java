package pharmise.model;

import java.time.LocalDateTime;

public class Sale {
    private String medicineName;
    private int quantity;
    private double totalPrice;
    private LocalDateTime date;

    public Sale(String medicineName, int quantity, double totalPrice) {
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = LocalDateTime.now();
    }

    public String getMedicineName() { return medicineName; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }

    public String toCSV() {
        return medicineName + "," + quantity + "," + totalPrice;
    }
}