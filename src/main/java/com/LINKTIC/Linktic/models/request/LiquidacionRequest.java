package com.LINKTIC.Linktic.models.request;

import com.LINKTIC.Linktic.config.ex.ErrorMessages;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiquidacionRequest {
    private Long tipoIdentificacion;
    private Long numeroIdentificacion;
    private Double valorAsegurado;
}