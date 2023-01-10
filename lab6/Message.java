package labs.lab6;

/**
 * An email message.
 */
public class Message {
	private String from;
	private String to;
	private String text;

	/**
	 * Constructs a Message object.
	 * 
	 * @param from 	the sender of the message
	 * @param to	the recipient of the message
	 * @param text	the text of the message
	 */
	public Message(String from, String to, String text) {
		this.from = from;
		this.to = to;
		this.text = text;
	}

	/**
	 * Gets the recipient.
	 * 
	 * @return the recipient
	 */
	public String getRecipient() {
		return to;
	}

	/**
	 * Formats the email message in the following format:
	 * From: [SENDER]
	 * To: [RECIPIENT]
	 * [TEXT]
	 */
	public String toString() {
		return "From: " + from + "\n" + "To: " + to + "\n" + text;
	}
}
