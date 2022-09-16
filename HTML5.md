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


### day04 -js09
```javascript
<script>
var data = 'alert("ALERT")';
eval(data);

var result = '10+10+10';
alert(eval(result));
// 일반 스트링을 실행시켜줄수있음, 따옴표들을 빼버리는

var result2 = 10/0;

if(isFinite(result2)){
	alert('Finite');
}else{
	alert('Infinite')
};
</script>

<h1>JS09 Center</h1>
```
- `eval()`은 괄호안에 스트링중에 계산이 가능하면 가능하도록 하는 명령어

### day04 - js10
```javascript

<script>
window.onload = function(){
	var hh1 = document.querySelector('#hh1');
	var hh2 = document.querySelector('#hh2');
	var hh3 = document.querySelector('#hh3');
	var daum = document.querySelector('#daum');
	
	daum.onclick = function(){
		var c = confirm('이동할거야?');
		if(c){
			location.href= 'http://www.daum.net';
		}else{
			return;
		}
	};
	
	hh1.onclick = function(){
		//클릭시 발동
		var txt = hh1.innerHTML;
		//hh1의 텍스트를 가져와라
		hh2.innerHTML = txt;
		//hh2의 텍스트를 뿌려라
		window.open('www.naver.com');
		//링크를 열어버림
	};
	hh2.onclick = function(){
		location.href='http://www.naver.com';
		//~로 이동시켜라
	};
	
	setInterval(function(){
		var date = new Date();
		var str = date.toString();
		hh2.innerHTML =str;
	}, 2000);
	// 2초에 한번씩 날짜를 스트링으로 변환한걸 뿌린다
	
	/* setTimeout(() => {
		location.href='/';
	}, 5000);
	// 5초뒤에 발동 */
	
	var si = setInterval(() => {
		var str = hh3.innerHTML;
		str += '*';
		hh3.innerHTML = str;
	}, 500);
	
	setTimeout(() => {
		clearInterval(si);
	}, 5000);
};

</script>

<h1 id = "hh1">JS10 Center</h1>
<h2 id = "hh2"></h2>
<h3 id = "hh3"></h3>
<h3><a id = "daum" href="#">Daum</a></h3>
```
- `onclick`은 클릭할때 발동하도록하는 것
- 하이퍼링크를 쓰는 `<a href>`와 비슷

### day04 - jq01
```javascript
<script>
$(document).ready(function(){
	$('.center>h1').css('color','red');
	$('.center>h2').text('REPLACE');
	$('.center>h2').css({'color':'red','background':'black'});
	$('.center>h3').click(function(){
		location.href='http://www.naver.com';
	});
});
//$라는건 여기서부터 jq라는 걸 나타내는 것
//문서가 준비되면 함수를 실행해라
//여러개를 실행하려하면 제이슨을 사용하여 표현
</script>

<div class="center">
	<h1>JQ01 Center</h1>
	<h2>Header2</h2>
	<h3>Header3</h3>
</div>
```
- JQuery 기초
- `$(document).ready(function(){});`안에서 이루어짐
- `{}`안에서 실행하면됨
- `$`로 시작함

### day04 - jq02
```javascript
<style>
	#cust_table{		
		width:300px;
		border:2px solid red;
	}
	.thead{
		color:red;
		background:black;
	}
</style>
<script>
	$(document).ready(function(){
		$('#cust_table > thead > tr').addClass('thead');
		$('#cust_table > thead > tr').click(function(){
			$('#cust_table > tbody').append('<tr><td>id01</td><td>pwd01</td><td>james</td></tr>');
		});
		$('#cust_table > tbody > tr').hover(function(){
			$('#cust_table > tbody > tr').addClass('thead');
		//'#cust_table > tbody > tr'를 반복할 필요 없이 this를 사용할 수 있다
		}, function(){
			$('#cust_table > tbody > tr').removeClass('thead');
		});
		//내 커서가 가는 곳에 앞함수, 아니면 뒷함수 발동
		$('#cust_table > tbody > tr:eq(1)').addClass('thead');
		/* $('#cust_table > tbody > tr').eq(1).addClass('thead'); */
		//바로 위랑 같은말
		// thead에 적용된 css클래스를 jq의 주어에 적용한다
		/* $('#cust_table > tbody > tr:not(eq(1))').addClass('thead'); */
		// eq1빼고 전부다 라는 조건
		
		$('#fin').click(function(){
			$('#cust_table').slideDown();
		});
		$('#fout').click(function(){
			$('#cust_table').slideUp();
		});
	});
</script>

<h1>JQ02 Center</h1>
<button id="fin">FadeIN</button>
<button id="fout">FadeOUT</button>
<!-- 12. fadein fadeout과 자매품 slideDown slideUp -->
<table id="cust_table">
	<thead>
		<tr><th>ID</th><th>PWD</th><th>NAME</th></tr>
	</thead>
	<tbody>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		
	</tbody>
</table>
```
- 테이블을 바꿀수도 있다

### day04 - jq03
```javascript
<script>
	$(document).ready(function(){
		var str = $('.center > h1').text();
		//1. h1의 텍스트를 가져온다
		$('.center > h1').text('LOGIN');
		//2. h1에 텍스트를 넣는다. 그러면 헤드h1은 LOGIN으로 변경
		/* $('.center > h1').html('<a href="#">LOGIN</a>'); */
		// 3. html도 가능
		
		$('#login_form > input[name="id"]').keyup(function(){
			$('#login_form > #id_span').text('');
		});
		//6. '#login_form > input[name="id"]' 이건 form
		// form에 keyup이라는 이벤트 발생하게되면 함수발동
		// span 영역에 '' 을 넣는다
		$('#login_form > input[name="id"]').blur(function(){
			var id = $(this).val();
			if(id.length < 4){
				$('#login_form > #id_span').text('ID는 4자리 이상입력');
				$(this).focus();
			}
		});
		// 7.떠났을때 이벤트 발생한다. 아이디 길이가 짧으면 다시입력하라고 하려함
		// 여기서 this는 #login_form > input[name="id"]
		// 포커스는 커서가 조건을 갖추면 못움직이도록
		
		
		$('#login_form > input[name="pwd"]').keyup(function(){
			$('#login_form > #pwd_span').text('');
		});
		// 위랑 똑같이
		
		$('#login_bt').click(function(){
			//4. 서밋 버튼을 눌렀을때를 제어할 수 있음
			var id = $('#login_form > input[name="id"]').val();
			var pwd = $('#login_form > input[name="pwd"]').val();
			if(id == ''){
				$('#login_form > #id_span').text('ID는 필수항목 입니다.');
				return;
			}
			if(pwd == ''){
				$('#login_form > #pwd_span').text('PWD는 필수항목 입니다.');
				return;
			}
						
			//5. input이 두개니 css작업에서 땡겨오는거처럼 []를 사용해줌
			//val이라는게 가져올때나 세팅할때나 다씀
			$('#login_form').attr({'action':'/loginimpl','method':'post'});
			// 8. 입력받은 데이터를 서버에 저장하려고 폼에다가 액션과 메소드를 설정해야하는데 여기서도 설정이 가능
			// 원래는 아래에서 폼 뒤에 액션, 메소드 어트리뷰트를 써야함
			$('#login_form').submit();
			// 9. 이제 버튼을 누르면 서버로 감
			
		});
	});
</script>

<div class="center">

<h1>JQ03 Center</h1>

<!-- 로그인기능 구현 -->

<form id="login_form">
	ID<input type="text" name="id"><span id="id_span"></span><br>
	PWD<input type="password" name="pwd"><span id="pwd_span"></span><br>
	<!-- <input type="submit" value="LOGIN"> -->
</form>
	<button id = "login_bt">LOGIN</button>
	<!-- 서밋 대신 버튼으로 함 -->
</div>
```
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
	
	@RequestMapping("/loginimpl")
	public String loginimpl(String id, String pwd, Model model) {
		if(id.equals("qqqq")&&pwd.equals("1111")) {
			model.addAttribute("center","loginok");
			model.addAttribute("loginid",id);
			//11.loginid에 입력받은id를 보낼거다
		}else {
			model.addAttribute("center","loginfail");
		}
		return "main";
	}
	// 10.받아들이는 객체는 각각의 id값을 입력
	// 여기에서 로그인 처리하는 로직을 넣어야함
	// 지금은 가상의 로그인 처리를 할 예정
}
```
- 메인컨트롤러도 바꿈
- 로그인기능을 구현
- 로그인 버튼을 누르면 메인컨트롤러의 `loginimpl`이 발동함
- `loginimpl`에 담긴 아이디와 비번을 입력받은 값과 비교함
- 같으면 `loginok` 다르면 `loginfail`

### day04 - jq04
```javascript
<style>
	#content{
		width:500px;
		border:2px solid red;
	}
</style>
<script>
	$(document).ready(function(){
		var cnt = 0;
		// 버튼을 누르는 횟수까지 확인할 수 있도록
		$('#append').click(function(){
			cnt++;
			$('#content').append('<h1>**append'+cnt+'</h1>');
		});
		// 3. 버튼들 기능 만들기
		$('#prepend').click(function(){
			cnt++;
			$('#content').prepend('<h1>**prepend'+cnt+'</h1>');
		});
		$('#after').click(function(){
			cnt++;
			$('#content').after('<h1>**after'+cnt+'</h1>');
		});
		$('#before').click(function(){
			cnt++;
			$('#content').before('<h1>**before'+cnt+'</h1>');
		});
		$('#remove').click(function(){
			$('#content').remove();
			// 빨간칸 자체가 사라짐
		});
		$('#empty').click(function(){
			$('#content').empty();
			// 빨간칸 내부에 데이터만 사라짐
		});
		// 2. 각 버튼들이 클릭하면 함수 발동, $('#empty').click(function(){}); 이런식의 구조로 시작
	});
</script>


<h1>JQ04 Center</h1>
<button id="append">APPEND</button>
<button id="prepend">PREPEND</button>
<button id="after">AFTER</button>
<button id="before">BEFORE</button>
<button id="remove">REMOVE</button>
<button id="empty">EMPTY</button>
<!-- 1. 각 버튼들 생성 -->
<div id = "content"></div>
```
- 각 버튼들의 기능을 구현함

### day04 - jq05
```javascript
<script>
function calc(a){
	if(typeof(a) == 'string'){
		if(a == '='){
			var num = $('input[name="result"]').val();
			var result = eval(num);
			$('input[name="result"]').val(result);
			return ;
			//eval을 이용해서 문자안이 계산가능하면 계산
		}
		var num = $('input[name="result"]').val();
		$('input[name="result"]').val(num+a);
	}else if(typeof(a) == 'number'){
		var num = $('input[name="result"]').val();
		$('input[name="result"]').val(num+a);
		//이렇게 하면 자리수가 늘어난다. 왜냐면 문자+숫자가 되버려서 문자가되버림
		//스트링까지 이렇게 해주면 수식을 보여줌
	};
	// typeof()로 일단 숫자인지 문자인지 판별
	// 스트링일때 이름이 result인 애한테 a값을 넣어준다
	
};
</script>

<h1>JQ05 Center</h1>
<input type="text" name="result" readonly="readonly"><br>
<!-- 원래 인풋은 폼안에 있으며 데이터를 전송시키는 역할 -->
<!-- 우리는 계산기를 한번 만들어볼 예정 -->
<!-- 이쁘게 만드려면 테이블로 만들어야함 -->
<!-- readonly는 읽기만 가능하도록 입력불가 -->
<button onclick="calc(1)">1</button>
<button onclick="calc(2)">2</button>
<button onclick="calc(3)">3</button>
<button onclick="calc('+')">+</button>
<button onclick="calc('=')">=</button>
<!-- 계산기니까 onclick을 써서 id를 부여안시킨다 -->
```
- 계산기를 구현하는 예제
- jq06에서 구현할 예정

### day04 - jq06
```javascript
<script>
function calc(a){
	if(typeof(a) == 'string'){
		if(a == '='){
			var num = $('input[name="result"]').val();
			var result = eval(num);
			$('input[name="result"]').val(result);
			return ;
		}
		if(a == 'c'){
			var result = '';
			$('input[name="result"]').val(result);
			return ;
		}
		var num = $('input[name="result"]').val();
		$('input[name="result"]').val(num+a);
	}else if(typeof(a) == 'number'){
		var num = $('input[name="result"]').val();
		$('input[name="result"]').val(num+a);
	};
};

</script>

<h1>스마트폰 계산기 구현하기</h1>
<!-- 버튼순서만 구현했는데 기능은 어떻게할까 -->
<!-- % / * - + 등 사칙연산하는 애들은 디스플레이가 비어있을때 못들어가게 하고싶다 -->
<!-- 중복기호 못쓰게 -->
<!-- indexof로 '='-1 자리 값이 스트링이면 오류가나도록 만들수있지않을까 -->
<!-- 반대로 indexof로 0번값이 스트링이면 ''이 되도록하면 되지않을까 -->
<!-- 수식이 이어지는걸 보고싶고 = 을 눌렀을때 결과값이 나오도록 하고싶다 구현완료-->
<!-- c를 누르면 초기화 하고싶다 구현완료-->
<table>
	<thead>
		<tr><th><input type="text" name="result" readonly="readonly"></th></tr>
	</thead>
	<tbody>
		<tr><td>
		<button onclick="calc('c')">C</button>
		<button onclick="calc('()')">()</button>
		<button onclick="calc('%')">%</button>
		<button onclick="calc('/')">/</button>
		</td></tr>
		<tr><td>
		<button onclick="calc(7)">7</button>
		<button onclick="calc(8)">8</button>
		<button onclick="calc(9)">9</button>
		<button onclick="calc('*')">X</button>
		</td></tr>
		<tr><td>
		<button onclick="calc(4)">4</button>
		<button onclick="calc(5)">5</button>
		<button onclick="calc(6)">6</button>
		<button onclick="calc('-')">-</button>
		</td></tr>
		<tr><td>
		<button onclick="calc(1)">1</button>
		<button onclick="calc(2)">2</button>
		<button onclick="calc(3)">3</button>
		<button onclick="calc('+')">+</button>
		</td></tr>
		<tr><td>
		<button onclick="calc('+/-')">+/-</button>
		<button onclick="calc(0)">0</button>
		<button onclick="calc('.')">.</button>
		<button onclick="calc('=')">=</button>
		</td></tr>
	</tbody>
</table>
```
- 1~9와 사칙연산, = , c 등을 버튼으로 구현
- 기능적인건 만족스럽게 구현하지 못함

## js+jq+ajax
### day04를 이용한 예제
1. 로그인 구현
	- (login.html)
		- 부트스트랩으로 먼저 형식을 가져옴
		- 서밋 대신에 일반버튼으로 대체함
		- jq로 버튼구현
		- jq의 시작은 $(document).ready(function(){});
		- $( )는 주어
		- 주어는 ' '안에 들어가며 id값은 #을 붙여줌
		- id값의 내부를 부를땐 > 로 하위값 호출
		- jq에서는 익명클래스를 사용해서 함수안에 함수넣고
		- 수틀리면 밖으로 빼서 또 만듬
		- 버튼을 클릭했을때 내가 입력한 id,pwd값이 전송되도록 해야함
		- 따라서 login_form에 속성을 부여해줘야함
		- $('#login_form').attr({  'action':'내가실행하려는 주소'  ,  'method':'데이터를 넘기는 방법' });
		- 그리고 나서 마지막에 $('#login_form').submit( );으로 부여된 속성값을 가진 데이터를 넘겨버림
		- (MainController.java)
		- loginimpl을 구현해야함
		- 객체에 id, pwd, model, session을 줌
		- 세션은 상황을 나누는목적
		- 가령 로그인 하기 전엔 우상단에 로그인+회원가입
		- 로그인 후에는 id+로그아웃 으로 변하게함
		- 로그인 기능을 구현해야하니 현재는 임의데이터id,pwd를 직업만들고
		- if+.equals로 이값과 입력받은 값이 같은지 비교
		- 같으면 session.setAttribute("loginid",id);로 세션 내부에 loginid라는 값에 참값인 id를 저장
		- model.addAttribute("center","loginok");로 센터에 loginok.html을 실행
		- (loginok.html)
		- 여기서는 타임리프로 문자를 호출하여 세션에 있는 id값을 불러내려함
		- <h2 th:text=${session.loginid}+ ' 님 환영합니다.'"></h2>
		- 만약 같지 않으면 loginfail로 전에 했던거로 바로적용
		- (main.html)
		- login ul에 가서 타임리프속성 붙여준다
		- th:if="${session.loginid == null}"는 지금 로그인값이 없다면
		- 우리가 설정했던 우상단에 로그인과 회원가입을 넣는다
		- 또다른 ul을 만들어서 반대상황을 줘서 id+로그아웃을 만든다
		- th:unless="${session.loginid == null}"
		- `<li><a href="#" th:text="${session.loginid}"></a></li>`
		- `<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>`
		- 아이디부분도 누를수 있게 하여서 개인정보 변경이나 뭐 눌러서 이것저것 바꿀수 있게 냅둠
	번외. 로그아웃 구현
		- (MainController.java)
		- 세션이 널값이 아니면 세션을 무효화 해버리면 로그아웃이 되버린다
		- 기본 클래스에 매핑을 걸어주고
		- 객체에 세션을 넣어준다
		- if로 세션이 널값이 아닐때 세션이 무효화되도록 session.invalidate( );를 넣고 리턴메인

![](/image/HTML,CSS/2022-09-16-00-03-34.png)
![](/image/HTML,CSS/2022-09-16-00-04-14.png)



2. 회원가입 구현
	- (register.html)
		- 폼을 또하나 땡겨오고 폼 id를 register_form으로 설정
		- id,pwd,pwd2,age,birth,hobby,gender 만듬
		- 회원가입 버튼도 하나 만들기
		- 버튼을 클릭했을때의 함수 구현하기
		- 마찬가지로 $(document).ready(function( ){ }); 시작
		- 회원가입폼 > 버튼 에 클릭함수 넣고
		- 회원가입폼에 속성을  부여해서 속성을 부여한 값이 registerimpl로 가도록 만듬, 전송방식은 post
		- 속성 부여후엔 서밋으로 보내버림
		- (MainController.java)
		- 기본 클래스에 매핑을 걸어주고
		- 객체를 넣어줄라는데 너무 길다
		- 따라서 CustVO라는 클래스를 따로 만들어줌
		- CustVO는 회원가입할때 우리가 입력하는 변수들을 필드선언+기본생성자+생성자+게터세터로 만듬
		- 만들고 난 후 다시 모델과 아까만든 CustVO속성의 객체하나까지 객체에 넣어줌
		- 그리고 모델에 속성부여로 센터에는 registerok.html을 rid부분엔 cust에서 따온 id를 넣는다
		- (registerok.html)
		- 타임리프로 rid를 땡겨와서 ~님 환영합니다 를 구현
		- 다시 (register.html)로 와서 세부조건들 설정
		- 비번일치 이벤트 만들기
		- pwd2에 키업함수를 걸어서 변수 pwd, pwd2가 일치하는지 안하는지 판별
		- $('#pwd2').keyup(function(){ });로 시작
		- var pwd = $('#pwd').val(); 로 input으로 받은 pwd에 값을줘서 변수 pwd에 담음
		- pwd2도 마찬가지 방법사용
		- if(pwd == pwd2)로 참이면 pwd2에 줬던 span에 Correct 입력 $('#pspan').text('Correct');
		- 아닐 경우에 $('#pspan').text('Incorrect'); 입력
		- 이번엔 아이디 중복을 확인하려함
		- 이번에도 데이터를 끌어오지 못해서 임의로 정해진 데이터를 넣고 비교
		- $('#id).keyup(fucntion( ){ })
		- 함수 내부에 변수 설정 var id = $(this).val();
		- 여기서 ajax를 발동시켜서 id의span에 가능 불가능 표시하려함
		- $.ajax({ });로 발동
		- 내부에 제이슨으로 표현
		- { url : '/checkid', data : {'cid':id} , success : function( ){ } }
		- (AController.java)
		- 여기서는 클래스 매핑이 아닌 퍼블릭 오브젝트 맵핑을 하여 객체 cid의 true, false를 가리고자함
		- 또한 이곳에 기본 클래스는 html을 요청할게 아니고 결과값만 받으려는거기 때문에 restcontroller로 받는다
		- checkid를 맵핑하고 오브젝트 클래스를 만들어주고 스트링 cid객체를 만들어 줌
		- 결과값에 쓰레기값 들어가지않도록 "";을 주고
		- if로 우리가 정한 아이디들을 equals로 줌 t , f로 표현
		- (register.html)
		- 다시 돌아와서 success 함수 내부에 result에 대한 t, f값으로 id의 span값에 텍스트로 가능 불가능을 띄워준다

![](/image/HTML,CSS/2022-09-16-00-05-02.png)
![](/image/HTML,CSS/2022-09-16-00-05-53.png)
![](/image/HTML,CSS/2022-09-16-00-06-36.png)

3. 화면에 시간띄우기
	- 메인 센터에 서버 시간을 띄우려함
		- (maincenter.html)
		- 제목외에 부제목으로 id = "server_time"이라는 것을 하나 만듬
		- 일반적인 jq로 시작
		- getdata함수 하나를 만듬
		- ajax를 발동 url : '/gettime', success : function( ){ }
		- (AController)
		- 이것도 오브젝트 타입으로 gettime클래스 만들어주고
		- Date d = new Date( )로 객체 생성
		- 리턴은 d를 문자로 표현해야하니 toString으로
		- 다시 돌아오면 함수에 result값을 넣고 디스플레이 함수를 돌려준다
		- 디스플레이 함수를 따로 빼서 만들어줌
		- 그냥 디스플레이에 데이터가 입력되면 result에 데이터값이 문자로 입력됨 -->근데 이게 구현이 안됨
![](/image/HTML,CSS/2022-09-16-00-08-56.png)


4. 실검 구현하기
	- (ajax_center.html)
		- 버튼을 누르면 제이슨에 저장된 것들이 나옴
		- 버튼과 결과값이 나올 곳을 생성한다
		- 일반적인 jq로 시작하고 추후에 인터벌을 줘서 일정 시간마다 버튼이 알아서 눌리게함
		- 스타일로 결과값 칸이 잘 보이도록 표시
		- getdata함수에 ajax발동 url은 getdata , 함수는 data를 받아 data를 display함수에 입력
		- (AController.java)
		- 오브젝트 속성의 getdata클래스 생성
		- 제이슨은 구성이 배열과 같기때문에 제이슨 어레이 객체를 생성
		- 제이슨 오브젝트는 K,V같은 속성이므로 맵과 비슷함. 그래서 우리가 정해놓은 데이터값들을 제이슨오브젝트에 담아야하니 얘도 객체생성
		- jo를 put으로 하나씩 담음. 모든 데이터가 담을때까지
		- 그리고 이 jo들을 ja배열에 담음
		- (ajax_center.html)
		- 다시 돌아오면 data = ja 이므로 이걸 디스플레이 해주면된다
		- 초기 결과값에 빈칸을 주고
		- 배열이므로 for문을 돌려야함
		- 근데 jq에서 for문은 다름
		- $(data).each(function(index,item){ });
		- 주어 배열의 각각의 키와 벨류를 함수 돌린다
		- result 세개를 주는데 이 중 두개는 다음줄로 넘기기 위한것
		- 가운데 result에 벨류값 세개를 +로 입력
		- 마지막엔 주어 결과창에 html로 result를 띄워준다
![](/image/HTML,CSS/2022-09-16-00-09-38.png)

### day04 자료들
> 계속 덮어씌우며 사용하도록
#### 1. 컨트롤러
##### AController
```java
import java.util.Date;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//ajax2. ajax를 따로 작동시킬 컨트롤러를 만듬

@RestController
public class AController {
	//그냥 컨트롤러는 html을 요청하는건데
	//우리는 그냥 결과값만 봐야하기때문에
	//restController를 사용
	@RequestMapping("/gettime")
	public Object gettime() {
		Date d = new Date();
		return "Server Time : "+d.toString();
	}
	
	@RequestMapping("/getmarker")
	public Object getmarker() {
		JSONArray ja = new JSONArray();
		JSONObject jo1 = new JSONObject();
		jo1.put("title", "국밥집");
		jo1.put("target", "http://www.naver.com");
		jo1.put("lat", 33.2625165);
		jo1.put("lng", 126.5553960);
		ja.add(jo1);
		
		JSONObject jo2 = new JSONObject();
		jo1.put("title", "중식집");
		jo1.put("target", "http://www.daum.net");
		jo1.put("lat", 33.2621120);
		jo1.put("lng", 126.5683600);
		ja.add(jo2);
		
		JSONObject jo3 = new JSONObject();
		jo1.put("title", "양식집");
		jo1.put("target", "http://www.google.com");
		jo1.put("lat", 33.2632010);
		jo1.put("lng", 126.5513750);
		ja.add(jo3);
		
		return ja;
	}
	
	@RequestMapping("/ch3")
	public Object ch3(String area) {
		//System.out.println(area); 확인용
		//{title:'Seoul',data:[[],[]]}
		JSONObject jo = new JSONObject();
		if(area.equals("s")) {
			jo.put("title", "Seoul");
			JSONArray ja = new JSONArray();
			for(var i=1; i<=5; i++) {
				JSONArray jaa = new JSONArray();
				jaa.add((i*10)+"대");
				jaa.add(20);
				ja.add(jaa);
			}
			
			jo.put("data", ja);
		}else if(area.equals("b")) {
			jo.put("title", "Busan");
			JSONArray ja = new JSONArray();
			for(var i=1; i<=5; i++) {
				JSONArray jaa = new JSONArray();
				jaa.add((i*10)+"대");
				jaa.add(20);
				ja.add(jaa);
			}
			
			jo.put("data", ja);
		}else if(area.equals("j")) {
			jo.put("title", "Jeju");
			JSONArray ja = new JSONArray();
			for(var i=1; i<=5; i++) {
				JSONArray jaa = new JSONArray();
				jaa.add((i*10)+"대");
				jaa.add(20);
				ja.add(jaa);
			}
			
			jo.put("data", ja);
		}
		return jo;
	}
	
	@RequestMapping("/getdata1")
	public Object getdata1() {
		// [{name:'',data:[]},{}]
		Random r = new Random();
		String str = "Seoul";
		
		JSONArray ja = new JSONArray();
		for(var i=1; i<=5; i++) {
			
			JSONObject jo = new JSONObject();
			jo.put("name", str+i);
			JSONArray jaa = new JSONArray();
			for(var j=1; j<=12; j++) {
				jaa.add(r.nextInt(10000)+1);
			}
			jo.put("data", jaa);
			ja.add(jo);
		}
		return ja;
	}
	
	@RequestMapping("/getdata2")
	public Object getdata2() {
		// [[],[],[]]
		Random r = new Random();
		JSONArray ja = new JSONArray();
		
		String str = "Korea";
		
		for(var i=1; i<=20; i++) {
			JSONArray jaa = new JSONArray();
			jaa.add(str+i);
			jaa.add(r.nextInt(100)+1);
			ja.add(jaa);
		}
		
		return ja;
	}
	
	@RequestMapping("/ch1")
	//13. /ch1만들기
	//14. 카테고리까지 하고싶다
	public Object ch1() {
		Random r = new Random();
		JSONArray ja_data = new JSONArray();
		//제이슨 어레이만 필요
		for(var i=1; i<=10; i++) {
			//12개 데이터니까 12번돌린다
			ja_data.add(r.nextInt(30000)+1);
		}
		JSONArray ja_cate = new JSONArray();
		ja_cate.add("한국");
		ja_cate.add("일본");
		ja_cate.add("중국");
		ja_cate.add("미국");
		ja_cate.add("싱가폴");
		ja_cate.add("미얀마");
		ja_cate.add("베트남");
		ja_cate.add("호주");
		ja_cate.add("태국");
		ja_cate.add("캄보디아");
		
		// 카테고리 데이터 제이슨 어레이
		
		JSONObject jo = new JSONObject();
		jo.put("cate", ja_cate);
		jo.put("data", ja_data);
		// 제이슨 오브젝트로 두개의 제이슨 어레이를 하나로
		return jo;
	}
	
	@RequestMapping("/getdata")
	public Object getdata() {
		Random r = new Random();
		
		JSONArray ja = new JSONArray();
		//DB에서 가져온 데이터를 제이슨으로 배열에 담음
		JSONObject jo1 = new JSONObject();
		int i1 = r.nextInt(10)+1;
	
		jo1.put("num", i1);
		jo1.put("title", "오징어게임");
		jo1.put("updown", "up");
		//이 제이슨 오브젝트가 데이터 한줄짜리
		//제이슨오브젝트는 해쉬맵 같은거라서 풋으로 데이터담음
		//원래는 for문으로 돌려야함
		int i2 = r.nextInt(20)+1;
		
		JSONObject jo2 = new JSONObject();
		jo2.put("num", i2);
		jo2.put("title", "태풍");
		jo2.put("updown", "down");
		
		int i3 = r.nextInt(20)+1;
		JSONObject jo3 = new JSONObject();
		jo3.put("num", i3);
		jo3.put("title", "러시아");
		jo3.put("updown", "up");
		
		int i4 = r.nextInt(20)+1;
		JSONObject jo4 = new JSONObject();
		jo4.put("num", i4);
		jo4.put("title", "우크라이나");
		jo4.put("updown", "up");
		
		int i5 = r.nextInt(20)+1;
		JSONObject jo5 = new JSONObject();
		jo5.put("num", i5);
		jo5.put("title", "전쟁");
		jo5.put("updown", "down");
		
		ja.add(jo1);
		ja.add(jo2);
		ja.add(jo3);
		ja.add(jo4);
		ja.add(jo5);
		//제이슨 어레이에 담기
		return ja;
	}
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {//cid로 id값을 받고
		String result = "";
		if(cid.equals("aaaa") || cid.equals("bbbb") || cid.equals("cccc")) {
			//아직 우리가 데이터베이스랑 연결을 안했기때문에 임의값
			result = "f";
		}else {
			result = "t";
		}
		return result;
	}

}
```
##### AJAXController
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AJAXController {
	
	@RequestMapping("")
	public String ajax(Model model) {
		model.addAttribute("center","ajax/ajax_center");
		model.addAttribute("left","ajax/ajax_left");
		return "main";
	}
	
	@RequestMapping("/ajax01")
	public String ajax01(Model model) {
		model.addAttribute("center","ajax//ajax01");
		model.addAttribute("left","ajax/ajax_left");
		return "main";
	}
	
	@RequestMapping("/ajax02")
	public String ajax02(Model model) {
		model.addAttribute("center","ajax/ajax02");
		model.addAttribute("left","ajax/ajax_left");
		return "main";
	}
	
	@RequestMapping("ajax03")
	public String ajax03(Model model) {
		model.addAttribute("center","ajax/ajax03");
		model.addAttribute("left","ajax/ajax_left");
		return "main";
	}
	
	@RequestMapping("ajax04")
	public String ajax04(Model model) {
		model.addAttribute("center","ajax/ajax04");
		model.addAttribute("left","ajax/ajax_left");
		return "main";
	}
	
	@RequestMapping("ajax05")
	public String ajax05(Model model) {
		model.addAttribute("center","ajax/ajax05");
		model.addAttribute("left","ajax/ajax_left");
		return "main";
	}
	
	@RequestMapping("ajax06")
	public String ajax06(Model model) {
		model.addAttribute("center","ajax/ajax06");
		model.addAttribute("left","ajax/ajax_left");
		return "main";
	}
	
	@RequestMapping("ajax07")
	public String ajax07(Model model) {
		model.addAttribute("center","ajax/ajax07");
		model.addAttribute("left","ajax/ajax_left");
		return "main";
	}

}
```
##### ChartController
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
	
	@RequestMapping("")
	public String chart(Model model) {
		model.addAttribute("center","chart/chart_center");
		model.addAttribute("left","chart/chart_left");
		return "main";
	}
	
	@RequestMapping("/chart01")
	public String chart01(Model model) {
		model.addAttribute("center","chart/chart01");
		model.addAttribute("left","chart/chart_left");
		return "main";
	}
	
	@RequestMapping("/chart02")
	public String chart02(Model model) {
		model.addAttribute("center","chart/chart02");
		model.addAttribute("left","chart/chart_left");
		return "main";
	}
	
	@RequestMapping("chart03")
	public String chart03(Model model) {
		model.addAttribute("center","chart/chart03");
		model.addAttribute("left","chart/chart_left");
		return "main";
	}

}
```
##### GeoController
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/geo")
public class GeoController {
	
	@RequestMapping("")
	public String geo(Model model) {
		model.addAttribute("center","geo/geo_center");
		model.addAttribute("left","geo/geo_left");
		return "main";
	}
	
	@RequestMapping("/geo01")
	public String geo01(Model model) {
		model.addAttribute("center","geo/geo01");
		model.addAttribute("left","geo/geo_left");
		return "main";
	}
	
	@RequestMapping("/geo02")
	public String geo02(Model model) {
		model.addAttribute("center","geo/geo02");
		model.addAttribute("left","geo/geo_left");
		return "main";
	}
	
	@RequestMapping("/geo03")
	public String geo03(Model model) {
		model.addAttribute("center","geo/geo03");
		model.addAttribute("left","geo/geo_left");
		return "main";
	}

}
```
##### MainController
```java
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.vo.CustVO;

@Controller
public class MainController {
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center","login");
		return "main";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center","register");
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session !=null) {
			session.invalidate();
			//main.html에서 설정한 타임리프에서 설정한데로 실행
		}
		return "main";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(String id, String pwd, Model model,
			HttpSession session) {
		//System.out.println(id+" "+pwd); // 메인으로 들어오는지 체크, 실제로는 반드시 지워줘야함
		  if(id.equals("qqqq")&&pwd.equals("1111")) {
			  session.setAttribute("loginid", id);
			  //세션에다가 로그인성공한 사람 정보를 넣어둠
			  // 우리 목표는 우상단에 로그아웃을 만드는 것
			  // 로그 아웃 전까지 계속 남아있음
			  // 모델에다가 넣은건 지속적이지 않음
			  model.addAttribute("center","loginok"); 
			  
		  //11.loginid에 입력받은id를 보낼거다 
		  }else { 
			  model.addAttribute("center","loginfail");
		  }	 
		return "main";
	}
	// 10.받아들이는 객체는 각각의 id값을 입력
	// 여기에서 로그인 처리하는 로직을 넣어야함
	// 지금은 가상의 로그인 처리를 할 예정
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, CustVO cust) {
		System.out.println(cust);
		model.addAttribute("center","registerok");
		model.addAttribute("rid",cust.getId());
		return "main";
	}
	
}
```
##### JSController
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// js를 따로 묶는 폴더링작업
@Controller
@RequestMapping("/js")
public class JSController {
	
	@RequestMapping("")
	public String js(Model model) {
		model.addAttribute("center","js/js_center");
		model.addAttribute("left","js/js_left");
		return "main";

	}
	@RequestMapping("/js01")
	public String js01(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js01");
		return "main";
	}
	
	@RequestMapping("/js02")
	public String js02(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js02");
		return "main";
	}
	
	@RequestMapping("/js03")
	public String js03(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js03");
		return "main";
	}
	
	@RequestMapping("/js04")
	public String js04(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js04");
		return "main";
	}
	
	@RequestMapping("/js05")
	public String js05(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js05");
		return "main";
	}
	
	@RequestMapping("/js06")
	public String js06(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js06");
		return "main";
	}
	
	@RequestMapping("/js07")
	public String js07(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js07");
		return "main";
	}
	
	@RequestMapping("/js08")
	public String js08(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js08");
		return "main";
	}
	
	@RequestMapping("/js09")
	public String js09(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js09");
		return "main";
	}
	
	@RequestMapping("/js10")
	public String js10(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js10");
		return "main";
	}
	
	@RequestMapping("/js11")
	public String js11(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js11");
		return "main";
	}
	
	@RequestMapping("/js12")
	public String js12(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js12");
		return "main";
	}
	
	@RequestMapping("/js13")
	public String js13(Model model) {
		model.addAttribute("left","js/js_left");
		model.addAttribute("center","js/js13");
		return "main";
	}
}
```
##### JQController
```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jq")
public class JQController {
	
	@RequestMapping("")
	public String jq(Model model) {
		model.addAttribute("center","jq/jq_center");
		model.addAttribute("left","jq/jq_left");
		return "main";
	}
	
	@RequestMapping("/jq01")
	public String jq01(Model model) {
		model.addAttribute("center","jq/jq01");
		model.addAttribute("left","jq/jq_left");
		return "main";
	}
	
	@RequestMapping("/jq02")
	public String jq02(Model model) {
		model.addAttribute("center","jq/jq02");
		model.addAttribute("left","jq/jq_left");
		return "main";
	}
	
	@RequestMapping("/jq03")
	public String jq03(Model model) {
		model.addAttribute("center","jq/jq03");
		model.addAttribute("left","jq/jq_left");
		return "main";
	}
	
	@RequestMapping("/jq04")
	public String jq04(Model model) {
		model.addAttribute("center","jq/jq04");
		model.addAttribute("left","jq/jq_left");
		return "main";
	}
	
	@RequestMapping("/jq05")
	public String jq05(Model model) {
		model.addAttribute("center","jq/jq05");
		model.addAttribute("left","jq/jq_left");
		return "main";
	}
	
	@RequestMapping("/jq06")
	public String jq06(Model model) {
		model.addAttribute("center","jq/jq06");
		model.addAttribute("left","jq/jq_left");
		return "main";
	}
	
	@RequestMapping("/jq07")
	public String jq07(Model model) {
		model.addAttribute("center","jq/jq07");
		model.addAttribute("left","jq/jq_left");
		return "main";
	}
	
}
```
#### 2. VO
```java
public class CustVO {
	private String id;
	private String pwd;
	private int age;
	private String birth;
	private String[] hobby;
	private String gender;
	// 기본 생성자
	public CustVO() {
	}
	public CustVO(String id, String pwd, int age, String birth, String[] hobby, String gender) {
		this.id = id;
		this.pwd = pwd;
		this.age = age;
		this.birth = birth;
		this.hobby = hobby;
		this.gender = gender;
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
	
	// 게터 세터
	
}
```
#### 3. 템플릿 - ajax
```html
<style>
#result{
	width:500px;
	border:2px solid red; 
}
</style>

<script>
function display(data){
	var result = '';
	$(data).each(function(index,item){
		//alert(index+' '+item); 확인용
		result += '<h3>';
		result += item.num+' '+item.title+' '+item.updown;
		result += '<h3>';
	});
	//jq의 for문, data배열의 개수만큼 함수를 돌린다 라는 뜻
	$('#result').html(result);
	//텍스트는 테그와테그사이에 텍스트로들어가는거고
	//html은 테그와테그사이에 테그로감
};

function getdata(){
	$.ajax({
		url:'/getdata',
		success:function(data){
			//데이터를 서버로 보낼필요없고
			//바로 보여주면됨
			//alert(data);
			//먼저 얼럿으로 확인
			display(data);
		}
	});
};

$(document).ready(function(){
	$('#get_bt').click(function(){
		getdata();
	});
	setInterval(() => {
		getdata();
	}, 3000);
});
</script>

<h3>AJAX Center</h3>
<button id="get_bt">GET DATA</button>
<div id = "result"></div>
<!-- 버튼을 누르면 화면이 바뀐다 -->
```
```html
<p><a href="/ajax/ajax01">ajax01</a></p>
<p><a href="/ajax/ajax02">ajax02</a></p>
<p><a href="/ajax/ajax03">ajax03</a></p>
<p><a href="/ajax/ajax04">ajax04</a></p>
<p><a href="/ajax/ajax05">ajax05</a></p>
<p><a href="/ajax/ajax06">ajax06</a></p>
<p><a href="/ajax/ajax07">ajax07</a></p>
```
```html
<h1>AJAX01 Center</h1>
```

#### 4. 템플릿 - 차트
##### chart_center.html
```html
<h1>Chart Center</h1>
```
##### chart_left.html
```html
<p><a href="/chart/chart01">chart01</a></p>
<p><a href="/chart/chart02">chart02</a></p>
<p><a href="/chart/chart03">chart03</a></p>
```
##### chart01.html
```html
<style>
#container{
	width:500px;
	height:400px;
	border:2px solid red;
}
</style>
<script>
function display(data){
	//4. display함수 만들기
	//5. main.html에 차트 라이브러리 삽입하기
	//6. 차트 붙여넣기
	//10. 객체에 data 넣기
	Highcharts.chart('container', {
	    chart: {
	        type: 'column',
	        options3d: {
	            enabled: true,
	            alpha: 10,
	            beta: 25,
	            depth: 70
	        }
	    },
	    title: {
	        text: 'MyChart'
	    },
	    subtitle: {
	        text: 'Source: ' +
	            '<a href="https://www.ssb.no/en/statbank/table/08804/"' +
	            'target="_blank">Multi</a>'
	    },
	    plotOptions: {
	        column: {
	            depth: 25
	        }
	    },
	    xAxis: {
	        categories: data['cate'],//15. data라는 제이슨오브젝트에서 'cate'를 끄집어냄
	        labels: {
	            skew3d: true,
	            style: {
	                fontSize: '16px'
	            }
	        }
	    },
	    yAxis: {
	        title: {
	            text: 'NOK (million)',
	            margin: 20
	        }
	    },
	    tooltip: {
	        valueSuffix: ' MNOK'
	    },
	    series: [{
	        name: 'Total imports',
	        data : data['data']
	    }]
	});
};

function getdata(){
	//var data = [16076, 112688, 39452, 0, 94352,
        //30495, 21813, 95908, 11596, 53771, null, 8270];
      	//11. 이부분을 ajax로 구현하기
      	$.ajax({
      		url:'/ch1',
      		success:function(data){
      			display(data);
      		}//12. /ch1 만들기
      	})
      	//display(data);
      	//9. getdata로 임의 데이터를 담고 display로 보냄 
};

$(document).ready(function(){
	//2. jq기본세팅
	//display();
	//3. display함수로 출력
	
	$('#ch1').click(function(){
		//7. ch1버튼 클릭시 함수발동
		 getdata();
		//8. getdata 함수로
	});
});
</script>

<h1>chart01 Center</h1>
<button id = "ch1">Chart1</button>
<div id = "container"></div>
<!-- 1.버튼, div id설정 -->
<!-- 버튼을 누르면 div영역에 차트가 그려짐 -->
```
##### chart02.html
```html
<style>
.col-sm-6{
	width:400px;
	height:400px;
	border:2px solid red;
}
</style>
<script>
function display1(result){
	//5. 차트 삽입
	//7. display1에 result값 들어감
	Highcharts.chart('container1', {

	    title: {
	        text: 'U.S Solar Employment Growth by Job Category, 2010-2020'
	    },

	    subtitle: {
	        text: 'Source: <a href="https://irecusa.org/programs/solar-jobs-census/" target="_blank">IREC</a>'
	    },

	    yAxis: {
	        title: {
	            text: 'Number of Employees'
	        }
	    },

	    xAxis: {
	        accessibility: {
	            rangeDescription: 'Range: 2010 to 2020'
	        }
	    },

	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },

	    plotOptions: {
	        series: {
	            label: {
	                connectorAllowed: false
	            },
	            pointStart: 2010
	        }
	    },

	    series: result,

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    }

	});
};
function display2(result){
	Highcharts.chart('container2', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'World\'s largest cities per 2021'
	    },
	    subtitle: {
	        text: 'Source: <a href="https://worldpopulationreview.com/world-cities" target="_blank">World Population Review</a>'
	    },
	    xAxis: {
	        type: 'category',
	        labels: {
	            rotation: -45,
	            style: {
	                fontSize: '13px',
	                fontFamily: 'Verdana, sans-serif'
	            }
	        }
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: 'Population (millions)'
	        }
	    },
	    legend: {
	        enabled: false
	    },
	    tooltip: {
	        pointFormat: 'Population in 2021: <b>{point.y:.1f} millions</b>'
	    },
	    series: [{// 배열안의 배열
	        name: 'Population',
	        data: result,//9. 데이터 넣기
	        dataLabels: {
	            enabled: true,
	            rotation: -90,
	            color: '#FFFFFF',
	            align: 'right',
	            format: '{point.y:.1f}', // one decimal
	            y: 10, // 10 pixels down from the top
	            style: {
	                fontSize: '13px',
	                fontFamily: 'Verdana, sans-serif'
	            }
	        }
	    }]
	});
};

function getdata1(){
	//6. ajax 기본세팅
	$.ajax({
		url:'/getdata1',
		success:function(result){
			display1(result);
		}
	})
};
function getdata2(){
	$.ajax({
		url:'/getdata2',
		success:function(result){
			display2(result);
			//8. /getdata1, /getdata2 만들기
		}
	})
};
//4. getdata - display연결

$(document).ready(function(){
	//2. jq기본세팅
	getdata1();
	getdata2();
	//3. 각 차트에 들어갈 데이터를 가져온다
});
</script>
<h1>chart02 Center</h1>
<!-- 두개의 차트 동시에 그리기 -->

<div class="row">
  <div class="col-sm-6" id = "container1">.col-sm-6</div>
  <div class="col-sm-6" id = "container2">.col-sm-6</div>
</div>
<!-- 1. 화면 분할하기 -->
```
##### chart03
```html
<style>
#container{
	width:100%;
	height:300px;
	border:2px solid red;
}
</style>
<script>
function display(result){
	Highcharts.chart('container', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: 0,
	        plotShadow: false
	    },
	    title: {
	        text: result['title'],
	        align: 'center',
	        verticalAlign: 'middle',
	        y: 60
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    accessibility: {
	        point: {
	            valueSuffix: '%'
	        }
	    },
	    plotOptions: {
	        pie: {
	            dataLabels: {
	                enabled: true,
	                distance: -50,
	                style: {
	                    fontWeight: 'bold',
	                    color: 'white'
	                }
	            },
	            startAngle: -90,
	            endAngle: 90,
	            center: ['50%', '75%'],
	            size: '110%'
	        }
	    },
	    series: [{
	        type: 'pie',
	        name: 'Browser share',
	        innerSize: '50%',
	        data: result['data']
	    }]
	});

};

function getdata(value){
	$.ajax({
		url:'/ch3',
		data:{'area':value},
		success:function(result){
			//alert(result['title']);
			//alert(result['data']);
			display(result);
		}
	});
};

$(document).ready(function(){
	$('#sel1').change(function(){
		var value = $(this).val();
		//내 자신이 바뀌면 내 자신에서 변수를 가져와라
		//alert(value); //데이터 넘어가는거 확인됨
		getdata(value);
	});
});
</script>

<h1>chart03 Center</h1>
<!-- login과 register는 폼과 폼사이에 서버데이터 전송, ajax를 안씀 -->
<!-- 폼을 이용하지않고 데이터 전송, ajax사용-->
<div class="form-group">
  <label for="sel1">Select Area:</label>
  <select class="form-control" id="sel1">
    <option>Choice Area</option>
    <option value="s">Seoul</option>
    <option value="b">Busan</option>
    <option value="j">Jeju</option>
  </select>
</div>
<div id="container"></div>
```

#### 5. 템플릿 - 지도
```html
<h1>Geo Center</h1>
```
```html
<p><a href="/geo/geo01">geo01</a></p>
<p><a href="/geo/geo02">geo02</a></p>
<p><a href="/geo/geo03">geo03</a></p>
```
```html
<h1>geo01 Center</h1>
```

#### 6. 템플릿 - JQuery
```html
<h1>JQuery Center</h1>
```
```html
<p><a href="/jq/jq01">jq01</a></p>
<p><a href="/jq/jq02">jq02</a></p>
<p><a href="/jq/jq03">jq03</a></p>
<p><a href="/jq/jq04">jq04</a></p>
<p><a href="/jq/jq05">jq05</a></p>
<p><a href="/jq/jq06">jq06</a></p>
<p><a href="/jq/jq07">jq07</a></p>
```
```html
<script>
$(document).ready(function(){
	$('.center>h1').css('color','red');
	$('.center>h2').text('REPLACE');
	$('.center>h2').css({'color':'red','background':'black'});
	$('.center>h3').click(function(){
		location.href='http://www.naver.com';
	});
});
//$라는건 여기서부터 jq라는 걸 나타내는 것
//문서가 준비되면 함수를 실행해라
//여러개를 실행하려하면 제이슨을 사용하여 표현
</script>

<div class="center">
	<h1>JQ01 Center</h1>
	<h2>Header2</h2>
	<h3>Header3</h3>
</div>
```
```html
<style>
	#cust_table{		
		width:300px;
		border:2px solid red;
	}
	.thead{
		color:red;
		background:black;
	}
</style>
<script>
	$(document).ready(function(){
		$('#cust_table > thead > tr').addClass('thead');
		$('#cust_table > thead > tr').click(function(){
			$('#cust_table > tbody').append('<tr><td>id01</td><td>pwd01</td><td>james</td></tr>');
		});
		$('#cust_table > tbody > tr').hover(function(){
			$('#cust_table > tbody > tr').addClass('thead');
		//'#cust_table > tbody > tr'를 반복할 필요 없이 this를 사용할 수 있다
		}, function(){
			$('#cust_table > tbody > tr').removeClass('thead');
		});
		//내 커서가 가는 곳에 앞함수, 아니면 뒷함수 발동
		$('#cust_table > tbody > tr:eq(1)').addClass('thead');
		/* $('#cust_table > tbody > tr').eq(1).addClass('thead'); */
		//바로 위랑 같은말
		// thead에 적용된 css클래스를 jq의 주어에 적용한다
		/* $('#cust_table > tbody > tr:not(eq(1))').addClass('thead'); */
		// eq1빼고 전부다 라는 조건
		
		$('#fin').click(function(){
			$('#cust_table').slideDown();
		});
		$('#fout').click(function(){
			$('#cust_table').slideUp();
		});
	});
</script>

<h1>JQ02 Center</h1>
<button id="fin">FadeIN</button>
<button id="fout">FadeOUT</button>
<!-- 12. fadein fadeout과 자매품 slideDown slideUp -->
<table id="cust_table">
	<thead>
		<tr><th>ID</th><th>PWD</th><th>NAME</th></tr>
	</thead>
	<tbody>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		<tr><td>id01</td><td>pwd01</td><td>james</td></tr>
		
	</tbody>
</table>
```
```html
<script>
	$(document).ready(function(){
		var str = $('.center > h1').text();
		//1. h1의 텍스트를 가져온다
		$('.center > h1').text('LOGIN');
		//2. h1에 텍스트를 넣는다. 그러면 헤드h1은 LOGIN으로 변경
		/* $('.center > h1').html('<a href="#">LOGIN</a>'); */
		// 3. html도 가능
		
		$('#login_form > input[name="id"]').keyup(function(){
			$('#login_form > #id_span').text('');
		});
		//6. '#login_form > input[name="id"]' 이건 form
		// form에 keyup이라는 이벤트 발생하게되면 함수발동
		// span 영역에 '' 을 넣는다
		$('#login_form > input[name="id"]').blur(function(){
			var id = $(this).val();
			if(id.length < 4){
				$('#login_form > #id_span').text('ID는 4자리 이상입력');
				$(this).focus();
			}
		});
		// 7.떠났을때 이벤트 발생한다. 아이디 길이가 짧으면 다시입력하라고 하려함
		// 여기서 this는 #login_form > input[name="id"]
		// 포커스는 커서가 조건을 갖추면 못움직이도록
		
		
		$('#login_form > input[name="pwd"]').keyup(function(){
			$('#login_form > #pwd_span').text('');
		});
		// 위랑 똑같이
		
		$('#login_bt').click(function(){
			//4. 서밋 버튼을 눌렀을때를 제어할 수 있음
			var id = $('#login_form > input[name="id"]').val();
			var pwd = $('#login_form > input[name="pwd"]').val();
			if(id == ''){
				$('#login_form > #id_span').text('ID는 필수항목 입니다.');
				return;
			}
			if(pwd == ''){
				$('#login_form > #pwd_span').text('PWD는 필수항목 입니다.');
				return;
			}
						
			//5. input이 두개니 css작업에서 땡겨오는거처럼 []를 사용해줌
			//val이라는게 가져올때나 세팅할때나 다씀
			$('#login_form').attr({'action':'/loginimpl','method':'post'});
			// 8. 입력받은 데이터를 서버에 저장하려고 폼에다가 액션과 메소드를 설정해야하는데 여기서도 설정이 가능
			// 원래는 아래에서 폼 뒤에 액션, 메소드 어트리뷰트를 써야함
			$('#login_form').submit();
			// 9. 이제 버튼을 누르면 서버로 감
			
		});
	});
</script>

<div class="center">

<h1>JQ03 Center</h1>

<!-- 로그인기능 구현 -->

<form id="login_form">
	ID<input type="text" name="id"><span id="id_span"></span><br>
	PWD<input type="password" name="pwd"><span id="pwd_span"></span><br>
	<!-- <input type="submit" value="LOGIN"> -->
</form>
	<button id = "login_bt">LOGIN</button>
	<!-- 서밋 대신 버튼으로 함 -->
</div>
```
```html
<style>
	#content{
		width:500px;
		border:2px solid red;
	}
</style>
<script>
	$(document).ready(function(){
		var cnt = 0;
		// 버튼을 누르는 횟수까지 확인할 수 있도록
		$('#append').click(function(){
			cnt++;
			$('#content').append('<h1>**append'+cnt+'</h1>');
		});
		// 3. 버튼들 기능 만들기
		$('#prepend').click(function(){
			cnt++;
			$('#content').prepend('<h1>**prepend'+cnt+'</h1>');
		});
		$('#after').click(function(){
			cnt++;
			$('#content').after('<h1>**after'+cnt+'</h1>');
		});
		$('#before').click(function(){
			cnt++;
			$('#content').before('<h1>**before'+cnt+'</h1>');
		});
		$('#remove').click(function(){
			$('#content').remove();
			// 빨간칸 자체가 사라짐
		});
		$('#empty').click(function(){
			$('#content').empty();
			// 빨간칸 내부에 데이터만 사라짐
		});
		// 2. 각 버튼들이 클릭하면 함수 발동, $('#empty').click(function(){}); 이런식의 구조로 시작
	});
</script>


<h1>JQ04 Center</h1>
<button id="append">APPEND</button>
<button id="prepend">PREPEND</button>
<button id="after">AFTER</button>
<button id="before">BEFORE</button>
<button id="remove">REMOVE</button>
<button id="empty">EMPTY</button>
<!-- 1. 각 버튼들 생성 -->
<div id = "content"></div>
```
```html
<script>
function calc(a){
	if(typeof(a) == 'string'){
		if(a == '='){
			var num = $('input[name="result"]').val();
			var result = eval(num);
			$('input[name="result"]').val(result);
			return ;
			//eval을 이용해서 문자안이 계산가능하면 계산
		}
		var num = $('input[name="result"]').val();
		$('input[name="result"]').val(num+a);
	}else if(typeof(a) == 'number'){
		var num = $('input[name="result"]').val();
		$('input[name="result"]').val(num+a);
		//이렇게 하면 자리수가 늘어난다. 왜냐면 문자+숫자가 되버려서 문자가되버림
		//스트링까지 이렇게 해주면 수식을 보여줌
	};
	// typeof()로 일단 숫자인지 문자인지 판별
	// 스트링일때 이름이 result인 애한테 a값을 넣어준다
	
};
</script>

<h1>JQ05 Center</h1>
<input type="text" name="result" readonly="readonly"><br>
<!-- 원래 인풋은 폼안에 있으며 데이터를 전송시키는 역할 -->
<!-- 우리는 계산기를 한번 만들어볼 예정 -->
<!-- 이쁘게 만드려면 테이블로 만들어야함 -->
<!-- readonly는 읽기만 가능하도록 입력불가 -->
<button onclick="calc(1)">1</button>
<button onclick="calc(2)">2</button>
<button onclick="calc(3)">3</button>
<button onclick="calc('+')">+</button>
<button onclick="calc('=')">=</button>
<!-- 계산기니까 onclick을 써서 id를 부여안시킨다 -->
```
```html
<script>
function calc(a){
	if(typeof(a) == 'string'){
		if(a == '='){
			var num = $('input[name="result"]').val();
			var result = eval(num);
			$('input[name="result"]').val(result);
			return ;
		}
		if(a == 'c'){
			var result = '';
			$('input[name="result"]').val(result);
			return ;
		}
		var num = $('input[name="result"]').val();
		$('input[name="result"]').val(num+a);
	}else if(typeof(a) == 'number'){
		var num = $('input[name="result"]').val();
		$('input[name="result"]').val(num+a);
	};
};

</script>

<h1>스마트폰 계산기 구현하기</h1>
<!-- 버튼순서만 구현했는데 기능은 어떻게할까 -->
<!-- % / * - + 등 사칙연산하는 애들은 디스플레이가 비어있을때 못들어가게 하고싶다 -->
<!-- 중복기호 못쓰게 -->
<!-- indexof로 '='-1 자리 값이 스트링이면 오류가나도록 만들수있지않을까 -->
<!-- 반대로 indexof로 0번값이 스트링이면 ''이 되도록하면 되지않을까 -->
<!-- 수식이 이어지는걸 보고싶고 = 을 눌렀을때 결과값이 나오도록 하고싶다 구현완료-->
<!-- c를 누르면 초기화 하고싶다 구현완료-->
<table>
	<thead>
		<tr><th><input type="text" name="result" readonly="readonly"></th></tr>
	</thead>
	<tbody>
		<tr><td>
		<button onclick="calc('c')">C</button>
		<button onclick="calc('()')">()</button>
		<button onclick="calc('%')">%</button>
		<button onclick="calc('/')">/</button>
		</td></tr>
		<tr><td>
		<button onclick="calc(7)">7</button>
		<button onclick="calc(8)">8</button>
		<button onclick="calc(9)">9</button>
		<button onclick="calc('*')">X</button>
		</td></tr>
		<tr><td>
		<button onclick="calc(4)">4</button>
		<button onclick="calc(5)">5</button>
		<button onclick="calc(6)">6</button>
		<button onclick="calc('-')">-</button>
		</td></tr>
		<tr><td>
		<button onclick="calc(1)">1</button>
		<button onclick="calc(2)">2</button>
		<button onclick="calc(3)">3</button>
		<button onclick="calc('+')">+</button>
		</td></tr>
		<tr><td>
		<button onclick="calc('+/-')">+/-</button>
		<button onclick="calc(0)">0</button>
		<button onclick="calc('.')">.</button>
		<button onclick="calc('=')">=</button>
		</td></tr>
	</tbody>
</table>
```
```html
<style>
	.form-group{ 
		width : 300px;
	}
</style>

<script>
	$(document).ready(function(){
		$('#register_form > input[name="id"]').keyup(function(){
			$('register_form > #id_span').text('');
		});
		$('#register_form > input[name="id"]').blur(function(){
			var id = $(this).val();
			if(id.length <2){
				$('#register_form > #id_span').text('아이디 반드시 입력');
				$(this).focus();
			}
		});
		// 포커싱을 해서 아이디를 2글자 이상 입력전까지는 커서를 못벗어나게 하는 구문
		
		
		$('#register_form > input[name="pwd"]').keyup(function(){
			$('#register_form > #pwd_span').text('');
		});
		$('#register_form > input[name="pwd"]').blur(function(){
			var pwd = $(this).val();
			if(pwd.length <2){
				$('#register_form > #pwd_span').text('비번 반드시 입력');
				$(this).focus();
			}
		});
		
		
		$('#register_form > input[name="name"]').keyup(function(){
			$('#register_form > #name_span').text('');
		});
		$('#register_form > input[name="name"]').blur(function(){
			var name = $(this).val();
			if(name.length <1){
				$('#register_form > #name_span').text('이름 반드시 입력');
				$(this).focus();
			}
		});
		
		
		$('#register_bt').click(function(){
			var id = $('#register_form > input[name="id"]').val();
			var pwd = $('#register_form > input[name="pwd"]').val();
			var name = $('#register_form > input[name="name"]').val();
			var age = $('#register_form > input[name="age"]').val();
			var birth = $('#register_form > input[name="birth"]').val();
			if(id == ''){
				$('#register_form > #id_span').text('아이디는 필수항목');
				return;
			}
			if(pwd == ''){
				$('#register_form > #pwd_span').text('비번은 필수항목');
				return;
			}
			if(name == ''){
				$('#register_form > #name_span').text('이름은 필수항목');
				return;
			}
			if(age == ''){
				$('#register_form > #age_span').text('나이는 필수항목');
				return;
			}
			if(birth == ''){
				$('#register_form > #birth_span').text('생일은 필수항목');
				return;
			}
			
			
			$('#register_form').attr({'action':'registerimpl','method':'post'});
			$('#register_form').submit();
			
			
			
		});
	});
</script>

<div class="center">

<h1>회원가입</h1>


<form id="register_form">
	ID<input type="text" name="id"><span id="id_span"></span><br>
	PWD<input type="password" name="pwd"><span id="pwd_span"></span><br>
	NAME<input type="text" name="name"><span id="name_span"></span><br>
	AGE<input type="text" name="age"><span id="age_span"></span><br>
	BIRTH<input type="text" name="birth"><span id="birth_span"></span><br>
</form>
	<button id = "register_bt">회원가입</button>
</div>
```

#### 7. 템플릿 - JavaScript
```html
<h1>JavaScript Center</h1>
```
```html
<p><a href="/js/js01">js01</a></p>
<p><a href="/js/js02">js02</a></p>
<p><a href="/js/js03">js03</a></p>
<p><a href="/js/js04">js04</a></p>
<p><a href="/js/js05">js05</a></p>
<p><a href="/js/js06">js06</a></p>
<p><a href="/js/js07">js07</a></p>
<p><a href="/js/js08">js08</a></p>
<p><a href="/js/js09">js09</a></p>
<p><a href="/js/js10">js10</a></p>
<p><a href="/js/js11">js11</a></p>
<p><a href="/js/js12">js12</a></p>
<p><a href="/js/js13">js13</a></p>
```
```html
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
```html
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
```html
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
```html
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
```html
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
```
```html
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
```html
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
```html
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
```html
<script>
var data = 'alert("ALERT")';
eval(data);

var result = '10+10+10';
alert(eval(result));
// 일반 스트링을 실행시켜줄수있음, 따옴표들을 빼버리는

var result2 = 10/0;

if(isFinite(result2)){
	alert('Finite');
}else{
	alert('Infinite')
};
</script>

<h1>JS09 Center</h1>
```
```html
<script>
window.onload = function(){
	var hh1 = document.querySelector('#hh1');
	var hh2 = document.querySelector('#hh2');
	var hh3 = document.querySelector('#hh3');
	var daum = document.querySelector('#daum');
	
	daum.onclick = function(){
		var c = confirm('이동할거야?');
		if(c){
			location.href= 'http://www.daum.net';
		}else{
			return;
		}
	};
	
	hh1.onclick = function(){
		//클릭시 발동
		var txt = hh1.innerHTML;
		//hh1의 텍스트를 가져와라
		hh2.innerHTML = txt;
		//hh2의 텍스트를 뿌려라
		window.open('www.naver.com');
		//링크를 열어버림
	};
	hh2.onclick = function(){
		location.href='http://www.naver.com';
		//~로 이동시켜라
	};
	
	setInterval(function(){
		var date = new Date();
		var str = date.toString();
		hh2.innerHTML =str;
	}, 2000);
	// 2초에 한번씩 날짜를 스트링으로 변환한걸 뿌린다
	
	/* setTimeout(() => {
		location.href='/';
	}, 5000);
	// 5초뒤에 발동 */
	
	var si = setInterval(() => {
		var str = hh3.innerHTML;
		str += '*';
		hh3.innerHTML = str;
	}, 500);
	
	setTimeout(() => {
		clearInterval(si);
	}, 5000);
};

</script>

<h1 id = "hh1">JS10 Center</h1>
<h2 id = "hh2"></h2>
<h3 id = "hh3"></h3>
<h3><a id = "daum" href="#">Daum</a></h3>
```

#### 8. 템플릿 - 메인
```html
<script >
$(document).ready(function(){
	//1. 버튼에 이벤트 달기
	$('#login_form > button').click(function(){
		//alert('login'); 체크용
		$('#login_form').attr(
				{
					'action':'/loginimpl',
					'method':'post'
				}
				// 제이슨 형태로 들어감
		);
		$('#login_form').submit();
		// 버튼 누르면 서밋으로 날려버림
	})
});
</script>


<div class="container">
	<div class="col-sm-5">
	  <h2>Login</h2>
	  <form id="login_form">
	    <div class="form-group">
	      <label for="id">ID:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
	    </div>
	    <div class="form-group">
	      <label for="pwd">Password:</label>
	      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
	    </div>
	    <button class="btn btn-default">LOGIN</button>
	  </form>
	</div>
</div>
<!-- 기본 템플릿 수성 div - col sm 5 를 주고, 서밋을 지움 -->
```
```html
<h1>LOGIN FAIL</h1>
```
```html
<h1>LOGIN OK</h1>
<h2 th:text="${session.loginid}+ ' 님 환영합니다.'"></h2>
<!-- th 는 타임리프호출 명령어 -->
<!-- 세션안에 있는 loginid를 끄집어내라 -->
```
##### main.html
```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<!-- 타임리프 선언명령어 -->
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 반응형 웹 -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <!-- 차트 라이브러리 -->
  <script src="https://code.highcharts.com/highcharts.js"></script>
  <script src="https://code.highcharts.com/highcharts-3d.js"></script>
  <script src="https://code.highcharts.com/modules/exporting.js"></script>
  <script src="https://code.highcharts.com/modules/export-data.js"></script>
  <script src="https://code.highcharts.com/modules/accessibility.js"></script>
 <!-- 카카오맵 -->
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5391a7213215108e6b8dc6ea778851ac"></script>
 
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
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
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="/">HOME</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/js">JavaScript</a></li>
        <li><a href="/jq">JQuery</a></li>
        <li><a href="/ajax">AJAX</a></li>
        <li><a href="/chart">Chart</a></li>
        <li><a href="/geo">Geo</a></li>
      </ul>
      <ul th:if="${session.loginid == null}" class="nav navbar-nav navbar-right">
        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="/register"><span class="glyphicon glyphicon-new-window"></span> Register</a></li>
        <!-- 로그인 하기전까지 나와야하는 것 -->
      </ul>
      <ul th:unless="${session.loginid == null}" class="nav navbar-nav navbar-right">
      	<li><a href="#" th:text="${session.loginid}"></a></li>
        <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        <!-- 로그인 했을때 나와야하는 것 -->
        <!--  세션에 정보가 없으면 얘가나오고 th:if-->
        <!--  세선에 정보가 있으면 얘가 나오고 th:unless-->
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
  
    <div class="col-sm-2 sidenav" th:insert="${left} ? ${left} : mainleft">
			</div>

			<!-- Main Center Start -->
			<div class="col-sm-8 text-left"	th:insert="${center} ? ${center} : maincenter">
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
```html
<script>

//3. 디스플레이가 길어질거 같으니 따로 함수만듬
function display(data){
	$('#result').text(data);
};// 이게 뭐가틀린건지 모르겠다

//1. 문서준비를 하고 그 위에 우리가 사용할 함수를 먼저 만듬
function getdata(){
	$.ajax({
		url:'/gettime',
		success:function(result){
			display(result);
		},
		error:function(){
			//alert('error')//각각의 얼럿들은 확인용
			$('#result').text('Error...');
		}
	});//제이슨으로 표현
};

$(document).ready(function(){
	setInterval(() => {	
		getdata();
	}, 5000);
	//4. 5초 지나면 바뀌도록 하기위해 setInterval을 써줌
});
</script>

<h1>Main Center</h1>
<!-- 메인센터에 ajax 서버시간 나타내기 구현 -->
<h3 id = "result"></h3>
```
```html
<h1>REGISTER OK</h1>
<h2 th:text="${rid}+' 님 환영합니다.'"></h2>
<!-- impl에서 끄집어낸 rid를 여기서 사용 -->
```
```html
<h1>Main Left</h1>
```
```html
$(document).ready(function(){
	$('#register_form > button').click(function(){
		$('#register_form').attr({
			'action':'/registerimpl',
			'method':'post'
		});
		$('#register_form').submit();
		//3. 레지스터 버튼을 누르면 함수발동
	});
	
	$('#pwd2').keyup(function(){
		var pwd = $('#pwd').val();
		var pwd2 = $('#pwd2').val();
		if(pwd == pwd2){
			$('#pspan').text('Correct');
		}else{
			$('#pspan').text('Incorrect');
			
		}
		
	});
	//4. 비번일치 이벤트 만들기
	
	$('#id').keyup(function(){
		//ajax5. 키업을 할때마다 ajax로 서버에 가서 데이터를 비교 하려는게 목표= 중복확인
		var id = $(this).val();
		//변수를 설정하고
		$.ajax({
			url:'/checkid',
			data:{'cid':id},
			success:function(result){
				if(result == 't'){
					$('#ispan').text('Available');
				}else{
					$('#ispan').text('Not Available');
					
				}
					
			}
				
		});
		//ajax를 불러오고 id값을 서버로 보냄
	});
});
</script>

<div class="container">
	<div class="col-sm-5">
	  <h2>Register</h2>
	  <form id="register_form">
	    <div class="form-group">
	      <label for="id">ID:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
	      <span id="ispan"></span>
	    </div>
	    <div class="form-group">
	      <label for="pwd">Password:</label>
	      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
	    </div>
	    <div class="form-group">
	      <label for="pwd2">Password2:</label>
	      <input type="password" class="form-control" id="pwd2" placeholder="Enter password">
	      <span id="pspan"></span>
	    </div>
	    <!-- 1. 서버로 날아가는 비번은 1개면됨 2번의 name을 지워버림 -->
	    <div class="form-group">
	      <label for="age">AGE:</label>
	      <input type="number" class="form-control" id="age" placeholder="Enter Age" name="age">
	    </div>
	    <div class="form-group">
	      <label for="birth">birth:</label>
	      <input type="date" class="form-control" id="birth" placeholder="Enter Birth" name="birth">
	    </div>
	    <div class="form-group">
	    	<label>Hobby: </label>
	      	<label class="checkbox-inline"><input type="checkbox" name="hobby" value="h1">Hobby 1</label>
			<label class="checkbox-inline"><input type="checkbox" name="hobby" value="h2">Hobby 2</label>
			<label class="checkbox-inline"><input type="checkbox" name="hobby" value="h3">Hobby 3</label>
			<!-- 2. 얘들은 우리가 입력값이 아니기 때문에 value를 줘서 선택시 그 값을 전송해야하고 name도 세팅해서 서버로 보내야함-->
	    </div>
	    <div class="form-group">
	    	<label>Gender: </label>
	      	<label class="radio-inline"><input type="radio" name="gender">Female</label>
	      	<label class="radio-inline"><input type="radio" name="gender">Male</label>
	    </div>
	    <button class="btn btn-default">REGISTER</button>
	  </form>
	</div>
</div>
```