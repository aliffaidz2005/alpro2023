package project.app.exception;

public class LoginExceptionUnautorized extends RuntimeException{

    public LoginExceptionUnautorized(String messages){
        super(messages);
    }

}
