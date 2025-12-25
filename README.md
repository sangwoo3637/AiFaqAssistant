# 🤖 AI FAQ Assistant

FAQ 기반 자동응답 + 질문 로그 관리 기능을 포함한  
**Spring Boot 기반 AI FAQ 포트폴리오 프로젝트**입니다.

---

## 📌 프로젝트 개요

기존의 단순 FAQ 시스템은  
- 질문이 정확히 일치하지 않으면 응답하지 못하고  
- 실제 사용 로그를 관리하기 어렵다는 한계가 있습니다.

이 프로젝트는 이러한 문제를 개선하기 위해  
**FAQ 자동응답 + 관리자 로그 관리 구조**로 설계되었습니다.

---

## 🛠 기술 스택

- **Backend**: Spring Boot 4.x, Spring MVC, Spring Data JPA
- **Database**: Oracle XE
- **View**: Thymeleaf
- **ORM**: Hibernate
- **Build Tool**: Maven
- **Server**: Embedded Tomcat

---

## ✨ 주요 기능

### 1️⃣ FAQ 자동 응답
- 사용자가 질문을 입력하면
- DB에 저장된 FAQ와 비교하여 응답
- 응답 결과를 화면에 출력

### 2️⃣ 질문 로그 자동 저장
- 모든 질문은 `QUESTION_LOG` 테이블에 저장
- 질문 내용 / 응답 내용 / 응답 유형(FAQ) / 시간 기록

### 3️⃣ 관리자 대시보드
- 전체 질문 수 확인
- FAQ 응답 수 / AI 응답 수 분리 집계
- 질문 로그 목록 테이블 제공

---

## 🧩 프로젝트 구조
com.portfolio.aifaq
├─ controller
│ ├─ PageController
│ └─ AdminController
├─ service
│ └─ ChatService
├─ domain
│ ├─ Faq
│ └─ QuestionLog
├─ repository
│ ├─ FaqRepository
│ └─ QuestionLogRepository
└─ AiFaqAssistantApplication

---

## 🎯 포트폴리오 포인트

- 단순 CRUD가 아닌 **실제 서비스 흐름 기반 설계**
- 사용자 화면 + 관리자 화면 분리
- 질문 로그를 활용한 **확장 가능한 AI 연계 구조**
- 향후 AI API(OpenAI 등) 연동이 가능한 구조

---

## 🔮 확장 아이디어 (면접용 한 줄)
- FAQ 미응답 시 AI API 연동
- 질문 유사도 기반 추천
- 관리자 FAQ 관리 화면 추가


