# void
- void는 return 값이 없다는 타입이다
```java
public interface A{
    void a();
}
//이렇게 인터페이스 하나 만들면
//다른클래스에서
@Override
public void a(){
    System.out.println("void");
}
//이렇게 받을수 있음
```
- 비교
```java
public interface A{
    String a();
}

@Override
public String a(){
    return = '문자타입';
}
```
- 처럼 리턴값 줘야함