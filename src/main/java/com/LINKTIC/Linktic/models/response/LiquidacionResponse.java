package com.LINKTIC.Linktic.models.response;

import com.LINKTIC.Linktic.models.Liquidacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiquidacionResponse {
    private Long tipoIdentificacion;
    private Long numeroIdentificacion;
    private Double valorAsegurado;
    private List<Liquidacion> liquidacion;
    private Double valorTotal;
}