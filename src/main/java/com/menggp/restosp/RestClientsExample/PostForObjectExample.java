package com.menggp.restosp.RestClientsExample;


import com.menggp.restosp.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 *  Пример POST-запроса
 *      - с использование метода "postForObject"
 */
public class PostForObjectExample {

    static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String empNo = "E11";

        Employee newEmployee = new Employee(empNo, "Tom", "Clerk");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Data attached to the request
        HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);

        // Send request with POST method
        Employee e = restTemplate.postForObject(
                URL_CREATE_EMPLOYEE,
                requestBody,
                Employee.class
        );

        if ( e != null && e.getEmpNo() != null ) {
            System.out.println("Employee created: " + e.getEmpNo());
        } else {
            System.out.println("Something error!");
        }

    }

}
