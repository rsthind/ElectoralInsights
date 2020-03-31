import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class BlendedAmerica{
	public static void main(String[] args) {
		
	}
	
	public static void visualize(String state, int year) {
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
			
			HashMap<String, DataElection> map = new HashMap<>();
			
			String inpRegion = "";
			
			for(int i = 0; i < numSubregions; i++) {
				String inpSubregion = br.readLine();
				String readRegion = br.readLine();
				if(inpRegion.equals(readRegion)) {
					
				}
				else {
					inpRegion = readRegion;
					
					file = "./input/" + inpRegion + year + ".txt";
					f = new File(file);
					fr = new FileReader(f);
					BufferedReader newBr = new BufferedReader(fr);
					
					newBr.readLine();
					
					while(newBr.ready()) {
						String line = newBr.readLine();
						String[] electionLine = line.split(",");
						String subregion = electionLine[0];
						
						int repub = Integer.parseInt(electionLine[1]);
						int dem = Integer.parseInt(electionLine[2]);
						int indep = Integer.parseInt(electionLine[3]);
						map.put(subregion, new DataElection(repub, dem, indep));
					}
				}
				
				String sBlocks = br.readLine();
				int numBlocks = Integer.parseInt(sBlocks);
				
				if(inpRegion.equals("LA")) {
					inpSubregion = inpSubregion.replace(" Parish", "");
				}
				else if(inpRegion.equals("VA")) {
					inpSubregion = inpSubregion.replace(" city", "");
				}
				DataElection votes = map.get(inpSubregion);
				
				if(votes == null) {
					StdDraw.setPenColor(StdDraw.GRAY);
				}else {
					double demVotes = votes.getDemoVotes();
					double repubVotes = votes.getRepubVotes();
					double indepVotes = votes.getIndepVotes();
					double sumVotes = demVotes + repubVotes + indepVotes;
					
					int red = (int)((repubVotes/sumVotes)*255);
					int green = (int)((indepVotes/sumVotes) * 255);
					int blue = (int)((demVotes/sumVotes) *255);
					
					StdDraw.setPenColor(red, green, blue);
				}
				
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
				
				StdDraw.filledPolygon(latitude, longitude);
				StdDraw.setPenColor(StdDraw.BLACK);
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