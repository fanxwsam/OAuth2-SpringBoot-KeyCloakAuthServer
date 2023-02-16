package com.login.ws.clients.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;

@Controller
public class HomePageController {


    @GetMapping("home")
    public String displayHomePage(Model model, @AuthenticationPrincipal OAuth2User principal){
        if(principal != null){
            String name = principal.getAttribute("name");
             model.addAttribute("name", name);
        }

        return "home";
    }
   


}
