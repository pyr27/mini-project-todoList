# 📝 TodoList Project

## 프로젝트 소개
Spring Boot 기반의 간단한 Todo List 애플리케이션입니다.  
사용자는 할 일을 등록, 수정, 삭제, 완료 체크할 수 있습니다.  
추후 회원 관리 및 JWT 기반 인증/인가 기능을 연동할 수 있도록 설계되었습니다.

---

## ⚙️ 기술 스택
- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Security + JWT
- Thymeleaf
- MySQL (개발용 DB) / H2 (테스트 DB)

---

## 📂 주요 기능
- **회원별 Todo 관리**  
  - 할 일 추가
  - 할 일 조회
  - 할 일 수정
  - 할 일 삭제
  - 완료 여부 체크  

- **(추가 예정)** 회원가입 / 로그인 / JWT 인증


## 📌 현재 한계 및 개선 예정
- DB 연결 시 일부 오류가 있어 **H2 기반 테스트만 진행 중**
- 예외 처리 및 테스트 코드 보완 필요
- 추후 **JWT 인증 및 회원 관리 기능** 추가 예정

---

## ✨ 배운 점
- Spring Boot 구조 (Controller - Service - Repository) 설계 및 구현
- JPA 활용한 CRUD 기능 구현 경험
- Spring Security 및 JWT 인증 구조에 대한 이해
