package co.edu.taller.behavioral;

public class ShippingRateStrategy {

    public interface Rate {
        long calculate(long base);
    }

    public enum Mode {
        STANDARD,
        EXPRESS,
        NIGHT
    }

    public long quote(Mode mode, long base) {

        if (base <= 0) {
            throw new IllegalArgumentException();
        }

        Rate strategy;

        switch (mode) {

            case STANDARD:
                strategy = value -> value;
                break;

            case EXPRESS:
                strategy = value -> value + 8000;
                break;

            case NIGHT:
                strategy = value -> value + 12000;
                break;

            default:
                throw new IllegalArgumentException();
        }

        return strategy.calculate(base);
    }
}