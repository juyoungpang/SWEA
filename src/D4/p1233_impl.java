package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1233_impl {
	public static void main(String[] args) throws IOException {
		int TTC = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int TC = 1; TC <= TTC; TC++) {
			sb.append("#").append(TC).append(" ");

			boolean flag = true;

			int nodeNum = Integer.parseInt(br.readLine());
			for (int rep = 0; rep < nodeNum; rep++) {
				String[] nodeInfo = br.readLine().split(" ");
				if (!flag)
					continue;
				if((nodeInfo.length==4 && isNum(nodeInfo[1]))||(nodeInfo.length==2 && !isNum(nodeInfo[1]))) {
					flag = false;
				}
			}
			
			sb.append(flag?1:0).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean isNum(String str) {
		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}