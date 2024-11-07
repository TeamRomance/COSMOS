# COSMOS 
##### 수정일: 2024-11-07 (목)
##### 작성자: 한우창

## Contact Us

### 기능 설명
요청에 따른 정보로 COSMOS 팀원에게 메일을 전송하는 기능.

### 사용된 기술
- JavaMailSender: 이메일 전송을 위한 Java 기반의 메일 라이브러리

### 주요 기능 흐름 
1. 사용자가 웹 페이지에서 Contact Us 양식을 작성하고 제출.
2. ContactUsController가 요청을 받아 EmailRequestDTO에 데이터를 매핑.
3. EmailService를 호출하여 이메일 전송 비즈니스 로직 수행.
4. JavaMailSenderEmailService가 실제 메일 전송 작업을 처리.



