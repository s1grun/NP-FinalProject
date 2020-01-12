package com.example.demo.presentation;

import com.example.demo.application.UserService;
import com.example.demo.domain.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Key;
import java.util.Date;

//@SessionAttributes("user")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
//    Key key;

//    @ModelAttribute("user")
//    public UserService create() {
//        return new UserService();
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody UserModel user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        try{
            userService.registerUser(username, password);
            JSONObject res =  new JSONObject();
            res.put("status", 200);
            return res.toString();
        } catch (Exception ex) {
            System.out.println("Registration failed");
            JSONObject res =  new JSONObject();
            res.put("status",500);
            return res.toString();
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UserModel user) throws Exception {
        UserEntity loggedInUser = null;
        String username = user.getUsername();
        String password = user.getPassword();

        try {
//            key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//            Date date = new Date();
//            long d = date.getTime();
//            date = new Date(d + 30 * 60 * 1000);
//            /**
//             * Here we are constructing the JWT token for authentication
//             */
//            String jws = Jwts.builder().setSubject("john").setExpiration(date).signWith(key).compact();
            loggedInUser = userService.login(username, password);
            JSONObject res =  new JSONObject();
            String userid = loggedInUser.getUserId();
            res.put("status", 200);
            res.put("userid", userid);
            res.put("username",username);
//            res.put("token", jws);
            return res.toString();
        } catch (Exception ex) {
           System.out.println("Login failed");
            JSONObject res =  new JSONObject();
            res.put("status",500);
           return res.toString();
        }
    }


}
