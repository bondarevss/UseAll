
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;




public class View extends JFrame{
    JPanel panel = new JPanel();
    JButton bsend = new JButton("Send");
    JList<String> frendlist = new JList();
    JTextArea messagearea = new JTextArea();
    JTextArea entermessage = new JTextArea();
    
    public View() throws ApiException, ClientException{
     
     bsend.setLocation(320, 350);
     bsend.setSize(80, 25);
     panel.add(bsend);
     
     
     frendlist.setLocation(10,25);
     frendlist.setSize(100, 250);
     frendlist.setVisible(true);
     panel.add(frendlist);
     
     
     messagearea.setLocation(130, 25);
     messagearea.setSize(250, 250);
     panel.add(messagearea);
    
     entermessage.setLocation(130, 285);
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
     ConnectVK vk = new ConnectVK();
    }
}
