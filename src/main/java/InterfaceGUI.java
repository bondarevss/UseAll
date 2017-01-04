/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Artyom
 */
public interface InterfaceGUI {
  public void sendListFriends(String [] friendlist);
  public void setMessageFriend (String [] friendmessage);
  public void setAction(Action action);
  public void setController(InterfaceController controller);
  public Action getAction();
}
