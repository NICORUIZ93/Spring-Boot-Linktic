package com.LINKTIC.Linktic.repository;

import com.LINKTIC.Linktic.models.Primas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrimaRepository extends JpaRepository<Primas, Long> {
    @Query(value = "SELECT * " +
            "FROM Primas " +
            "WHERE edad_minima <= :edad " +
            "  AND edad_maxima >= :edad", nativeQuery = true)
    List<Primas> findPrimasByEdad(@Param("edad") int edad);
}