package com.igeos.backend.custoMarginal.OperacaoSemiHorario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeos.backend.custoMarginal.OperacaoSemiHorario.dto.request.OperacaoSemiHorarioRequest;
import com.igeos.backend.custoMarginal.OperacaoSemiHorario.model.OperacaoSemiHorario;
import com.igeos.backend.custoMarginal.OperacaoSemiHorario.repository.OperacaoSemiHorarioRepository;
import com.igeos.backend.custoMarginal.operacaoSemanal.dto.request.OperacaoSemanalRequest;
import com.igeos.backend.custoMarginal.operacaoSemanal.model.OperacaoSemanal;

import java.util.List;
import java.util.Optional;

@Service
public class OperacaoSemiHorarioService {

    @Autowired
    private final OperacaoSemiHorarioRepository operacaoSemiHorarioRepository;

    public OperacaoSemiHorarioService(OperacaoSemiHorarioRepository operacaoSemiHorarioRepository) {
        this.operacaoSemiHorarioRepository = operacaoSemiHorarioRepository;
    }

    public OperacaoSemiHorario salvarOperacaoSemiHorario(OperacaoSemiHorarioRequest OperacaoSemiHorario) {
        System.out.println("Dados recebidos: " + OperacaoSemiHorario);

        OperacaoSemiHorario novaOperacaoSemiHorario = new OperacaoSemiHorario();

        novaOperacaoSemiHorario.setData(OperacaoSemiHorario.data());
        novaOperacaoSemiHorario.setAno(OperacaoSemiHorario.ano());
        novaOperacaoSemiHorario.setMes(OperacaoSemiHorario.mes());
        novaOperacaoSemiHorario.setIdSubSistema(OperacaoSemiHorario.idSubSistema());
        novaOperacaoSemiHorario.setSubSistema(OperacaoSemiHorario.subSistema());
        novaOperacaoSemiHorario.setHora(OperacaoSemiHorario.hora());
        novaOperacaoSemiHorario.setCustoMarginalOperacao(OperacaoSemiHorario.custoMarginalOperacao());

        return operacaoSemiHorarioRepository.save(novaOperacaoSemiHorario);
        
    }


    public List<OperacaoSemiHorario> listarTodos() {
        return operacaoSemiHorarioRepository.findAll();
    }

    public Optional<OperacaoSemiHorario> buscarPorId(Long id) {
        return operacaoSemiHorarioRepository.findById(id);
    }

    public void deletar(Long id) {
        operacaoSemiHorarioRepository.deleteById(id);
    }
}
