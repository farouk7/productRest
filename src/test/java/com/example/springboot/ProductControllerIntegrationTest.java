package com.example.springboot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSortProductsEndpoint() throws Exception {
        // Define la URL del endpoint con la categoría y los pesos de las métricas
        String url = "/products/sort?category=T-Shirts";
        String requestBody = "{ \"salesUnitsWeight\": 0.8, \"stockRatioWeight\": 0.2 }";

        // Realiza la solicitud HTTP POST al endpoint y verifica la respuesta
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

