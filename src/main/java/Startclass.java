
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BS
 */
public class Startclass {
    public static void main(String[] args) throws ApiException, ClientException, IOException {
        //View v = new View();

        ConnectVK vk = new ConnectVK();
        Controller c = new Controller(vk);
        View v = new View(c);
        c.setGUI(v);
        // TODO
        //1. Упростить старт класс
        // 2. Изменить конструктор View
        // 3. Доделать актион
        // 4. Получить список сообщений 
        
    }
}
