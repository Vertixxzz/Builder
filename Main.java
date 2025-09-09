public class Main {

    public static void main(String[] args) {
        Product laptop = new Product.Builder()
                .withName("ThinkPad X1 Carbon")
                .inCategory("Laptop")
                .withPrice(1599.99)
                .ofBrand("Lenovo")
                .withDescription("Lightweight business laptop with high durability.")
                .withWarranty(24)
                .available(true)
                .build();

        Product tv = new Product.Builder()
                .withName("Bravia XR")
                .inCategory("TV")
                .withPrice(1200.00)
                .ofBrand("Sony")
                .withWarranty(12)
                .build();

        Product smartphone = new Product.Builder()
                .withName("Galaxy S23 Ultra")
                .inCategory("Smartphone")
                .withPrice(1299.00)
                .ofBrand("Samsung")
                .withDescription("Amazing flagship powered by SnapDragon gen 2(my phone btw)")
                .withWarranty(24)
                .available(false)
                .build();

        System.out.println(laptop);
        System.out.println(tv);
        System.out.println(smartphone);
    }
}

class Product {
    private final String name;
    private final String category;
    private final double price;
    private final String brand;
    private final String description;
    private final int warrantyMonths;
    private final boolean available;

    private Product(Builder builder) {
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.brand = builder.brand;
        this.description = builder.description;
        this.warrantyMonths = builder.warrantyMonths;
        this.available = builder.available;
    }

    public static class Builder {
        private String name;
        private String category;
        private double price;
        private String brand;
        private String description;
        private int warrantyMonths;
        private boolean available = true;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder inCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder withPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder ofBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withWarranty(int months) {
            this.warrantyMonths = months;
            return this;
        }

        public Builder available(boolean available) {
            this.available = available;
            return this;
        }

        public Product build() {
            if (name == null || name.isBlank()) {
                throw new IllegalStateException("Product must have a name.");
            }
            if (price <= 0) {
                throw new IllegalStateException("Product must have a valid price.");
            }
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s (%s) - $%.2f, Warranty: %d months, Available: %b. %s",
                brand, name, category, price, warrantyMonths, available,
                description == null ? "" : description
        );
    }
}