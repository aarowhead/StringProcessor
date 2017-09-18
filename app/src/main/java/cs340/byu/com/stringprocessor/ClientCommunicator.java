package cs340.byu.com.stringprocessor;

import com.google.gson.Gson;
import com.shared.IntPasser;
import com.shared.StringPasser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//Singleton
public class ClientCommunicator {

    private String serverIp = "localhost";
    private String port = "8080";
    private String baseUrl;

    private void write(String jsonStr, HttpURLConnection http) throws IOException{
        Writer myWriter = new OutputStreamWriter(http.getOutputStream());
        myWriter.write(jsonStr);
        myWriter.flush();
        myWriter.close();
    }

    private static ClientCommunicator communicator;

    private ClientCommunicator(){
        baseUrl = "http://" + serverIp + ":" + port;
    }

    public static ClientCommunicator getInstance(){
        if(communicator == null){
            communicator = new ClientCommunicator();
        }
        return communicator;
    }

    public <T> T sendRequest(String urlSuffix, Object editString, Class<T> returnType){
        try {
            Gson gson = new Gson();

            URL url = new URL(baseUrl + urlSuffix);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.addRequestProperty("Content-Type", "application/json");
            http.connect();

            String jsonStr = gson.toJson(editString);

            write(jsonStr, http);

            if(http.getResponseCode() == HttpURLConnection.HTTP_OK){
                Reader myReader = new InputStreamReader(http.getInputStream());

                return gson.fromJson(myReader, returnType);
            }else if(http.getResponseCode() == HttpURLConnection.HTTP_NOT_ACCEPTABLE){
                throw new NumberFormatException();
            }


        }catch (IOException e){
            System.out.println("IOException: " + e);
            e.printStackTrace();
        }

        return null;
    }

}
