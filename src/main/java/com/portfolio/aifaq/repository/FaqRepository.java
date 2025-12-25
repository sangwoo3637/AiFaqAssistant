package com.portfolio.aifaq.repository;

import com.portfolio.aifaq.domain.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Long> {
}
