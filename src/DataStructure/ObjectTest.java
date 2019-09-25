package DataStructure;

public class ObjectTest {
    String a;
    int b;

    public ObjectTest(String a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "ObjectTest{" +
                "a='" + a + '\'' +
                ", b=" + b +
                '}';
    }
}
