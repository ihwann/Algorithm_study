package CodingTest;

import java.util.*;

/**
 * 제임스가 일하는 사무실에는 문서를 한 번에 하나씩 인쇄할 수 있는 프린터 한 대가 있습니다. 혼자 프린터를 사용할 때는 별 문제가 없지만, 여러 사람이 동시에 프린터를 사용할 때는 어떤 문서를 먼저 인쇄할지 정해야 합니다. 일반적인 프린터의 경우 먼저 요청된 문서를 먼저 인쇄하지만, 제임스는 보다 효율적인 일처리를 위해 다음과 같이 프린터가 인쇄 요청을 처리하는 규칙을 정했습니다.
 * <p>
 * 인쇄 중 또는 대기 중인 문서가 없을 때 인쇄 요청된 문서는 즉시 인쇄합니다.
 * 인쇄 중 또는 대기 중인 문서가 있을 때 인쇄 요청된 문서는 대기열에 추가합니다.
 * 인쇄 중인 문서가 전부 인쇄된 후 대기열에서 다음 문서를 선택해 인쇄합니다.
 * 3-1. 대기 중인 문서중 페이지 수가 적은 문서부터 인쇄합니다.
 * 3-2. 대기 중인 문서중 페이지 수가 같은 문서가 있을 경우, 먼저 요청된 문서부터 인쇄합니다.
 * 3-3. 현재 인쇄 중인 문서의 인쇄가 끝난 시각과 새로 요청된 문서의 인쇄 요청 시각이 같은 경우, 새로 요청된 문서를 먼저 대기열에 추가한 후 다음에 인쇄해야 될 문서를 선택합니다.
 * 제임스는 프린터가 규칙대로 작동하는지 테스트하기 위해 가상의 인쇄 요청 데이터를 만들어 입력해보려 합니다. 각 인쇄 요청 데이터는 다음과 같은 형식입니다.
 * <p>
 * [문서 번호, 인쇄 요청 시각, 페이지 수]
 * 단, 인쇄 요청 시각은 0초부터 시작하며, 초 단위로 나타냅니다. 예를 들어 어떤 문서의 인쇄 요청 데이터가 [2, 2, 4]인 경우, 이는 2번 문서가 2초에 인쇄 요청됐으며, 4페이지를 인쇄해야 된다는 의미입니다. 또한 한 페이지를 인쇄하는 데에는 1초가 걸립니다.
 * <p>
 * 인쇄 요청 데이터들이 들어있는 배열 data가 매개변수로 주어질 때, 배열에 인쇄가 완료되는 순서대로 문서 번호를 담아 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * data는 가로(열) 길이가 3, 세로(행) 길이가 1 이상 100,000 이하인 2차원 배열입니다.
 * data의 원소는 [문서 번호, 인쇄 요청 시각, 페이지 수] 형식입니다.
 * 인쇄할 문서가 N개일 때, 모든 문서에는 1부터 N까지 번호가 하나씩 붙어있습니다.
 * data의 각 행은 문서 번호와 인쇄 요청 시각이 증가하는 순서로 주어집니다.
 * 즉, data의 각 행의 문서 번호는 1부터 N까지 오름차순 형태로 주어지며, 번호가 클수록 나중에 인쇄 요청된 문서입니다.
 * 인쇄 요청 시각이 같은 문서는 없습니다.
 * 인쇄 요청 시각은 0 이상 100,000,000 이하인 자연수입니다.
 * 페이지 수는 1 이상 100,000 이하인 자연수입니다.
 * 문서를 대기열에 추가하거나, 다음 인쇄할 문서를 선택하는데 걸리는 시간은 없다고 가정합니다.
 * <p>
 * 입출력 예
 * data	                                                        result
 * [[1, 0, 5],[2, 2, 2],[3, 3, 1],[4, 4, 1],[5, 10, 2]]	        [1,3,4,2,5]
 * [[1, 0, 3], [2, 1, 3], [3, 3, 2], [4, 9, 1], [5, 10, 2]]	    [1,3,2,4,5]
 * [[1, 2, 10], [2, 5, 8], [3, 6, 9], [4, 20, 6], [5, 25, 5]]	[1,2,4,5,3]
 */

class Paper implements Comparable<Paper> {
    int id; // 문서번호
    int requestTime; // 인쇄요청시간
    int page; //페이지 수

    public Paper(int id, int requestTime, int page) {
        this.id = id;
        this.requestTime = requestTime;
        this.page = page;
    }

    @Override
    public int compareTo(Paper other) {
        if (this.page < other.page) {
            return -1;
        } else if (this.page == other.page && this.requestTime < other.requestTime) {
            return -1;
        }
        return 1;
    }
}

public class Zoom02 {
    public static void main(String[] args) {

        int[][] data = {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};
        List<Integer> answerList = new ArrayList<>();
        List<Paper> paperList = new ArrayList<>();

        for (int[] info : data) {
            paperList.add(new Paper(info[0], info[1], info[2]));
        }

        Queue<Paper> printQueue = new LinkedList<>();
        PriorityQueue<Paper> waitingQueue = new PriorityQueue<>();

        // 현재시각과 첫번째 프린트 완료 시간
        int time = 0;
        int completeTime = time + paperList.get(0).page;

        printQueue.offer(paperList.get(0)); // 프린터에 넣고
        paperList.remove(0); // 페이퍼리스트에서 삭제

        // 프린터와 대기열이 빌 때 까지 반복
        while (answerList.size() <= data.length) {
            if (time == completeTime) {
                Paper printedPaper = printQueue.poll();
                answerList.add(printedPaper.id);

                //3-3 규칙
                if (completeTime == paperList.get(0).requestTime) {
                    printQueue.offer(paperList.get(0));
                    completeTime = time + printQueue.peek().page;
                    paperList.remove(0);
                    // 대기열에서 종이를 꺼낸다.
                } else if (!waitingQueue.isEmpty()) {
                    printQueue.offer(waitingQueue.poll());
                    completeTime = time + printQueue.peek().page;
                } else {
                    time++;
                    continue;
                }
            } else if (time >= completeTime && !printQueue.isEmpty()) {
                Paper printedPaper = printQueue.poll();
                answerList.add(printedPaper.id);
            }

            if (paperList.size() != 0) {
                if (time == paperList.get(0).requestTime) {
                    if (!printQueue.isEmpty()) {
                        waitingQueue.offer(paperList.get(0));
                        paperList.remove(0);
                    } else {
                        printQueue.offer(paperList.get(0));
                        paperList.remove(0);
                    }
                }
                time++;
            } else {
                break;
            }

        }

        System.out.println("time = " + time);
        System.out.println("completeTime = " + completeTime);
        for (Integer i : answerList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
