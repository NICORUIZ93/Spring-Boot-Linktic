package com.LINKTIC.Linktic.services.servicesImpl;

import com.LINKTIC.Linktic.config.ex.ErrorMessages;
import com.LINKTIC.Linktic.config.ex.Linktic;
import com.LINKTIC.Linktic.models.Amparos;
import com.LINKTIC.Linktic.models.Asegurados;
import com.LINKTIC.Linktic.models.Liquidacion;
import com.LINKTIC.Linktic.models.Primas;
import com.LINKTIC.Linktic.models.request.LiquidacionRequest;
import com.LINKTIC.Linktic.models.response.LiquidacionResponse;
import com.LINKTIC.Linktic.repository.AmparoRepository;
import com.LINKTIC.Linktic.repository.AseguradoRepository;
import com.LINKTIC.Linktic.repository.PrimaRepository;
import com.LINKTIC.Linktic.services.LiquidacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LiquidacionServiceImpl implements LiquidacionService {
    private final AseguradoRepository aseguradoRepository;
    private final PrimaRepository primaRepository;
    private final AmparoRepository amparoRepository;

    public LiquidacionServiceImpl(AseguradoRepository aseguradoRepository, PrimaRepository primaRepository, AmparoRepository amparoRepository) {
        this.aseguradoRepository = aseguradoRepository;
        this.primaRepository = primaRepository;
        this.amparoRepository = amparoRepository;
    }

    public void validarDatos(List<LiquidacionRequest> requests) {
        for (LiquidacionRequest request : requests) {
            if (request.getTipoIdentificacion() == null || request.getNumeroIdentificacion() == null ||
                    request.getValorAsegurado() == null || request.getValorAsegurado() <= 0) {
                throw new Linktic(ErrorMessages.MISSING_DATA);
            }
            if (request.getValorAsegurado() <= 0) {
                throw new Linktic(ErrorMessages.INVALID_INSURANCE_AMOUNT);
            }
        }
    }

    @Override
    public List<LiquidacionResponse> generarLiquidacion(List<LiquidacionRequest> requests) {
        validarDatos(requests);
        log.info("LiquidacionService::generarLiquidacion {}", requests);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        List<LiquidacionResponse> liquidaciones = new ArrayList<>();
        for (LiquidacionRequest request : requests) {
            Asegurados asegurado = aseguradoRepository
                    .findByNumeroIdentificacion(request.getNumeroIdentificacion())
                    .orElseThrow();

            int edad = calcularEdad(asegurado.getFechaNacimiento());
            log.info("edad {}", edad);

            List<Primas> primas = primaRepository.findPrimasByEdad(edad);
            Amparos amparos;
            List<Liquidacion> liquidacions = new ArrayList<>();

            for (Primas prima : primas) {
                log.info("valorPrima {} * {} = {}",
                        request.getValorAsegurado(),
                        prima.getPorcentajePrima(),
                        Double.valueOf(decimalFormat.format(request.getValorAsegurado() * prima.getPorcentajePrima())));

                amparos = amparoRepository.findById(prima.getCodigo()).orElseThrow();
                liquidacions.add(Liquidacion.builder()
                        .codigoAmparo(amparos.getCodigo())
                        .nombreAmparo(amparos.getNombre())
                        .valorPrima(Double.valueOf(decimalFormat.format(request.getValorAsegurado() * prima.getPorcentajePrima())))
                        .build());
            }

            liquidaciones.add(LiquidacionResponse.builder()
                    .numeroIdentificacion(request.getNumeroIdentificacion())
                    .tipoIdentificacion(request.getTipoIdentificacion())
                    .valorAsegurado(request.getValorAsegurado())
                    .liquidacion(liquidacions)
                    .valorTotal(Double.valueOf(decimalFormat.format(liquidacions.stream().mapToDouble(Liquidacion::getValorPrima).sum())))
                    .build());
        }

        return liquidaciones;
    }

    public static int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

}
