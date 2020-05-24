package com.example.demo.controller;

import java.security.Principal;
import java.util.Set;

import com.example.demo.utils.SecurityContextUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {

    @GetMapping(path = "/username")
    public ResponseEntity<String> getAuthorizedUserName(Principal principal) {
        System.out.println(principal);
        return ResponseEntity.ok(SecurityContextUtils.getUserName());
    }

    @GetMapping(path = "/roles")
    public ResponseEntity<Set<String>> getAuthorizedUserRoles() {
        return ResponseEntity.ok(SecurityContextUtils.getUserRoles());
    }
}
