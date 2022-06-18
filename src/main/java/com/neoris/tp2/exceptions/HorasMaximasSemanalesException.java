package com.neoris.tp2.exceptions;

import java.text.MessageFormat;

public class HorasMaximasSemanalesException extends Exception {
    private static final String MESSAGE_PATTERN = "El empleado de id {0} supera las horas semanales";

    public HorasMaximasSemanalesException(Integer empeladoId){
        super(MessageFormat.format(MESSAGE_PATTERN,empeladoId));
    }
}
