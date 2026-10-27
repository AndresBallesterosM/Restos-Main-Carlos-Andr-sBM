package co.edu.taller.structural;

interface PaymentPort {
    String charge(String orderId, long pesos);
}

public class PaymentGatewayAdapter implements PaymentPort {

    public static class LegacyGateway {
        public String chargeInCents(String id, long cents) {
            return "LEGACY:" + id + ":" + cents;
        }
    }

    private final LegacyGateway legacy;

    public PaymentGatewayAdapter(LegacyGateway legacy) {
        this.legacy = legacy;
    }

    @Override
    public String charge(String orderId, long pesos) {

        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (pesos <= 0) {
            throw new IllegalArgumentException();
        }

        return legacy.chargeInCents(orderId, pesos * 100);
    }
}