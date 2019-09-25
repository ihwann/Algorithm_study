package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {

        List<ObjectTest> list = new ArrayList<>();
        list.add(new ObjectTest("a", 5));
        list.add(new ObjectTest("b", 4));
        list.add(new ObjectTest("c", 3));
        list.add(new ObjectTest("d", 2));
        list.add(new ObjectTest("e", 1));


        Collections.sort(list, new Comparator<ObjectTest>() {
            @Override
            public int compare(ObjectTest o1, ObjectTest o2) {
                int result;
                if(o1.b >= o2.b){
                    result = -1;
                }else{
                    result = 1;
                }
                return result;
            }
        });

        for(Object item : list){
            System.out.println(item.toString());
        }
    }
}
