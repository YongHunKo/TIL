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
  9. 