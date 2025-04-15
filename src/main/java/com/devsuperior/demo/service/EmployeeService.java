package com.devsuperior.demo.service;


import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Employee;
import com.devsuperior.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Page<EmployeeDTO> findAll ( Pageable pageable ) {
        Page<Employee> page = repository.findAll(pageable);
        return page.map(x -> new EmployeeDTO(x));
    }

}
