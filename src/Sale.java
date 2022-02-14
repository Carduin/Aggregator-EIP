public class Sale {

    private Integer productId;

    private Integer clientId;

    private String name;

    private Double price;

    private Integer quantity;

    public Sale(String data) {
        String[] values = data.split(";");
        clientId = Integer.valueOf(values[0]);
        productId = Integer.valueOf(values[1]);
        name = values[2];
        price = Double.valueOf(values[3]);
        quantity = Integer.valueOf(values[4]);
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
