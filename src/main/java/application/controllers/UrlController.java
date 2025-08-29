package application.controllers;

import application.dto.UrlDto;
import application.model.Url;
import application.services.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestBody UrlDto urlDto){
        return "http://localhost:8080/" + urlService.shortenUrl(urlDto);
    }
}
