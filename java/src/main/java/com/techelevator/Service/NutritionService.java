package com.techelevator.Service;

import com.techelevator.model.NutritionResponseDto;
import com.techelevator.model.NutritionSearchDto;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class NutritionService {
    private static final String API_BASE_URL = "https://trackapi.nutritionix.com/v2/natural/nutrients";
    private final RestTemplate restTemplate = new RestTemplate();
    /**
     * remove these before posting on github
     */

    private String id = "bdfcdf10";
    private String key = "eff739e751de6ea7dda74c8031e7da5f";
/**
    Nutritionix API does not require a true login; it simply uses the id and key to authenticate a request and returns
    It may, however, require the user to be logged in to the website to authenticate
    https://developer.nutritionix.com/
 **/

    public NutritionResponseDto search(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-app-id", id); //user id custom header
        headers.add("x-app-key", key); //user key custom header
        NutritionSearchDto searchDto = new NutritionSearchDto();
        searchDto.setQuery(query);
        HttpEntity<NutritionSearchDto> entity = new HttpEntity<>(searchDto, headers);
        NutritionResponseDto temp = null;
        try {
            temp = restTemplate.exchange(API_BASE_URL, HttpMethod.POST, entity, NutritionResponseDto.class).getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

}
