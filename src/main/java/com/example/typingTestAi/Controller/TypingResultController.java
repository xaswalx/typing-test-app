package com.example.typingTestAi.Controller;

import com.example.typingTestAi.Entity.TypingResult;
import com.example.typingTestAi.Repository.TypingResultRepository;
import org.springframework.web.bind.annotation.*;
import com.example.typingTestAi.Service.AITextService;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@CrossOrigin
public class TypingResultController {

    private final TypingResultRepository repository;

    private final AITextService aiTextService;

    public TypingResultController(TypingResultRepository repository , AITextService aiTextService){
        this.repository = repository;
        this.aiTextService = aiTextService;
    }

    @PostMapping
    public TypingResult saveResult(@RequestBody TypingResult result){
        return repository.save(result);
    }

    @GetMapping("/text")
    public String generateText(){
        return aiTextService.generateTypingText();
    }

    @GetMapping
    public List<TypingResult> getAllResult(){
        return repository.findAll();
    }

    @GetMapping("/top10")
    public  List<TypingResult> getLedarborad()
    {
        return repository.findTop10ByOrderByWpmDesc();
    }

    @GetMapping("/top")
    public TypingResult getTopResult()
    {
        return repository.findTopByOrderByWpmDesc();
    }

}