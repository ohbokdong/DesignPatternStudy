# Week 14 - Chain Of Responsibility Pattern(역할 사슬 패턴)

## 역할 사슬 패턴

* **한 요청을 두 개 이상의 객체에서 처리하고 싶다면 사용**
* 예제 시나리오
  * 자바탑재된 뽑기기계 출시 이후 뽑기회사는 많은 이메일을 받고있음
  * 이메일은 팬이 보내는 메일, 기계를 옮겨달라는 메일, 새로 설치해 달라는 메일, 스펨 메일
    * 팬 메일은 CEO에게 직접 전달되어야 함
    * 항의 메일은 법무 담당부서로
    * 신규 설치 요청 메일은 영업부로
    * 스팸 메일은 그냥 지워버려야 함
* 할 일
  * 검출기를 써서 메일을 분류해줄 수 있는 디자인을 만들어야 함
* **역할 사슬 패턴의 사용법**
  * **역살 사슬 패턴에서는 주어진 요청을 검토하기 위해 객체 사슬을 생성함**
  * 그 사슬에 속해 있는 각 객체에서는 자기가 받은 요청을 검사하여 직접 처리하거나 사슬에 들어있는 다른 객체한테 넘기게 됨
    * 사슬에 드렁있는 각 객체는 핸들러 역할을 하며 각 객체마다 그 다음에 이어지는 객체가 있음
    * 주어진 요청을 처리할 수 있으면 직접 처리하고, 그렇지 않으면 다음 객체한테 넘김
  * 이메일이 수신되면 첫 번째 핸들러인 SpamHandler에 전달됨, SpamHandler에서 처리할 수 없으면 FanHandler로 넘어감
    * 이와 비슷한 식으로 사슬을 따라서 요청이 전달되면서 어딘가 적절한 핸들러에 의해 처리됨

![cor-img1](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/cor/cor-img1.png?raw=true)

![cor-img2](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/cor/cor-img2.png?raw=true)


* **장점**
  * 요청을 보낸 쪽하고 받는 쪽을 분리시킬 수 있음
  * 객체에서는 사슬 구조를 몰라도 되고 그 사슬에 들어 있는 다른 객체에 대한 직접적인 레퍼런스를 가질 필요도 없기 때문에 객체를 단순하게 만들 수 있음
  * 사슬에 들어가는 객체를 바꾸거나 순서를 바꿈으로써 역할을 동적으로 추가/제거 할 수 있다
* **역할 사슬 사용법 및 단점**
  * 윈도우 시스템에서 마우스 클릭이나 키보드 이벤트를 처리할 때 흔하게 쓰임
  * 요청이 반드시 수행된다는 보장이 없다는 단점이 있음
    * 사슬 끝까지 갔는데도 아무 객체에서도 처리해주지 않을 수 있음(사실 이런 특성은 장점이 될 수도 있음)
  * 실행시에 과정을 살펴보거나 디버깅하기가 힘들 수 있다는 단점이 있음

```java
public abstract class Handler {
  private Handler successor; // 다음 처리할 핸들러를 멤버로  들고 있음
  public abstract void handleRequest();
  
  public void setSuccessor(Handler successor) {
    this.successor = successor;
  }
  public Handler getSuccessor() {
    return successor;
  }
}
```

```java
public class SpamHandler extends Handler {
  private String strText;
  public SpamHandler(String strText) {
    this.strText = strText;
    this.setSuccessor(new FanHandler(strText)); // 다음 처리할 핸들러를 설정
  }
  
  @Override
  public void handleRequest() {
    if (strText.indexOf("광고") != -1) { // 나머지도 이와 같은 구조
      System.out.println("***************************");
      System.out.println("=>광고 메일로  분류되었습니다.");
      System.out.println("\n");
      /*
       * 메일을 삭제하는 처리
       */
    } else {
      this.getSuccessor().handleRequest(); // 처리 못하면 책임을 넘김
    }
  }
}
```

```java
public class CORDrive { // Chain Of Responsibility(역할 사슬)  패턴 예제
  public static void main(String[] args) {
    /*
    * 1. 이메일 목록을 한 줄씩 읽음(csv 가데이터)
    * 2. Spam 핸들러 생성
    * 3. HandleRequest호출해서 역할 사슬을 타도록 함
    */
    
    try { // csv 데이터를 읽어서 핸들러 handleRequest를 요청함
      InputStream is = new FileInputStream(new  File("D:/dev/eclipse-workspace/local_dp_study/src/week14/younggeun0/chainofresponsibility/csv.txt"));
      InputStreamReader isr = new  InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      
      String temp = "";
      while((temp = br.readLine()) != null){
        System.out.println(temp);
        Handler handler = new SpamHandler(temp);
        handler.handleRequest();
      }
        
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
```

![cor-img3](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/cor/cor-img3.png?raw=true)
