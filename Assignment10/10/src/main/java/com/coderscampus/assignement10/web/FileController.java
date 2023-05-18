 package com.coderscampus.assignement10.web;
import java.net.MalformedURLException;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class FileController {
	private static final String API_KEY = "1a5d951cbf50420aaf54751c55e6b2dd";

    @GetMapping("/mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(
            @RequestParam String numCalories,
            @RequestParam String diet,
            @RequestParam String exclusions) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/generate")
                .queryParam("apiKey", API_KEY)
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .build()
                .toUri();

        ResponseEntity<WeekResponse> response = restTemplate.getForEntity(uri, WeekResponse.class);
        return response;
    }

    @GetMapping("/mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(
            @RequestParam(value ="targetCalories", required = false) String numCalories,
            @RequestParam (required = false)String diet,
            @RequestParam(value = "exclude", required = false) String exclusions) throws MalformedURLException {
    
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
                .queryParam("apiKey", API_KEY)
                .queryParam("timeFrame", "day")
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .build()
                .toUri();

        ResponseEntity<DayResponse> response = restTemplate.getForEntity(uri, DayResponse.class);
        return response;
    }
//    @GetMapping("/hi")
//    public String sysout(){
//    	
//		return "hello world";
//
//	}
}
