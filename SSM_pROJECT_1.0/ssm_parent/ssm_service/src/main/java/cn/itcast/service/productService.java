package cn.itcast.service;

import cn.itcast.Product;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface productService {

    PageInfo<Product> findAllProduct(int pageNum, int pageSize);
}
