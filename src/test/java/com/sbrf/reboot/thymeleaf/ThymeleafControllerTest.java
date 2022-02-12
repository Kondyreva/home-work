package com.sbrf.reboot.thymeleaf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ThymeleafController.class)
class ThymeleafControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getMessage() throws Exception {
        String expected = "Tanya";
        mockMvc.perform(get("/user").param("name", expected))
                .andExpect(status().isOk())
                .andExpect(model().attribute("name", equalTo(expected)))
                .andExpect(content().string(containsString(expected)));
    }
}