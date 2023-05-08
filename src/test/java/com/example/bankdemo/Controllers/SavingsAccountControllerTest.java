package com.example.bankdemo.Controllers;
import com.example.bankdemo.models.SavingsAccount;
import com.example.bankdemo.services.SavingsAccountService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@WebMvcTest(SavingsAccountController.class)
class SavingsAccountControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SavingsAccountService savingsAccountService;

    private SavingsAccount savingsAccount;

    @Before
    public void setUp() {
        savingsAccount = new SavingsAccount(2000, 105L,true);
    }


    @Test
    void deposit() throws Exception {
        Long accountNumber = 1L;
        double amount = 5000.0;

        doNothing().when(savingsAccountService).deposit(accountNumber, amount);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/savings/" + accountNumber + "/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("amount", String.valueOf(amount)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(savingsAccountService, times(1)).deposit(accountNumber, amount);
    }

    @Test
    void withdraw() throws Exception {
        Long accountNumber = 1L;
        double amount = 5000.0;

        doNothing().when(savingsAccountService).withdraw(accountNumber, amount);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/savings/" + accountNumber + "/withdraw")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("amount", String.valueOf(amount)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(savingsAccountService, times(1)).withdraw(accountNumber, amount);
    }

    @Test
    void openSavings() throws Exception {
        double amount = 5000.0;

        when(savingsAccountService.OpenAccount(amount)).thenReturn(1L);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/savings/open")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("amount", String.valueOf(amount)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"));

        verify(savingsAccountService, times(1)).OpenAccount(amount);
    }
}
