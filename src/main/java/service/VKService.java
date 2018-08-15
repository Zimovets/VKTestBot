package service;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.queries.users.UserField;
import domain.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VKService {

    private final String CLIENT_SECRET = "9DauaMckRmsmzoUogJ0a";
    private final String REDIRECT_URI = "https://oauth.vk.com/blank.html";
    private final String VK_AUTH_URL = "https://oauth.vk.com/authorize?client_id=6661409&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=code&v=5.80";
    private final Integer APP_ID = 6661409;
    private String code;

    private VkApiClient vk;
    private UserActor actor;

    public static Set<User> users;

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
                if (newValue.contains("#code=")) {
                    String[] split = newValue.split("#code=");
                    code = split[1];
                    try {
                        initClient();
                        initRecentUsers();
                    } catch (ClientException e) {
                        e.printStackTrace();
                    } catch (ApiException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stage.close();
                }
            }

        });

    }

    private void initRecentUsers() throws ClientException, ApiException, InterruptedException {
        users = new HashSet<>();
        List<Integer> usersId = vk.friends().getRecent(actor).execute();
        List<String> userIdString = usersId.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());
        List<UserXtrCounters> userXtrCounters = vk.users().get(actor).userIds(userIdString)
                .fields(UserField.MAIDEN_NAME, UserField.BDATE, UserField.CONTACTS, UserField.HOME_TOWN).execute();
        userXtrCounters.stream()
                .forEach(user -> users.add(new User(user.getFirstName(), user.getLastName(), user.getBdate(), user.getMobilePhone(), user.getHomeTown())));
    }

    private void initClient() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        vk = new VkApiClient(transportClient);
        UserAuthResponse authResponse = vk.oauth()
                .userAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
                .execute();
        actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }
}
