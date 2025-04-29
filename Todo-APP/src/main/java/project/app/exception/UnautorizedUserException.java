package project.app.exception;

public class UnautorizedUserException extends RuntimeException{

    public UnautorizedUserException(String message){
        super(message);
    }
}
