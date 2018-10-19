package cn.itcast.service.impl;

import cn.itcast.SysRole;
import cn.itcast.SysUser;
import cn.itcast.dao.sysUserDao;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private sysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      SysUser sysUser = sysUserDao.findUserByName(username);
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        List<SysRole> roles = sysUser.getRoles();
        if(roles!=null&&roles.size()>0) {
            for (SysRole role : roles) {
                authorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }
        User user = new User(sysUser.getUsername(),sysUser.getPassword(),sysUser.getStatus()==1?true:false,true,true,true,authorityList);
        return user;
    }
}
