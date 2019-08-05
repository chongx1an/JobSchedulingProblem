package DisjointSet;

public class DisjointSet {
	private int parent[];
	
	public DisjointSet(int n){
		parent = new int[n + 1];
		
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	public int find(int s) {
		if (s == parent[s])
			return s;
		return parent[s] = find(parent[s]);
	}
	
	public void merge(int u, int v) {
		parent[v] = u;
	}
	
}
