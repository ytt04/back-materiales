package com.evaluacion.materiales.controller;

import com.evaluacion.materiales.entity.Ciudad;
import com.evaluacion.materiales.entity.Departamento;
import com.evaluacion.materiales.model.ApiResponse;
import com.evaluacion.materiales.repository.CiudadRepository;
import com.evaluacion.materiales.repository.DepartamentoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ubicacion")
@CrossOrigin("http://localhost:4200")
@Tag(name = "Ubicación", description = "Creación de departamentos y ciudades")
public class UbicacionController {

    @Autowired private DepartamentoRepository departamentoRepo;
    @Autowired private CiudadRepository ciudadRepo;

    @PostMapping("/departamentos")
    public ResponseEntity<?> crearDepartamento(@RequestBody Departamento d) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Departamento creado", departamentoRepo.save(d)));
    }

    @PostMapping("/ciudades")
    public ResponseEntity<?> crearCiudad(@RequestBody Ciudad c) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Ciudad creada", ciudadRepo.save(c)));
    }

    @GetMapping("/departamentos")
    public ResponseEntity<?> listarDepartamentos() {
        return ResponseEntity.ok(new ApiResponse<>(200, "Lista de departamentos", departamentoRepo.findAll()));
    }

    @GetMapping("/ciudades")
    public ResponseEntity<?> listarCiudades() {
        return ResponseEntity.ok(new ApiResponse<>(200, "Lista de ciudades", ciudadRepo.findAll()));
    }

}