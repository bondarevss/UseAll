
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;


public class ConnectVK {
    
    public ConnectVK() throws ApiException, ClientException {
      TransportClient transportClient = HttpTransportClient.getInstance();
      VkApiClient vk = new VkApiClient(transportClient); 
      UserAuthResponse authResponse = vk.oauth()
        .userAuthorizationCodeFlow(5738598, "kkJCdcP3K4LVga14Evdi","https://oauth.vk.com/blank.html", "afa5a1d378bb22fd54")
        .execute();
      
        UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
        //vk.messages().send(actor).userId(13298515).message("Тестируем UseALL");
        
    }

    
}
