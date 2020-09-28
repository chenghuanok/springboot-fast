package com.share.fast.security;

import com.share.fast.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 自定义用户登录
 * @Author: chenghuan
 * @Date: 2020/9/27 15:34
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 密码加密
    */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("执行自定义登录逻辑，用户名为："+username);
        //根据用户名查找对应用户信息
        if(!"admin".equals(username)){
           throw new BizException("用户不存在");
        }
        //比较密码，成功返回user(密码一般来自数据库，这里为了方便写死)
        final String password = passwordEncoder.encode("123");
        final User user = new User(username,password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
