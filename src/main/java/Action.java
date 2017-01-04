
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
public class Action implements ActionListener,ListSelectionListener {
    static int indexfriend = -99;
    int idfriend=-99;
    InterfaceGUI gui;
    InterfaceModel model;
    
    public Action(InterfaceGUI gui, InterfaceController controller ) {
    this.gui = gui;    
    }
    
    public Action(InterfaceGUI gui) {
    this.gui = gui;    
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
         Object o = e.getSource();
         
//     if (o.getClass() == JButton){
//         if (idfriend!=-99)
//         {
//         String ms = v.entermessage.getText();
//             try {
//                 vk.sendmessage(ms,idfriend);
//             } catch (ApiException ex) {
//                 Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
//             } catch (ClientException ex) {
//                 Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
//             }
//         v.entermessage.setText(null);
//         
//     }
//     }
//     else if (o==v.firendlist)
//     {
//         v.messagearea.setText("messages loads...");
//     }
//     else
//     {
//         System.out.println("action");
//     }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //Object o = e.getSource();
       JList l = (JList)e.getSource();
       int tpmindex = l.getSelectedIndex();
        System.out.println("Выбран " + tpmindex);
        //idfriend = vk.friendsmas[tpmindex].id;
       // System.out.println("ID френда определён как " + idfriend);
 
    }

}   
