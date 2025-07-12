package com.evaluacion.materiales.repository;

import com.evaluacion.materiales.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, String> {}
