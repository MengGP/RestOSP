package com.menggp.restosp.RestClientsExample;

import com.menggp.restosp.model.Employee;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 *  Пример POST-запроса
 *      - с использование метода "postForEntity"
 */
public class PostForEntityExample {

    static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String empNo = "E11";

        Employee newEmployee = new Employee(empNo, "Adam", "staff");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Data attached to the request
        HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);
        // HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee);

        // Send request with POST method
        ResponseEntity<Employee> result = restTemplate.postForEntity(
        // ResponseEntity<Employee> result = restTemplate.exchange(
                URL_CREATE_EMPLOYEE,
                // HttpMethod.POST,
                requestBody,
                Employee.class
        );

        System.out.println("Status code: " + result.getStatusCode() );

        // Code = 200
        if (result.getStatusCode() == HttpStatus.OK) {
            Employee e = result.getBody();
            System.out.println("Employee created: " + e.getEmpNo());
        } else {
            System.out.println("Something error!");
        }

    }
}
