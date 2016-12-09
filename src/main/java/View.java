
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




public class View extends JFrame implements InterfaceGUI{
    Action action;
    JPanel panel = new JPanel();
    JButton bsend = new JButton("Send");
    
    JScrollPane scrollpane = new JScrollPane();    
    JList firendlist = new JList();
    
    JTextArea messagearea = new JTextArea();    
    JTextArea entermessage = new JTextArea();
    
    public ConnectVK vk;
    
    
    public View() throws ApiException, ClientException{
       
    
     bsend.setLocation(320, 350);
     bsend.setSize(80, 25);
     panel.add(bsend);
     bsend.addActionListener(action);      
    
     //firendlist.setListData(createfrendlist());
     firendlist.setVisibleRowCount(15);  
     firendlist.addListSelectionListener(action);   
     
     scrollpane.setLocation(10,25);
     scrollpane.setSize(120, 250);
     scrollpane.setViewportView(firendlist);
     panel.add(scrollpane);
      
     
     
     messagearea.setLocation(150, 25);
     messagearea.setSize(250, 250);
     messagearea.setLineWrap(true);
     messagearea.setWrapStyleWord(true);
     panel.add(messagearea);
    
     entermessage.setLocation(150, 285);
     entermessage.setSize(250, 50);
     entermessage.setLineWrap(true);
     entermessage.setWrapStyleWord(true);    
 
     panel.add(entermessage);
     
     add(panel);
     
     panel.setSize(400, 400);
     panel.setLocation(10, 10);
     panel.setLayout(null);
     
     setLayout(null);
     setSize(500, 500);
     setVisible(true);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     
    }

    
    public void setAction(Action action)
    {
         this.action = action;
    }
public String [] createfrendlist() throws ApiException, ClientException{
    return vk.createfriendmas();
}

    @Override
    public void sendListFriends(String[] friendlist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMessageFriend(String[] friendmessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


