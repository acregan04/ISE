import java.util.ArrayList;

public class compareHist {

	public ArrayList<Double> run(ArrayList<float[][][]> imageHistMatrices, float[][][] qHsv, int compareMethod) {

		int numBins = 8;
		float[][][] histBase = histogram(qHsv, numBins);
		ArrayList<Double> allResults = new ArrayList<Double>();

		for (int i = 0; i < imageHistMatrices.size(); i++) {
			float[][][] histTest = imageHistMatrices.get(i);
			System.out.println("\n");
			
			double baseTest;

			if (compareMethod == 0) {
				baseTest = correlation(histBase, histTest, numBins);
				System.out.println("Method " + compareMethod + ": " + baseTest);
				allResults.add(baseTest);
			} else if (compareMethod == 1) {
				baseTest = chisquare(histBase, histTest, numBins); // change correlation to Chi-square
				System.out.println("Method " + compareMethod + ": " + baseTest);
				allResults.add(baseTest);
			} else if (compareMethod == 2) {
				baseTest = intersection(histBase, histTest, numBins); // change correlation to Intersection
				System.out.println("Method " + compareMethod + ": " + baseTest);
				allResults.add(baseTest);
			} else if (compareMethod == 3) {
				baseTest = bhattacharyya(histBase, histTest, numBins); // change correlation to Bhattacharyya
				System.out.println("Method " + compareMethod + ": " + baseTest);
				allResults.add(baseTest);
			}
		}
		return allResults;
	}

	public static float[][][] histogram(float[][][] hsvMatrix, int numBins) {
		int hBins = numBins; int sBins = numBins; int vBins = numBins;
		float[][][] hist = new float[hBins][sBins][vBins];
		int totalPixels = hsvMatrix.length * hsvMatrix[0].length * hsvMatrix[0][0].length;
		float hStep = 360.0f / hBins;
		float sStep = 1.0f / sBins;
		float vStep = 1.0f / vBins;
		for (int i = 0; i < hsvMatrix.length; i++) {
			for (int j = 0; j < hsvMatrix[0].length; j++) {
				float hVal = hsvMatrix[i][j][0];
				float sVal = hsvMatrix[i][j][1];
				float vVal = hsvMatrix[i][j][2];
				int hIdx = (int) (hVal / hStep);
				int sIdx = (int) (sVal / sStep);
				int vIdx = (int) (vVal / vStep);
				// Check if the values fall into the bin
				if (hIdx >= hBins)
					hIdx = hBins - 1;		
				if (sIdx >= sBins) 
					sIdx = sBins - 1;
				if (vIdx >= vBins) 
					vIdx = vBins - 1;
				// Increment the count in the histogram
				hist[hIdx][sIdx][vIdx]++;
			}
		}
		// Normalize the histogram
		for (int h = 0; h < hBins; h++) {
			for (int s = 0; s < sBins; s++) {
				for (int v = 0; v < vBins; v++) {
					hist[h][s][v] /= totalPixels;
				}
			}
		}
		return hist;
	}

	public static double correlation(float[][][] histBase, float[][][] histTest, int bins) {
		int rows = histBase.length;
		int cols = histBase[0].length;
		double sum1 = 0, sum2 = 0, sum3 = 0;
		double mean1 = 0, mean2 = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int k = 0; k < bins; k++) {
					mean1 += histBase[i][j][k];
					mean2 += histTest[i][j][k];
				}
			}
		}
		mean1 /= (rows * cols * bins);
		mean2 /= (rows * cols * bins);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int k = 0; k < bins; k++) {
					sum1 += (histBase[i][j][k] - mean1) * (histTest[i][j][k] - mean2);
					sum2 += Math.pow(histBase[i][j][k] - mean1, 2);
					sum3 += Math.pow(histTest[i][j][k] - mean2, 2);
				}
			}
		}
		return sum1 / Math.sqrt(sum2 * sum3);
	}

	public static double intersection(float[][][] histBase, float[][][] histTest, int bins) {
		double intersection = 0;
		int hBins = histBase.length;
		int sBins = histBase[0].length;
		int vBins = histBase[0][0].length;
		for (int h = 0; h < hBins; h++) {
			for (int s = 0; s < sBins; s++) {
				for (int v = 0; v < vBins; v++) {
					intersection += Math.min(histBase[h][s][v], histTest[h][s][v]);
				}
			}
		}
		return intersection;
	}

	public static double chisquare(float[][][] histBase, float[][][] histTest, int bins) {
		double distance = 0;
		int hBins = histBase.length;
		int sBins = histBase[0].length;
		int vBins = histBase[0][0].length;
		for (int h = 0; h < hBins; h++) {
			for (int s = 0; s < sBins; s++) {
				for (int v = 0; v < vBins; v++) {
					double delta = histBase[h][s][v] - histTest[h][s][v];
					double sum = histBase[h][s][v] + histTest[h][s][v];
					if (sum > 0) {
						distance += delta * delta / sum;
					}
				}
			}
		}
		return distance;
	}

	public static double bhattacharyya(float[][][] histBase, float[][][] histTest, int bins) {
		int rows = histBase.length;
		int cols = histBase[0].length;
		double sum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int k = 0; k < bins; k++) {
					sum += Math.sqrt(histBase[i][j][k] * histTest[i][j][k]);
				}
			}
		}
		return Math.sqrt(1.0 - sum);
	}
}
