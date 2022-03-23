package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Point11650 {

  int x;
  int y;

  Point11650(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return new StringBuilder().append(x + " ").append(y).toString();
  }
}

public class Q_11650 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());

    List<Point11650> pointList = new LinkedList<>();

    while (num-- > 0) {

      String[] inputData = br.readLine().split(" ");

      pointList.add(
          new Point11650(Integer.parseInt(inputData[0]), Integer.parseInt(inputData[1]))
      );
    }

    Collections.sort(pointList, new Comparator<Point11650>() {
      @Override
      public int compare(Point11650 o1, Point11650 o2) {
        if (o1.x > o2.x) {
          return 1;
        } else if (o1.x == o2.x) {
          if (o1.y > o2.y) {
            return 1;
          } else {
            return -1;
          }
        } else {
          return -1;
        }
      }
    });

    for (Point11650 item : pointList) {
      System.out.println(item.toString());
    }
  }
}
