package com.portfolio.aifaq.repository;

import com.portfolio.aifaq.domain.QuestionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionLogRepository extends JpaRepository<QuestionLog, Long> {

    List<QuestionLog> findAllByOrderByIdDesc();

    List<QuestionLog> findByAnswerTypeOrderByIdDesc(String answerType);
}
