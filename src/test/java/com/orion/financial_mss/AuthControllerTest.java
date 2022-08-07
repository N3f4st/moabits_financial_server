package com.orion.financial_mss;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.orion.financial_mss.model.AppUser;
import com.orion.financial_mss.security.SecurityConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = {
        FinancialMssApplication.class,
        TestConfig.class
})
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthControllerTest {

    private MockMvc mockMvc;
    private static final String baseUriAuth = "/auth";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Order(1)
    public void RegisterUserThenReturnOk() throws Exception {
        StringBuilder sbUserName = new StringBuilder();
        sbUserName.append("userNumber");
        sbUserName.append(new Date().toString());

        AppUser appUser = new AppUser(sbUserName.toString(), "testName", "1234");
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc
                .perform(post(baseUriAuth + "/register")
                        .content(objectMapper.writeValueAsString(appUser))
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void PreventRegisterUserWithIncompleteDataThenReturn400() throws Exception {
        AppUser appUser = new AppUser("", "testName", "1234");
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc
                .perform(post(baseUriAuth + "/register")
                        .content(objectMapper.writeValueAsString(appUser))
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(3)
    public void PreventRegisterUserWithExistentUserThenReturn409() throws Exception {
        AppUser appUser = new AppUser("jurg", "testName", "1234");
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc
                .perform(post(baseUriAuth + "/register")
                        .content(objectMapper.writeValueAsString(appUser))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isConflict());
    }
}
