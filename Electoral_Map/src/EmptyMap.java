import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EmptyMap{
	public static void main(String[] args) {
		visualize("CA");
	}
	
	public static void visualize(String state) {
		try{
			StdDraw.enableDoubleBuffering();
			String file = "./input/" + state + ".txt";
			File f = new File(file);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
						
			String min = br.readLine();
			min.trim();
			String[] minL = new String[2];
			minL = min.split("   ");
			
			String max = br.readLine();
			max.trim();
			String[] maxL = new String[2];
			maxL = max.split("   ");
			
			double minLat = Double.parseDouble(minL[0]);
			double minLong = Double.parseDouble(minL[1]);
			double maxLat = Double.parseDouble(maxL[0]);
			double maxLong = Double.parseDouble(maxL[1]);
			int xFactor = (int)((maxLat - minLat)/(maxLong - minLong));
			StdDraw.setCanvasSize(xFactor * 512, 512);
			
			StdDraw.setXscale(minLat, maxLat);
			StdDraw.setYscale(minLong, maxLong);
			
			int numSubregions = Integer.parseInt(br.readLine());
			StdDraw.setPenColor(StdDraw.BLACK);
			br.readLine();
			
			for(int i = 0; i < numSubregions; i++) {
				String subregion = br.readLine();
				String region = br.readLine();
				int numBlocks = Integer.parseInt(br.readLine());
				
				double[] longitude = new double[numBlocks];
				double[] latitude = new double[numBlocks];
				
				for(int j = 0; j < numBlocks; j++) {
					String line = br.readLine();
					line.trim();
					String[] lineL = new String[2];
					lineL = line.split("   ");
					longitude[j] = Double.parseDouble(lineL[1]);
					latitude[j] = Double.parseDouble(lineL[0]);
				}
				StdDraw.polygon(latitude, longitude);
				br.readLine();
			}
			StdDraw.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}