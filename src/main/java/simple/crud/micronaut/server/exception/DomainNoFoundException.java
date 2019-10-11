package simple.crud.micronaut.server.exception;

public class DomainNoFoundException extends Exception {

    public DomainNoFoundException(String message) {
        super(message);
    }
}
