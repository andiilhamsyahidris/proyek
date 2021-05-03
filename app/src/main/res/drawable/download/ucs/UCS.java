import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

// Uniform-Cost Search
public class UCS {
	public class UCSResult {
		public Edge[] getPaths() {
			return paths.clone();
		}

		public int getTotalCost() {
			return cost;
		}

		public int getTotalExpansion() {
			return expansion;
		}

		private Edge[] paths;
		private int cost;
		private int expansion;
	}

	public UCS(Vertex[] vertexes, Edge[] edges) {
		this.verts = new ArrayList<Vertex>(Arrays.asList(vertexes));
		this.edges = new ArrayList<Edge>(Arrays.asList(edges));

		// Buat graf bolak balik untuk mensimulasikan graf tanpa arah
		int size = this.edges.size();
		for (int i = 0; i < size; i++) {
			Edge reverse = this.edges.get(i).reverse();

			if (this.edges.contains(reverse) == false) {
				this.edges.add(reverse);
			}
		}

		neighboor = new HashMap<Vertex, HashSet<Edge>>();
		size = this.edges.size();

		// Buat koneksi tetangga antar simpul
		// HashSet<Edge> mengandung semua yang Edge.getA() == Vertex
		for (int i = 0; i < size; i++) {
			Edge e = this.edges.get(i);
			Vertex v = e.getA();

			// Apakah vertex benar-benar didefinisikan?
			if (verts.contains(v) == false) {
				throw new IllegalArgumentException("Vertex \"" + verts + "\" missing from verts");
			}

			HashSet<Edge> adjacent = neighboor.get(v);

			if (adjacent == null) {
				adjacent = new HashSet<Edge>();
				neighboor.put(e.getA(), adjacent);
			}

			adjacent.add(e);
		}
	}

	public UCSResult find(Vertex source, Vertex destination) {
		HashSet<Edge> connection = neighboor.get(source);

		if (connection == null) {
			throw new IllegalArgumentException("Source vertex \"" + source + "\" doesn't exist");
		}

		if (neighboor.get(destination) == null) {
			throw new IllegalArgumentException("Destination vertex \"" + destination + "\" doesn't exist");
		}

		PriorityQueue<PathCost> frontier = new PriorityQueue<PathCost>(16, UCS::comparePathCost);
		HashSet<Vertex> visited = new HashSet<Vertex>();
		int totalExpansion = 1;

		// Set frontier
		for (Edge e: connection) {
			frontier.offer(new PathCost(e, null));
		}

		visited.add(source);

		while (true) {
			// Ambil yang pertama
			PathCost pc = frontier.poll();

			if (pc == null) {
				// Gagal, tidak ada solusi
				return null;
			}

			Vertex next = pc.edge.getB();

			if (next.equals(destination)) {
				// Ditemukan solusi
				UCSResult result = new UCSResult();
				result.cost = pc.totalCost;
				result.expansion = totalExpansion;
				result.paths = pc.getPaths();

				return result;
			}

			// Jika tidak ada rekursi, lanjut
			if (visited.contains(next) == false) {
				visited.add(next);

				HashSet<Edge> adjacent = neighboor.get(next);

				if (adjacent != null) {
					// Tambahkan ke queue
					for (Edge e: adjacent) {
						// Pastikan tidak kembali ke simpul sebelumnya
						if (e.getB().equals(pc.edge.getA()) == false) {
							frontier.offer(new PathCost(e, pc));
						}
					}
				}
			}

			totalExpansion++;
			// Simpul yang tidak terhubung ke sisi selanjutnya atau
			// simpul yang siklik akan terhapus secara otomatis
		}
	}

	private class PathCost {
		PathCost(Edge edge, PathCost prev) {
			this.edge = edge;
			this.totalCost = edge.getCost();

			if (prev != null) {
				totalCost += prev.totalCost;
				previous = prev;
			}
		}

		public Edge[] getPaths() {
			ArrayList<Edge> edges = new ArrayList<Edge>();

			PathCost pc = this;
			while (pc != null) {
				edges.add(pc.edge);
				pc = pc.previous;
			}

			Edge[] result = new Edge[edges.size()];

			Collections.reverse(edges);
			edges.toArray(result);

			return result;
		}

		Edge edge;
		PathCost previous;
		int totalCost;
	}

	// Fungsi sorting
	static int comparePathCost(PathCost a, PathCost b) {
		return a.totalCost - b.totalCost;
	}

	private ArrayList<Vertex> verts;
	private ArrayList<Edge> edges;
	private HashMap<Vertex, HashSet<Edge>> neighboor;
}
