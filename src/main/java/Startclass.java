
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
    public static void main(String[] args) throws ApiException, ClientException, IOException, Exception {
        //View v = new View();
        
        Controller c = new Controller(new View(), new ConnectVK());
        
       // c.setGUI(v);
        // TODO
        //1. Упростить старт класс +
        // 2. Изменить конструктор View + 
        // 3. Доделать актион +
        // 4. Получить список сообщений + -  
        // 5. Сделать сворачивание в трей 
        // 6. Уведомление из трея
        // 7. Собрать установщик 
        
        // 8. доработать получение токена
        
    }
}
