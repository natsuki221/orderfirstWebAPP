package orderfirst.orderpos.dbGetData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import net.sf.json.JSON;
//import org.json.JSONObject;
import net.sf.json.JSONObject;

public class GetJSON {

    Connection conn;

    static final String url1 = "https://api.jotform.com/form/221351734915454/submissions?apiKey=dd8927189d0d2f34827b7d9d9135abec&limit=1&orderby=created_at";
    static final String url2 = "https://api.jotform.com/form/221571117004442/submissions?apiKey=dd8927189d0d2f34827b7d9d9135abec&limit=1&orderby=created_at";
    static final String url3 = "https://api.jotform.com/form/221604300991448/submissions?apiKey=dd8927189d0d2f34827b7d9d9135abec&limit=1&orderby=created_at";
    static final String url4 = "https://api.jotform.com/form/221621676000444/submissions?apiKey=dd8927189d0d2f34827b7d9d9135abec&limit=1&orderby=created_at";

    public static JSON temp() throws IOException {
        
        JSON jsonObject = null;
        // 我們需要進行請求的地址：
        try {
            // 1.URL類封裝了大量複雜的實現細節，這裡將一個字串構造成一個URL物件
            URL url = new URL(url1);
            // 2.獲取HttpURRLConnection物件
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 3.呼叫connect方法連線遠端資源
            connection.connect();
            // 4.訪問資源資料，使用getInputStream方法獲取一個輸入流用以讀取資訊
            BufferedReader bReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            // 對資料進行訪問
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // 關閉流
            bReader.close();
            // 關閉連結
            connection.disconnect();
            // 列印獲取的結果
            System.out.println(stringBuilder.toString());

            // 將獲得的String物件轉為JSON格式
            jsonObject = JSONObject.fromObject(stringBuilder.toString());
            
            
/*
            // 通過利用JSON鍵值對的key，來查詢value
            System.out.println("book name : " + jsonObject.get("subtitle").toString());
            System.out.println("author : " + jsonObject.get("author").toString());
            System.out.println("summary : " + jsonObject.get("summary").toString());

            // 對於value也是JSON的物件，將物件的value轉為一個新的JSON繼續進行
            JSONObject aObject = JSONObject.fromObject(jsonObject.get("images").toString());
            System.out.println("images:  " + aObject.get("small").toString());
*/

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        return jsonObject;
        
        

    }

}
