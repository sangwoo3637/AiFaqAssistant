package com.portfolio.aifaq.controller;

import com.portfolio.aifaq.domain.Faq;
import com.portfolio.aifaq.repository.FaqRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FaqController {

    private final FaqRepository faqRepository;

    public FaqController(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @GetMapping("/admin/faq")
    public String faqPage(Model model) {
        model.addAttribute("faqs", faqRepository.findAll());
        return "admin_faq";
    }

    @PostMapping("/admin/faq")
    public String addFaq(
            @RequestParam String question,
            @RequestParam String answer
    ) {
        Faq faq = new Faq(question, answer);
        faqRepository.save(faq);
        return "redirect:/admin/faq";
    }
}
