package com.menggp.restosp.RestClientsExample;

import com.menggp.restosp.model.Employee;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 *  Полный пример GET
 *          - с заголовками
 *           и
 *          - преобрадованием JSON(XML) <==> Java-POJO
 */
public class GetPOJOWithHeadersExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";

    public static void main(String[] args) {

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // HTTP headers
        HttpHeaders headers = new HttpHeaders();

        //headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_XML } ));
        headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON } ));

        // Request to return JSON format
        //headers.setContentType( MediaType.APPLICATION_XML );
        headers.setContentType( MediaType.APPLICATION_JSON );
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<String>: To get result as Employee[]
        HttpEntity<Employee[]> entity = new HttpEntity<>(headers);

        // Send request with GET method, and Headers
        ResponseEntity<Employee[]> response = restTemplate.exchange(
                URL_EMPLOYEES,
                HttpMethod.GET,
                entity,
                Employee[].class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Responce Status Code: " + statusCode);

        // Status Code: 200
        if (statusCode == HttpStatus.OK) {
            // Responce Body Data
            Employee[] list = response.getBody();

            if (list != null ) {
                for (Employee e : list ) {
                    System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName() + " - " + e.getPosition());
                }
            }
        }


    }

}
