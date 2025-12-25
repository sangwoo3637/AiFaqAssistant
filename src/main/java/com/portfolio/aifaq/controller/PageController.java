package com.portfolio.aifaq.controller;

import com.portfolio.aifaq.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    private final ChatService chatService;

    public PageController(ChatService chatService) {
        this.chatService = chatService;
    }

    // 메인 화면
    @GetMapping("/")
    public String home() {
        return "assistant";
    }

    // GET /ask 대응 (새로고침, 직접접속 대비)
    @GetMapping("/ask")
    public String askPage() {
        return "assistant";
    }

    // 질문 전송
    @PostMapping("/ask")
    public String ask(@RequestParam String question, Model model) {
        var result = chatService.ask(question);

        model.addAttribute("answer", result.answer());
        model.addAttribute("type", result.type());

        return "assistant";
    }
}
