package br.com.demo;

import br.com.demo.dto.PessoaDTO;
import br.com.demo.service.PessoaService;

import java.lang.reflect.InvocationTargetException;

public class TesteReflexao {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PessoaService pessoaService = new PessoaService();
        PessoaDTO pessoaDTO = pessoaService.list();
        System.out.println(pessoaDTO);
    }

}
