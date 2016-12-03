
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.apps.responses.GetResponse;
import com.vk.api.sdk.queries.users.UserField;
import java.util.ArrayList;
import java.util.Random;


public class ConnectVK {
    VkApiClient vk;
    UserActor actor;
    Random random ;
    Friend friendsmas [];
    int friendcnt;
    
    
    public ConnectVK() throws ApiException, ClientException {
      
      random = new Random();    
      TransportClient transportClient = HttpTransportClient.getInstance();
      vk = new VkApiClient(transportClient); 
      
      
      //it's just for first run only. Need to get code and token and myId ---------
      //first step. You need  code      
//      String code = "69ff7f9593c60164e5";     
//      
//      
//      //second step     
//      UserAuthResponse authResponse = vk.oauth()
//        .userAuthorizationCodeFlow(5738598, "kkJCdcP3K4LVga14Evdi","https://oauth.vk.com/blank.html", code)
//        .execute();      
//      
//      String token = authResponse.getAccessToken();
//      int myId = authResponse.getUserId();
//      System.out.println(token + " " + myId );
      
      //--------------------------------------------------------------------
      // Go      
      String token = "";
      int myId = 1286612;
      
        actor = new UserActor(myId, token);
        ArrayList<String> l = new ArrayList();
        //l=vk.friends().get(null).execute();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!! " + vk.friends().get(actor).execute());
  
    }
public void sendmessage (String msg,int id) throws ApiException, ClientException{
 vk.messages().send(actor).message(msg).userId(id).randomId(random.nextInt()).execute();   
}

public void createfriendmas(){
    friendsmas = new Friend[2];
    Friend f1 = new Friend("Артём", "Смоляк", null, 13298515);
    friendsmas[0]=f1;
    Friend f2 = new Friend("Сергей", "Бондарев", null, 1286612);
    friendsmas[1]=f2;
}

public void pursinformation(){

}
    
}
