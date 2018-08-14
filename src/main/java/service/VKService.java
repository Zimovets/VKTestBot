package service;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class VKService {
    private final String REDIRECT_URL = "https://oauth.vk.com/blank.html";
    private final String VK_AUTH_URL = "https://oauth.vk.com/authorize?client_id=6661409&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=code&v=5.80";
    public static String token;

    public void init() throws Exception {
        Stage stage = new Stage();
        final WebView view = new WebView();
        final WebEngine engine = view.getEngine();
        engine.load(VK_AUTH_URL);
        stage.setScene(new Scene(view));
        stage.show();
        engine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
                if (newValue.contains("#code=")) {
                    String[] split = newValue.split("#code=");
                    token = split[1];
                    System.out.println(token);
                    stage.close();
                }
            }

        });
    }
}
