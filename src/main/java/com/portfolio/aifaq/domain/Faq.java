package com.portfolio.aifaq.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "FAQ")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAQ_ID")
    private Long id;

    @Column(name = "QUESTION", nullable = false, length = 500)
    private String question;

    @Lob
    @Column(name = "ANSWER", nullable = false)
    private String answer;

    protected Faq() {}

    public Faq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Long getId() { return id; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
}
