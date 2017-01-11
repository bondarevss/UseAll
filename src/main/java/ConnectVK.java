
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
import java.util.prefs.Preferences;


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
      FirstWindow firstwindow = new FirstWindow();
      
      
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
      
      Preferences pref = Preferences.userRoot().node("UseAll"); 
     // pref.put("token",engine.getLocation().substring(engine.getLocation().indexOf("token=")+6,engine.getLocation().indexOf("&expires")));
      System.out.println(pref.get("token", "no token")); 
      System.out.println(pref.get("user_id", "no user_id"));
      
      while (pref.get("token", "no token").equals("no token") || pref.get("user_id", "no user_id").equals("no user_id")){
          firstwindow.getFirstWindow();
          
      }
      String token = pref.get("token", "no token");
      int myId = Integer.parseInt(pref.get("user_id", "no user_id"));
      
      
      
          
            
        actor = new UserActor(myId, token);   
  
    }

    @Override
    public String [] getFriends(Friend [] friends) throws ApiException, ClientException{
    
        List <UserField> fields = new LinkedList<UserField>();
        fields.add(UserField.PERSONAL);
//        fields.add(UserField.SEX);
//        fields.add(UserField.LAST_SEEN);
//        fields.add(UserField.ABOUT);
    
     GetFieldsResponse response = vk.friends().get(actor, fields).execute();
     List <UserXtrLists> UsersList =  response.getItems();    
     
     String [] myfriends = new String[UsersList.size()];
      friends = new Friend[UsersList.size()];

      for(int i = 0; i < UsersList.size(); i++) 
     {
         UserXtrLists user = UsersList.get(i);
         myfriends[i] = user.getFirstName() + " " + user.getLastName(); 
         friends[i] = new Friend (user.getFirstName(),user.getLastName(), user.getNickname(), user.getId());
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
