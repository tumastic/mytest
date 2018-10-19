package cn.itcast.dao;

import cn.itcast.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sysRoleDao {

    @Select("select * from sys_role where id in (select roleId from sys_user_role where userId = #{id})")
    List<SysRole> findById();

    @Select("select * from sys_role ")
    List<SysRole> findAllRole();

    @Delete("delete from sys_role where id in ")
    void removeRoleById();
}
