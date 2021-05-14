// Sisi
public class Edge {
	public Edge(Vertex a, Vertex b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}

	public Vertex getA() {
		return a;
	}

	public Vertex getB() {
		return b;
	}

	public int getCost() {
		return cost;
	}

	public Edge reverse() {
		return new Edge(b, a, cost);
	}

	public boolean contains(Vertex v) {
		return a == v || b == v;
	}

	public boolean equals(Object o) {
		if (o instanceof Edge) {
			Edge e = (Edge) o;
			return e.a.equals(a) && e.b.equals(b);
		} else {
			return false;
		}
	}

	public int hashCode() {
		return a.hashCode() + 666 * b.hashCode() - cost;
	}

	protected Vertex a, b;
	protected int cost;
}
