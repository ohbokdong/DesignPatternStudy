c# 은 Beverage 클래스에서 GetDescription 에 virtual을 해줘야 정상 작동함.

CondimentDecorator에서 GetDescription()에 대한 가상 함수를 오버라이딩 해서 사용함.

그렇지 않으면 Coffee 에 대한 Beverage 클래스의 GetDescription() 함수로 접근을 해서 제목없음을 호출




