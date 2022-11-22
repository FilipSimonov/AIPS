package faks.aud4;

public class Podsekvenca {

    public static int najdolgaPodsekvenca(String x,String y){
        int n = x.length();
        int m = y.length();

        int NZP[][] = new int[n+1][m+1];

        for (int i=0;i<n;i++){
            NZP[i][0] = 0;      //first column
        }
        for (int j=0;j<m;j++){
            NZP[0][j] = 0;      //first row;
        }

        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if (x.charAt(i-1) == y.charAt(j-1)){
                    NZP[i][j] = NZP[i-1][j-1]+1;
                }
                else {
                    NZP[i][j] = Math.max(NZP[i-1][j],NZP[i][j-1]);
                }
            }
        }
        return NZP[n][m];
    }

    String najdolgaZaednickaPodsekvencaString(String x,String y){
        int i,j;
        int n=x.length();
        int m=y.length();

        int NZP[][] = new int[n+1][m+1];
        for ( i=0;i<n;i++){
            NZP[i][0] = 0;
        }
        for (j=0;j<m;j++){
            NZP[0][j] = 0;
        }
        for (i=1;i<=n;i++){
            for (j=1;j<=m;j++){
                if (x.charAt(i-1) == y.charAt(j-1)){
                    NZP[i][j] = NZP[i-1][j-1]+1;
                }
                else {
                    NZP[i][j] = Math.max(NZP[i-1][j],NZP[i][j-1]);
                }
            }
        }
        char rez1[] = new char[Math.max(n,m)];
        int L = 0;
        i=n;
        j=m;

        while ((i!=0) && (j!=0)){
            if (x.charAt(i-1) == y.charAt(j-1)){
                rez1[L] = x.charAt(i-1);
                L++;
                i--;
                j--;
            }else {
                if (NZP[i][j] == NZP[i-1][j]){
                    i--;
                }else {
                    j--;
                }
            }
        }
        String rez2 = "";
        for ( i=0;i<L;i++){
            rez2+=rez1[L-1-i];
        }
        return rez2;
    }

    public static void main(String[] args) {
        Podsekvenca dp = new Podsekvenca();

        String x = "ggcaccacg";
        String y = "acggcggatacg";

        System.out.println(dp.najdolgaPodsekvenca(x, y));
        System.out.println(dp.najdolgaZaednickaPodsekvencaString(x, y));
    }
}
