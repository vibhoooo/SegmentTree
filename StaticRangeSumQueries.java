import java.util.*;
import java.io.*;
public class StaticRangeSumQueries {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while(st==null||!st.hasMoreTokens()) {
                try {
                    st=new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str="";
            try {
                str=br.readLine().trim();
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;
		public FastWriter() {
			this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
		}
        public void println() throws IOException {
            bw.append("\n");
        }
		public void print(Object object) throws IOException {
			bw.append("" + object);
		}
		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}
		public void close() throws IOException {
			bw.close();
		}
	}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out=new FastWriter();
            int n=in.nextInt();
            int q=in.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<=n-1;++i) {
                arr[i]=in.nextInt();
            }
            long[] ps=new long[n];
            ps[0]=arr[0];
            for(int i=1;i<=n-1;++i) {
                ps[i]=ps[i-1]+arr[i];
            }
            while(q-->0) {
                int a=in.nextInt();
                int b=in.nextInt();
                if(a==1) {
                    out.println(ps[b-1]);
                }
                else {
                    out.println(ps[b-1]-ps[(a-1)-1]);
                }
            }
            out.close();
        } 
        catch(Exception e) {
            return;
        }
    }
}