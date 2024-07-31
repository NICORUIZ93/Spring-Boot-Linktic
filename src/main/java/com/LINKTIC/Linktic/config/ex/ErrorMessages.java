package com.LINKTIC.Linktic.config.ex;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessages {
    public static final String MISSING_DATA = "Todos los datos de entrada son obligatorios.";
    public static final String INVALID_INSURANCE_AMOUNT = "El valor asegurado debe ser mayor que cero.";
    public static final String NO_APPLICABLE_COVERAGE = "No le aplica ningún amparo.";
}
