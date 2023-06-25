package jiao.zi.hao.jiaozihao.entity;

public class Product {
    private Integer product_id;
    private String name;
    private Double price;
    private Integer quantity;
    private String descriptions;
    private Byte status;

    public Product() {
    }

    public Product(Integer product_id, String name, Double price, Integer quantity, String descriptions, Byte status) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
