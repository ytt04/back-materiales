package com.evaluacion.materiales.service;

import com.evaluacion.materiales.entity.Material;
import com.evaluacion.materiales.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MaterialService {
    @Autowired private MaterialRepository repo;

    public List<Material> getAll() { return repo.findAll(); }
    public List<Material> getByTipo(String tipo) { return repo.findByTipo(tipo); }
    public List<Material> getByFecha(LocalDate fecha) { return repo.findByFechaCompra(fecha); }
    public List<Material> getByCiudad(String codigo) { return repo.findByCiudad_Codigo(codigo); }

    public Material save(Material m) {
        validarFechas(m);
        return repo.save(m);
    }

    public Material update(Long id, Material m) {
        if (!repo.existsById(id)) throw new RuntimeException("Material no encontrado");
        m.setId(id);
        validarFechas(m);
        return repo.save(m);
    }

    private void validarFechas(Material m) {
        if (m.getFechaVenta() != null && m.getFechaCompra().isAfter(m.getFechaVenta()))
            throw new IllegalArgumentException("La fecha de compra no puede ser posterior a la de venta");
    }
}
