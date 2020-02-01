# Week 4 추가 정리
## JAVA Enum
(https://limkydev.tistory.com/66 참고)

### Enum 개념
- 서로 관련 있는 상수들의 집합
- 기존, 상수를 정의할 때 final static string으로 쓰던 방식의 보완으로 자바1.5버전부터 'enum'등장
- 클래스처럼 보이게 하는 상수
- 서로 관련있는 상수들끼리 모아 상수들을 대표할 수 있는 이름으로 타입을 정의하는 것
- Enum 클래스 형을 기반으로 한 클래스형 선언 

### Enum 장점
1. 코드가 단순, 가독성이 좋음
2. 인스턴스 생성과 상속을 방지하여 상수값의 타입 안정성이 보장됨
3. enum class를 사용해 새로운 상수들의 타입을 정의하므로 그 외 타입을 가진 데이터값 여부를 컴파일 시 체크
4. 키워드 enum을 사용하기 때문에 구현의 의도가 '열거'임을 알 수 있음

### Enum 장점 예제
```JAVA
package week5.minj0i;

public class EnumExample {

	// 기존에 상수를 정의하는 방법
	public static final String MALE = "MALE";
	public static final String FEMALE = "FEMALE";

	public static void main(String[] args) {
		String gender1;

		gender1 = EnumExample.MALE;
		gender1 = EnumExample.FEMALE;

		// MALE, FEMALE이 아닌 상수 값이 할당 될 때
		// 컴파일시 에러가 나지 않음. -> 문제점 발생.
		gender1 = "boy";

		Gender gender2;
		gender2 = Gender.MALE;
		gender2 = Gender.FEMALE;

		// 컴파일 시 의도하지 않는 상수 값을 체크할 수 있음.
		// Enum으로 정의한 상수값만 할당 받을 수 있음.
		gender2 = "boy";
    }

}

//enum class를 이용해 Gender라는 새로운 상수들의 타입을 정의한다.
enum Gender {
	MALE, FEMALE;
}
```

gender2 = Gender.MALE; Gender2 = Gender.FEMALE에서 다음과 같은 내용이 생략됐다고 생각하면 됨
```JAVA
class Gender{
  public static final Gender MALE = new Gender();
  public static final Gender FEMALE = new Gender();
}
```

### Enum 사용법
1. Enum을 이용한 열거형 선언하기

EnumClass는 다른 클래스와 마찬가지로 별도의 java파일, 클래스 안, 클래스 밖 선언 가능

    1) 별도의 .java로 선언 (DevType.java)
```JAVA
package EnumExample;

public enum DevType {
	MOBILE, WEB, SERVER
}
```
    2) Class 내부에서 선언 (Developer.java)
```JAVA
package EnumExample;
package EnumExample;

public class Developer {
	public String name;
	public int career;
	public enum DevType {
		MOBILE, WEB, SERVER
	}
}
```
    3) Class 외부에서 선언 (Develoer.java)
```JAVA
package EnumExample;

public class Developer {
	
	public String name;
	public int career;
	public DevType type;
}

enum DevType {
	MOBILE, WEB, SERVER
}
```
[주의할 점]
- 열거형으로 선언된 순서에 따라 0 부터 인덱스 값을 가진다. 순차적으로 증가된다.
- enum 열거형으로 지정된 상수들은 모두 대문자로 선언
- 마지막에 열거형 변수들을 선언한 후 세미콜론(;)은 찍지 않는다.

### Enum Method
1. values() : 열거된 모든 원소를 배열에 담아 순서대로 리턴
```JAVA
package EnumExample;

public class Developer {

	public static void main(String[] args){	
		for(DevType type : DevType.values()){
			System.out.println(type);
		}
	}

}

enum DevType {
	MOBILE, WEB, SERVER
}
// 결과값
// MOBILE
// WEB
// SERVER
```

2. ordinal() : 원소에 열거된 순서를 정수 값으로 리턴
```JAVA
package EnumExample;

public class Developer {
	
	public String name;
	public int career;
	public DevType type;
	
	public static void main(String[] args){
		Developer developer = new Developer();
		
		developer.name = "홍길동";
		developer.career = 3;
		developer.type = DevType.MOBILE;
	
		System.out.println(developer.type.ordinal());
		
		DevType tp = developer.type.SERVER;
		
		System.out.println(tp.ordinal());	
		
	}
}

enum DevType {
	MOBILE, WEB, SERVER
}
/* 결과값
0
2
*/
```

3. valueOf() : 매개변수로 주어진 String과 열거형에서 일치하는 이름을 갖는 원소를 리턴

(일치하지 않는 경우 예외(IllegalArgumentException) 발생)
```JAVA
package EnumExample;

public class Developer {
	
	public String name;
	public int career;
	public DevType type;
	
	public static void main(String[] args){
    
    // 원하는 EnumType 가져오는 방법1 - enum형 객체를 만들어서 가져오기
    DevType tp1 = DevType.MOBILE; 
    // 2 - valueOf()메소드 이용
		DevType tp2 = DevType.valueOf("WEB");
		
		System.out.println(tp1);
		System.out.println(tp2);
		
	}

}

enum DevType {
	MOBILE, WEB, SERVER
}
/* 결과값
MOBILE
WEB
*/
```

### 열거형 상수를 다른 값과 연결하기
열거형 상수와 관련된 값을 생성자를 통해 연결시킬 경우 세미콜론(;)을 붙여야 함
```JAVA
package EnumExample;

public class Developer {
	
	public String name;
	public int career;
	public DevType type;
	
	public static void main(String[] args){
	
		for(DevType type : DevType.values()){
			System.out.println(type.getName());
		}
		
	}

}

enum DevType {

	//상수("연관시킬 문자") <- 이땐 줄 끝에 세미콜론 (;) 붙이기.
	MOBILE("안드로이드"), WEB("스프링"), SERVER("리눅스");
	
	final private String name;
	
	public String getName() {
		return name;
	}

	private DevType(String name){
		this.name = name;
	}
	
}
/* 결과값
안드로이드
스프링
리눅스
*/
```
