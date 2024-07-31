package com.LINKTIC.Linktic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "primas")
public class Primas {
    @Id
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(name = "edad_minima", nullable = false)
    private Long edadMinima;

    @Column(name = "edad_maxima", nullable = false)
    private Long edadMaxima;

    @Column(name = "porcentaje_prima", nullable = false)
    private Double porcentajePrima;

}
