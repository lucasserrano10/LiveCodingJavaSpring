package br.com.xuiter.xuiter_api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class PiuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("should piu")
    void t1() throws Exception {
        mockMvc.perform(get("/piu"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((ResultMatcher) content().string("TESTE"));
    }
}
