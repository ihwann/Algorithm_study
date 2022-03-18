package restapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PostRequestDemoRestApi {
    private static final String HOST_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {
        String s = "{ \"userId\" : \"1\", \"id\" : \"2\" }";

        try {
            URL url = new URL(HOST_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try {
                OutputStream os = conn.getOutputStream();
                byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
                os.write(bytes);
                os.close();
            } catch (Exception e) {
                e.getMessage();
            }


            conn.connect();

            //http 요청 후 응답 받은 데이터를 버퍼에 쌓는다
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String responseData;
            String returnData;
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer에 응답받은 데이터 순차적으로 저장 실시
            }

            //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입 실시
            returnData = sb.toString();
            JsonElement e = new JsonParser().parse(returnData).getAsJsonObject().get("id");

            //http 요청 응답 코드 확인 실시
            String responseCode = String.valueOf(conn.getResponseCode());
            System.out.println("http 응답 코드 : " + responseCode);
            System.out.println("http 응답 데이터 : " + e.getAsInt());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
