package br.com.demo.service;

import br.com.demo.dto.PessoaDTO;
import br.com.demo.model.Pessoa;
import br.com.demo.reflexao.Transformator;
import br.com.demo.repository.PessoaRepository;

import java.lang.reflect.InvocationTargetException;


public class PessoaService {

    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new PessoaRepository().findAll();

        PessoaDTO pessoaDTO = new Transformator().transform(pessoa, PessoaDTO.class);

        return pessoaDTO;
    }

}
