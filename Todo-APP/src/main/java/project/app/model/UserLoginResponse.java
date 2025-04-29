package project.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import jakarta.servlet.http.Cookie;

@Data
public class UserLoginResponse {

    private String name;
    @JsonIgnore
    private Cookie cookie;

    public UserLoginResponse() {
    }
}
