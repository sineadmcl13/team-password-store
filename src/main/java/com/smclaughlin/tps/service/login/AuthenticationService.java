package com.smclaughlin.tps.service.login;

import com.smclaughlin.tps.pojos.UserPojo;
import com.smclaughlin.tps.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sineadmclaughlin on 01/02/2017.
 */
@Service
public class AuthenticationService implements AuthenticationProvider {

    @Autowired
    private IUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        if(userService.checkLoginIsValid(username, password)){

            UserPojo loggedInMember = userService.returnUserByUsername(username);
            List<GrantedAuthority> authorityList =  AuthorityUtils.createAuthorityList("ROLE_ADMIN");
            return new UsernamePasswordAuthenticationToken(loggedInMember, password, authorityList);

        }else{
            return null;
        }

    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}