package DataStructure;

public class MyCalTest {
    public static void main(String[] args) {
        CalculatorInterface cal = new MyCal();

        int ans1 = cal.plus(3,2);
        int ans2 = cal.exec(3,3);
        int ans3 = CalculatorInterface.exec2(4,2);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
