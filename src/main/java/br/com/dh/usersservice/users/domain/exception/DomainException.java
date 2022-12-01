package br.com.dh.usersservice.users.domain.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message, null, true, false);
    }
}
