package top.rainbowcat.shiro.realms;

import cn.hutool.core.bean.BeanUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import top.rainbowcat.common.lang.UserProfile;
import top.rainbowcat.entity.User;
import top.rainbowcat.service.UserService;
import top.rainbowcat.shiro.JwtToken;
import top.rainbowcat.utils.JwtUtils;

@Slf4j
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    public void setName(String name){
        super.setName("loginRealm");
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 在用户认证通过后，根据安全数据获取用户具有的所有操作权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取已认证的用户数据
        User user = (User) principalCollection.getPrimaryPrincipal();
        //查询相应数据库获取权限信息即可
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwt = (JwtToken) authenticationToken;
        Claims claims = jwtUtils.parseJwt((String) jwt.getPrincipal());
        String username = (String) claims.get("username");
        User user = userService.findByUserName(username);
        if (user == null){
            throw new UnknownAccountException("账户不存在！");
        }
        UserProfile profile = new UserProfile();
        BeanUtil.copyProperties(user, profile);
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), this.getName());
    }
}
