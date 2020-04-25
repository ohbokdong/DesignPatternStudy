# 프로토타입(Prototype) 패턴
객체를 생성하는 데 비용(시간과 자원)이 많이 들고, 비슷한 객체가 이미 있는 경우에 사용되는 생성 패턴 중 하나로,<br/>
미리 만들어진 객체(object)를 복사하여 개체를 생성하는 패턴<br/>
JAVA에서는 <b>clone()</b>를 사용한다.

## 프로토타입의 장점
- 클라이언트에서는 새로운 인스턴스를 만드는 복잡한 과정을 몰라도 됨
- 클라이언트에서는 구체적인 형식을 모르더라도 객체를 생성할 수 있음
- 상황에 따라서 객체를 새로 생성하는 것보다 객체를 복사는 것이 더 효율적일 수 있음

## 프로토타입의 활용법 
- 시스템에서 복잡한 클래스 계층구조에 파묻혀 있는 다양한 형식의 객체 인스턴스를 새로 만들어야 하는 경우에 유용하게 써먹을 수 있음
- 종류가 너무 많아 클래스로 정리되지 않는 경우
    - 취급하는 오브젝트의 종류가 너무 많아 각각을 별도의 클래스로 만들어 다수의 소스 파일을 작성해야 하는 단점을 극복
- 클래스로부터 인스턴스 생성이 어려운 경우
    - 생성하고 싶은 인스턴스가 복잡한 작업을 거쳐 만들어지기 때문에, 클래스로부터 만들기가 매우 어려운 경우
- framework와 생성할 인스턴스를 분리하고 싶은 경우
    - 프레임워크를 특정 클래스에 의존하지 않고 만들고 싶은 경우, 클래스 이름을 지정하여 인스턴스를 만드는 것이 아니라, 이미 모형이 되는 인스턴스를 등록해 두고, 그 인스턴스를 복사하여 생성한다.

## 프로토타입의 단점
- 때때로 객체의 복사본을 만드는 일이 매우 복잡한 경우가 있다

## 프로토타입 구조
- prototype의 역할
    - 인스턴스를 복사하여 새로운 인스턴스를 만들기 위한 메소드를 결정
- ConcretePrototype
    - 인스턴스를 복사해서 새로운 인스턴스를 만드는 메소드를 실제로 구현
- Client
    - 인스턴스 복사 메소드를 사용해서 새로운 인스턴스를 만듬

![prototype](https://lh3.googleusercontent.com/proxy/9h5V5jh9imOKtNNX_6SeW4koW88LG91yh742kvVHk6wb_ONy9QIafmPp7klVwS5qug4g2pxjy59luRGh0xXQleu-fHwIVFXzUeipSo5pAzE)

## 프로토타입 예제
![shape](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/minj0i/shape.png?raw=true)

<h2>1. Shape 클래스</h2>
clone() 메소드를 사용하기 위해 Cloneable 인터페이스를 구현하며, 공통 메소드인 draw()는 추상 메소드로 정의하고, 하위 클래스에서 사용할 clone()는 공통으로 동작하는 메소드를 정의

```JAVA
public abstract class Shape implements Cloneable {
	protected Type type;
	abstract void draw();
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object clone = null;
		
		try {
			clone = super.clone();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
```
<h2>2. Circle, Triangle, Rectangle 클래스</h2>
각각 shape 클래스를 상속 받으며 draw() 메소드를 재정의

```JAVA
public class Circle extends Shape{
	public Circle() {
		this.type = type.CIRCLE;
	}

	@Override
	void draw() {
		System.out.println("[circle]입니다.");
	}
}
```

<h2>3. ShapeStore 클래스</h2>
저장소를 담당하며, 최초 registerShape() 메소드 호출 시 복제에 사용할 객체를 인스턴스화해서 shapeMap에 저장하는 동작을 하며, getShape() 메소드를 통해 객체의 복사본을 반환해주는 역할

```JAVA
import java.awt.Window.Type;
import java.util.HashMap;
import java.util.Map;

public class ShapeStore {
	private static Map<Type, Shape> shapeMap = new HashMap<Type, Shape>();
	
	public void registerShape() {
		Rectangle rec = new Rectangle();
		Circle cir = new Circle();
		Triangle tri = new Triangle();
		
		shapeMap.put(rec.type, rec);
		shapeMap.put(cir.type, cir);
		shapeMap.put(tri.type, tri);
	}
	
	public Shape getShape(Type type) {
		return (shape)shapeMap.get(type).clone();
	}
}
```

<h2>4. Main 클래스</h2>
Client에 해당하는 부분으로 복제된 객체를 사용

```JAVA
public class Main {
    public static void main(String[] args) {
        ShapeStore manager = new ShapeStore();
        manager.registerShape();
        
        Circle cir1 = (Circle)manager.getShape(Type.CIRCLE);
        cir1.draw();
        Circle cir2 = (Circle)manager.getShape(Type.CIRCLE);
        cir2.draw();
        
        Rectangle rec1 = (Rectangle)manager.getShape(Type.RECTANGLE);
        rec1.draw();
        
        Triangle tri1 = (Triangle)manager.getShape(Type.TRIANGLE);
        tri1.draw();
        
    }
}
```

실행결과

```HTML
[Circle]입니다.
[Circle]입니다.
[Rectangle]입니다.
[Triangle]입니다.
```


## 얕은 복사 vs 깊은 복사

### clone : 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성
- 복제이유: 원본객체를 안전하게 보호하기 위해서
- cloneable 인터페이스를 구현하지 않으면 clone()메소드를 호출할 때 CloneNotSupportedException 예외가 발생
- try-catch 구문 필요
- 얕은복제(this clone)와 깊은복제(deep clone)가 있음

### 얕은 복제
복제된 필드값을 변경하면 기본형의 원본 필드값은 그대로지만  참조형의 필드는 번지만 복제되기 때문에 원본과 같은 객체를 참조하게 됨

```JAVA
class A implements Cloneable { // 보안때문에 cloneable 상속 필요
	int i;
	int[] arr;

	A(int i, int[] arr) {
		this(i);
		this.arr = arr;
	}

	A copy() throws CloneNotSupportedException {
		return (A) clone();
	}
}

public class CloneTest {
	public static void main(String[] args) {
		A a1, a2 = null;
		a1 = new A(10, new int[] { 10, 20, 30 });
		try {
			a2 = a1.copy();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println("-------------");
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		// 해시코드가 서로 다름
		// 서로 다른 객체라는 뜻

		a1.i = 99; // 원본의 값이 바뀌어도
		a1.arr[0] = 99;
		System.out.println("a1.i= " + a1.i); // 99
		System.out.println("a2.i= " + a2.i); // 10 복제본의 값에는 영향을 미치지 않지만
		System.out.println("a1.arr[0]= " + a1.arr[0]); // 99
		System.out.println("a2.arr[0]= " + a2.arr[0]); // 99 참조형 필드는 '번지만 복제'되기 때문에 같은 객체를 참조하게 된다 (얕은 복제) } }
	}
}

```

### 깊은 복제
참조형 필드가 참조하는 객체도 복제하기 때문에 복제된 참조 객체를 변경해도 원본 객체가 변경되지 않음

```JAVA
class B implements Cloneable { // 보안때문에 clone 필요
	int i;
	int[] arr;

	B(int i) {
		this.i = i;
	}

	B(int i, int[] arr) {
		this(i);
		this.arr = arr;
	}

	B copy() throws CloneNotSupportedException {
		B copyObj = (B) this.clone(); // arr.clone();
		int[] copyArr = (int[]) arr.clone();
		copyObj.arr = copyArr;
		return copyObj;
	}
}

public class CloneTest {
	public static void main(String[] args) {
		B b1, b2 = null;
		b1 = new B(10, new int[] { 10, 20, 30 });
		try {
			b2 = b1.copy();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		b1.i = 99; // 원본의 값이 바뀌어도
		b1.arr[0] = 99;
		
		System.out.println("b1.arr[0]= " + b1.arr[0]); // 99
		System.out.println("b2.arr[0]= "+b2.arr[0]); //10 다른번지의 복제된 다른 객체를 참조하기때문에 원본의 값은 변하지 않음 } }
	}
}

```