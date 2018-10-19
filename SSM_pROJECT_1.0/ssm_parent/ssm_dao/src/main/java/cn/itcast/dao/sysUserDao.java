package cn.itcast.dao;

import cn.itcast.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sysUserDao {

    @Select("select * from SYS_USER  where username=#{username}  ")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id",property = "roles",javaType = List.class,
                    many=@Many(select = "cn.itcast.dao.sysRoleDao.findById")),
    })
    SysUser findUserByName(String username);
}
