# Week 6 보충 - JavaScript Object, Class

## 메소드(Method)

* 객체의 속성값으로 함수를 지정가능
  * **어떤 객체의 속성으로 접근해서 사용하는 함수를 메소드(method)라고 함**
  * 객체 리터럴 안에서 특별한 표기법을 사용하여 메소드를 정의할 수 있음

```javascript
const person = {
  greet: function() {
    return 'hello';
  }
};

person.greet(); // 'hello';
```

## this

* 다른 함수들과 달리 '메소드'란 이름을 사용하는 이유는 메소드가 다른 함수들과 다르게 특별히 취급됨
* `this` 키워드를 사용하면 메소드 호출 시에 해당 메소드를 갖고 있는 객체에 접근가능

```javascript
const person = {
  name: '오영근',
  age: 31,
  introduce() {
    // `this`를 사용해서 객체의 속성에 접근함
    return `안녕하세요, 제 이름은 ${this.name}입니다. 제 나이는 ${this.age}살 입니다.`
  },
  getOlder() {
    // `this`를 사용해서 객체의 속성을 갱신함
    this.age++;
  }
};

person.introduce(); // '안녕하세요, 제 이름은 오영근입니다. 제 나이는 31살 입니다.'
person.getOlder(); // undefined
person.introduce(); // '안녕하세요, 제 이름은 오영근입니다. 제 나이는 32살 입니다.'
```

* **method를 사용하면 데이터와 그 데이터와 관련된 동작을 객체라는 하나의 단위로 묶어서 다룰 수 있음**
  * 함수 대신 메소드를 사용하는 핵심적인 이유
* 주의할 점은 `function`키워드를 통해 정의된 함수 내부의 `this` 키워드가 실제로 무엇을 가리킬 것인가는 메소드가 어떻게 **정의**되는가에 의해 결정되는 것이 아니라 메소드가 어떻게 **사용**되는 가에 의해 결정됨

```javascript
function introduce() {
  return `안녕하세요, 제 이름은 ${this.name}입니다.`;
}

const person1 = {
  name: '오영근',
  introduce
};

const person2 = {
  name: '최충현',
  introduce
};

person1.introduce(); // 안녕하세요, 제 이름은 오영근입니다.
person2.introduce(); // 안녕하세요, 제 이름은 최충현입니다.
```

* 즉 어떤 객체의 메소드로 사용되느냐에 따라 메소드 내부의 `this`가 가리키는 객체가 달라질 수 있음

## 프로토타입(Prototype)

* 수 많은 객체가 공통으로 사용하는 속성과 메소드를 중복해서 저장하는 것은 저장공간을 낭비하는 일
* 아래와 같이 객체를 생성하면 모든 객체에 똑같은 `introduce`메소드가 저장되어 객체 1000개마다 별개의 함수가 생성됨

```javascript
// 사람을 나타내는 객체를 생성하는 팩토리 함수
function personFactory(name) {
  return {
    name,
    introduce: function() {
      return `안녕하세요, 제 이름은 ${this.name}입니다.`;
    }
  };
}

const people = [];

for (let i = 0; i < 1000; i++) {
  people.push(personFactory('오영근'))
}

people[0].introduce === people[1].introduce // false
```

* **JS에서는 객체간 공유되어야 하는 속성과 메소드를 프로토타입(prototype)이라는 기능을 이용해서 효율적으로 저장가능**
* 어떤 객체에 프로토타입을 지정하면 프로토타입의 속성을 해당 객체에서 **재사용**가능
* 가장 쉬운 방법은 `Object.crate`함수를 이용하는 것
  * 아래와 같이 프로토타입 기능을 이용해 한 객체에서 다른 객체의 기능을 가져와 사용하는 것을 **프로토타입 상속(Prototype Inheritance)**라고 함

```javascript
const personPrototype = {
  introduce: function() {
    return `안녕하세요, 제 이름은 ${this.name}입니다.`;
  }
};

const person1 = Object.create(personPrototype); // 새 객체를 생성하고 프로토타입을 지정함
person1.name = '오영근';

const person2 = Object.create(personPrototype);
person2.name = '최충현';

person1.introduce(); // 안녕하세요, 제 이름은 오영근입니다.
person2.introduce(); // 안녕하세요, 제 이름은 최충현입니다.

person1.introduce === person2.introduce; // true
```

### 프로토타입 읽고 쓰기

* `Object.getPrototypeOf` 함수와 `Object.setPrototypeOf`함수를 사용해서 현재 프로토타입을 읽을 수도 쓸 수도 있음
  * 객체가 생성된 후 프로토타입을 변경하는 작업은 굉장히 느리므로 `Object.setPrototypeOf`함수 사용은 피하는게 좋음

```javascript
const parent = {
  familyName: '윤'
};
const child = Object.create(parent);

Object.getPrototypeOf(child) === parent; // true

const newParent = {
  familyName: '신'
};
Object.setPrototypeOf(child, newParent);
Object.getPrototypeOf(child) === parent; // false
```

* 객체 리터럴을 통해 생성된 객체의 프로토타입에는 자동으로 `Object.prototype`이 지정됨

```java
const obj = {};
Object.getPrototypeOf(obj) === Object.prototype; // true
```

---

### 프로토타입 체인(Prototype Chain)

### 프로토 타입 체인의 끝

### 속성 가리기

### 프로토타입을 간접적으로 변경하는 것은 불가능

---

## 생성자(Constructor)

* 객체 생성하기 위한 방법들

```javascript
// 객체 리터럴 사용하는 방법
var a = {};

// Object.create 함수를 사용하는 방법
var b = Object.create({});

// new 키워드를 이용하는 방법
var c = new Object();
```

### 생성자 정의

### 인스턴스

### 생성자와 프로토타입

### constructor


### 펙토리 함수의 재정의

* 생성자를 이용한 personFactory 함수를 재작성한 결과

```javascript
// 사람을 나타내는 객체를 생성하는 팩토리 함수
function Person(name) {
  this.name = name;
}
Person.prototype.introduce = function() {
  return `안녕하세요, 제 이름은 ${this.name}입니다.`;
};

const person = new Person('윤아준');

person.introduce(); // '안녕하세요, 제 이름은 윤아준입니다.'
```

## 정적 메소드(Static Method)

* JS 함수는 객체이기도 함, 생성자의 속성에 지정된 메소드를 **정적 메소드(Static Method)**라고 함
  * `Number.isNaN`, `Object.getPropertyOf` 등 함수들이 모두 정적 메소드
* 정적 메소드는 특정 인스턴스에 대한 작업이 아니라, 해당 생성자와 관련된 일반적인 작업을 정의하고 싶을 때 사용

```javascript
// 생성자의 속성에 함수를 직접 할당합니다.
Person.compareAge = function(person1, person2) {
  if (person1.age < person2.age) {
    return '첫 번째 사람의 나이가 더 많습니다.';
  } else if (person1.age === person2.age) {
    return '두 사람의 나이가 같습니다.';
  } else {
    return '두 번째 사람의 나이가 더 많습니다.';
  }
}
```

## JS Class

### ES2015 class

* ES2015 이전까지는 비슷한 종류의 객체를 많이 만들어 내기 위해 생성자를 사용

```javascript
// 생성자
function Person({name, age}) {
  this.name = name;
  this.age = age;
}
Person.prototype.introduce = function() {
  return `안녕하세요, 제 이름은 ${this.name}입니다.`;
};

const person = new Person({name: '오영근', age: 31});
console.log(person.introduce()); // 안녕하세요, 제 이름은 오영근입니다.
console.log(typeof Person); // function
console.log(typeof Person.prototype.constructor); // function
console.log(typeof Person.prototype.introduce); // function
console.log(person instanceof Person); // true
```

* ES2015에서 클래스를 도입하여 생성자 기능을 대체함, `class` 표현식을 사용하면 생성자와 같은 기능을 하는 함수를 훨씬 깔끔한 문법으로 정의가능

```javascript
// 클래스
class Person {
  // 이전에서 사용하던 생성자 함수는 클래스 안에 `constructor`라는 이름으로 정의합니다.
  constructor({name, age}) {
    this.name = name;
    this.age = age;
  }

  // 객체에서 메소드를 정의할 때 사용하던 문법을 그대로 사용하면, 메소드가 자동으로 `Person.prototype`에 저장됩니다.
  introduce() {
    return `안녕하세요, 제 이름은 ${this.name}입니다.`;
  }
}

const person = new Person({name: '오영근', age: 31});
console.log(person.introduce()); // 안녕하세요, 제 이름은 오영근입니다.
console.log(typeof Person); // function
console.log(typeof Person.prototype.constructor); // function
console.log(typeof Person.prototype.introduce); // function
console.log(person instanceof Person); // true
```

* `class`블록에서는 JS의 다른 곳에서는 사용되지 않는 **별도의 문법**으로 코드를 작성해야 함

```javascript
// 클래스는 함수가 아닙니다!
class Person {
  console.log('hello');
}
// 에러: Unexpected token
```

```javascript
// 클래스는 객체가 아닙니다!
class Person {
  prop1: 1,
  prop2: 2
}
// 에러: Unexpected token
```

* 문법이 아니라 동작 측면에서 본 ES2015 이전 생성자와 ES2015 클래스의 차이점
  * 클래스는 함수로 호출될 수 없음
  * 클래스 선언은 `let`과 `const` 처럼 블록 스코프에 선언되며, **호이스팅(hoisting)**이 일어나지 않음
  * 클래스의 메소드 안에서 `super` 키워드를 사용할 수 있음

### 메소드 정의하기

* 클래스 메소드를 정의할 때는 객체 리터럴에서 사용하던 문법과 유사한 문법을 사용
* 인스턴스 메소드(Instance Method)는 다음과 같은 문법을 통해 정의

```javascript
class Calculator {
  add(x, y) {
    return x + y;
  }
  subtract(x, y) {
    return x - y;
  }
}
```

* 객체 리터럴의 문법과 마찬가지로 임의의 표현식을 대괄호로 둘러싸서 메소드 이름으로 사용가능

```javascript
const methodName = 'introduce';
class Person {
  constructor({name, age}) {
    this.name = name;
    this.age = age;
  }
  // 아래 메소드의 이름은 `introduce`가 됩니다.
  [methodName]() {
    return `안녕하세요, 제 이름은 ${this.name}입니다.`;
  }
}

console.log(new Person({name: '오영근', age: 31}).introduce()); // 안녕하세요, 제 이름은 오영근입니다.
```

* Getter, Setter를 정의하고 싶으면 메소드 이름 앞에 `set` 또는 `get`을 붙여주면 됨

```javascript
class Account {
  constructor() {
    this._balance = 0;
  }
  get balance() {
    return this._balance;
  }
  set balance(newBalance) {
    this._balance = newBalance;
  }
}

const account = new Account();
account.balance = 10000;
account.balance; // 10000
```

* `static` 키워드를 메소드 이름 앞에 붙여주면 **정적 메소드**가 됨

```javascript
class Person {
  constructor({name, age}) {
    this.name = name;
    this.age = age;
  }
  // 이 메소드는 정적 메소드입니다.
  static sumAge(...people) {
    return people.reduce((acc, person) => acc + person.age, 0);
  }
}

const person1 = new Person({name: '윤아준', age: 19});
const person2 = new Person({name: '신하경', age: 20});

Person.sumAge(person1, person2); // 39
```

* Generator 메소드는 생략(추후 보강)

### 클래스 필드(Class Field)

* 클래스 블록 안에서 할당 연산자(`=`)를 이용해 인스턴스 속성을 지정할 수 있는 문법을 **클래스 필드**라 함
  * 아직 정식 표준으로 채택된 기능이 아님, 이 기능을 구현한 브라우저는 없는 상태고 Babel, TypeScript 등의 트랜스파일러를 통해 일불 기능을 사용할 수 있음

```javascript
class Counter {
  static initial = 0; // static class field
  count = Counter.initial; // class field
  inc() {
    return this.count++;
  }
}

const counter = new Counter();
console.log(counter.inc()); // 0
console.log(counter.inc()); // 1

Counter.initial = 10;
console.log(new Counter().count); // 10
```

### 클래스 필드와 this

* `class` 블록은 새로운 블록 스코프를 형성하고 이 내부에서 사용된 `this`는 인스턴스 객체를 가리킴

```javascript
class MyClass {
  a = 1;
  b = this.a;
}

new MyClass().b; // 1
```

* 이 성질을 이용하면 화살표 함수를 통해서 메소드를 정의할 수 있음
  * 화살표 함수 안에서의 `this` 키워드는 바로 바깥쪽 스코프에 존재하는 this와 같은 객체를 가리킴

```javascript
class MyClass {
  a = 1;
  getA = () => {
    return this.a;
  }
}

new MyClass().getA(); // 1
```

* 일반적인 메소드와 클래스 필드의 차이점
  * 일반적인 메소드는 `prototype` 속성에 저장되는 반면, 클래스 필드는 인스턴스 객체에 저장됨
  * 화살표 함수의 `this`는 호출 형태에 관계없이 항상 인스턴스 객체를 가리킴
    * 메소드를 값으로 다루어야 할 경우 일반적인 메소드 대신 화살표 함수가 사용되는 경우가 종종 있음
  * 일반적인 메소드와 달리 클래스 필드를 통해 정의한 메소드는 **인스턴스를 생성할 때마다 새로 생성 됨**

### 클래스의 상속(Class Inheritance)

* 클래스 상속(class inheritance, subclassing) 기능을 통해 한 클래스의 기능을 다른 클래스에서 재사용 가능
  * `extends` 키워드를 통해 `Child`클래스가 `Parent` 클래스를 상속
  * '부모-자식 클래스 관계' 또는 '슈퍼 클래스-서브 클래스 관계'

```javascript
class Parent {
  // ...
}

class Child extends Parent {
  // ...
}
```

```javascript
class Parent {
  static staticProp = 'staticProp';
  static staticMethod() {
    return 'I\'m a static method.';
  }
  instanceProp = 'instanceProp';
  instanceMethod() {
    return 'I\'m a instance method.';
  }
}

class Child extends Parent {}

console.log(Child.staticProp); // staticProp
console.log(Child.staticMethod()); // I'm a static method.

const c = new Child();
console.log(c.instanceProp); // instanceProp
console.log(c.instanceMethod()); // I'm a instance method.
```

### 클래스 상속과 프로토타입 상속

* 클래스 상속은 내부적으로 프로토타입 상속 기능을 활용

```javascript
class Person {}
class Student extends Person {}
const student = new Student();
```

![img](https://helloworldjavascript.net/images/class-inheritance-prototype-chain.svg)



### 출처

* **JavaScript로 만나는 세상**
  * [객체](https://helloworldjavascript.net/pages/180-object.html)
  * [클래스](https://helloworldjavascript.net/pages/270-class.html)