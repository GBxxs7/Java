package jiao.zi.hao.jiaozihao.controller;

import jiao.zi.hao.jiaozihao.common.Result;
import jiao.zi.hao.jiaozihao.entity.TProduct;
import jiao.zi.hao.jiaozihao.exception.ServiceException;
import jiao.zi.hao.jiaozihao.service.ITProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tproduct")
public class TProductController {
    @Autowired
    ITProductService itProductService;

    // Product 查询全部商品接口
    @GetMapping("/productInquire")
    public Result productInquire() {
        List<TProduct> tProducts = itProductService.productInquire();
        return Result.success(tProducts, "查询成功");
    }

    // Product 通过品名查询接口
    @PostMapping("/searchByName")
    public Result searchByName(@RequestParam String name) {
        List<TProduct> tProducts = itProductService.searchByName(name);
        return Result.success(tProducts,"查新成功");
    }

    // Product 添加商品接口
    @PostMapping("/productAdd")
    public Result productAdd(@RequestBody TProduct tProduct) {
        itProductService.productAdd(tProduct);
        return Result.success("添加成功");
    }

    // 删除商品数据接口
    @DeleteMapping("/productDeleteById/{id}")
    public Result productDeleteById(@PathVariable Integer id) {
        itProductService.productDeleteById(id);
        return Result.success();
    }

    // 修改管理员密码接口
    @PutMapping("/productChange")
    public Result productChange(@RequestBody TProduct tProduct) {
        itProductService.productChange(tProduct);
        return Result.success();
    }

    // 商品名查重接口
    @PostMapping("/productCheck/{name}")
    public Result productCheck(@PathVariable String name) {
        List<TProduct> tProducts = itProductService.productCheck(name);
        int index = tProducts.size();
        System.out.println(index);
        if (index == 0) {
            return Result.success(index,"商品名未重复");
        } else {
            throw new ServiceException("-1","商品名重复,请重新修改");
        }
    }
}
