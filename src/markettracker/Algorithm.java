package markettracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander
 */
public class Algorithm {
    
    float curIndexPrice=0;
    
    Algorithm() {
        curIndexPrice=0;
    }
    
    public void getRealtime() {
        //Perform operations to query the stock api
        String httpRequest;
        String response="";

        httpRequest = "https://finnhub.io/api/v1/quote?symbol="+MarketTracker.currentIndex+"&token="+MarketTracker.finhubAPIToken;

        try {
            response = sendGet(httpRequest);
        } catch(Exception e) {
            ;
        }
        
        JSONObject quote = new JSONObject(response);
        
        this.curIndexPrice=Float.parseFloat(quote.get("c").toString());
    }
    
    private static String sendGet(String url) throws Exception {
        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(url).openConnection();

        // optional default is GET
        httpClient.setRequestMethod("GET");
        httpClient.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

        int responseCode = httpClient.getResponseCode();
        
        //Check if response code is anything other than 200 and if so then pause for 10 seconds and create a dialog
        if(responseCode!=200) System.out.println("Unable to update!");
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            
            httpClient.disconnect();
            
            return response.toString();
        }
        
    }
}
