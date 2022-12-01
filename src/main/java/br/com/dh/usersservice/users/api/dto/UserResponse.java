package br.com.dh.usersservice.users.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String nome;
    private String sobrenome;
    private String cor;
    private String nacionalidade;
}
