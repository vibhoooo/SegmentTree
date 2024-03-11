import java.util.*;
import java.io.*;
public class Main {
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
    static long[] t=new long[800000];
    public static void build(int index,int l,int r) {
        if(l==r) {
            t[index]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(2*index,l,mid);
        build(2*index+1,mid+1,r);
        t[index]=t[2*index]+t[2*index+1];
    }
    public static void update(int index,int l,int r,int pos,int val) {
        if(pos<l||pos>r) {
            return;
        }
        if(l==r) {
            t[index]=val;
            arr[l]=val;
            return;
        }
        int mid=l+(r-l)/2;
        update(2*index,l,mid,pos,val);
        update(2*index+1,mid+1,r,pos,val);
        t[index]=t[2*index]+t[2*index+1];
    }
    public static long query(int index,int l,int r,int lq,int rq) {
        if(l>rq||r<lq) {
            return 0;
        }
        if(l>=lq&&r<=rq) {
            return t[index];
        }
        int mid=l+(r-l)/2;
        return query(2*index,l,mid,lq,rq)+query(2*index+1,mid+1,r,lq,rq);
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out=new FastWriter();
            int n=in.nextInt();
            int q=in.nextInt();
            for(int i=0;i<=n-1;++i) {
                arr[i]=in.nextInt();
            }
            build(1,0,n-1);
            for(int i=0;i<=q-1;++i) {
                int ch=in.nextInt();
                if(ch==1) {
                    int x=in.nextInt();
                    int v=in.nextInt();
                    update(1,0,n-1,x-1,v);
                }
                else {
                    int l=in.nextInt();
                    int r=in.nextInt();
                    long sum=query(1,0,n-1,l-1,r-1);
                    out.println(sum);
                }
            }
            out.close();
        } 
        catch(Exception e) {
            return;
        }
    }
}