package cn.itcast.controller;

import cn.itcast.SysRole;
import cn.itcast.SysUser;
import cn.itcast.service.RoleService;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.RoleServiceImpl;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class sysUserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    /*
        service事务
       1.查询所有的user  页面userList 返回uList

       2.增加user
       /user/addUserUI 经过方法控制器跳转useraAdd.jsp
       保存转到/user/saveUser 保存
       跳转到userList页面

       3.修改user
       /user/managerUserRoleUI?userId=${user.id}
       通过方法跳转到
       managerUserRole.jsp  给他roles,rStr
       保存返回/user/managerUserRole 进行保存处理
       userList页面
     */
    @RequestMapping("/findAllUser")
    public String findAllUser(Model model){
        List<SysUser> uList = userService.findAllUser();
        model.addAttribute("uList",uList);
        return "user/userList";
    }
     /*2.增加user
       /user/addUserUI 经过方法控制器跳转useraAdd.jsp
    保存转到/user/saveUser 保存
    跳转到userList页面*/
     @RequestMapping("/addUserUI")
     public String addUserUI(){
        return "/user/userAdd";
     }

     @RequestMapping("/saveUser")
    public String saveUser(SysUser user){
         int success = userService.saveUser(user);
         if(success>0){
             return "redirect:findAllUser";
         }else {
             return "/user/userAdd";
         }
     }
     /*
     *  3.修改user
       /user/managerUserRoleUI?userId=${user.id}
       通过方法跳转到
       managerUserRole.jsp  给他roles,rStr
       保存返回/user/managerUserRole 进行保存处理
       userList页面
     * */

     @RequestMapping("/managerUserRoleUI")
     public String managerUserRoleUI(Model model,int userId){
         SysUser user = userService.findUserById(userId);
         List<SysRole>roles = user.getRoles();
         List<SysRole>allRoles = roleService.findAllRole();
         String rStr = "";
         if(roles!=null&&roles.size()>0){
            for(SysRole role:roles){
               rStr +=role.getRoleName()+",";
            }
         }
         model.addAttribute("roles",allRoles);
         model.addAttribute("user",user);
         model.addAttribute("rStr",rStr);
         return "user/managerUserRole";
     }

     @RequestMapping("/managerUserRole")
    public String managerUserRole(Integer userId,Integer[] ids){
           userService.managerUserRole(userId,ids);
         return "redirect:findAllUser";
     }


}
