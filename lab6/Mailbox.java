package labs.lab6;

import java.util.ArrayList;

/**
 * An email mailbox.
 */
public class Mailbox {
	private String user;
	private ArrayList<Message> messages;

	/**
	 * Constructs a Mailbox object.
	 * 
	 * @param user the user
	 */
	public Mailbox(String user) {
		this.user = user;
		messages = new ArrayList<Message>();
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user of this mailbox
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Adds a message to the mailbox.
	 * 
	 * @param m the message to add
	 */
	public void addMessage(Message m) {
		messages.add(m);
	}

	/**
	 * Retrieves text of all messages, in the following format:
	 * -----
	 * [MESSAGE1]
	 * -----
	 * [MESSAGE2]
	 * 
	 * etc.
	 */
	public String getAllMessages() {
		String res = "";
		for (Message m: messages) {
			res += " -----\n" + m;
		}
		return res;
	}
}
