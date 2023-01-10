package labs.lab3;

/**
 * Represents the height of a terrain at different points in a square
 */
public class Terrain {
	
	private double[][] heights;
	
	
	/**
	 * Constructor
	 * 
	 * @param heights	heights of the terrain at different points in a square
	 */
	public Terrain(double[][] heights) {
		this.heights = heights;
	}

	
	/**
	 * Returns a flood map, showing which of the points in the terrain would be flooded
	 * if the water level was the given value. A point is flooded if the water level
	 * is > the height of the terrain.
	 * 
	 * In the flood map, each flooded point is represented by a * and each non-flooded
	 * point is represented by a -.
	 * 
	 * @param waterLevel	the water level
	 * 
	 * @return	the flood map
	 */
	public char[][] getFloodMap(double waterLevel) {
		char[][] res = new char[heights.length][heights[0].length];
		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[0].length; j++) {
				if (waterLevel > heights[i][j]) {
					res[i][j] = '*';
				}
				else {
					res[i][j] = '-';
				}
			}
		}
		return res;
	}
}
