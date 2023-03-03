package com.ctbcbank.boot.lab1;

import com.ctbcbank.boot.lab1.services.GreetingServices;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import static
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


//---------------------------------------------------------------------------------------
@WebMvcTest
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GreetingServices service;
    @Test
    public void testMocMVCNotNull(){
        assertThat(mockMvc).isNotNull();
    }
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(Matchers.containsString("純手刻")));

    }

    @Test
    public void testNotFoundPage() throws Exception {
        mockMvc.perform(get("/info"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testResponseBody() throws Exception {
        when(service.greet()).thenReturn("sample greeting message");
        mockMvc.perform(get("/greeting"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("sample")));
    }
}
