
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import java.util.Random;


public class ConnectVK {
    
    public ConnectVK() throws ApiException, ClientException {
      Random random = new Random();  
        
      TransportClient transportClient = HttpTransportClient.getInstance();
      VkApiClient vk = new VkApiClient(transportClient); 
      
      
      //it's just for first run only. Need to get code and token and myId ---------
      //first step. You need  code      
      String code = "afa5a1d378bb22fd54";     
      
      
      //second step     
      UserAuthResponse authResponse = vk.oauth()
        .userAuthorizationCodeFlow(5738598, "kkJCdcP3K4LVga14Evdi","https://oauth.vk.com/blank.html", code)
        .execute();      
      
      String token = authResponse.getAccessToken();
      int myId = authResponse.getUserId();
      System.out.println(token + " " + myId );
      
      //--------------------------------------------------------------------
      // Go      
      
        //UserActor actor = new UserActor(myId, token);
        //vk.messages().send(actor).userId(13298515).message("Java проверочка");
        //vk.messages().send(actor).message("отправление сообщений работает. прием:)").userId(1286612).randomId(random.nextInt()).execute();
    }

    
}
