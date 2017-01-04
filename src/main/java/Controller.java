
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Artyom
 */
public class Controller implements InterfaceController{
InterfaceModel model;
InterfaceGUI gui;
Action action; 

    public Controller(InterfaceGUI gui, InterfaceModel model) {
        this.model = model;
        //this.gui = gui;
        
        action = new Action(gui, this);
        //gui.setAction(action);
        //gui.setController(this);
       }
    public Controller(InterfaceModel model) {
        this.model = model;
        //action = new Action(gui, this);

       }
    
    public void setGUI(InterfaceGUI gui){
       this.gui = gui; 
       
       action = gui.getAction();
       
    }

    @Override
    public boolean sendMessage(String message, int idUser) {
      return model.sendMessage(message, idUser);
    }
    @Override
    public String[] getMessage() {
       return null;
    }
    
    public String [] getFriends() throws ApiException, ClientException {
     return model.getFriends();
    }
    
}
