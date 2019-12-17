//package com.example.demo.presentation;
//
//import com.example.demo.domain.UserEntity;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class UserServiceDetails implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
////    @Override
//    @Transactional
//    public UserDetails loadUserByName(String name) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByName(name);
//        if (userEntity == null)
//            throw new UsernameNotFoundException(name);
//
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(name));
//
//        return new org.springframework.security.core.userdetails.User(userEntity.getName(), userEntity.getPassword(), grantedAuthorities);
//    }
//}
