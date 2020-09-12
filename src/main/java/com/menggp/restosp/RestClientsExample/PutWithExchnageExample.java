package com.menggp.restosp.RestClientsExample;

import com.menggp.restosp.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * Запрс PUT - простой пример
 *          - с использвоанием метода "exchange" - RestTemplate
 *          - проверка простым GET по empNum
 */
public class PutWithExchnageExample {

    static final String URL_UPDATE_EMPLOYEE = "http://localhost:8080/employee";
    static final String URL_EMPLOYEE_PREFIX = "http://localhost:8080/employee";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        String empNo = "E01";

        Employee updapeInfo = new Employee(empNo, "Ted", "SysAdmin");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        // Data attached to the request
        HttpEntity<Employee> requestBody = new HttpEntity<>(updapeInfo, headers);

        // Send request with PUT method
        restTemplate.exchange(
                URL_UPDATE_EMPLOYEE,
                HttpMethod.PUT,
                requestBody,
                Void.class
        );

        // Проверка с GET-запросом
        String resourceUrl = URL_EMPLOYEE_PREFIX + "/" + empNo;

        Employee e = restTemplate.getForObject(resourceUrl, Employee.class);

        if(e != null) {
            System.out.println("(Client side) Employeer after update: ");
            System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName() + " - " + e.getPosition());
        }


    }
}
