package cn.itcast.dao;

import cn.itcast.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface productDao {

    @Select("select * from product")
    List<Product> findAllProduct();

}
