package com.security.service;

import com.security.dto.NasaApodDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ApiService {
    @Value("${api.url}")
    private String TARGET_HOST;
    @Value("${api.key}")
    private String API_KEY;

    private final RestClient restClient;
    private final NasaApodService nasaApodService;

    public ApiService(RestClient restClient, NasaApodService nasaApodService) {
        this.restClient = restClient;
        this.nasaApodService = nasaApodService;
    }

    public String getApod(){
        return restClient
                .get()
                .uri(TARGET_HOST + "?api_key=" + API_KEY)
                .retrieve()
                .body(String.class);
    }

    public String scrapeApod(){
        NasaApodDTO apodDTO = restClient
                .get()
                .uri(TARGET_HOST + "?api_key=" + API_KEY)
                .retrieve()
                .body(NasaApodDTO.class);
        nasaApodService.add(apodDTO);
        return "Image scrapped successfully";
    }
}
