import java.util.EnumMap;

public class MapRunner {
	public static void main(String[] args)
	{
		EmptyMap em = new EmptyMap();
		em.visualize("WA");
		StdDraw.pause(2000);
		em.visualize("USA");
		StdDraw.pause(2000);
		em.visualize("USA-county");
		StdDraw.pause(2000);
		
		ElectoralMap elm = new ElectoralMap();
		elm.visualize("WA", 2012);
		StdDraw.pause(2000);
		elm.visualize("USA", 2012);
		StdDraw.pause(2000);
		elm.visualize("USA-county", 2012);
		StdDraw.pause(2000);
		
		BlendedAmerica blam = new BlendedAmerica();
		blam.visualize("WA", 2012);
		StdDraw.pause(2000);
		blam.visualize("USA", 2012);
		StdDraw.pause(2000);
		blam.visualize("USA-county", 2012);
		StdDraw.pause(2000);
	}
	

}
