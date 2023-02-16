package com.apps.appsdeveloperblog.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/api/photos")
public class PhotoListController {

    @GetMapping("protected")
    public String getProtectedPhotos(){
        return "The protected photos list ....... enjoy....";
    }


    @Secured("ROLE_developer")
    @DeleteMapping("{id}")
    public String deletePhoto(@PathVariable String id){
        return "Deleting photo with id that id = '" + id +"'.........";
    }

    //@PreAuthorize("hasRole('developer1')")
    @PreAuthorize("hasAuthority('ROLE_developer1')")
    @PostMapping
    public String addPhoto(){
        return "A photo posted and it's ugly.........";
    }



}
