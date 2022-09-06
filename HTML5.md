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
<table>
		<thead>
			<tr><th width="150">NAME</th><th width="150">IMAGE</th><th width="150">PRICE</th><th width="150">BUY</th><th width="150">CART</th></tr>
		</thead>
		<tbody>
			<tr><th>meat</th><th><img src="img/m1.jfif" width="100"></th><th>20000</th><th><a href="#">BUY</a></th><th><a href="#">CART</a></th></tr>
		</tbody>
	</table>
<!--이런식으로 테이블을 생성도 할 수 있고 명령어 안에 길이도 설정할 수 있고 템플릿링크도 넣을 수 있다-->
<img src="리소스-스태틱-img폴더 안에 있는 이미지파일">
<video src="img폴더 안에 있는 동영상파일" controls="controls"></video>
```
  - 로그인창 형식
```HTML
<form ation="/loginimpl" method="post">
  <fieldset>
    <legend>LOGIN</legend>
    <label for="id">ID</label>
    <input id="id" type='text' name="fid">
    <!--legend라는 LOGIN을 전체적으로 두르는 선을 만들고-->
    <!--ID라는 라벨을 만들어서 붙여주고-->
    <!--입력창의 프로그래밍명은"id"이고 타입은 문자입력이고 fid라는 객체에 데이터를 저장-->
    <label for="pwd">PWD</label>
    <input id="pwd" type='password' name="fpwd">
    <!--타입만 다른데 password타입은 입력시 쩜쩜쩜으로 보임-->
    <input type="submit" value="LOGIN">
    <!--LOGIN이라고 써진 버튼을 만든다-->
    <!--마지막으로 이 form이 실행되면 loginimpl메소드를 실행시키며 입력정보들을 url에 표시함(post방식)-->
    </fieldset>
</form>
```
  - 회원가입창 형식
```HTML
<form action="/registerimpl" method="get">
		ID<input type="text" name="id"><br>
		PWD<input type="password" name="pwd"><br>
		AGE<input type="number" name="age"><br>
		BIRTH<input type="date" name="birth"><br>
		HOBBY<br>
		<input type="checkbox" name="hobby" value="t">Train
		<input type="checkbox" name="hobby" value="s">Study
		<input type="checkbox" name="hobby" value="n">Netplex<br>
		<!-- 입력값이 아니라서 value를 선택해야함 그래서 미리 value를 지정 -->
		<!-- 또 얘는 여러개 값을 중복체크하는 방식이라 쪼끔 고민해야함 -->
		GENDER<br>
		Female<input type="radio" name="gender" value="f">
		Male<input type="radio" name="gender" value="m">
		Aje<input type="radio" name="gender" value="a"><br>
    <!--radio타입은 선택지중 1택만 가능한 타입-->
		CAR<br>
		<select name="car">
			<option value="k1">K1</option>
			<option value="k2">K2</option>
			<option value="k3">K3</option>
		</select>
		<br>
		<!-- IMAGE<input type="file" name="img"><br> -->
		TA<textarea rows="10" cols="30" name="ta"></textarea>
		<input type="submit" value="REGISTER">
	</form>
  ```
  - 메인컨트롤러 수정
```java
/*
*지금은 여기서 로그인가능한 값(qqq,111)을 줘서
*입력값이 맞으면 홈으로 이동 다르면 loginfail이
*실행되도록 하였다
*기본적으로 scanner 이런건 쓰지않고 html로 입력을
*직접 받기때문에 받아오려는 input값에서 설정한 *name값을 따오면된다
*나머지는 if+equals로 String들이 일치하는지 판별 
*/
@RequestMapping("/loginimpl")
	public String loginimpl(String fid, String fpwd) {
		System.out.println("Login Impl");
		System.out.println(fid+" "+fpwd);
		String next = null;
		if(fid.equals("qqq")&&fpwd.equals("111")) {
			next = "start";
		}else {
			next = "loginfail";
		}
		return next;
	}
	@RequestMapping("/registerimpl")
	public String registerimpl(Cust cust) {
    //Cust클래스를 임포트 해줘야함
		System.out.println(cust);
		return "start";
	}
	@RequestMapping("/css")
	public String css01(String page) {
    //css가 반복되어버려서 html로 쉽게 반복할 수 있도록 구현해놓음 후에 기술예정
		return page;
  }
```
  - Cust
```java
import java.util.Arrays;

public class Cust {
	private String id;
	private String pwd;
	private int age;
	private String birth;
	private String[] hobby;
	private String gender;
	private String car;
	private String ta;

	public Cust() {
	}

	public Cust(String id, String pwd, int age, String birth, String[] hobby, String gender, String car, String ta) {
		this.id = id;
		this.pwd = pwd;
		this.age = age;
		this.birth = birth;
		this.hobby = hobby;
		this.gender = gender;
		this.car = car;
		this.ta = ta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	@Override
	public String toString() {
		return "Cust [id=" + id + ", pwd=" + pwd + ", age=" + age + ", birth=" + birth + ", hobby="
				+ Arrays.toString(hobby) + ", gender=" + gender + ", car=" + car + ", ta=" + ta + "]";
	}

}
//따로 초기설계클래스를 만들어주었다
//필드값+기본생성자+필드생성자+getter/setter+toString으로 이루어짐
```
  - CSS여러개 준비하기
```HTML
  <h3><a href="/css?page=css01">CSS01</a></h3>
	<h3><a href="/css?page=css02">CSS02</a></h3>
	<h3><a href="/css?page=css03">CSS03</a></h3>
	<h3><a href="/css?page=css04">CSS04</a></h3>
	<h3><a href="/css?page=css05">CSS05</a></h3>
	<h3><a href="/css?page=css06">CSS06</a></h3>
	<h3><a href="/css?page=css07">CSS07</a></h3>
	<h3><a href="/css?page=css08">CSS08</a></h3>
  <!--이런식으로 a태그에 css폴더속에 cssXX번을 끌고와라 를 표현-->
```
  - css01
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/css01.css">
<style>
	* {
		margin:0;
		padding:0;
		/*바깥쪽 안쪽 여백을 없애라*/
	}
	p {
		color:gray;
	}
</style>
</head>
<body>
	<h1>CSS01</h1>
	<h1 id="hh1">Header1</h1>
	<h2>Header2</h2>
	<h2 class="cc1">Header2</h2>
	<p class="cc1">Paragraph</p>
	<p>Parag<span>raph</span></p>
</body>
</html>
```
```css
@charset "EUC-KR";

	h1 {
		color:red;
		background:black;
		/*태그*/
	}
	#hh1 {
		color:yellow;
		background:blue;
	}
	/*사실은 h1에 색칠을 다하고 hh1에 덧칠을 한 개념*/
	/*id*/
	.cc1 {
		color:pink;
		background:red;
	}
	/*클래스*/
	p > span {
		color:red;
	}
	/*p 안에 있는 span을 가리키는 말*/
  ```
  ![css1](/image/2022-09-07-02-21-37.png)

  - css02
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a {
		color:black;
		text-decoration: none;
	}
	a:hover {
		color:red;
	}
	/*hover는 커서를 올릴 시 라는 뜻*/
	ul,ol {
		list-style:none;
		/*ul과ol의 기본쩜쩜을 없애겠다*/
	}
	ul > li:nth-child(1) {
		color:blue;
	}
	ul > li:nth-child(1) >a {
		background:blue;
	}
	/*2n = 짝수, 2n+1 = 홀수를 ()안에 넣기가능*/
	
	input [name="id"]{
		background:gray;
	}
	h1:hover {
	/*커서를 올리면 변함*/
		color:red;
		background:black;
	}
	p::first-line {
		color:pink;
	}
	p::selection { 
		background:yellow;
	}
</style>
</head>
<body>
	<h1>CSS02</h1>
	<h2><a href="#">Click</a></h2>
	<ul>
		<li><a href="#">MENU1</a>a</li>
		<li><a href="#">MENU2</a></li>
		<li><a href="#">MENU3</a></li>
		<li><a href="#">MENU4</a></li>
		<li><a href="#">MENU5</a></li>
	</ul>
	<p>ParagraphParagraphParagrap<br>hParagraph</p>
	<form>
		ID<input type="text" name="id"><br>
		PWD<input type="password" name="pwd"><br>
		<input type="submit" value="LOGIN">
	</form>
</body>
</html>
```
![](/image/2022-09-07-02-36-04.png)


  - css03
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/css03.css">
<style>
	 body {
	 background-image: url("img/bg.png");
	 }
</style>
</head>
<body>
	<h1>CSS03</h1>
	<table id="cust_tb">
		<thead>
			<tr><th>id</th><th>pwd</th><th>name</th></tr>
		</thead>	
		<!--테이블헤드-->
		<tbody>
			<tr><td>id01</td><td>pwd01</td><td>이말숙</td></tr>
			<tr><td>id01</td><td>pwd01</td><td>이말숙</td></tr>
			<tr><td>id01</td><td>pwd01</td><td>이말숙</td></tr>
			<tr><td>id01</td><td>pwd01</td><td>이말숙</td></tr>
			<tr><td>id01</td><td>pwd01</td><td>이말숙</td></tr>
		</tbody>
		<!--테이블바디-->
	</table>
</body>
</html>
```
```css
@charset "EUC-KR";

#cust_tb {
	 	width:300px;
	 	border:1px solid black;
	 	border-collapse: collapse;
	 	/*표와 셀 사이의 테두리여백 제거*/
	 }
	 #cust_tb , tr , td, th{
	 	border:1px solid black;
	 }
	 #cust_tb >thead > tr > th{
	 	font-family: 'Antonio', sans-serif;
	 }
	 
	 #cust_tb >tbody > tr > td{
	 	 text-align: center;
	 	 font-family: 'Noto Sans KR', sans-serif;
	 }
	 #cust_tb > tbody > tr:nth-child(2n+1){
	 	background:yellow;
	 }
	 #cust_tb > tbody > tr:hover{ 
	 	background: gray;
	 }
```
![](/image/2022-09-07-02-45-03.png)


  - css04
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		margin:0;
		padding:0;
    /*패딩은 내용과 선사이의 거리를 뜻함*/
	}
	div {
		width:300px;
		height:300px;
		border:2px solid red;
	}
	#d1 {
		background:blue;
		padding:10px;
	}
	/*이거 안쪽여백padding을 줄경우 박스 크기가 달라져버림!! 매우 주의*/
	#d1 > span {
		margin:10px;
	}
	/*이렇게 주면 인라인이기때문에 크기변형없이 10띄워짐*/
	/*인라인인걸 블락으로 바꾸려면 마진위쪽에 display:block;을 추가하면됨*/
	#d2 {
		background:yellow;
		margin:10px 20px;
		/*값 1개면 모든방향 2개면 x축y축 4개면 북동서남*/
		display:none;
		/*사라지는데 그 존재 자체가 사라져버림*/
		/* visibility: hidden; 은 보이는것만 사라짐 존재는 있음 */
	}
	#d3 {
		background:green;
		margin:0 auto;
		/*화면 크기가 바뀌어도 항상 가운데  */
	}
</style>
</head>
<body>
	<h1>CSS04</h1>
	<div id="d1">
		<span>SPAN</span>
	</div>
	<div id="d2">
		
	</div>
	<div id="d3">
		
	</div>
</body>
</html>
```
![](/image/2022-09-07-02-45-43.png)


  - css05
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		margin:0;
		padding:0;
	}
	div {
		width:100px;
		height:100px;
		/* float:left; */
		/*float은 블럭만 됨, 그래서 어제 메뉴블럭을 정렬함*/
		position: absolute;
		opacity: 0.8;
    /*투명도*/
	}
	#d1 {
		background:red;
		margin:30px 30px;
		z-index: 100;
		overflow: auto;
	}
	#d2 {
		background:blue;
		margin:60px 60px;
		z-index: 10;
	}
	#d3 {
		background:green;
		margin: 90px 90px;
		z-index: 20;
  /*z-index는 인덱스마다 높이를 줘서 높은값이 위로 올라오게 만드는 것*/
	}
	#d1 > p {
		width:50px;
		margin:0 auto;
	}
</style>
</head>
<body>
	<h1>CSS05</h1>
</body>
	<div id = "d1">
	<p>Para</p>
	<p>Para</p>
	<p>Para</p>
	<p>Para</p>
	<p>Para</p>
	<p>Para</p>
	</div>
	<div id = "d2"></div>
	<div id = "d3"></div>
</html>
```
![](/image/2022-09-07-02-46-47.png)
