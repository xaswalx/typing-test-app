package com.example.typingTestAi.Repository;

import com.example.typingTestAi.Entity.TypingResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypingResultRepository  extends JpaRepository<TypingResult, Long> {
    TypingResult findTopByOrderByWpmDesc();
    List<TypingResult> findTop10ByOrderByWpmDesc();


}