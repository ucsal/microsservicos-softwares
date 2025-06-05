package com.sistema.softwares_service.controller;

import com.sistema.softwares_service.dto.SoftwareRequestDTO;
import com.sistema.softwares_service.model.Software;
import com.sistema.softwares_service.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/softwares")
public class SoftwareController {

    private final SoftwareService softwareService;

    @Autowired
    public SoftwareController(SoftwareService softwareService) {
        this.softwareService = softwareService;
    }

    //certo
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Software> create(@RequestBody SoftwareRequestDTO dto) {
        return ResponseEntity.ok(softwareService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Software>> getAll() {
        return ResponseEntity.ok(softwareService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Software> getById(@PathVariable Long id) {
        return ResponseEntity.ok(softwareService.getById(id));
    }

    //certo
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Software> update(@PathVariable Long id, @RequestBody SoftwareRequestDTO dto) {
        return ResponseEntity.ok(softwareService.update(id, dto));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        softwareService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/disponiveis")
    public ResponseEntity<List<Software>> getAvailable() {
        return ResponseEntity.ok(softwareService.getAvailable());
    }

    //certo
    @PutMapping("/{id}/indisponibilizar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Software> markAsUnavailable(@PathVariable Long id) {
        return ResponseEntity.ok(softwareService.markAsUnavailable(id));
    }
}
