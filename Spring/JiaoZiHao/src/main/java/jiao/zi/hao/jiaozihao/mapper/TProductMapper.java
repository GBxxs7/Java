package jiao.zi.hao.jiaozihao.mapper;

import jiao.zi.hao.jiaozihao.entity.TProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TProductMapper {

    List<TProduct> productInquire();

    void productAdd(TProduct tProduct);

    void productDeleteById(Integer id);

    void productChange(TProduct tProduct);

    List<TProduct> productCheck(String name);

    List<TProduct> searchByName(String name);
}
