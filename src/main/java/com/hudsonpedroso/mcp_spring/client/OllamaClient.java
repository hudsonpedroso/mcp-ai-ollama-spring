package com.hudsonpedroso.mcp_spring.client;

import com.hudsonpedroso.mcp_spring.config.ApiProperties;
import com.hudsonpedroso.mcp_spring.model.request.OllamaRequest;
import com.hudsonpedroso.mcp_spring.model.response.OllamaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class OllamaClient {
    
    private final ApiProperties apiProperties;
    private final RestTemplate restTemplate;
    
    public OllamaResponse generateText(String prompt) {
        log.info("Enviando requisição para Ollama com prompt: {}", prompt);
        
        OllamaRequest request = OllamaRequest.builder()
                .model(apiProperties.getModel())
                .prompt(prompt)
                .stream(false) // false = não streaming, true = streaming
                .options(OllamaRequest.Options.builder()
                        .temperature(0.7)
                        .num_predict(256)
                        .build())
                .build();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<OllamaRequest> entity = new HttpEntity<>(request, headers);
        
        try {
            OllamaResponse response = restTemplate.postForObject(
                    apiProperties.getUrl(), 
                    entity, 
                    OllamaResponse.class
            );
            
            log.info("Resposta recebida do Ollama: {}", response);
            return response;
        } catch (Exception e) {
            log.error("Erro ao comunicar com Ollama: {}", e.getMessage(), e);
            throw new RuntimeException("Falha na comunicação com o Ollama", e);
        }
    }
}