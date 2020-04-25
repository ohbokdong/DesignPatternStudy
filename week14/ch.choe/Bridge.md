# Bridge Pattern

## 브릿지 패턴이란?

구현, 추상화 부분까지 변경 시켜야 하는 경우 브릿지 패턴을 사용
구현부에서 추상층을 분리 하여 각자 독립적으로 변형 할 수 있게 해주는 패턴

## 장점
- 구현을 인터페이스에 결합시키지 않기 때문에 구현, 추상화 부분을 분리 
- 추상화된 부분과 실제 구현 부분을 독립적으로 확장 가능
- 추상화 부분을 구현한 구상 클래스를 바꿔도 클라이언트 쪽에는 영향이 없음

## 단점
- 디자인이 복잡해짐

## 활용법 
- 여러 플랫폼에서 사용하는 그래픽스 및 윈도우 처리 시스템에 유용하게 사용
- 인터페이스와 구현부를 서로 다른 방식으로 변경해야 하는 경우 유용하게 사용

![shape](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/img.JPG?raw=true)

<pre><code>
 /** "Implementor" */
 interface IDrawingAPI {
    void DrawCircle(double x, double y, double radius);
 }

 /** "ConcreteImplementor" 1/2 */
 class DrawingAPI1 : IDrawingAPI {
    public void DrawCircle(double x, double y, double radius)
    {
        System.Console.WriteLine("API1.circle at {0}:{1} radius {2}", x, y, radius);
    }
 }

 /** "ConcreteImplementor" 2/2 */
 class DrawingAPI2 : IDrawingAPI
 {
    public void DrawCircle(double x, double y, double radius)
    {
        System.Console.WriteLine("API2.circle at {0}:{1} radius {2}", x, y, radius);
    }
 }

 /** "Abstraction" */
 interface IShape {
    void Draw();                             // low-level (i.e. Implementation-specific)
    void ResizeByPercentage(double pct);     // high-level (i.e. Abstraction-specific)
 }

 /** "Refined Abstraction" */
 class CircleShape : IShape {
    private double x, y, radius;
    private IDrawingAPI drawingAPI;
    public CircleShape(double x, double y, double radius, IDrawingAPI drawingAPI)
    {
        this.x = x;  this.y = y;  this.radius = radius;
        this.drawingAPI = drawingAPI;
    }
    // low-level (i.e. Implementation-specific)
    public void Draw() { drawingAPI.DrawCircle(x, y, radius); }
    // high-level (i.e. Abstraction-specific)
    public void ResizeByPercentage(double pct) { radius *= pct; }
 }

 /** "Client" */
 class BridgePattern {
    public static void Main(string[] args) {
        IShape[] shapes = new IShape[2];
        shapes[0] = new CircleShape(1, 2, 3, new DrawingAPI1());
        shapes[1] = new CircleShape(5, 7, 11, new DrawingAPI2());

        foreach (IShape shape in shapes) {
            shape.ResizeByPercentage(2.5);
            shape.Draw();
        }
    }
 }
</code></pre>
