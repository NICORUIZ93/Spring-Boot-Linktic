package com.LINKTIC.Linktic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "amparos")
public class Amparos {

    @Id
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

}
