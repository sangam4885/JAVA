public class Item {
    private String name;
    private String type;
    private double price;
    private String size = "MEDIUM";

    public Item(String type, String name, double price) {
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();
        this.price = price;
    }

    public double getBasePrice() {
        return this.price;
    }

    public String getName() {
        if (type.equals("DRINK") || type.equals("SIDE")) {
            return size + " " + name;
        }
        return name;
    }

    public double getAdjustedPrice() {
        return switch (size) {
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public void setSize(String size) {
        this.size = size.toUpperCase();
    }

    public void printItem() {
        printItem(getName(), getAdjustedPrice());
    }

    public static void printItem(String name, double price) {
        System.out.printf("%20s : %6.2f %n", name, price);
    }
}
