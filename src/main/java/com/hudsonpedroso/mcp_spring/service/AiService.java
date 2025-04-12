package com.hudsonpedroso.mcp_spring.service;

import com.hudsonpedroso.mcp_spring.client.OllamaClient;
import com.hudsonpedroso.mcp_spring.model.response.OllamaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AiService {
    
    private final OllamaClient ollamaClient;
    
    public String generateResponse(String userPrompt) {
        log.info("Gerando resposta para prompt: {}", userPrompt);
        OllamaResponse response = ollamaClient.generateText(userPrompt);
        
        if (response != null && response.getResponse() != null) {
            return response.getResponse().trim();
        } else {
            return "Não foi possível gerar uma resposta.";
        }
    }
}