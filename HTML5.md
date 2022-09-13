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
## 기본 명령어
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
## 로그인창 형식
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
## 회원가입창 형식
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
## 메인컨트롤러 수정
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
## Cust
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
## CSS여러개 준비하기
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
## css01
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

## css02
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


## css03
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


## css04
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


## css05
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
	
## css06
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin:0;
		padding:0;
	}
	a{
		text-decoration : none;
		color : black;
	}
	ul, li{
		list-style : none;
	}
	ul{
		width : 500px;
		height : 40px;
		border-top : 3px solid black;
		border-bottom : 3px solid black;
		margin : 0 auto; 
		/* 화면중앙으로 맞춤 */
	}
	ul > li {
		float : left;
		margin : 0px 20px;
		line-height : 40px;
	}
	/* ul아래 li들의 방향을 바꾼다 왼쪽부터 오른쪽으로 */
	/* 각각 x축으로 0px y축으로 10px을 떨어뜨린다 */
	/* 라인하이트는 높이에 맞춰서 중앙으로 맞춤 */
	ul > li > a:hover{
		color : red;
		font-weight : bold;
	}
	
</style>
</head>
<body>
	<ul>
		<li><a href="#">HTML5</a></li>
		<li><a href="#">CSS3</a></li>
		<li><a href="#">JavaScript</a></li>
		<li><a href="#">JQuery</a></li>
		<li><a href="#">AJAX</a></li>
	</ul>
</body>
</html>
```
![](/image/HTML,CSS/2022-09-09-03-16-18.png)
## css07
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/css07.css">
<style>
	a{
		text-decoration : none;
		color : black;
	}
</style>
</head>
<body>
	<h1>CSS07</h1>
	<div class="big_bt">
		<a href="#">CLICK</a>
	</div>
	<!-- div가 어찌보면 하나의 박스를 의미함 -->
	<!-- 또한 얘들만 적용시킬라고 id대신에 class를 줌 -->
</body>
</html>
```
```css
@charset "EUC-KR";
@import url('https://fonts.googleapis.com/css2?family=Antonio&family=Source+Code+Pro&display=swap');
/* Big Button CSS Start ---------*/
	.big_bt{
		margin : 5px auto;
		width:120px; height:50px;
		background-color:red;
		border:3px solid white;
		border-radius:20px;
		box-shadow: 3px 3px 3px gray;
	}
	/* 클래스는 . 으로 가져옴 */
	.big_bt > a{
		font-family: 'Source Code Pro', monospace;
		display : block;
		text-align : center;
		font-size : 130%;
		font-weight : bold;
		color : white;
		line-height : 50px; 
	}
	/* a의 영역이 글자크기만큼밖에 생성이안됨 = a를 변경시키자 */
	/* 높이는 밖에 div에 맞추는건 height가 아니라 line-height */
	.big_bt:hover{
		border : 3px solid yellow;
	}
	.big_bt > a:hover{
		color : yellow;
	}
	/* Big Button CSS End -----------*/
```
![](/image/HTML,CSS/2022-09-09-03-17-54.png)
- 버튼을 만드는 예제였음
- 호버기능까지 줘서 커서를 가져가면 변함
## css08
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/css07.css">
<link rel="stylesheet" href="css/css08.css">
<style>
	
</style>
</head>
<body>
	<header>
		<ul id="h_top">
			<li><a href="#">LOGIN</a></li>
			<li><a href="#">REGISTER</a></li>
			<li><a href="#">ABOUT US</a></li>
		</ul>
		<h1>HTML5 & CSS3.0</h1>
		<ul id="h_bottom">
			<li><a href="#">HTML5</a></li>
			<li><a href="#">CSS3</a></li>
			<li><a href="#">JavaScript</a></li>
			<li><a href="#">JQuery</a></li>
			<li><a href="#">AJAX</a></li>
		</ul>
	</header>
	<nav>
	</nav>
	<section>
		<aside id="left_a">
				<div class="big_bt">
					<a href="#">CLICK</a>
				</div>
				<div class="big_bt">
					<a href="#">CLICK</a>
				</div>
				<div class="big_bt">
					<a href="#">CLICK</a>
				</div>
		</aside>
		<!-- 왼쪽에는 버튼을 넣을거임 -->
		<aside id="center_a">
			<div></div>
			<div></div>
		</aside>
		<!-- 여기는 컨텐츠를 넣을생각 -->
		<aside id="right_a">
			<img src="https://via.placeholder.com/80x50">
			<img src="https://via.placeholder.com/80x50">
			<img src="https://via.placeholder.com/80x50">
			<img src="https://via.placeholder.com/80x50">
			<img src="https://via.placeholder.com/80x50">
			<img src="https://via.placeholder.com/80x50">
		</aside>
		<!-- 오른쪽엔 광고를 넣을거임 -->
		<!-- 이걸 인라인에서 블락으로 바꿔서 센터로 놓고싶다 위에 가서 설정 -->
	</section>
	<footer>
	</footer>
</body>
</html>
```
```css
@charset "UTF-8";
/* Global Header CSS */
	*{
		margin:0;
		padding:0;
	}
	a{
		text-decoration : none;
		color:black;
	}
	ul,ol{
		list-style:none;
	}
	
	
	/* Start Header CSS------- */
	header{
		width : 800px;
		height : 120px;
		margin : 0 auto;
		background : red;
	}
	header > h1{
		width : 500px;
		height : 50px;
		text-align : center;
		margin : 0 auto;
	}
	header > #h_bottom{
		width : 500px;
		height : 40px;
		border-top : 3px solid black;
		border-bottom : 3px solid black;
		margin : 0 auto; 
	}
	header > #h_bottom > li {
		float : left;
		margin : 0px 20px;
		line-height : 40px;
	}
	header > #h_bottom > li > a:hover{
		color : white;
		font-weight : bold;
	}
	header > #h_top {
		width : 800px;
		height : 20px;
	}
	header > #h_top >  li {
		float : right;
	}
	/* End Header CSS------- */
	
	
	
	/* Start Nav CSS------- */
	nav{
		width : 800px;
		height : 30px;
		margin : 0 auto;
		background : #997000;
	}
	/* End Nav CSS------- */
	
	
	
	/* Start Section CSS------- */
	section{
		width : 800px;
		height : 600px;
		margin : 0 auto;
		background : #D5D5D5; 
	}
	section > aside{
		float : left;
		/* 박스는 이러헥 왼쪽으로 정렬시키면 순서대로된다 */
	}
	section > #left_a{
		width: 150px;
		height : 600px;
		background : #F5D6D6;
	}
	section > #center_a{
		width: 550px;
		height : 600px;
		background : #C6D6D6;
	}
	section > #center_a > div{
		width: 500px;
		height : 250px;
		border : 2px solid black;
		margin : 10px auto;
	}
	section > #center_a > div:hover{
		background : gray;
		border : 2px solid black;
	}
	section > #right_a{
		width: 100px;
		height : 600px;
		background : #E7D6D6;
	}
	section > #right_a > img{
		display : block;
		margin : 5px auto;
	}
	/* End Section CSS------- */
	
	
	/* Start Footer CSS------- */
	footer{
		width : 800px;
		height : 30px;
		margin : 0 auto;
		background : black; 
	}
	/* End footer CSS------- */
	/* 전체적인 모양부터 만든다 */
```
- 기본적인 틀은 `bootstrap`으로 가져와서 함
- css를 여러개 링크도 가능하다는걸 알게됨
- 대체로 부트스트랩을 따오면 되는거 같음
- 우리가 직접 그리지 않아도 이미 널려있는게 많음
![](/image/HTML,CSS/2022-09-09-03-22-17.png)
## css09
```HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>Insert title here</title>
<style>
	@media screen and (max-width:767px){
		body{
			background:red;color:white;
		}
		div{
			width : 400px;
			height : 300px;
			background : white;
		}
	}
	@media screen and (min-width:768px) and (max-width:959px){
		body{
			background:blue;color:white;
		}
		div{
			width : 600px;
			height : 400px;
			background : yellow;
		}
	}
	@media screen and (min-width:960px){
		body{
			background:black;color:white;
		}
		div{
			width : 800px;
			height : 600px;
			background : white;
		}
	}
	/* 반응형 웹 먼저 바디를 설정하고 meta를 변경 */
	/* 화면 사이즈에 따라 배경색이 달라짐 */
</style>
</head>
<body>
	<div></div>
</body>
</html>
```
- 반응형 웹에 대한 예제
- 화면 크기를 일정크기에 맞춰서 재구성함
- 각각 사용하는 디바이스 디스플레이 환경에 따라 설정함

## 특정 부분은 고정시키고  일부분만 바꾸기
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String main() {
		return "main";

	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("center","about");
		model.addAttribute("left","left_about");
		return "main";

	}
	
	@RequestMapping("/projects")
	public String projects(Model model) {
		model.addAttribute("center","projects");
		model.addAttribute("left","left_projects");
		return "main";

	}
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("center","contact");
		model.addAttribute("left","left_contact");
		return "main";
		// 일종의 치환 개념
	}
}
```
```HTML
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>My Page</title>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<li><a href="/about">About</a></li>
					<li><a href="/projects">Projects</a></li>
					<li><a href="/contact">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav" th:insert="${left} ? ${left} : left">
			</div>

			<!-- Main Center Start -->
			<div class="col-sm-8 text-left"
				th:insert="${center} ? ${center} : center">
				<!-- ${center}센터 값이 존재하지 않으면 우리가 만들어 놓은 center.html을 실행해라 -->
			</div>
			<!-- Main Center End -->
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>
</body>
</html>
```
- 각 메소드에 객체를 입력하고 `객체.addAttribute(x,y)`를 하여 치환 하는 개념으로 메소드 실행시 x.html을 y.html로 바뀌는 것
- 즉 바꾸려는 것 외에는 그대로인데 바꾸고싶은 것만 바뀌는 것    
**<전>**
![](/image/HTML,CSS/2022-09-09-03-39-13.png)
**<다른 곳을 누른 후>**
![](/image/HTML,CSS/2022-09-09-03-40-18.png)

## 컨트롤러와 템플릿의 분리 - 세분화
- 메인컨트롤러에 모든 클래스를 담기에는 너무 길어진다
- 따라서 공통점이 있는 클래스들 끼리 따로 빼버린다
![](/image/HTML,CSS/2022-09-14-02-33-25.png)
![](/image/HTML,CSS/2022-09-14-02-34-22.png)
![](/image/HTML,CSS/2022-09-14-02-35-03.png)
- 여기서 주의해야 할건 세부적인 컨트롤러는 시작에 컨트롤러와 맵핑을 같이 붙여준다.
- 마찬가지로 템플릿도 따로 묶어서 할 수 있다
- ![](/image/HTML,CSS/2022-09-14-02-37-38.png)
- 위에서 썼던 $를 사용해서 센터와 왼쪽을 바꾼다
### day04 - js01
```javascript
<meta charset="utf-8">

<script>
window.onload = function(){
	// 3. 그래서 이걸 넣어서 순서를 변경하는 것
	// 얘들은 건너뛰고 아래에 바디를 실행하고 와서 이걸 실행한다
	// 이러면 이제 'REPLACE TEXT...'가 뜸
	var h2 = document.querySelector('h2');
	//1. 문서안에서 클래스, 태그, 아이디도 가져올수 있는 거
	//js에서는 ' 을 쓴다
	// 가져와 그리고 이걸 넣어
	h2.innerHTML = 'REPLACE TEXT...';
	//2. js는 위에서 부터 쭉 실행 되는데 아직 h2가 구현이 안된상황
	//h2 자리에 Header2라고 뜸
};
</script>

<h1>JS01 Center</h1>
<h2>Header2</h2>
<p>Paragraph</p>
```
- js의 특징 1
### day04 - js02
```javascript
<script>
window.onload = function(){
	//alert('Alert');
	// 화면이 뿌려진 후에 알트 발동
	var h1 = document.querySelector('h1');
		// js에서 변수 선언은 var
	//h1.innerHTML = 'TEXT..';
		// h1 안에 'TEXT..'를 넣으세요
	h1.innerHTML = '<a href="">CLICK</a>'
	// 링크넣기도가능
	
	var h2 = document.querySelector('#hh2');
	h2.innerHTML = 'H2 TEXT';
	
	var h3 = document.querySelector('.cc1');
	h3.innerHTML = 'CC1 class';
	// 근데 클래스를 두개 묶었는데 하나만 적용됨
	
	var a = 10;
	var b = 20;
	//alert(a+b);
	//console.log('RESULT:'+(a+b));
	
	h2.innerHTML = (a+b);
	// 나중에 바꾼걸로 덮어씌워짐
};


</script>

<h1>JS02 Center</h1>
<h2 id="hh2">JS02 Center</h2>
<h3 class="cc1">JS02 Center</h3>
<h4 class="cc1">JS02 Center</h4>
<h5>JS02 Center</h5>
```
- js의 특징 2

### day04 - js03
```javascript
<script>

var n1 = 10;
var n2 = 10.2;

var b = true;
//블린값 줄때 소문자로 줘야함.
var s1 ='abc';
// 자바에서 string은 레퍼런스 타입이지만 js에선 그냥 var
var s2 = "abc";

var a = [1,'a',true];
// js에선 다양한 타입 넣기 가능, 배열도 object타입
var o = {'name':'james','age':10};
// js의 객체
var o2 = [
	{'name':'james','age':10},
	{'name':'james','age':10},
	{'name':'james','age':10}
];
// 배열안에 객체넣기
// -->이런 오브젝트를 표현한 것들을 제이슨이라고 함
var f = function(){
	return 10;
};
// 변수안에 함수넣기 가능
var u;
// undefined 로 냅두는 것

/* alert(typeof(a));
console.log(typeof(a)); 타입확인용 방법 2가지*/

var d1 = 10;
var d2 = '20';

var result = d1+d2;//1020이 나옴
var result = d1*d2;//어라 얘는 되네 200, + 만 안되는
var result = d1+Number(d2);//타입변환시키는 방법
// 타입변환이 안돼는 애들이면 Nan이 나옴

var data = Math.max(1,5,3,6,7,100);
alert(data);
</script>
<h1>JS03 Center</h1>
```
- js의 특징 3

### day04 - js04
```javascript
<script>

var str = 'abcdefg';
var len = str.length;
var s = str.charAt(2);
// 두번째에 있는 변수가 뭐냐 = 0부터시작 = c
var s2 = str.indexOf('d');
// 너 몇번째니 = 3

//<예제>id와 도메인 분리하기
var mail = 'jmlee@tonesol.com';
var id = mail.substring(0,mail.indexOf('@'));
var domain = mail.substring(mail.indexOf('@')+1,mail.indexOf('.'));
alert(id);
alert(domain);
//alert로 확인하기



</script>

<h1>JS04 Center</h1>
```
- js특징 4

### day04 - js05
```javascript
<style>
	#center_div{
		width:200px;
		border:2px solid red;
	}
</style>

<script>

/* var a = [1,2,3,4,5]; */
/* for(var i=0; i<a.length;i++){
	alert(a[i]);
}; 잘 안씀*/
/* for(var i in a){
	alert(a[i]);
}; */
// js의 확장된 for문
window.onload = function(){
	//배열을 div칸 화면에 뿌리고싶다
	var data = ['ABC','DEF','GHI','JKL'];
	var result = '';
	var center = document.querySelector('#center_div');
	for(var i in data){
		result +='<h1>'+data[i]+'</h1>';
	};
	center.innerHTML = result;
};

</script>


<h1>JS05 Center</h1>
<div id="center_div">
</div>
```
- js의 특징 5

### day04 - js06
```javascript
<meta charset="utf-8">

<style>
	#center_div{
		width:400px;
		border:2px solid red;
	}
</style>

<script>
window.onload = function(){
	//제이슨 데이터를 어떻게 뽑아서 표현할 것이냐
	var data = [
		{'num':1,'title':'오징어게임','updown':'up'},
		{'num':2,'title':'태풍','updown':'down'},
		{'num':3,'title':'러시아','updown':'up'},
		{'num':4,'title':'우크라이나','updown':'down'},
		{'num':5,'title':'전쟁','updown':'up'}
	];
	
	var result = '';
	var center = document.querySelector('#center_div');
	//뿌릴 위치
	for(var i in data){
		result += '<h3>'+data[i].num+'. '+data[i].title+' '+data[i].updown+'</h3>';
	};
	center.innerHTML = result;
};

</script>


<h1>JS06 Center</h1>
<div id="center_div">
</div>
```
- js특징 6, 실검처럼 표현하기

### day04 - js07
```javascript
<script>
/* f1();
//얘는 실행됨
f2();
//얘는 안됨 */
function f1(){
	return 10;
};
var f2 = function(){
	return 20;
};

var r1 = f1();
var r2 = f2();


function f3(a,b){
	return a*b;
};

var result = f3(10,20);
alert(result);
</script>

<h1>JS07 Center</h1>
```
- js특징 7

### day04 - js08
```javascript
<script>
function f1(){
	return 10;
};
function f2(){
	return 10;
};

function f3(g1,g2){
	return 100 *g1()*g2();
};

var result = f3(f1,f2);
// 함수에 함수넣기 가능

// 그럼 반대로해도 되지않을까?
function a1(){
	return function(){//익명클래스 넣기
		return 100;
	};
};		

var r =a1();
//r은 익명클래스가 됨
var data = r();
alert(data);
</script>

<h1>js08 Center</h1>
```
- js특징 8, 익명클래스를 구현