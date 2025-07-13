package com.evaluacion.materiales.repository;

import com.evaluacion.materiales.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>, JpaSpecificationExecutor<Material> 
{
    List<Material> findByTipo(String tipo);
    List<Material> findByFechaCompra(LocalDate fecha);
    List<Material> findByCiudad_Codigo(String codigo);
}