# Java-springboot-2026

## 12일차

### Toyproject - StudyGroup

#### 스터디 모집 DB설계

- 스터디모집 ERD
  ![alt text](image-35.png)

- 테이블 관계
  - 스터디 종륲 카테고리 1개는 여러개의 스터디글에 포함
    - `categories 1 : N study_posts`
  - 사용자 1명은 여러개의 스터디 글을 쓸 수 있음
    - `user_account 1 : N study_posts`
  - 사용자 1명은 여러개의 댓글을 쓸 수 있음
    - `user_account 1 : N comment`
  - 스터디 게시글 1개에는 여러개의 댓글이 적힘
    - `study_posts 1 : N comments`
  - 사용자 1명은 여러 스터디 게시글에 신청가능
    - `user_account 1 : N study_applications`
  - 스터디 게시글 1개에는 여러 신청이 들어옴
    - `study_posts 1 : N study_applications`

#### 스터디모집 웹사이트

```
StudyGroup
├─ config: 회원가입, 로그인 시 암호화
├─ controller: MVC 패턴 중 Controller 영역
├─ dto: MVC 패턴 중 Model에 직접 연관
├─ `mapper`: MVC 패턴 중 Model. DB 쿼리 매핑
├─ service: MVC 패턴 중 Model. 비즈니스(도메인) 로직
├─ validation: MVC 패턴 중 View. 화면 입력 검증
└─ resources: 웹페이지 리소스
    ├─ `mapper`: MVC 패턴 중 Model. DB 쿼리 위치
    ├─ static: View에 포함되는 이미지, CSS, 정적 HTML, js
    └─ templates: MVC 패턴 중 View. 실제 화면을 나타낼 영역
```

- 카테고리 CRUD
  - dto, Category, 클래스 생성
  - validation, CategoryForm 클래스 생성
  - mapper, CategoryMapper, StudyPostMapper 인터페이스, xml 생성
  - service, CategoryService, StudyPostService 클래스 생성 <!--, CategoryServiceImpl, StudyPostServiceImpl -->
  - controller, Admin용 CategoryController 클래스 생성
  - templates/admin/category/list.html, form.html 생성

    ![alt text](image-36.png)

- 스터디포스트 CRUD
  - dto, StudyPost 클래스 생성
  - mapper, StudyPostMapper 인터페이스, xml 생성
  - validation, StudyPostForm 클래스 생성. dto, StudyPost 멤버변수 복사 사용
  - service, StudyPostService 클래스 생성
  - controller, StudyPostController 클래스 생성
  - templates/post/list.html, form.html 생성

  ![alt text](image-37.png)

#### 조회수 증가

- 스터디포스트 상세보기 확인

## 13일차

#### 스터디 모집 기능

- 스터디포스트 아래 댓글기능
  - dto, Comment 클래스
  - validation, CommentForm 클래스
  - mapper, CommentMapper 인터페이스
  - templates/mapper, CommentMapper.xml SQL
  - service, CommentService 클래스
  - controller, CommentController 클래스
  - controller, StudyPostController.detail() 댓글 목록, 폼 추가
  - html, post/detail.html 화면 추가

- 스터디신청 기능
  - dto, StudyApplication 클래스
  - validation, StudyApplicataionForm 클래스
  - mapper, StudyApplicationMapper 인터페이스
  - templates/mapper, StudyApplication.xml
  - service, StudyApplicationService 클래스
  - controller, StudyApplicationController 클래스
  - html, post/detail.html 화면 추가

## 14일차

#### 스터디모집 신청 계속

#### TIP

- Controller는 사용자의 요청을 받아서 Service로 전달한 뒤 받은 결과를 View로 출력하는 기능
- Service는 요청에서 Model로 데이터 요청, 돌려받아서 비즈니스 로직 처리
- View는 돌려받은 데이터들을 표현

![alt text](image-38.png)

#### 필요이슈

- [x] Controller에서 post 메서드 파라미터 순서 중요
  - 입력검증 파라미터 다음에 BindingResult가 위치해야 함!
  - @Valid CommentForm commentForm, BindingResult bindingResult, ...

- [x] 스터디 신청 문제
  - 중복신청 시 알림이 없음
  - 신청 후 메세지가 없음

- [x] 각 입력폼 에러메시지 디자인 통일
  - 글로벌 에러는 alert 디자인으로
  - 각 입력별 에러메시지는 단순 빨간색으로

- [x] 전체 인원이 2명인데 3명 승인 가능
- [x] 승인한 멤버에 대해 다시 거절하는 기능
- [x] 인원이 전부 신청승인 되고나면 스터디포스트 자체가 CLOSED가 되어야 함
- [x] Join.html, Login.html 페이지 버튼 디자인 변경
- [x] 마감된 스터디에 신청버튼이 존재
- [x] 스터디포스트 페이징
  - BoardMapper.xml 참조해서 StudyPostMapper.xml findAll 메서드 변경
  - StudyPostMapper 인터페이스 위 내용참조해서 추가변경
  - BoardServiceImpl 참조해서 StudyPostService 클래스 getPostList 메서드 변경
  - StudyPostController 클래스 수정
  - templates/post/list.html 페이징 추가

- [x] 게시판 작성자 입력 불필요
  - dto.BoardForm @NotBlank 어노테이션 삭제
- [x] 게시판 댓글 등록 오류메세지 미출력
  - RedirectAttributes 파라미터 사용
- [x] 기존 게시판 상세 디자인 StudyPost 상세 형태와 동일하게 변경
- [x] 로그아웃 후 home으로 이동
- [x] 전체 Footer 작업
  - Bootstrap 클래스만으로 가능

![alt text](image-39.png)

## 15일차

### StudyGroup 계속

#### 관리자 홈관리화면

- 컨텐츠 관리
  - Stie 테이블
  - dto, Site 클래스
  - validation, SiteForm 클래스
  - controller, SiteController 클래스
  - mapper, SiteMapper 인터페이스
  - templates/mapper, SiteMapper.xml
  - service, SiteService 클래스
  - controller, HomeController home 메서드 수정

  ![alt text](image-41.png)

- 이미지 관리
  - application.properties에 저장경로 설정!
  - Site_Image 테이블 생성
  - dto, SiteImage 클래스
  - validation, SiteImageForm 클래스
  - controller, SiteImageController 클래스
  - mapper, SiteImageMapper 인터페이스
  - templates/mapper, SiteImageMapper.xml
  - service, SiteImageService 클래스
  - controller, HomeController home 메서드 수정

## 16일차

### StudyGroup 계속

#### 관리자 홈관리 중 이미지 처리

- 이미지 관리 계속
  -

#### 남은 이슈

- [x] favicon(favorite + icon) 추가
  - 자동인식방법 resources/static/favicon.ico
  - png to ico 변환 필요

  ![alt text](image-40.png)

- [x]에러 페이지 필요 - 디자인만 잘하면 됨
  - 404 에러: Page Not Found
  - 500 에러: Internal Server Error

- home.html 관리자가 관리할 화면 생성
  - Hero 이미지: 웹 전체 화면을 채우는 배경이미지
  - Carousel 이미지: 이미지가 일정시간마다 전환, 또는 버튼클릭으로 전환하는 디자인
  - 현재화면

- home.html 동작 바인딩
- Spring Security
- JWT
- 파일 업로드

- 미니프로젝트 팀 구성
- 미니프로젝트 주제
