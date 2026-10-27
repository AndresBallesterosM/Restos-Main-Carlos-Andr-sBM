package co.edu.taller.structural;

public class CheckoutFacade {
    public interface Inventory {
        boolean reserve(String sku, int quantity);
    }

    public interface Payment {
        boolean charge(String orderId, long amount);
    }

    private final Inventory inventory;
    private final Payment payment;

    public CheckoutFacade(Inventory i, Payment p) {
        inventory = i;
        payment = p;
    }

    public String checkout(String orderId, String sku, int quantity, long amount) {
        if (orderId == null || orderId.isBlank() || sku == null || sku.isBlank()
                || quantity <= 0 || amount <= 0) {
            throw new IllegalArgumentException("Invalid checkout data");
        }

        if (!inventory.reserve(sku, quantity)) {
            throw new IllegalStateException("Inventory unavailable");
        }

        if (!payment.charge(orderId, amount)) {
            throw new IllegalStateException("Payment declined");
        }

        return "CONFIRMED:" + orderId;
    }
}