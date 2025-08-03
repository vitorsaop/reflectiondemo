package br.com.demo.repository;

import br.com.demo.model.Pessoa;

import java.util.List;

public class PessoaRepository {

    public Pessoa findAll() {
        return new Pessoa(1, "João", "123.456.789-00");
    }

}
