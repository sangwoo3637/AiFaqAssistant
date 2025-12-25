package com.portfolio.aifaq.controller;

import com.portfolio.aifaq.repository.QuestionLogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final QuestionLogRepository questionLogRepository;

    public AdminController(QuestionLogRepository questionLogRepository) {
        this.questionLogRepository = questionLogRepository;
    }

    @GetMapping("/admin/logs")
    public String logs(
            @RequestParam(required = false) String type,
            Model model
    ) {
        if (type == null || type.equals("ALL")) {
            model.addAttribute("logs", questionLogRepository.findAllByOrderByIdDesc());
        } else {
            model.addAttribute("logs",
                    questionLogRepository.findByAnswerTypeOrderByIdDesc(type));
        }

        model.addAttribute("selectedType", type == null ? "ALL" : type);
        return "admin_logs";
    }
}
