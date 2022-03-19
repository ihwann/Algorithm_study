package CodingTest;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 리눅스의 쉘 명령어가 하는 일을 유사하게 따라 하는 프로그램을 작성하려고 합니다.
 *
 * 다음 세 가지 명령어가 동작하도록 프로그램을 작성해주세요.
 *
 * 1.
 * 이름	mkdir
 * 사용 방법	mkdir directory
 * 설명	특정 위치에 디렉토리를 생성합니다.
 * 2.
 * 이름	rm
 * 사용 방법	rm directory
 * 설명	특정 디렉토리를 삭제합니다. 삭제한 디렉토리의 하위 디렉토리들 또한 함께 삭제됩니다.
 * 3.
 * 이름	cp
 * 사용 방법	cp source dest
 * 설명	source 디렉토리를 dest로 복사합니다. source 디렉토리의 하위 디렉토리들 또한 복사되어야 합니다.
 * 위 명령을 수행할 시스템에는 오직 디렉토리만 존재하며, 최상위 디렉토리는 "/"로 표시하고 그 하위 디렉토리는 "/root", "/usr", "/tmp", "/tmp/tmp2"와 같이 구분합니다.
 *
 * 제한사항
 * directory는 시스템의 디렉토리 구조를 나타내는 문자열 배열입니다.
 *
 * directory의 길이는 1 이상 20 이하입니다.
 * directory의 원소는 각 디렉토리의 절대 경로(최상위 디렉토리부터의 경로)를 나타냅니다.
 * 시스템상의 모든 디렉토리에 대한 경로가 주어집니다.
 * 각 디렉토리 이름은 길이가 1 이상 10 이하입니다.
 * 경로를 나타내는 문자열은 알파벳 소문자와 '/' 로만 이루어져 있습니다.
 * 한 디렉토리 안에 같은 이름의 디렉토리가 두 개 이상 있는 경우는 없으며, 또한 잘못된 경로가 주어지는 경우는 없습니다.
 * 디렉토리 경로는 사전 순으로 정렬되어 주어집니다.
 * command는 명령어들이 담긴 문자열 배열입니다.
 *
 * command의 길이는 1 이상 20 이하입니다.
 * command의 원소는 쉘 명령어를 나타내는 문자열입니다.
 * 문제에 주어진 명령어만 입력으로 주어지며, 잘못된 경로가 주어지는 경우는 없습니다.
 * 경로는 항상 절대 경로(최상위 디렉토리부터의 경로)로만 주어집니다.
 * cp명령의 경우 자기 자신의 하위 디렉토리에 복사하는 명령은 주어지지 않습니다.
 * cp명령의 경우 복사하는 위치에 이름이 동일한 다른 디렉토리가 이미 있는 경우는 주어지지 않습니다.
 * "rm /" 명령은 입력으로 주어지지 않습니다.
 * rm 명령은 항상 디렉토리 하나를 정상적으로 삭제하는 경우만 입력으로 주어집니다. (존재하지 않거나 잘못된 경로, 없는 디렉토리 등을 삭제하는 경우는 없습니다)
 * mkdir 명령은 항상 디렉토리 하나를 정상적으로 생성하는 경우만 입력으로 주어집니다. (존재하지 않거나 잘못된 경로, 해당 경로에 같은 이름의 디렉토리가 이미 있는 경우, 중간 경로에 해당하는 디렉토리가 없는 경우 등은 입력으로 주어지지 않습니다.)
 * 모든 명령어를 수행한 후 디렉토리 구조를 문자열 형태로 배열에 담아 사전 순으로 정렬해서 return해주세요.
 *
 * 입력되는 디렉토리 구조와 마찬가지로, 모든 디렉토리에 대한 절대 경로를 문자열 형태로 담은 뒤 사전 순으로 정렬해서 return 하면 됩니다.
 * '/'가 알파벳보다 사전 순으로 더 앞에 온다고 가정합니다.
 * 입출력 예 #1
 * directory
 * [
 * "/",
 * "/hello",
 * "/hello/tmp",
 * "/root",
 * "/root/abcd",
 * "/root/abcd/etc",
 * "/root/abcd/hello"
 * ]
 * command
 * [
 * "mkdir /root/tmp",
 * "cp /hello /root/tmp",
 * "rm /hello"
 * ]
 * result
 * [
 * "/",
 * "/root",
 * "/root/abcd",
 * "/root/abcd/etc",
 * "/root/abcd/hello",
 * "/root/tmp",
 * "/root/tmp/hello",
 * "/root/tmp/hello/tmp"
 * ]
 * 입출력 예 #2
 * directory
 * [
 * "/"
 * ]
 * command
 * [
 * "mkdir /a",
 * "mkdir /a/b",
 * "mkdir /a/b/c",
 * "cp /a/b /",
 * "rm /a/b/c"
 * ]
 * result
 * [
 * "/",
 * "/a",
 * "/a/b",
 * "/b",
 * "/b/c"
 * ]
 */
public class KakaoBank02 {
    public static void main(String[] args) {
        String[] directory = {"/"};

        String[] command = {"mkdir /a",
                "mkdir /a/b",
                "mkdir /a/b/c",
                "cp /a/b /",
                "rm /a/b/c"};


        List<String> directoryList = new LinkedList<>();
        for (String dir : directory) {
            directoryList.add(dir);
        }

        for (String cmd : command) {
            if (cmd.startsWith("mkdir")) {
                String makeDirectory = cmd.split(" ")[1];
                directoryList.add(makeDirectory);
                continue;
            }

            if (cmd.startsWith("rm")) {
                String removeDirectory = cmd.split(" ")[1];

                directoryList.removeIf(dir -> dir.startsWith(removeDirectory));
            }

            if (cmd.startsWith("cp")) {
                String sourceDirectory = cmd.split(" ")[1].substring(directoryList.lastIndexOf("/"));
                String targetDirectory = cmd.split(" ")[2];
                for (int i = 0; i < directoryList.size(); i++) {
                    String dir = directoryList.get(i);
                    if (dir.startsWith(sourceDirectory)) {
                        directoryList.add(targetDirectory + dir);
                    }
                }
            }
        }

        Collections.sort(directoryList);

        for (String s : directoryList) {
            System.out.println(s);
        }
        //directoryList.toArray(new String[0]);
    }
}
