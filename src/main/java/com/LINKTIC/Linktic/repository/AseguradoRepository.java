package com.LINKTIC.Linktic.repository;

import com.LINKTIC.Linktic.models.Asegurados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AseguradoRepository extends JpaRepository<Asegurados, Long> {
    Optional<Asegurados> findByNumeroIdentificacion(Long numeroIdentificacion);
}