package br.com.xuiter.xuiter_api.dto;

import br.com.xuiter.xuiter_api.entities.Xuit;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class XuitResponse {

    @JsonProperty
    private final Long id;

    @JsonProperty
    private final @NotNull
    @Size(min = 1, max = 42) String content;

    @JsonProperty
    private final String type;

    @JsonProperty
    private final String authorUsername;

    public XuitResponse(Xuit xuit){
        this.id = xuit.getId();
        this.content = xuit.getContent();
        this.type = xuit.getType().name();
        this.authorUsername = xuit.getAuthor().getUsername();
    }

}
