package com.arotas.arotas.service;

import com.arotas.arotas.model.Localizacao;
import com.arotas.arotas.model.Veiculo;
import com.arotas.arotas.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalizacaoService {

    @Autowired
    LocalizacaoRepository repository;

    public List<Veiculo> veiculos(){
        List<Veiculo> vcs = new ArrayList<Veiculo>();
        vcs.add(new Veiculo("123456", "CSA6410", "Carlos",
                new Localizacao(132.00121211F, 50.215454F)));

        return vcs;
    }
}
