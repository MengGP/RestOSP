package com.menggp.restosp.RestClientsExample;

import com.menggp.restosp.model.Employee;
import org.springframework.web.client.RestTemplate;

/**
 * Пример простого GET
 *      - с преобразованием объекта JSON <==> Java-POJO
 */
public class SimpleGetPOJOExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers
        Employee[] list = restTemplate.getForObject(
                                            URL_EMPLOYEES,
                                            Employee[].class
        );

        if (list != null ) {
            for (Employee e : list ) {
                System.out.println("Employee: " + e.getEmpName() + " - " + e.getEmpName());
            }
        }


    }

}
