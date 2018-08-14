package service;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class VKService {

    private final String CLIENT_SECRET = "9DauaMckRmsmzoUogJ0a";
    private final String REDIRECT_URI = "https://oauth.vk.com/blank.html";
    private final String VK_AUTH_URL = "https://oauth.vk.com/authorize?client_id=6661409&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=code&v=5.80";
    private final Integer APP_ID = 6661409;
    private String code;

    private VkApiClient vk;
    private UserActor actor;

    public void doWork() throws Exception {
        initCode();
    }

    private void initCode() throws Exception {
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
                    code = split[1];
                    System.out.println(code);
                    try {
                        initClient();
                    } catch (ClientException e) {
                        e.printStackTrace();
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                    stage.close();
                }
            }

        });
    }

    private void initClient() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        vk = new VkApiClient(transportClient);
        System.out.println(vk.toString());

        UserAuthResponse authResponse = vk.oauth()
                .userAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
                .execute();

        actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
        System.out.println(actor.toString());
    }
}
