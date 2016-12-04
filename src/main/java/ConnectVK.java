
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.apps.responses.GetResponse;
import com.vk.api.sdk.objects.friends.UserXtrLists;
import com.vk.api.sdk.objects.friends.responses.GetFieldsResponse;
import com.vk.api.sdk.queries.users.UserField;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
      
       String token = "016e3918979dce82476645e7ebada2aeedbb86030b4f94247792ed25fec8adadd651f0578529125ab75a5";
      //String token = "5afe700dce30ff5dc08e89f340da6476ed5a1515dcd2992285ddd4956ae5bd00fec92f8c44801e6179ab5";
      int myId = 13298515;
      
      
      //String token = "";
      //int myId = 1286612;
      
        actor = new UserActor(myId, token);

        
        
        //GetFieldsResponse gfr = vk.friends().get(actor, fields).execute();
        //l=vk.friends().get(null).execute();
       // List <UserXtrLists> list =  gfr.getItems();
        
    // for(int i = 0; i < gfr.getCount(); i++) 
    // {
    //     UserXtrLists user = list.get(i);
    //     System.out.println("friends " + user.getFirstName() + " " + user.getLastName() );
    // }
        
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!! " + vk.friends().get(actor,  ).execute());
  
    }
public void sendmessage (String msg,int id) throws ApiException, ClientException{
 vk.messages().send(actor).message(msg).userId(id).randomId(random.nextInt()).execute();   
}

public String [] createfriendmas() throws ApiException, ClientException{
    
        List <UserField> fields = new LinkedList<UserField>();
        fields.add(UserField.PERSONAL);
//        fields.add(UserField.SEX);
//        fields.add(UserField.LAST_SEEN);
//        fields.add(UserField.ABOUT);
//        fields.add(UserField.BDATE);
//        fields.add(UserField.CITY);
//        fields.add(UserField.CONTACTS);
//        fields.add(UserField.EDUCATION);
    
     GetFieldsResponse response = vk.friends().get(actor, fields).execute();
     List <UserXtrLists> UsersList =  response.getItems();    
     
     String [] myfriends = new String[UsersList.size()];

      for(int i = 0; i < UsersList.size(); i++) 
     {
         UserXtrLists user = UsersList.get(i);
         myfriends[i] = user.getFirstName() + " " + user.getLastName();         
     }     
      
      return myfriends;
}

public void pursinformation(){

}
    
}
