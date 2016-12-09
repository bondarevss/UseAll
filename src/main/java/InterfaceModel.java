/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Artyom
 */
public interface InterfaceModel {
   public String[] getMessage(int idFriend); 
   public boolean sendMessage(String message,int idUser);
   public String[] newMessage (int idFriend);
}
