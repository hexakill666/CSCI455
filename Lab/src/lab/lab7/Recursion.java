package lab.lab7;

public class Recursion {

    public int longestWordLen(String words){
        int len = words.indexOf(" ");
        if(len == -1){
            return words.length();
        }
        int len2 = longestWordLen(words.substring(len + 1));
        return Math.max(len, len2);
    }

    public String string1UpToN(int n) {
        return RAppendUpTo("", 1, n);
    }

    private String RAppendUpTo(String strSoFar, int i, int n){
        strSoFar += i;
        if(i != n){
            strSoFar += " ";
        }
        if(i == n){
            return strSoFar;
        }
        return RAppendUpTo(strSoFar, i + 1, n);
    }

    public int fastExpon(int x, int n) {
        if(n == 1){
            return x;
        }
        if(n == 0){
            return 1;
        }
        int n2 = n / 2;
        int x2 = fastExpon(x, n2);
        int res = x2 * x2;
        return (n & 1) == 1 ? res * x : res;
    }

    public String printEmployee(int start, int end){
        StringBuilder sb = new StringBuilder();
        for(int a = start; a <= end; a++){
            sb.append("employee").append(a);
            if(a != end){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Recursion().printEmployee(12,24));
    }

}
