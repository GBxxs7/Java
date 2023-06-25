package jiao.zi.hao.jiaozihao.entity;

import lombok.Data;

@Data
public class TProduct {
    private Integer product_id;
    private String name;
    private Double price;
    private Integer quantity;
    private String descriptions;
    private Byte status;
}
