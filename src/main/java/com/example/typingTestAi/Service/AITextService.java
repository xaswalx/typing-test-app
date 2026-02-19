package com.example.typingTestAi.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AITextService {


    public String generateTypingText() {


        String url = "http://localhost:11434/api/generate";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> reqBody = new HashMap<>();

        reqBody.put("model", "tinyllama");
        reqBody.put("prompt", "Write exactly 120 words for typing practice about discipline. " +
                "Do not use commas, periods, numbers, symbols, or any punctuation. " +
                "Return only the paragraph.");
        reqBody.put("stream", false);


        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<Map<String, Object>> request = new HttpEntity<>(reqBody, headers);

        try {
            ResponseEntity<Map> response =
                    restTemplate.postForEntity(url, request, Map.class);

            return response.getBody().get("response").toString();
        } catch (Exception e) {

            // Fallback text (so your app never crashes)
            return "Discipline is the foundation of success. Practicing daily improves focus, accuracy, and confidence. Consistent effort builds strong habits over time and helps individuals achieve their goals through steady progress.";
        }


    }
}
