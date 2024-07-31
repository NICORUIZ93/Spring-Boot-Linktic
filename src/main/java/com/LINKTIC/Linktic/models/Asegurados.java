package com.LINKTIC.Linktic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "asegurados")
public class Asegurados {
    @Id
    @Column(name = "tipo_identificacion", nullable = false)
    private Long tipoIdentificacion;

    @Column(name = "numero_identificacion", nullable = false)
    private Long numeroIdentificacion;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "sexo", nullable = false)
    private Long sexo;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
}
