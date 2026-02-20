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
        reqBody.put("prompt", "Generate only one continuous paragraph of 140 to 170 words in very simple English about any random everyday topic chosen internally. Do not write a title. Do not mention the topic name separately. Do not use exclamation marks. Do not use commas. Do not use colons. Do not use semicolons. Do not use dashes. Do not use quotation marks. Do not use brackets. Do not use bullet points. Do not use numbering. Do not create sections. Do not create lists. Do not create headings. Do not create introduction or conclusion labels. Do not use special characters or symbols. Use only full stops as punctuation. Do not create new lines. Output only the paragraph text and nothing else.");
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
