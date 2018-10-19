package cn.itcast.service.impl;

import cn.itcast.SysRole;
import cn.itcast.dao.sysRoleDao;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private sysRoleDao sysRoleDao;

    @Override
    public List<SysRole> findAllRole() {
        List<SysRole> roles = sysRoleDao.findAllRole();
        return roles;
    }


}
