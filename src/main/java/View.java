
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




public class View extends JFrame{
    JPanel panel = new JPanel();
    JButton bsend = new JButton("Send");
    JList<String> firendlist = new JList();
    JTextArea messagearea = new JTextArea();
    JTextArea entermessage = new JTextArea();
    Actions actions;
    public ConnectVK vk;
    
    public View() throws ApiException, ClientException{
     vk = new ConnectVK();
     actions = new Actions(this, vk);
     createfrendlist();
     bsend.setLocation(320, 350);
     bsend.setSize(80, 25);
     panel.add(bsend);
     bsend.addActionListener(actions);
     
     firendlist.setListData(createfrendlist());
     firendlist.setLocation(10,25);
     firendlist.setSize(120, 250);
     firendlist.setVisible(true);
     panel.add(firendlist);
     firendlist.addListSelectionListener(actions);
    
     
     
     messagearea.setLocation(150, 25);
     messagearea.setSize(250, 250);
     panel.add(messagearea);
    
     entermessage.setLocation(150, 285);
     entermessage.setSize(250, 50);
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

public String [] createfrendlist(){
    vk.createfriendmas();
    String [] myfriends = new String[vk.friendsmas.length];
    for (int i = 0; i < vk.friendsmas.length; i++) {
        myfriends[i]= vk.friendsmas[i].name + " " + vk.friendsmas[i].lastname;
    }
    return myfriends;
}
}

class Actions implements ActionListener,ListSelectionListener{
    View v;
    ConnectVK vk;
    public Actions(View view, ConnectVK vk) {
    v = view;
    this.vk = vk;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
         Object o = e.getSource();
     if (o==v.bsend){
         System.out.println(v.entermessage.getText());
         String ms = v.entermessage.getText();
             try {
                 vk.sendmessage(ms,1286612);
             } catch (ApiException ex) {
                 Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClientException ex) {
                 Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
             }
         v.entermessage.setText(null);
         
     }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //Object o = e.getSource();
       JList l = (JList)e.getSource();
       int tpmindex = l.getSelectedIndex();
        System.out.println("ВЫбран" + tpmindex); 
    }

}
