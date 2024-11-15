# COSMOS
##### 수정일: 2024-11-16 (토)
##### 작성자: 한우창

## Auth

### 기능 설명
- 로그인을 통해 사용자 권한에 따라 접근 가능한 리소스를 제어하는 기능

### 사용된 기술
- SpringDataJpa: 사용자 정보를 DB에 저장 및 조회.
- SpringSecurity: 사용자 인증 및 권한 관리를 위한 보안 프레임워크

### 주요 기능 흐름
1. 사용자가 로그인 페이지로 이동
   - 사용자가 /login 경로로 접근.
   - LoginController가 요청을 처리하여 로그인 페이지 반환.
2. 사용자 인증
   - 로그인 요청 시 CustomUserDetailService가 데이터베이스에서 사용자 정보를 조회하여 인증.
   - 인증 실패 시 CustomLoginFailureHandler가 호출되어 실패 메시지 처리.
   - 인증 성공 시 CustomLoginSuccessHandler가 호출되어 세션 초기화 및 리다이렉트.
3. API 접근 권한 제어
   - 로그인 성공 후 인증된 사용자는 API 문서에 접근 가능.
   - 비로그인 사용자는 접근 시 로그인 페이지로 리다이렉트.







