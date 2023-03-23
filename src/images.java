import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.Icon;

public class images {

	public static ArrayList<Image> details(Icon icon, String queryImgStr) throws IOException, ClassNotFoundException {

		long startTime = System.nanoTime();
		
		
		final File qIm = new File(queryImgStr);
		final File dir = new File("src\\gallery");

		// array of supported extensions
		final String[] EXTENSIONS = new String[] { "jpg" };
		// filter to identify images based on their extensions
		final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

			@Override
			public boolean accept(final File dir, final String name) {
				for (final String ext : EXTENSIONS) {
					if (name.endsWith("." + ext)) {
						return (true);
					}
				}
				return (false);
			}
		};

		BufferedImage qImage = ImageIO.read(qIm);
		int qWidth = qImage.getWidth();
		int qHeight = qImage.getHeight();
		float[][][] qhsvImage = new float[qHeight][qWidth][3];

		for (int y = 0; y < qHeight; y++) {
			for (int x = 0; x < qWidth; x++) {
				int rgb = qImage.getRGB(x, y);
				int r = (rgb >> 16) & 0xff;
				int g = (rgb >> 8) & 0xff;
				int b = rgb & 0xff;

				float[] hsv = RGBtoHSV(r, g, b);
				qhsvImage[y][x][0] = hsv[0];
				qhsvImage[y][x][1] = hsv[1];
				qhsvImage[y][x][2] = hsv[2];
			}
		}

		// READ IN FROM FILE
		ArrayList<float[][][]> imageHistMatrices = saveData.readHSV();
		ArrayList<String> imgsDir = new ArrayList<String>();
		ArrayList<Image> proImgs = new ArrayList<Image>();
		for (final File f : dir.listFiles(IMAGE_FILTER)) {
			imgsDir.add(f.toString());
		}

		// method 0 *Correlation*
		// method 1 *Chi-square*
		// method 2 *Intersection*
		// method 3 *Bhattacharyya*
		int method = 3;

		ArrayList<Double> allResults = new ArrayList<Double>();
		allResults = new compareHist().run(imageHistMatrices, qhsvImage, method);

		ArrayList<String> fproImgs = new ArrayList<String>();
		fproImgs = imgsDir;

		Map<Double, String> map = new HashMap<Double, String>();
		for (int y = 0; y < allResults.size(); y++) {
			map.put(allResults.get(y), fproImgs.get(y));
		}

		Collections.sort(allResults);
		fproImgs.clear();

		for (int z = 0; z < map.size(); z++) {
			fproImgs.add(map.get(allResults.get(z)));
		}

		// print sorted list
		for (double s : allResults) {
			System.out.println(s);
		}

		// taking top 10 images Correlation and Intersection
		if (method == 1 || method == 3) {
			for (int i = 0; i < fproImgs.size(); i++) {

				File f = new File(fproImgs.get(i));
				BufferedImage image = ImageIO.read(f);
				proImgs.add(image);
			}
		}
		// taking top 10 images for Bhattacharyya and Chi-Square
		else {
			for (int i = fproImgs.size() - 1; i > fproImgs.size() - 31; i--) {

				File f = new File(fproImgs.get(i));
				BufferedImage image = ImageIO.read(f);
				proImgs.add(image);
			}
		}
		
		long endTime = System.nanoTime();  // Record the end time in nanoseconds
		long elapsedTime = endTime - startTime;  // Calculate the elapsed time in nanoseconds		
		double elapsedSeconds = (double) elapsedTime / 1_000_000_000.0;  // Convert elapsed time to seconds
		
		System.out.println("Elapsed time (s): " + elapsedSeconds); 
		
		return proImgs;
	}

	public static float[] RGBtoHSV(int r, int g, int b) {
		float h, s, v;
		float rf = r / 255.0f;
		float gf = g / 255.0f;
		float bf = b / 255.0f;

		float max = Math.max(Math.max(rf, gf), bf);
		float min = Math.min(Math.min(rf, gf), bf);
		v = max;

		float delta = max - min;
		if (max == 0 || delta == 0) {
			h = 0;
			s = 0;
		} else {
			s = delta / max;
			if (rf == max) 
				h = (gf - bf) / delta;
			 else if (gf == max)
				h = 2 + (bf - rf) / delta;
			 else 
				h = 4 + (rf - gf) / delta;
			h *= 60;
			if (h < 0) 
				h += 360;
		}
		return new float[] { h, s, v };
	}
}
