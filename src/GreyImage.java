public class GreyImage {
	public static final int BLACK = 0;
	public static final int WHITE = 255;

	int[][] pixelValues;

	public GreyImage() {
		// TODO Auto-generated constructor stub
	}

	public int countWhitePixels() {
		int numPix = 0;
		for (int i = 0; i < pixelValues.length; i++) {
			for (int j = 0; j < pixelValues[i].length; j++) {
				if (pixelValues[i][j] == 255)
					numPix++;
			}
		}
		return numPix;
	}

	public static int[][] createTestArray() {
		return new int[][] { { 255, 184, 178, 84, 129 }, { 84, 255, 255, 130, 84 }, { 78, 255, 0, 0, 78 }, { 84, 130, 255, 130, 84 } };
	}

	public void setPixelValues(int[][] colors) {
		this.pixelValues = colors;
	}

	public int[][] getPixelValues() {
		return pixelValues;
	}

	public void processImage() {
		for (int i = 0; i < pixelValues.length - 2; i++) {
			for (int j = 0; j < pixelValues[i].length - 2; j++) {
				int finValue = pixelValues[i][j] - pixelValues[i + 2][j + 2];
				if (finValue < BLACK) {
					finValue = BLACK;
				}
				pixelValues[i][j] = finValue;
			}
		}
	}

	public static boolean areSame(int[][] one, int[][] two) {
		boolean tf = true;
		for (int i = 0; i < one.length - 2; i++) {
			for (int j = 0; j < one[i].length - 2; j++) {
				if (one[i][j] != two[i][j])
					tf = false;
			}
		}
		return tf;
	}

}