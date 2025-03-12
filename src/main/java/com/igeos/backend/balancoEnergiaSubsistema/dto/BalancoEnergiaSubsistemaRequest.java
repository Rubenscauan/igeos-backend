package com.igeos.backend.balancoEnergiaSubsistema.dto;

import java.sql.Date;
import java.sql.Time;

public record BalancoEnergiaSubsistemaRequest(
    String data,
    String hora,
    int ano,
    int mes,
    String idSubsistema,
    String subsistema,
    float geracaoHidraulicaVerificada,
    float geracaoTermicaVerificada,
    float geracaoEolicaVerificada,
    float geracaoFotovoltaicaVerificada,
    float cargaVerificada,
    float intercambioVerificado
) {}
