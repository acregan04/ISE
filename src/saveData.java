import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class saveData implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final FileFilter IMAGE_FILTER = new FileFilter() {
		@Override
		public boolean accept(final File file) {
			if (file.isDirectory()) {
				return false;
			}
			final String name = file.getName();
			return name.endsWith(".jpg") || name.endsWith(".png");
		}
	};

	public static void HSVSaver() throws IOException {
		
		long startTime = System.nanoTime();

		final File dir = new File("src\\gallery");
		ArrayList<float[][][]> imageMatrices = new ArrayList<>();

		if (dir.isDirectory()== false) { // make sure it's a directory
			JOptionPane.showMessageDialog(null, "No image gallery detected", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		for (final File f : dir.listFiles(IMAGE_FILTER)) {
			try {
				BufferedImage image = ImageIO.read(f);

				int width = image.getWidth();
				int height = image.getHeight();
				float[][][] hsvImage = new float[height][width][3];

				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						int rgb = image.getRGB(x, y);
						int r = (rgb >> 16) & 0xff;
						int g = (rgb >> 8) & 0xff;
						int b = rgb & 0xff;

						float[] hsv = images.RGBtoHSV(r, g, b);
						hsvImage[y][x][0] = hsv[0];
						hsvImage[y][x][1] = hsv[1];
						hsvImage[y][x][2] = hsv[2];
					}
				}
				imageMatrices.add(hsvImage);
				System.out.println("image: " + f.getName());

			} catch (final IOException e) {
				JOptionPane.showMessageDialog(null, "Failed to read in images from gallery", "Warning",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
		}

		ArrayList<float[][][]> imageHistoMatrices = new ArrayList<>();
		for (int i = 0; i < imageMatrices.size(); i++) {

			int numBins = 8;
			float[][][] histTest = compareHist.histogram(imageMatrices.get(i), numBins);
			imageHistoMatrices.add(histTest);
			System.out.println("hist: " + i);
		}

		File file = new File("src\\test.bin");
		
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
			// Write the header
			out.writeInt(imageHistoMatrices.size());

			// Write the data for each image
			for (float[][][] image : imageHistoMatrices) {
				out.writeInt(image.length); // Width
				out.writeInt(image[0].length); // Height

				// Write the hsv values
				for (int i = 0; i < image.length; i++) {
					for (int j = 0; j < image[0].length; j++) {
						for (int k = 0; k < image[i][j].length; k++) {
							out.writeFloat(image[i][j][k]);
						}
					}
				}
			}
			System.out.println("SAVED!");
			JOptionPane.showMessageDialog(null, "Data successfully saved to file", "Process Update",
					JOptionPane.INFORMATION_MESSAGE);
		}
		catch (final IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to save data to file", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		long endTime = System.nanoTime();  // Record the end time in nanoseconds
		long elapsedTime = endTime - startTime;  // Calculate the elapsed time in nanoseconds		
		double elapsedSeconds = (double) elapsedTime / 1_000_000_000.0;  // Convert elapsed time to seconds
		
		System.out.println("Elapsed time (s): " + elapsedSeconds); 
	}

	public static ArrayList<float[][][]> readHSV() throws IOException {
		
		File file = new File("src\\test.bin");
		ArrayList<float[][][]> data = new ArrayList<>();

		try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
			// Read the header
			int numImages = in.readInt();

			// Read the data for each image
			for (int k = 0; k < numImages; k++) {
				int width = in.readInt();
				int height = in.readInt();
				int depth = 8;

				// Initialize the image array with the correct dimensions
				float[][][] image = new float[width][height][depth];

				// Read the hsv values
				for (int i = 0; i < width; i++) {
					for (int j = 0; j < height; j++) {
						for (int d = 0; d < depth; d++) {
							image[i][j][d] = in.readFloat();
						}
					}
				}
				data.add(image);
			}
		}
		
		catch (final IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to read data from file", "Warning",
					JOptionPane.WARNING_MESSAGE);
			
		}
		return data;
	}

	/*
	public static void saver(ArrayList<Double>[] scores) throws IOException {

		// Create a new file 
		File file = new File("src\\scores.csv");

		if (file.exists()) { file.delete();
		// Write the data 
		FileWriter writer = new FileWriter(file); 
		for (int i = 0; i < scores.length; i++) { 
			// Write the ID 
			writer.write("ID" + (i+1) + ",");
			//ID1*Correlation*
			//ID2 *Chi-square*
			//ID3*Intersection*
			//ID4*Bhattacharyya*

			// Write the scores 
			List<Double> row = scores[i]; 
			for (Double score : row) {
				writer.write(score + ","); }

			// Move to next row 
			writer.write("\n"); }

		// Close the file 
		writer.close(); }
	}

	public static ArrayList<Double>[] readScores() throws FileNotFoundException {

		String fileName = "src\\scores.csv";

		List<ArrayList<Double>> result = new ArrayList<>(); 
		Scanner scanner = new Scanner(new File(fileName)); 
		while (scanner.hasNextLine()) {
			ArrayList<Double> row = new ArrayList<>(); 
			String[] data = scanner.nextLine().split(","); 
			for (int i = 1; i < data.length; i++) 
			{
				row.add(Double.parseDouble(data[i])); 
			} 
			result.add(row); 
		} 
		scanner.close();
		return result.toArray(new ArrayList[0]); 
	}
	*/

}