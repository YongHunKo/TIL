# HTML
- HTML5+CSS3+JS를 합쳐서 3대장이라고 한다
```HTML
<h1>Hell HTML5</h1>
```
- 이런 형식의 구성
- 시작하는명령어와 끝내는명령어가 짝을 지어져있다
- 몇몇명령어는 시작명령어만 있음
- HTML에서 주석은 `<!-- -->`로 작성함
- 이클립스 세팅
  1. 스프링부트를 먼저 다운받는다
  2. 프로젝트를 만드는데 `스프링부트 프로젝트 - 스타터`로 생성한다
  3. 이름, type-Maven, Packaging : War, 자바11, Group명, Package명을 잘 설정한다
  4. Spring Boot DevTools, Thymeleaf, Spring Web 체크
  5. 카페에 긴줄 복사해서 `pom.xml`에 45~46번째줄 `</dependency>` 다음에 붙여넣기
  6. windows reference encording에서 언어를 utf-8로 반드시 설정
  7. 기본포트를 8080에서 80으로 바꿔야하는데
  8. src/main/resources 에 applications.properties 파일 수정 server.port=80
  9. src/main/java-패키지명 에서 다른 패키지를 만들어야함
  10. 보통 `.controller`로 붙임
  11. `MainController`클래스 작성
  12. `Controller`를 ctrl+space해서 임포트시킴
  13. 클래스 내부에서 메소드에 `request`를 마찬가지로 임포트시킴
  14. 클래스에 void를 안줬으니 리턴을 시켜야함
  15. `request`를 하고 난뒤 `("/")` 를 해줘야함
  16. 메소드를 만들어줬으면 이제 메소드에 해당하는 템플릿을 작성해줘야함
  17. 템플릿 작성시 생성위치 꼭 잘 봐야함
  18. 여기까지가 기본생성하는 방법
- 기본 명령어
```HTML
<h1></h1>
<!--제목 글자 생성 명령어, 속성은 블록 속성이라 한줄을 다씀 = 민폐-->
<a href="/">
<!--큰따옴표안의 템플릿으로 이동, #을 넣으면 재자리-->
```