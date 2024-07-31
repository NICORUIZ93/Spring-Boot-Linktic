package com.LINKTIC.Linktic.services;

import com.LINKTIC.Linktic.models.request.LiquidacionRequest;
import com.LINKTIC.Linktic.models.response.LiquidacionResponse;

import java.util.List;

public interface LiquidacionService {
    List<LiquidacionResponse> generarLiquidacion(List<LiquidacionRequest> requests);
}
