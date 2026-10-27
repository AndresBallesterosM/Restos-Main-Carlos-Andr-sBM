package co.edu.taller.structural;

public interface ShippingCost {

    long cost();

    class Standard implements ShippingCost {

        @Override
        public long cost() {
            return 12000;
        }
    }

    abstract class Decorator implements ShippingCost {

        protected final ShippingCost delegate;

        protected Decorator(ShippingCost delegate) {

            if (delegate == null) {
                throw new IllegalArgumentException();
            }

            this.delegate = delegate;
        }
    }

    class Priority extends Decorator {

        public Priority(ShippingCost delegate) {
            super(delegate);
        }

        @Override
        public long cost() {
            return delegate.cost() + 6500;
        }
    }

    class Insurance extends Decorator {

        public Insurance(ShippingCost delegate) {
            super(delegate);
        }

        @Override
        public long cost() {
            return delegate.cost() + 3000;
        }
    }
}