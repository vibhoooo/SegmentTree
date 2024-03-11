import java.util.*;
import java.io.*;
public class RangeXORQueries {
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
    static int[] arr=new int[200000];
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out=new FastWriter();
            int n=in.nextInt();
            int q=in.nextInt();
            for(int i=0;i<=n-1;++i) {
                arr[i]=in.nextInt();
            }
            long[] pre=new long[n];
            pre[0]=arr[0];
            for(int i=1;i<=n-1;++i) {
                pre[i]=pre[i-1]^arr[i];
            }
            for(int i=0;i<=q-1;++i) {
                int l=in.nextInt();
                int r=in.nextInt();
                if(l==1) {
                    out.println(pre[r-1]);
                }
                else {
                    out.println(pre[r-1]^pre[(l-1)-1]);
                }
            }
            out.close();
        } 
        catch(Exception e) {
            return;
        }
    }
}