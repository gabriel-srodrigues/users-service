package br.com.dh.usersservice.users.domain.model;

import br.com.dh.usersservice.users.domain.exception.DomainException;
import lombok.Getter;

@Getter
public class User {
    private String nome;
    private String sobrenome;
    private String cor;
    private String nacionalidade;

    private User(String nome, String sobrenome, String cor, String nacionalidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cor = cor;
        this.nacionalidade = nacionalidade;
        validate();
    }

    public static User newUser(String nome, String sobrenome, String cor, String nacionalidade) {
        final var corAlterada = "COR ESCOLHIDA [%s]".formatted(cor);
        return new User(nome, sobrenome, corAlterada, nacionalidade);
    }

    public void validate() {
        checkNameConstraint();
        checkSobrenomeConstraint();
        checkCorConstraint();
        checkNacionalidadeConstraint();
    }

    private void checkNacionalidadeConstraint() {
        if (nacionalidade == null) {
            throw new DomainException("'nacionalidade' should not be null");
        }
        if (nacionalidade.isEmpty()) {
            throw new DomainException("'nacionalidade' should not be empty");
        }
    }

    private void checkCorConstraint() {
        if (cor == null) {
            throw new DomainException("'cor' should not be null");
        }
        if (cor.isEmpty()) {
            throw new DomainException("'cor' should not be empty");
        }
    }

    private void checkSobrenomeConstraint() {
        if (sobrenome == null) {
            throw new DomainException("'sobrenome' should not be null");
        }
        if (sobrenome.isEmpty()) {
            throw new DomainException("'sobrenome' should not be empty");
        }
    }

    private void checkNameConstraint() {
        if (nome == null) {
            throw new DomainException("'nome' should not be null");
        }
        if (nome.isEmpty()) {
            throw new DomainException("'nome' should not be empty");
        }
    }

}
