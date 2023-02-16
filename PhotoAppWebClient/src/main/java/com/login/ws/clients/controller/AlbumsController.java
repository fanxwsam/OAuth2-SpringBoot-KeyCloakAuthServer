package com.login.ws.clients.controller;

import com.login.ws.clients.response.AlbumRest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;

@Controller
public class AlbumsController {
    @Autowired
    OAuth2AuthorizedClientService oauth2ClientService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient webClient;

    @GetMapping("/albums")
    public String getAlbums(Model model,
                            @AuthenticationPrincipal OidcUser principal){

        /*
        System.out.println("Principal...." + principal);
        System.out.println("Principal...." + principal.getIdToken().getTokenValue());

//        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
//        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
//
//        OAuth2AuthorizedClient oauth2Client = oauth2ClientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(),
//                oauthToken.getName());
//
//        String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
//        System.out.println("jwtAccessToken = " + jwtAccessToken);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken)authentication;
        System.out.println("oauthToken.getAuthorizedClientRegistrationId()   " + oauthToken.getAuthorizedClientRegistrationId());
        System.out.println("oauthToken.getName()    " + oauthToken.getName());

        OAuth2AuthorizedClient oauth2Client = oauth2ClientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId()
                , oauthToken.getName());

        String accessToken = oauth2Client.getAccessToken().getTokenValue();
        System.out.println("JWT access Token..." + accessToken);

//        AlbumRest album1 = new AlbumRest();
//        album1.setAlbumId("albumIdHere");
//        album1.setUserId("1");
//        album1.setAlbumTitle("Album 1 title");
//        album1.setAlbumDescription("Album 1 description");
//        album1.setAlbumUrl("http://localhost:9000/albums/1");
//
//        AlbumRest album2 = new AlbumRest();
//        album2.setAlbumId("albumIdHere");
//        album2.setUserId("2");
//        album2.setAlbumTitle("Album 2 title");
//        album2.setAlbumDescription("Album 2 description");
//        album2.setAlbumUrl("http://localhost:9000/albums/2");

        String url = "http://localhost:8091/albums";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + accessToken);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ParameterizedTypeReference<List<AlbumRest>> typeRef = new ParameterizedTypeReference<List<AlbumRest>>() {};

        ResponseEntity<List<AlbumRest>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, typeRef);

        model.addAttribute("albums", responseEntity.getBody());
*/
        String url = "http://localhost:8091/albums";
        ParameterizedTypeReference<List<AlbumRest>> typeRef = new ParameterizedTypeReference<List<AlbumRest>>() {};
        List<AlbumRest> responseEntity = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(typeRef)
                .block();
        model.addAttribute("albums", responseEntity);
        return "albums";

    }


}
