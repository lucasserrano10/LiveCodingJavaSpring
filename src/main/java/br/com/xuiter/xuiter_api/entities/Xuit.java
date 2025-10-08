package br.com.xuiter.xuiter_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Xuit {

    public enum XuitType{
        ORIGINAL,REXUIT,QUOTE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1,max = 42)
    private String content;

    @Enumerated(EnumType.STRING)
    @NotNull
    private XuitType type;

    @NotNull
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private User author;

    @ManyToOne(optional = true)
    @JoinColumn(name = "original_xuit_id", nullable = true)
    private Xuit originalXuit;

    @NotNull
    private LocalDateTime createdAt;

    @Deprecated
    protected Xuit(){

    }

    public Xuit(String content, XuitType type, User author) {
        this.content = content;
        this.type = type;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public @NotNull @Size(min = 1, max = 42) String getContent() {
        return content;
    }

    public @NotNull XuitType getType() {
        return type;
    }

    public @NotNull User getAuthor() {
        return author;
    }

    public Xuit getOriginalXuit() {
        return originalXuit;
    }

    public @NotNull LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
