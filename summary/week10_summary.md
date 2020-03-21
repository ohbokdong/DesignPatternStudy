# Week 10 스테이트 패턴 (State Pattern) 

## 스테이트 패턴 이란? 

객체 지향 방식으로 상태 기계를 구현 하는 패턴

인터페이스를 통해 파생 클래스에서 상태를 구현하고 정의되는 메소드를 호출하여 상태변화를 구현함으로써 상태 기계를 구현

내부 상태가 바뀜에 따라 객채의 행동을 바꿀 수 있는 패턴

객체 클래스가 바뀌는 결과를 얻을 수 있음

### 상태 기계란?

기계는 한번에 오로지 하나의 상태만을 가지게 되며 이벤트에 의해 한 상태에서 다른 상태로 변화를 할 수 있으며 이를 전이라함
상태롸 전이를 유발하는 조건들의 집합으로써 상태 기계가 정의됨.


**장점**

- 상태 객체의 행동이 캡슐화 됨

- 클라이언트는 상태 객체에 대하여 거의 몰라도 됨

- 구성을 통해 행동을 정의하는 객체를 유연하게 바꿀 수 있음

------------------------
## 문제 1

뽑기 기계를 제작 요청이 옴

**상태 : 동전 있음, 동전 없음, 알맹이 판매, 알맹이 매진**

**행동 : 동전 투입, 동전 반환, 손잡이 돌림, 알맹이 내보냄**

--이미지

## 해결방법 1

각 상태에 대한 변화를 IF문을 통해 해결 


------------------------

## 문제 2

뽑기 기계에 대한 기능 확장 요구, 해결방법 1로 확장을 하려니 너무 많은 코드를  수정해야함

OCP 가 지켜지지않음, 캡슐화 x, 버그 가능성 UP, 상태전환 파악 어려움

**상태 : 동전 있음, 동전 없음, 알맹이 판매, 알맹이 매진, 당첨**

**행동 : 동전 투입, 동전 반환, 손잡이 돌림, 알맹이 내보냄, 알맹이 2개 내보냄**

--이미지

## 해결방법 2

스테이트 패턴을 이용한 해결

State 인터페이스를 통해 행동에 대한 함수 정의
State를 상송 받는 서브 클래스 생성하여 행동에 따른 행위 정의

State 구성을 통해서 객체를 유연하게 바꿈


```c#
//행동 정의 인터페이스
 interface State
    {
        void InsertQuarter();
        void EjectQuarter();
        void TurnCrack();
        void Dispense();
    }
```

```java
//상태 클래스
   class NoQuarterState : State
    {
        GumballMachine m_GumballMachine;

        public NoQuarterState(GumballMachine machine)
        {
            m_GumballMachine = machine;
        }
        public void Dispense()
        {
            Console.WriteLine("동전을 넣어주세요.");
        }

        public void EjectQuarter()
        {
            Console.WriteLine("동전을 넣어주세요.");
        }

        public void InsertQuarter()
        {
            Console.WriteLine("동전을 넣으셨습니다.");
            //행동 후 다음 상태를 갱신
            m_GumballMachine.SetState(GumballMachine.StateType.HasQuarter);
        }

        public void TurnCrack()
        {
            Console.WriteLine("동전을 넣어주세요.");
        }
    }
```
```c#
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state;

    public void SetState(State state)
    {
        this.state = state;
    }
    public void InsertQuarter()
    {
        state.InsertQuarter();
    }

    public void EjectQuarter()
    {
        state.EjectQuarter();
    }

    public void TurnCrank()
    {
        state.TurnCrack();
        state.Dispense();
    }
    public void ReleaseBall()
    {
        Console.WriteLine("out the slot");
        if(count != 0)
        {
            count--;
        }
    }
```

스테이트 패턴을 통해 얻은 결과

1. 상태의 행동을 국지화 시킴
2. IF선언문 삭제
3. 상태 변경에 대하여 닫혀 있고 새로운 상태 클래스를 추가하여 확장 가능 (OCP)
4. 이해하기 좋은 코드와 구조가 됨

