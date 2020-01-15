package com.qf.realm;


import com.qf.beans.User;
import com.qf.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("AuthorizationInfo" + principals);

        return null;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //真正的执行登录的位置
        UsernamePasswordToken user1 = (UsernamePasswordToken) token;

        //在数据库查询用户
        User user = userService.getUserByName(user1.getUsername());

        if (null == user){
            throw new UnknownAccountException("用户为空");
        }

        if(user.getAstatus() ==3){
            throw new LockedAccountException("用户被锁定");
        }

        //认证过程交给shiro完成
        String principal = user1.getUsername();  //账号
        String credentials = user.getApass(); //从数据库 获取密码
        String realmName = super.getName(); //realm的名字

        //进行注册时加入盐值;登录时同样也需要
        ByteSource bs = ByteSource.Util.bytes(principal);

        AuthenticationInfo ai = new SimpleAuthenticationInfo(principal,credentials,bs,realmName);

        return ai;
    }
}
