package com.menggp.restosp.RestClientsExample;

import com.menggp.restosp.model.Employee;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Промер с GET-запросом
 *         - с использованием заголовков (headers)
 */
public class GetWithHaederExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";

    public static void main(String[] args) {

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // HTTP headers
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON } ));

        // Request to return JSON format
        headers.setContentType( MediaType.APPLICATION_JSON );
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<String>: To get result asa String
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send request with GET method, and Headers
        ResponseEntity<String> response = restTemplate.exchange(
                URL_EMPLOYEES,
                HttpMethod.GET,
                entity,
                String.class);

        String result = response.getBody();

        System.out.println(result);
    }


}
