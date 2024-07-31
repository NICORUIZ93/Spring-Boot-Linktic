package com.LINKTIC.Linktic.controllers;

import com.LINKTIC.Linktic.models.request.LiquidacionRequest;
import com.LINKTIC.Linktic.models.response.LiquidacionResponse;
import com.LINKTIC.Linktic.services.LiquidacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.LINKTIC.Linktic.constans.coreRouter.LiquidacionRoutes.ROOT;

@Slf4j
@RestController
@RequestMapping(ROOT)
public class LiquidacionController {
    private final LiquidacionService liquidacionService;

    public LiquidacionController(LiquidacionService liquidacionService) {
        this.liquidacionService = liquidacionService;
    }

    @PostMapping()
    public ResponseEntity<List<LiquidacionResponse>> calcularLiquidacion(@RequestBody List<LiquidacionRequest> requests) {
        log.info("LiquidacionController::calcularLiquidacion : requests {} ", requests);
        return ResponseEntity.ok(liquidacionService.generarLiquidacion(requests));
    }

}
