package com.hudsonpedroso.mcp_spring.controller;

import com.hudsonpedroso.mcp_spring.service.AiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {
    
    private final AiService aiService;

    /*
    *
    *   POST http://localhost:8080/api/chat
        Content-Type: application/json

        {
          "prompt": "Olá, como você está?"
        }
    *
    * */
    
    @PostMapping
    public Map<String, String> chatWithAi(@RequestBody Map<String, String> request) {
        String userPrompt = request.get("prompt");
        log.info("Recebida solicitação de chat com prompt: {}", userPrompt);
        
        String aiResponse = aiService.generateResponse(userPrompt);
        
        return Map.of("response", aiResponse);
    }
}