package comparableAndComparator;

public class Product {

    private int pId;
    private String name;
    private double price;
    private double rating;

    public Product(int pId, String name, double price, double rating) {
        this.pId = pId;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricing() {
        return this.price;
    }

    public void setPricing(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
