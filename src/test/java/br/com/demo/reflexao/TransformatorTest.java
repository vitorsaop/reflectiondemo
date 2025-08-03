package br.com.demo.reflexao;

import br.com.demo.dto.PessoaDTO;
import br.com.demo.model.Endereco;
import br.com.demo.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

@DisplayName("Testando a transforma��o de Pessoa para PessoaDTO")
public class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Jo�o", "123.456.789-00");
    Endereco endereco = new Endereco("Rua A", 123);

    @Test
    @DisplayName("Fazendo a transforma��o de Pessoa para PessoaDTO")
    public void shouldTransform() {
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = null;
        try {
            pessoaDTO = transformator.transform(pessoa, PessoaDTO.class);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertNotNull(pessoaDTO, "O objeto PessoaDTO n�o deve ser nulo");
        Assertions.assertEquals("Jo�o", pessoaDTO.getNome(), "O nome deve ser 'Jo�o'");
        Assertions.assertEquals("123.456.789-00", pessoaDTO.getCpf(), "O CPF deve ser '123.456.789-00'");
        Assertions.assertEquals("PessoaDTO{  nome='Jo�o', cpf='123.456.789-00'}", pessoaDTO.toString(), "A representa��o em string do DTO deve corresponder ao esperado");

    }

    @Test
    @DisplayName("N�o deve transformar endere�o e ainda deve lan�ar ClassNotFoundException")
    public void shouldNotTransform() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            transformator.transform(endereco, (Class<PessoaDTO>) Class.forName("br;com.demo.dto.EnderecoDTO"));
        }, "Deve lan�ar ClassNotFoundException ao tentar transformar Endereco");

    }

}
