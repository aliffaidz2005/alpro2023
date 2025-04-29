package project.app.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class UserLoginRequest {

    @NotBlank(message = "username tidak boleh kosong")
    private String username;
    @NotBlank(message = "password tidak boleh kosong")
    private String password;


}
