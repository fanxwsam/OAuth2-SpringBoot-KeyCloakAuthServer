package com.apps.appsdeveloperblog.controller;

import com.apps.appsdeveloperblog.response.UserRest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/users")
public class UserController {

    @GetMapping("/status/check")
    public String getStatus(){
        return "working ..... as expected...";
    }

    @PreAuthorize("#id == #jwt.subject")
    //@PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable String id,  @AuthenticationPrincipal Jwt jwt){
        return "user " + id + " has been deleted.....and JWT subject = " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping("{id}")
    public UserRest getUser(@PathVariable String id,  @AuthenticationPrincipal Jwt jwt){

        UserRest userRest = new UserRest("Sam", "Fan", id);

        return userRest;
    }

}
