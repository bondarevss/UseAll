
import java.util.prefs.Preferences;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BS
 */

public class TestJavaFx {

    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JFXPanel jfx = new JFXPanel();
               
               
        Platform.runLater(new Runnable() {
        public void run() {
 
        WebView wv = new WebView();
        Scene scene = new Scene(wv);
        jfx.setScene(scene);
        WebEngine engine = wv.getEngine();
        engine.load("https://oauth.vk.com/authorize?client_id=5738598&redirect_uri=https://oauth.vk.com/blank.html&display=page&scope=messages,friends,offline&response_type=token&v=5.60");
      
        
      engine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> ov,
                    Worker.State oldState, Worker.State newState) {
                      
                    if (newState == Worker.State.SUCCEEDED) {
                            System.out.println(engine.getLocation());
                            if (engine.getLocation().indexOf("token=")!=-1)
                            {
                            System.out.println(engine.getLocation().substring(engine.getLocation().indexOf("token=")+6,engine.getLocation().indexOf("&expires")));
                            Preferences pref = Preferences.userRoot().node("UseAll"); 
                            pref.put("token",engine.getLocation().substring(engine.getLocation().indexOf("token=")+6,engine.getLocation().indexOf("&expires")));
                                System.out.println(pref.get("token", "no token"));
                            }
                            }
                        }
                    });
               
                
        
        }
        }
);
        
        
        
      jf.setSize(800, 500);
     jf.setVisible(true);
     jf.add(jfx);
     jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}    

