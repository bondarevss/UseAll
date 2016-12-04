
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




public class View extends JFrame{
    JPanel panel = new JPanel();
    JButton bsend = new JButton("Send");
    
    JScrollPane scrollpane = new JScrollPane();    
    JList firendlist = new JList();
    
    JTextArea messagearea = new JTextArea();    
    JTextArea entermessage = new JTextArea();
    
    Actions actions;
    public ConnectVK vk;
    
    
    public View() throws ApiException, ClientException{
        
     vk = new ConnectVK();
     actions = new Actions(this, vk);
     
    
     bsend.setLocation(320, 350);
     bsend.setSize(80, 25);
     panel.add(bsend);
     bsend.addActionListener(actions);      
    
     firendlist.setListData(createfrendlist());
     firendlist.setVisibleRowCount(15);  
     firendlist.addListSelectionListener(actions);   
     
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

public String [] createfrendlist() throws ApiException, ClientException{
    return vk.createfriendmas();
}
}

class Actions implements ActionListener,ListSelectionListener{
    View v;
    ConnectVK vk;
    static int indexfriend = -99;
    int idfriend=-99;
    public Actions(View view, ConnectVK vk) {
    v = view;
    this.vk = vk;
    
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
         Object o = e.getSource();
     if (o==v.bsend){
         if (idfriend!=-99)
         {
         String ms = v.entermessage.getText();
             try {
                 vk.sendmessage(ms,idfriend);
             } catch (ApiException ex) {
                 Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClientException ex) {
                 Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
             }
         v.entermessage.setText(null);
         
     }
     }
     else if (o==v.firendlist)
     {
         v.messagearea.setText("messages loads...");
     }
     else
     {
         System.out.println("action");
     }
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
