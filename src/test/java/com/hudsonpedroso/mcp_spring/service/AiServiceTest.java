package com.hudsonpedroso.mcp_spring.service;

import com.hudsonpedroso.mcp_spring.client.OllamaClient;
import com.hudsonpedroso.mcp_spring.model.response.OllamaResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AiServiceTest {

    @InjectMocks
    private AiService unit;
    
    @Mock
    private OllamaClient ollamaClient;
    
    @Test
    void shouldGenerateResponse() {
        // given
        String prompt = "Teste";
        OllamaResponse ollamaResponse = new OllamaResponse();
        ollamaResponse.setResponse("Resposta de teste");
        
        when(ollamaClient.generateText(prompt)).thenReturn(ollamaResponse);
        
        // when
        String result = unit.generateResponse(prompt);
        
        // then
        assertEquals("Resposta de teste", result);
    }
}