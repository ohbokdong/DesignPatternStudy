## 1. 호이스팅, Hoisting

### 호이스팅 개념

- 자바스크립트 함수는 실행되기 전에 함수 안에 필요한 변수값들을 모두 모아서 유효 범위의 최상단에 선언한다.
    - 자바스크립트 Parser가 함수 실행 전 해당 함수를 한 번 훑는다.
    - 함수 안에 존재하는 변수/함수선언에 대한 정보를 기억하고 있다가 실행시킨다.
    - 유효 범위: 함수 블록 {} 안에서 유효
- 즉, 함수 내에서 아래쪽에 존재하는 내용 중 필요한 값들을 끌어올리는 것이다.
    - 실제로 코드가 끌어올려지는 건 아니며, 자바스크립트 Parser 내부적으로 끌어올려서 처리하는 것이다.
    - 실제 메모리에서는 변화가 없다.

### 호이스팅의 대상

- **var 변수 선언**과 **함수선언문**에서만 호이스팅이 일어난다.
    - var 변수/함수의 선언만 위로 끌어 올려지며, 할당은 끌어 올려지지 않는다.
    - let/const 변수 선언과 함수표현식에서는 호이스팅이 발생하지 않는다.
```JAVASCRIPT
        console.log("hello");
        var myname = "HEEE"; // var 변수 
        let myname2 = "HEEE2"; // let 변수

        /** --- JS Parser 내부의 호이스팅(Hoisting)의 결과 - 위와 동일 --- */
         var myname; // [Hoisting] "선언"
         console.log("hello");
         myname = "HEEE"; // "할당"
         let myname2 = "HEEE2"; // [Hoisting] 발생 X
```
    - 함수선언문 vs 함수표현식
```JAVASCRIPT
  function foo() { // 함수선언문
            console.log("hello");
    }
  var foo2 = function() { // 함수표현식
            console.log("hello2");
    }
```
```JAVASCRIPT
  foo();
  foo2();
  
  function foo() { // 함수선언문
            console.log("hello");
  }
  var foo2 = function() { // 함수표현식
            console.log("hello2");
    }
```  
```JAVASCRIPT
    // Compile
    var foo2; // [Hoisting] 함수표현식의 변수값 "선언"
  
    function foo() { // [Hoisting] 함수선언문
            console.log("hello");
    }
  
    foo();
    foo2(); // ERROR!! 
  
    foo2 = function() { 
            console.log("hello2");
    }
```
## 2. 클로저

[클로저 개념]

클로저(closure)는 내부함수가 외부함수의 맥락(context)에 접근할 수 있는 것을 가르킨다.

외부함수의 실행이 끝나서 외부함수가 소멸된 이후에도 내부함수가 외부함수의 변수에 접근 할 수 있다. 이러한 메커니즘을 클로저라고 한다.

내부함수가 외부함수의 지역변수에 접근 할 수 있고, 외부함수는 외부함수의 지역변수를 사용하는 내부함수가 소멸될 때까지 소멸되지 않는다.
```JAVASCRIPT
  function closure(n) {
    return function() {
      return++n;
    }
  }
  var a = closure(10);
  document.write(a()+"<br>");
  document.write(a()+"<br>");
  
  //출력
  11
  12
```
## 3. 프로토타입, prototype
```JAVASCRIPT
  function Person() {
    this.eyes = 2;
    this.nose = 1;
  }
  var kim  = new Person();
  var park = new Person();
  console.log(kim.eyes);  // => 2
  console.log(kim.nose);  // => 1
  console.log(park.eyes); // => 2
  console.log(park.nose); // => 1
```
이렇게 쓰면 메모리에 eyes, nose가 두 개씩 할당됨
```JAVASCRIPT
    function Person() {}
    Person.prototype.eyes = 2;
    Person.prototype.nose = 1;
    var kim  = new Person();
    var park = new Person():
    console.log(kim.eyes); // => 2
    ...
```
Person.prototype이라는 빈 Object가 존재하고, Person함수로 생성된 객체 kim, park들은 Object에 들어있는 값을 모두 갖다 쓸 수 있음

- 동일한 메서드를 '생성자 함수'에 포함시키지 않고 외부에 만들어 놓은 뒤 '인스턴스'에서 필요할 때만 호출해서 사용하도록 함
```JAVA
    //프로토타입 형식
    객체명.prototype.메서드 = function() {
    	실행문;
    }
```
```HTML
    <!DOCTYPE HTML>
    <html lang="ko">
    <head>
    	<meta charset = "UTF-8">
    	<title>프로토타입</title>
    <script>
    	1. 생성자 함수 Circle
    	var Circle = function(c,d) {
    		this.color = c;
    		this.diameter = d;
    	}
    
    	2. 생성자 함수 Circle의 메서드를 프로토타입으로 정의
    	Circle.prototype.radius = function(n){
    		var r = n/2;
    		return r;
    	}
    
    	var green_circle = new Circle("green", 200);
    	document.write(green_circle.radius(200));
    </script>
    </head>
    <body>
    </body>
    </html>
    
    화면 결과 : 100
```
