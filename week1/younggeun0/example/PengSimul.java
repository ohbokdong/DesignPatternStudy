package week1.younggeun0.example;

public class PengSimul {

    public static void main(String[] args) {
        
        Penguin pengsu = new Pengsu();
        Penguin ppororo = new Ppororo();
        Penguin doll = new PengDoll();

        // 스트레티지 패턴을 이용한 행동 위임
        pengsu.performWalk();
        ppororo.performWalk();
        doll.performWalk();

        // 일반 상속으로 행동 구현 - 상속은 한개만 가능
        System.out.println(pengsu.getTweet());
        System.out.println(ppororo.getTweet());
        System.out.println(doll.getTweet());
    }
}