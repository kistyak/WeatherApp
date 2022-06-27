package com.example.weth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_check;

    @FXML
    private TextField city_field;

    @FXML
    private Text temperature;

    @FXML
    void initialize() {
        button_check.setOnAction(event -> {String getUserCity = city_field.getText().trim();
            if(!getUserCity.equals("")) {
                String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=9216b7139d09d067bd79fa033a895148&units=metric");
                if (!output.isEmpty()) {
                  JSONObject obj = new JSONObject(output);
                    temperature.setText("Temperature: " + obj.getJSONObject("main").getDouble("temp"));
                }
            }
        });
    }
    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("Wrong city");
        }
        return content.toString();
    }
}
