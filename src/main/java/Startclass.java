
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

        Controller c = new Controller(new View(), new ConnectVK());

    }
}
