package cn.itcast.controller;

import cn.itcast.Product;
import cn.itcast.service.impl.ProductServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class productController {

    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/findAllProduct")
    public String  findAll(Model model, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue =  "3")int pageSize){
        PageInfo<Product> pb =  productService.findAllProduct(pageNum,pageSize);
        model = model.addAttribute("pb" ,pb);
        return "product/productList";
    }

}
