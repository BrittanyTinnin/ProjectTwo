package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.revature.daoimpl.UserDao;



public class UserDetailsService {
    @Autowired
    private UserDao userDao;

  //  @Transactional(readOnly = true)
   // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       // User user = userDao.findByUsername(username);

        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

    //    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }


