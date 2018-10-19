package cn.itcast.service;

import cn.itcast.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
      List<SysUser> findAllUser();

      int saveUser(SysUser user);

      SysUser findUserById(int id);


    void managerUserRole(Integer userId, Integer[] ids);
}
