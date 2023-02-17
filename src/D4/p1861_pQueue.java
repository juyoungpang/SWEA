package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1861_pQueue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		StringBuilder sb = new StringBuilder();

		int TTC = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= TTC; TC++) {
			int ansS = 0, ansC = 0;
			PriorityQueue<Room> pq = new PriorityQueue<>();

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				tok = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					pq.add(new Room(i, j, Integer.parseInt(tok.nextToken())));
				}
			}

			while (!pq.isEmpty()) {
				Room room = null;
				int row = 0;
				int col = 0;
				int diffRow = 0;
				int diffCol = 0;

				int start = pq.peek().val;
				int count = 0;
				do {
					room = pq.poll();
					row = room.row;
					col = room.col;
					count++;

					if(pq.isEmpty()) break;
					diffRow = Math.abs(row - pq.peek().row);
					diffCol = Math.abs(col - pq.peek().col);
				} while ((diffRow == 1 && diffCol == 0) || (diffRow == 0 && diffCol == 1));

				if (count > ansC) {
					ansS = start;
					ansC = count;
				}
			}

			sb.append("#").append(TC).append(" ").append(ansS).append(" ").append(ansC).append("\n");
		}

		System.out.println(sb.toString());
	}
}

class Room implements Comparable<Room> {
	int row;
	int col;
	int val;

	public Room(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}

	@Override
	public int compareTo(Room o) {
		return this.val - o.val;
	}

}