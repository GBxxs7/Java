package jiao.zi.hao.jiaozihao.service.impl;

import jiao.zi.hao.jiaozihao.entity.TProduct;
import jiao.zi.hao.jiaozihao.mapper.TProductMapper;
import jiao.zi.hao.jiaozihao.service.ITProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TProductService implements ITProductService {

    @Autowired
    TProductMapper tProductMapper;

    @Override
    public List<TProduct> productInquire() {
        List<TProduct> tProducts = tProductMapper.productInquire();
        return tProducts;
    }

    @Override
    public void productAdd(TProduct tProduct) {
        tProductMapper.productAdd(tProduct);
    }

    @Override
    public void productDeleteById(Integer id) {
        tProductMapper.productDeleteById(id);
    }

    @Override
    public void productChange(TProduct tProduct) {
        tProductMapper.productChange(tProduct);
    }

    @Override
    public List<TProduct> productCheck(String name) {
        return tProductMapper.productCheck(name);
    }

    @Override
    public List<TProduct> searchByName(String name) {
        List<TProduct> tProducts = tProductMapper.searchByName(name);
        return tProducts;
    }
}
