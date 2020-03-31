
public class DataElection {
	private int democratVotes;
	private int republicanVotes;
	private int independentVotes;
	
	public DataElection(int repub, int dem, int indep) {
		democratVotes = dem;
		republicanVotes = repub;
		independentVotes = indep;
	}
	
	public int getDemoVotes() {
		return democratVotes;
	}
	
	public int getRepubVotes() {
		return republicanVotes;
	}
	
	public int getIndepVotes() {
		return independentVotes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
