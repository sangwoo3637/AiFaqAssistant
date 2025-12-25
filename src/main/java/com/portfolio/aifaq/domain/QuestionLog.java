package com.portfolio.aifaq.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "QUESTION_LOG")
public class QuestionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long id;

    @Column(name = "QUESTION", nullable = false, length = 500)
    private String question;

    @Lob
    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "ANSWER_TYPE", length = 20)
    private String answerType;

    @Column(name = "SIMILARITY")
    private Double similarity;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    /* getter */
    public Long getId() { return id; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public String getAnswerType() { return answerType; }
    public Double getSimilarity() { return similarity; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    /* setter */
    public void setQuestion(String question) { this.question = question; }
    public void setAnswer(String answer) { this.answer = answer; }
    public void setAnswerType(String answerType) { this.answerType = answerType; }
    public void setSimilarity(Double similarity) { this.similarity = similarity; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
