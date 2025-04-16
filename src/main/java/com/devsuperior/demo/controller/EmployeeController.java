package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.service.EmployeeService;
import org.springframework.data.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll ( Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
        Page<EmployeeDTO> page = service.findAll(pageRequest);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert (@RequestBody EmployeeDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
