
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Artyom
 */
public class Controller implements InterfaceController, ActionListener, ListSelectionListener {

    InterfaceModel model;
    InterfaceGUI gui;
    int idfriend = -99;

    public Controller(InterfaceGUI gui, InterfaceModel model) throws Exception {
        this.model = model;
        this.gui = gui;
        gui.setController(this);
    }

    @Override
    public boolean sendMessage(String message, int idUser) {
        return model.sendMessage(message, idUser);
    }

    @Override
    public String[] getMessage() {
        return null;
    }

    @Override
    public String[] getFriends(Friend[] friends) throws ApiException, ClientException {
        return model.getFriends(friends);
    }
    
 
  
    

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o instanceof JButton) {

            JButton button = (JButton) o;
            if (button.getText().equals("Send")) {
                if (idfriend != -99) {
                    String ms = ((View) gui).entermessage.getText();

                    model.sendMessage(ms, idfriend);

                    ((View) gui).entermessage.setText(null);

                }
            } else if (o instanceof JList) 
                {

                    ((View) gui).messagearea.setText("messages loads...");
                }
                else
     {
         System.out.println("action");
     }
            }
        }
    
     
     

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //Object o = e.getSource();
       String oneStrMessage= "";
       JList l = (JList)e.getSource();
       int tpmindex = l.getSelectedIndex();
        System.out.println("Выбран " + tpmindex);
        try {
            
            String [] temp = model.getMessage(2);
            for (int i = 0; i < temp.length; i++) {
               oneStrMessage+=temp[i] + "\n";
            }
        } catch (ApiException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClientException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
            
      
        ((View) gui).messagearea.setText(oneStrMessage);
        //idfriend = vk.friendsmas[tpmindex].id;
       // System.out.println("ID френда определён как " + idfriend);
 
    }

   
    
}
