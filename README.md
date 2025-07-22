## Memo 프로젝트 기능
### 📝 메모 기능 (Memo)
- 메모 작성 (`POST /api/memos`)
- 메모 전체 조회 (`GET /api/memos`)
- 메모 수정 (`PUT /api/memos/{id}`)
- 메모 삭제 (`DELETE /api/memos/{id}`)
- 키워드로 메모 검색 (`GET /api/memos/contents`)
  - 쿼리 파라미터 `keyword`가 메모의 내용(`contents`)에 포함된 항목 반환
  
-----------------------------------

## Board 프로젝트 기능
### 👩‍💼 회원 기능 (Member)
- 회원 가입 (`POST /members/signup`)
- 특정 회원 조회 (`GET /members/{id}`)
- 비밀번호 변경 (`PATCH /members/{id}`)

### 📋 게시글 기능 (Board)
- 게시글 작성 (`POST /boards`)
  - 세션에 회원 정보가 있어야 작성 가능
- 게시글 전체 조회 (`GET /boards`)
- 특정 게시글 조회 (`GET /boards/{id}`)
  - 게시글 작성자의 나이도 함께 응답
- 게시글 삭제 (`DELETE /boards/{id}`)

### 🔐 세션 기반 인증
- 회원 가입 시 `HttpSession`에 사용자 정보 저장
- 게시글 작성 시 `@SessionAttribute`를 활용하여 인증
