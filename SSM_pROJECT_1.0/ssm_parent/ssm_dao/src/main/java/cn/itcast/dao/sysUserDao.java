package cn.itcast.dao;

import cn.itcast.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sysUserDao {

    @Select("select * from SYS_USER  where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id",property = "roles",javaType = List.class,
                    many=@Many(select = "cn.itcast.dao.sysRoleDao.findById")),
    })
    SysUser findUserByName(String username);

    @Select("select * from sys_user")
    List<SysUser> findUserAll();

    @Insert("insert into SYS_USER  values(usersave.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    int saveUser(SysUser user);

    @Select("select * from sys_user where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property="id"),
            @Result(column="id",property = "roles",javaType = List.class,
                    many = @Many(select = "cn.itcast.dao.sysRoleDao.findById"))
    })
    SysUser findUserById(int id);

    @Delete("delete from sys_user_role where userId= #{id}")
    void removeRoleByUserId(int id);

    @Insert("insert into sys_user_role values(#{userId},#{roleId})")
    void saveUserRole(@Param("userId") Integer userId, @Param("roleId") int roleId);
}
