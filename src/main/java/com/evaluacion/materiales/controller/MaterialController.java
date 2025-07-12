package com.evaluacion.materiales.controller;

import com.evaluacion.materiales.entity.Material;
import com.evaluacion.materiales.model.ApiResponse;
import com.evaluacion.materiales.service.MaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/materiales")
@Tag(name = "Materiales", description = "Operaciones CRUD de Material")
public class MaterialController {
    @Autowired private MaterialService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(200, "Consulta exitosa", service.getAll()));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<?> getByTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Consulta exitosa", service.getByTipo(tipo)));
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<?> getByFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Consulta exitosa", service.getByFecha(fecha)));
    }

    @GetMapping("/ciudad/{codigo}")
    public ResponseEntity<?> getByCiudad(@PathVariable String codigo) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Consulta exitosa", service.getByCiudad(codigo)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Material m) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(200, "Guardado", service.save(m)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse<>(400, e.getMessage(), null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Material m) {
        try {
            return ResponseEntity.ok(new ApiResponse<>(200, "Actualizado", service.update(id, m)));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(500, e.getMessage(), null));
        }
    }
}
