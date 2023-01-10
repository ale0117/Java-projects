package labs.lab1;

/**
 * Compute international standard sizes for paper, where A0 = 841 x 1189 mm A1 =
 * 594 x 841 mm A2 = 420 x 594 mm A3 = 292 x 423 mm etc
 */
public class Sheet {

	private int width;
	private int length;
	private int size;

	
	/**
	 * create a sheet of size A0
	 */
	public Sheet() {
		width = 841;
		length = 1189;
		size = 0;
	}

	
	/**
	 * @return the width of the paper
	 */
	public int getWidth() {
		return width;
	}

	
	/**
	 * @return the length of the paper
	 */
	public int getLength() {
		return length;
	}

	
	/**
	 * @return the ISO name for the paper
	 */
	public String getName() {
		return "A" + size;
	}

	
	/**
	 *
	 * @return a sheet that is cut in half along the length
	 */
	public Sheet cutInHalf() {
		Sheet newSheet = new Sheet();
		newSheet.width = this.length/2;
		newSheet.length = this.width;
		newSheet.size = this.size+1;
		return newSheet;
	}
}
