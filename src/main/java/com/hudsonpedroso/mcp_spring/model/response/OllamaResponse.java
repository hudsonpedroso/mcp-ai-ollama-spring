package com.hudsonpedroso.mcp_spring.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OllamaResponse {
    private String model;
    private String response;
    private Boolean done;
    private Long total_duration;
    private Long load_duration;
    private Long prompt_eval_duration;
    private Long eval_duration;
}