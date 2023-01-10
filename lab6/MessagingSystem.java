package labs.lab6;

import java.util.ArrayList;

/**
 * An email messaging system.
 */
public class MessagingSystem {
	private ArrayList<Mailbox> mailboxes;

	/**
	 * Constructs a MessagingSystem object
	 */
	public MessagingSystem() {
		mailboxes = new ArrayList<Mailbox>();
	}


	/**
	 * Delivers a message to the recipient
	 * 
	 * @param sender		message sender
	 * @param recipient		message recipient
	 * @param text			text of the message
	 */
	public void deliver(String sender, String recipient, String text) {
		boolean exist = false;
		for (Mailbox m: mailboxes) {
			if (m.getUser() == recipient) {
				m.addMessage(new Message(sender, recipient, text));
				exist = true;
			}
		}
		if (exist == false) {
			Mailbox temp = new Mailbox(recipient);
			temp.addMessage(new Message(sender, recipient, text));
			mailboxes.add(temp);	
		}
	}

	
	/**
	 * Retrieves the messages for a user
	 * 
	 * @param user the user
	 */
	public String getMessages(String user) {
		for (Mailbox m: mailboxes) {
			if (m.getUser() == user) {
				return m.getAllMessages();
			}
		}
		return "";
	}
}
