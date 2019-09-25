package DataStructure;

public class test {
    public static void main(String[] args) {

        try{
            int i = 1;
            int j = 0;

            System.out.println(i/j);
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            System.out.println("finally  실행");
        }
        System.out.println("메인 실행");
    }
}
