package com.menggp.restosp.RestClientsExample;

import org.springframework.web.client.RestTemplate;

/**
 * Простейший пример GET-запроса с RestTemplate
 */
public class SimpleGetExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // GET-зарос в Headers по умолчанию
        // Возвращает результат в формате строки в XML представлении
        String result = restTemplate.getForObject(URL_EMPLOYEES, String.class);

        System.out.println(result);
    }

}
