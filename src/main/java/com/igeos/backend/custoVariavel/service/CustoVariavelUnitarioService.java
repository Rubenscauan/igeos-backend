package com.igeos.backend.custoVariavel.service;

import com.igeos.backend.custoVariavel.dto.request.CustoVariavelUnitarioRequest;
import com.igeos.backend.custoVariavel.model.CustoVariavelUnitario;
import com.igeos.backend.custoVariavel.repository.CustoVariavelUnitarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustoVariavelUnitarioService {
    @Autowired
    private final CustoVariavelUnitarioRepository custoVariavelUnitarioRepositorrepository;

    public CustoVariavelUnitarioService(CustoVariavelUnitarioRepository custoVariavelUnitarioRepositorrepository) {
        this.custoVariavelUnitarioRepositorrepository = custoVariavelUnitarioRepositorrepository;
    }

    public CustoVariavelUnitario salvarCustoVariavelUnitario(CustoVariavelUnitarioRequest custoVariavelUnitarioRequest) {
        System.out.println("Dados recebidos: " + custoVariavelUnitarioRequest);

        CustoVariavelUnitario novoCustoVariavelUnitario = new CustoVariavelUnitario(); 
        novoCustoVariavelUnitario.setDataInicio(custoVariavelUnitarioRequest.dataInicio());
        novoCustoVariavelUnitario.setAno(custoVariavelUnitarioRequest.ano());
        novoCustoVariavelUnitario.setMes(custoVariavelUnitarioRequest.mes());
        novoCustoVariavelUnitario.setDataFim(custoVariavelUnitarioRequest.dataFim());
        novoCustoVariavelUnitario.setAnoPmo(custoVariavelUnitarioRequest.anoPmo());
        novoCustoVariavelUnitario.setMesPmo(custoVariavelUnitarioRequest.mesPmo());
        novoCustoVariavelUnitario.setNumeroRevisao(custoVariavelUnitarioRequest.numeroRevisao());
        novoCustoVariavelUnitario.setSemanaOperativa(custoVariavelUnitarioRequest.semanaOperativa());
        novoCustoVariavelUnitario.setIdModeloUsina(custoVariavelUnitarioRequest.idModeloUsina());
        novoCustoVariavelUnitario.setIdSubSistema(custoVariavelUnitarioRequest.idSubSistema());
        novoCustoVariavelUnitario.setSubSistema(custoVariavelUnitarioRequest.subSistema());
        novoCustoVariavelUnitario.setUsina(custoVariavelUnitarioRequest.usina());
        novoCustoVariavelUnitario.setCustoVariavelUnitario(custoVariavelUnitarioRequest.custoVariavelUnitario());    

        return custoVariavelUnitarioRepositorrepository.save(novoCustoVariavelUnitario);
    }

    public List<CustoVariavelUnitario> listarTodos() {
        return custoVariavelUnitarioRepositorrepository.findAll();
    }

    public Optional<CustoVariavelUnitario> buscarPorId(Long id) {
        return custoVariavelUnitarioRepositorrepository.findById(id);
    }

    public void deletarPorId(Long id) {
        custoVariavelUnitarioRepositorrepository.deleteById(id);
    }
}
