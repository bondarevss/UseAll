
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
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectVK implements InterfaceModel{
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
//      String code = "";     
//      
//      
//      //second step     
//      UserAuthResponse authResponse = vk.oauth()
//        .userAuthorizationCodeFlow(, "","https://oauth.vk.com/blank.html", code)
//        .execute();      
//      
//      String token = authResponse.getAccessToken();
//      int myId = authResponse.getUserId();
//      System.out.println(token + " " + myId );
      
      //--------------------------------------------------------------------
      // Go      
      
       String token = "";
       int myId = 0;      
    
        actor = new UserActor(myId, token);   
  
    }

public String [] createfriendmas() throws ApiException, ClientException{
    
        List <UserField> fields = new LinkedList<UserField>();
        fields.add(UserField.PERSONAL);
//        fields.add(UserField.SEX);
//        fields.add(UserField.LAST_SEEN);
//        fields.add(UserField.ABOUT);
    
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

    @Override
    public String[] getMessage(int idFriend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sendMessage(String message, int idUser) {
        try {  
            vk.messages().send(actor).message(message).userId(idUser).randomId(random.nextInt()).execute();
        } catch (Exception ex) {
            return false;   
        }
        return true;
    }

    @Override
    public String[] newMessage(int idFriend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
