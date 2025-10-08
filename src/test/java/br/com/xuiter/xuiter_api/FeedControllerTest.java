package br.com.xuiter.xuiter_api;

import br.com.xuiter.xuiter_api.entities.User;
import br.com.xuiter.xuiter_api.entities.Xuit;
import br.com.xuiter.xuiter_api.repositories.UserRepository;
import br.com.xuiter.xuiter_api.repositories.XuitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FeedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private XuitRepository xuitRepository;

    @Test
    @DisplayName("should return a feed of xuits")
    void t1() throws Exception {
        User patricia = userRepository.save(new User(null, "Patricia"));

        List.of(
                new Xuit(
                        "Siga o IA sob controle.",
                        Xuit.XuitType.ORIGINAL,
                        patricia),
                new Xuit(
                        "Siga o Dev Sem Fronteiras",
                        Xuit.XuitType.ORIGINAL,
                        patricia)
        ).forEach(xuit -> xuitRepository.save(xuit));



        mockMvc.perform(get("/feed"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].id").isNotEmpty())
                .andExpect(jsonPath("$[0].content").value("Siga o IA sob controle."))
                .andExpect(jsonPath("$[0].authorUsername").value("Patricia"))
                .andExpect(jsonPath("$[0].type").value("ORIGINAL"))

                .andExpect(jsonPath("$[1].id").isNotEmpty())
                .andExpect(jsonPath("$[1].content").value("Siga o Dev Sem Fronteiras"))
                .andExpect(jsonPath("$[1].authorUsername").value("Patricia"))
                .andExpect(jsonPath("$[1].type").value("ORIGINAL"));

    }

}
