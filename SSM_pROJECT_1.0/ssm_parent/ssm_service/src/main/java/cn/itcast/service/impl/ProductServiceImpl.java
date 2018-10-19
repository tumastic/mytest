package cn.itcast.service.impl;

import cn.itcast.Product;
import cn.itcast.dao.productDao;
import cn.itcast.service.productService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements productService {

    @Autowired
    private productDao productDao;

    @Override
    public PageInfo<Product> findAllProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product>list = productDao.findAllProduct();
        PageInfo<Product> page = new PageInfo<>(list);
        return page;
    }
}
