package jiao.zi.hao.jiaozihao.service;

import jiao.zi.hao.jiaozihao.entity.TProduct;

import java.util.List;

public interface ITProductService {
    List<TProduct> productInquire();

    void productAdd(TProduct tProduct);

    void productDeleteById(Integer id);

    void productChange(TProduct tProduct);

    List<TProduct> productCheck(String name);

    List<TProduct> searchByName(String name);
}
