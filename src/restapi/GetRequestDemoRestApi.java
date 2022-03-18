package restapi;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetRequestDemoRestApi {
    private static final String HOST_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws UnsupportedEncodingException {

        HttpURLConnection conn = null;

        // GET 방식 파라미터 생성
        StringBuffer params = new StringBuffer();
        Map<String, String> parameters = new HashMap<>();
        String strParam = paramMapToString(parameters);

        try {
            URL url = new URL(HOST_URL + strParam);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            //conn.setRequestProperty("Token", null);
            conn.setDoOutput(true);
            conn.addRequestProperty("Content-Type", "application/json");


            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String lines = null;
                while ((lines = br.readLine()) != null) {
                    sb.append(br.readLine());
                }
                JsonObject jsonObject = new Gson().fromJson(String.valueOf(sb), JsonObject.class).getAsJsonObject("data");
                System.out.println(jsonObject);
            } else {
                System.out.println("responseCode = " + responseCode);
                System.out.println("responseMessage = " + conn.getResponseMessage());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String paramMapToString(Map<String, String> paramMap) {
        StringBuffer sb = new StringBuffer();

        if (!paramMap.isEmpty()) {
            Iterator<Map.Entry<String, String>> iterator = paramMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> param = iterator.next();
                sb.append(param.getKey()).append("=").append(param.getValue());

                if (iterator.hasNext()) {
                    sb.append("&");
                }
            }
        }

        return sb.toString();
    }
}
