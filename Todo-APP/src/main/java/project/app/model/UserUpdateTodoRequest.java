package project.app.model;

import lombok.NonNull;

public class UserUpdateTodoRequest {
    @NonNull
    private Integer id;
    private String title;
    private String deskripsi;
    private Boolean complate;

    public UserUpdateTodoRequest(){

    }


    public @NonNull Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Boolean getComplate() {
        return complate;
    }

    public void setComplate(Boolean complate) {
        this.complate = complate;
    }
}
