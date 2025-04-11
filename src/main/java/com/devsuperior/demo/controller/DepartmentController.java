package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.service.DepartmentService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll () {
        List<DepartmentDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
