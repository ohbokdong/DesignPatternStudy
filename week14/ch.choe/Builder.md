# Builder Pattern

## 빌더 패턴이란?

객체 생성 패턴 중 하나

생산 단계를 캡슐화 하고 싶다면 빌더 패턴을 사용

복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴

빌더 패턴은 다양하게 쓰일 수 있음 

## 장점
- 복합 객체가 생성되는 과정을 캡슐화
- 여러 단계와 다양한 절차를 통해 객체 생성
- 내부 구조를 클라이언트로 부터 보호
- 클라이언트는 추상 인터페이스만 볼수 있어 구현 코드를 쉽게 바꿀 수 있음

## 단점
- 팩토리를 사용하는 경우  비해 객체를 만들기 위해 클라이언트를 더 많이 알아야함

## 활용법 
- 복합 객체  구조를 구축하기위한 용도로 많이 쓰임

<pre><code>
// 빌더 사용 전
public class UserInfoBuilder 
{ 
    private String name; 
    private int age;
    private String addr; 
    ublic UserInfoBuilder 
    setName(String name)
    { 
        this.name = name;
        return this;
    }
    public UserInfoBuilder setAge(int age)
    { 
        this.age = age; 
        return this; 
    } 
    public UserInfoBuilder setAddr(String addr)
    { 
        this.addr = addr; 
        return this; 
    }
             
    public UserInfo build(){ 
        return new UserInfo(name, age, addr); 
    } 
}

UserInfo userInfo = new UserInfo("테스터", 25, "서울시 강남구"); 

System.out.println(userInfo.getUserInfo()); 

// 결과 => name: 테스터, age: 25, addr: 서울시 강남구


//빌더 사용 후
public class UserInfoBuilder { 
    private String name; 
    private int age; 
    private String addr; 
    public UserInfoBuilder setName(String name) 
    { 
        this.name = name;
        return this;
    } 
    public UserInfoBuilder setAge(int age) 
    { 
        this.age = age; 
        return this; 
    } 
    public UserInfoBuilder setAddr(String addr) 
    { 
        this.addr = addr; 
        return this; 
    } 
    public UserInfo build() { 
        return new UserInfo(name, age, addr); 
    } 
}

UserInfoBuilder userInfoBuilder = new UserInfoBuilder();
UserInfo userInfo3 = userInfoBuilder
    .setName("테스터3")
    .setAddr("주소")
    .setAge(26)
    .build(); 

System.out.println(userInfo3.getUserInfo()); 
// 결과 => name: 테스터3, age: 26, addr: 주소

출처: https://lemontia.tistory.com/483 [side impact]
</code></pre>

<pre><code>
class Pizza
{
    string dough;
    string sauce;
    string topping;
    public Pizza() {}
    public void SetDough( string d){ dough = d;}
    public void SetSauce( string s){ sauce = s;}
    public void SetTopping( string t){ topping = t;}
}

//Abstract Builder
abstract class PizzaBuilder
{
    protected Pizza pizza;
    public PizzaBuilder(){}
    public Pizza GetPizza(){ return pizza; }
    public void CreateNewPizza() { pizza = new Pizza(); }

    public abstract void BuildDough();
    public abstract void BuildSauce();
    public abstract void BuildTopping();
}

//Concrete Builder
class HawaiianPizzaBuilder : PizzaBuilder
{
    public override void BuildDough()   { pizza.SetDough("cross"); }
    public override void BuildSauce()   { pizza.SetSauce("mild"); }
    public override void BuildTopping() { pizza.SetTopping("ham+pineapple"); }
}

//Concrete Builder
class SpicyPizzaBuilder : PizzaBuilder
{
    public override void BuildDough()   { pizza.SetDough("pan baked"); }
    public override void BuildSauce()   { pizza.SetSauce("hot"); }
    public override void BuildTopping() { pizza.SetTopping("pepparoni+salami"); }
}

/** "Director" */
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void SetPizzaBuilder (PizzaBuilder pb) { pizzaBuilder = pb; }
    public Pizza GetPizza() { return pizzaBuilder.GetPizza(); }


    public void ConstructPizza() {
        pizzaBuilder.CreateNewPizza();
        pizzaBuilder.BuildDough();
        pizzaBuilder.BuildSauce();
        pizzaBuilder.BuildTopping();
    }
}

/** A customer ordering a pizza. */
class BuilderExample
{
    public static void Main(string[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.SetPizzaBuilder ( hawaiianPizzaBuilder );
        waiter.ConstructPizza();

        Pizza pizza = waiter.GetPizza();
    }
}
</code></pre>

[빌더 패턴 - 위키](https://ko.wikipedia.org/wiki/%EB%B9%8C%EB%8D%94_%ED%8C%A8%ED%84%B4)

<pre><code>
 StringBuilder builder = new StringBuilder();
            builder.Append("Test");
            builder.Append("Test1");
            builder.Append("Test2");

            builder.ToString();
</code></pre>

스트링 빌더도 비슷해 보여서 참고 해봅니다.
