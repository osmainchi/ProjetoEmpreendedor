/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

 import java.io.BufferedReader;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import org.apache.http.HttpEntity;
    import org.apache.http.HttpResponse;
    import org.apache.http.client.HttpClient;
    import org.apache.http.client.methods.HttpPost;
    import org.apache.http.impl.client.DefaultHttpClient;
    import org.json.simple.JSONArray;
    import org.json.simple.JSONObject;
    import org.json.simple.parser.JSONParser;
    import org.json.simple.parser.ParseException;

public class BuscarCoordenadas {

  public static Object Longitude(String endereco) throws ParseException  {
        InputStream inputStream = null;
        String address = endereco;
        String json = "";
        address = address.replaceAll(" ","+");
        String key = "AIzaSyDjwP3KYfk7OxC1DBySQ37n-v_88Q45mgE";
        try {           
            HttpClient client = new DefaultHttpClient();  
            HttpPost post = new HttpPost("https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key="+key);
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            inputStream = entity.getContent();
        } catch(Exception e) {
        }

        try {           
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"),8);
            StringBuilder sbuild = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sbuild.append(line);
            }
            inputStream.close();
            json = sbuild.toString();               
        } catch(Exception e) {
        }


        //now parse
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        JSONObject jb = (JSONObject) obj;

        //now read
        JSONArray jsonObject1 = (JSONArray) jb.get("results");
        JSONObject jsonObject2 = (JSONObject)jsonObject1.get(0);
        JSONObject jsonObject3 = (JSONObject)jsonObject2.get("geometry");
        JSONObject location = (JSONObject) jsonObject3.get("location");

        return location.get("lat");
        


    }
  
    public static Object Latitude(String endereco) throws ParseException  {
        InputStream inputStream = null;
        String address = endereco;
        String json = "";
        address = address.replaceAll(" ","+");
        String key = "AIzaSyDjwP3KYfk7OxC1DBySQ37n-v_88Q45mgE";
        try {           
            HttpClient client = new DefaultHttpClient();  
            HttpPost post = new HttpPost("https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key="+key);
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            inputStream = entity.getContent();
        } catch(Exception e) {
        }

        try {           
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"),8);
            StringBuilder sbuild = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sbuild.append(line);
            }
            inputStream.close();
            json = sbuild.toString();               
        } catch(Exception e) {
        }


        //now parse
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        JSONObject jb = (JSONObject) obj;

        //now read
        JSONArray jsonObject1 = (JSONArray) jb.get("results");
        JSONObject jsonObject2 = (JSONObject)jsonObject1.get(0);
        JSONObject jsonObject3 = (JSONObject)jsonObject2.get("geometry");
        JSONObject location = (JSONObject) jsonObject3.get("location");
       
        return location.get("lng");


    }
}
