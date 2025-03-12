package com.igeos.backend.balancoEnergiaSubsistema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igeos.backend.balancoEnergiaSubsistema.dto.BalancoEnergiaSubsistemaRequest;
import com.igeos.backend.balancoEnergiaSubsistema.model.BalancoEnergiaSubsistema;
import com.igeos.backend.balancoEnergiaSubsistema.repository.BalancoEnergiaSubsistemaRepository;

@Service
public class BalancoEnergiaSubsistemaService {
    private final BalancoEnergiaSubsistemaRepository balancoEnergiaSubsistemaRepository;

    public BalancoEnergiaSubsistemaService(BalancoEnergiaSubsistemaRepository balancoEnergiaSubsistemaRepository) {
        this.balancoEnergiaSubsistemaRepository = balancoEnergiaSubsistemaRepository;
    }

    public List<BalancoEnergiaSubsistema> findAll() {
        return balancoEnergiaSubsistemaRepository.findAll();
    }
    
    public void SalvarBalancoEnergia(BalancoEnergiaSubsistemaRequest balancoEnergiaDTO) {
        System.out.println("Dados recebidos: " + balancoEnergiaDTO);

        BalancoEnergiaSubsistema balancoNovo = new BalancoEnergiaSubsistema();

        balancoNovo.setData(balancoEnergiaDTO.data());
        balancoNovo.setHora(balancoEnergiaDTO.hora());
        balancoNovo.setAno(balancoEnergiaDTO.ano());
        balancoNovo.setMes(balancoEnergiaDTO.mes());
        balancoNovo.setIdSubsistema(balancoEnergiaDTO.idSubsistema());
        balancoNovo.setSubsistema(balancoEnergiaDTO.subsistema());
        balancoNovo.setGeracaoHidraulicaVerificada(balancoEnergiaDTO.geracaoHidraulicaVerificada());
        balancoNovo.setGeracaoTermicaVerificada(balancoEnergiaDTO.geracaoTermicaVerificada());
        balancoNovo.setGeracaoEolicaVerificada(balancoEnergiaDTO.geracaoEolicaVerificada());
        balancoNovo.setGeracaoFotovoltaicaVerificada(balancoEnergiaDTO.geracaoFotovoltaicaVerificada());
        balancoNovo.setCargaVerificada(balancoEnergiaDTO.cargaVerificada());
        balancoNovo.setIntercambioVerificado(balancoEnergiaDTO.intercambioVerificado());
        balancoEnergiaSubsistemaRepository.save(balancoNovo);
        
    }

}
