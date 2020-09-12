package com.menggp.restosp.RestClientsExample;

import com.menggp.restosp.model.Employee;
import org.springframework.web.client.RestTemplate;

public class DeleteExample2 {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // URL with URI-variable
        String resourceUrl = "http://localhost:8080/employee/{empNo}";
        Object[] uriValues = new Object[] {"E11"};

        // Send request with DELETE method
        restTemplate.delete(resourceUrl, uriValues);

        // Проверка выполнения - GET
        String currUrl = resourceUrl.replace("{empNo}", uriValues[0].toString());

        Employee e = restTemplate.getForObject(currUrl, Employee.class);

        if (e != null) {
            System.out.println("(Client side) Employee after delete: ");
            System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
        } else {
            System.out.println("Employee not found!");
        }

    }

}
