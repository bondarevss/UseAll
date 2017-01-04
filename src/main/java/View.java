
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class View extends JFrame implements InterfaceGUI {

    Action action = new Action(this);
    InterfaceController controller;
    JPanel panel = new JPanel();
    JButton bsend = new JButton("Send");

    JScrollPane scrollpane = new JScrollPane();
    JScrollPane scrollpaneJep = new JScrollPane();
    JList firendlist = new JList();

    JTextArea messagearea = new JTextArea();
    JTextArea entermessage = new JTextArea();
   // JEditorPane jep = new JEditorPane();


    public View(InterfaceController controller) throws ApiException, ClientException, IOException {
        this.controller = controller;
        bsend.setLocation(320, 350);
        bsend.setSize(80, 25);
        panel.add(bsend);
        bsend.addActionListener(action);
        
        firendlist.setListData(createfrendlist());
        firendlist.setVisibleRowCount(15);
        firendlist.addListSelectionListener(action);

        scrollpane.setLocation(10, 25);
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

//     scrollpaneJep.setLocation(405, 25);
//     scrollpaneJep.setSize(250, 385);
//     jep.setPage("https://oauth.vk.com/authorize?client_id=5738598&redirect_uri=https://oauth.vk.com/blank.html&display=page&scope=messages,friends&response_type=code&v=5.60");
//     scrollpaneJep.setViewportView(jep);
//     panel.add(scrollpaneJep);
        add(panel);

        panel.setSize(700, 400);
        panel.setLocation(10, 10);
        panel.setLayout(null);

        setLayout(null);
        setSize(800, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void setAction(Action action) {
        this.action = action;
    }
    
    public Action getAction() {
        return this.action;
    }
    
    @Override
    public void setController(InterfaceController controller) {
        this.controller = controller;
    }

    public String[] createfrendlist() throws ApiException, ClientException {
      
        return controller.getFriends();
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
