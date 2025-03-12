package com.igeos.backend.custoMarginal.operacaoSemanal.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeos.backend.balancoEnergiaSubsistema.dto.BalancoEnergiaSubsistemaRequest;
import com.igeos.backend.balancoEnergiaSubsistema.model.BalancoEnergiaSubsistema;
import com.igeos.backend.custoMarginal.operacaoSemanal.dto.request.OperacaoSemanalRequest;
import com.igeos.backend.custoMarginal.operacaoSemanal.model.OperacaoSemanal;
import com.igeos.backend.custoMarginal.operacaoSemanal.repository.OperacaoSemanalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OperacaoSemanalService {

    @Autowired
    private final OperacaoSemanalRepository operacaoSemanalRepository;

    public OperacaoSemanalService(OperacaoSemanalRepository operacaoSemanalRepository) {
        this.operacaoSemanalRepository = operacaoSemanalRepository;
    }

    public OperacaoSemanal salvarOperacaoSemanal(OperacaoSemanalRequest operacaoSemanal) {
        System.out.println("Dados recebidos: " + operacaoSemanal);

        OperacaoSemanal novaOperacaoSemanal = new OperacaoSemanal();

        novaOperacaoSemanal.setData(operacaoSemanal.data());
        novaOperacaoSemanal.setAno(operacaoSemanal.ano());
        novaOperacaoSemanal.setMes(operacaoSemanal.mes());
        novaOperacaoSemanal.setIdSubSistema(operacaoSemanal.idSubSistema());
        novaOperacaoSemanal.setSubSistema(operacaoSemanal.subSistema());
        novaOperacaoSemanal.setCustoMarginalOperacaoSemanal(operacaoSemanal.custoMarginalOperacaoSemanal());
        novaOperacaoSemanal.setCustoMarginalOperacaoSemanalCargaLeve(operacaoSemanal.custoMarginalOperacaoSemanalCargaLeve());
        novaOperacaoSemanal.setCustoMarginalOperacaoSemanalCargaMedia(operacaoSemanal.custoMarginalOperacaoSemanalCargaMedia());
        novaOperacaoSemanal.setCustoMarginalOperacaoSemanalCargaPesada(operacaoSemanal.custoMarginalOperacaoSemanalCargaPesada());
        return operacaoSemanalRepository.save(novaOperacaoSemanal);
    }

    public List<OperacaoSemanal> buscarTodasOperacoesSemanais() {
        return operacaoSemanalRepository.findAll();
    }

    public Optional<OperacaoSemanal> buscarOperacaoSemanalPorId(Long id) {
        return operacaoSemanalRepository.findById(id);
    }

    public OperacaoSemanal atualizarOperacaoSemanal(Long id, OperacaoSemanal operacaoSemanalAtualizada) {
        if (operacaoSemanalRepository.existsById(id)) {
            operacaoSemanalAtualizada.setId(id);
            return operacaoSemanalRepository.save(operacaoSemanalAtualizada);
        }
        return null; 
    }

    public void excluirOperacaoSemanal(Long id) {
        operacaoSemanalRepository.deleteById(id);
    }
}
