package application.services;

import application.dto.UrlDto;
import application.model.Url;
import application.repositories.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UrlService{

    private final UrlRepository urlRepository;
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Random random = new Random();

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(UrlDto urlDto){
        String code;
        do{
            code = generateCode(6);
        }while(urlRepository.findByShortCode(code).isPresent());

        Url url = new Url();

        url.setOriginalUrl(urlDto.getUrl());
        url.setShortCode(code);
        urlRepository.save(url);

        return code;
    }

    private String generateCode(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    public String findOriginalUrl(String shortCode){
        return urlRepository.findByShortCode(shortCode)
                .map(Url::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }




}
