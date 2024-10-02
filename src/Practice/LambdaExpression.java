package Practice;
interface Area{
    public void area();
}
public class LambdaExpression {
    public static void main(String[] args) {
        Area a = ()->{
            int b = 10;
            System.out.println("Area : "+(b*b));
        };
        a.area();
    }
}
