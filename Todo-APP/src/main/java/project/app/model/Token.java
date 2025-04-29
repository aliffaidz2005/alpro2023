package project.app.model;

import lombok.Data;

import java.time.Instant;


public class Token {

    private Integer id;
    private String token;

    public Token(String token,Integer id) {
        this.token = token;
        this.id = id;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
