package com.neoris.tp2.exceptions;

import java.text.MessageFormat;

public class HorasMinimasSinCargarException extends Exception {
    public static final String MESSAGE_PATTERN = "El empleado con id {0} no cumple con las horas minimas en la semana anterior";
    public HorasMinimasSinCargarException(Integer empleadoId){
        super(MessageFormat.format(MESSAGE_PATTERN, empleadoId));
    }
}
