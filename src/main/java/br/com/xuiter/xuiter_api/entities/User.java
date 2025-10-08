package br.com.xuiter.xuiter_api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "\\w+")
    @NotNull
    @Size(max=10)
    private String username;

    @NotNull
    private LocalDateTime createdAt;

    //Esse construtor não deve ser usado diretamente, ele existe só para o JPA.
    @Deprecated
    protected User() {
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
