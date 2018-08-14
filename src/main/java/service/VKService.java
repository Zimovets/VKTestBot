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
    public static String tokenUrl;

//    {Stage statisticsStage = new Stage();
//        statisticsStage.initModality(Modality.APPLICATION_MODAL);
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(this.getClass().getResource("/fxml/statistics_window.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Scene scene = new Scene(root, 700, 500);
//        statisticsStage.setTitle("Statistics");
//        statisticsStage.setScene(scene);
//        statisticsStage.show();}

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
                if (newValue.startsWith(REDIRECT_URL)) {
                    tokenUrl = newValue;
                    stage.close();
                }
            }

        });
        System.out.println(tokenUrl);
    }
}
