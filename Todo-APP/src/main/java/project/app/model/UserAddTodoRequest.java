package project.app.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class UserAddTodoRequest {

    @NotBlank(message = "judul todo tidak boleh kosong")
    private String title;

    private String dekspripsi;


    public UserAddTodoRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDekspripsi() {
        return dekspripsi;
    }

    public void setDekspripsi(String dekspripsi) {
        this.dekspripsi = dekspripsi;
    }
}
