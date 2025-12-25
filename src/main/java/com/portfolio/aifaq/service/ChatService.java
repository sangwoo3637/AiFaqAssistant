package com.portfolio.aifaq.service;

import com.portfolio.aifaq.domain.Faq;
import com.portfolio.aifaq.domain.QuestionLog;
import com.portfolio.aifaq.repository.FaqRepository;
import com.portfolio.aifaq.repository.QuestionLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    private static final double FAQ_SIMILARITY_THRESHOLD = 0.8;

    private final FaqRepository faqRepository;
    private final QuestionLogRepository logRepository;

    public ChatService(FaqRepository faqRepository,
                       QuestionLogRepository logRepository) {
        this.faqRepository = faqRepository;
        this.logRepository = logRepository;
    }

    public AnswerResult ask(String question) {

        List<Faq> faqs = faqRepository.findAll();

        Faq bestMatch = null;
        double bestScore = 0.0;

        for (Faq faq : faqs) {
            double score = similarity(question, faq.getQuestion());
            if (score > bestScore) {
                bestScore = score;
                bestMatch = faq;
            }
        }

        if (bestMatch != null && bestScore >= FAQ_SIMILARITY_THRESHOLD) {
            saveLog(question, bestMatch.getAnswer(), "FAQ", bestScore);
            return new AnswerResult(bestMatch.getAnswer(), "FAQ");
        }

        String aiAnswer = "AI 임시 응답입니다.";
        saveLog(question, aiAnswer, "AI", bestScore);
        return new AnswerResult(aiAnswer, "AI");
    }

    private void saveLog(String question, String answer, String type, double similarity) {
        QuestionLog log = new QuestionLog();
        log.setQuestion(question);
        log.setAnswer(answer);
        log.setAnswerType(type);
        log.setSimilarity(similarity);
        log.setCreatedAt(LocalDateTime.now());
        logRepository.save(log);
    }

    private double similarity(String a, String b) {
        return a.equalsIgnoreCase(b) ? 1.0 : 0.3;
    }

    public record AnswerResult(String answer, String type) {}
}
