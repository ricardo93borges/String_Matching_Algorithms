/**
 * Created by ricardo on 26/08/17.
 */
public class Main {

    public static void main (String[] args){
        String text1 = "aababcc";
        String text2 = "babacacccabab";
        String pattern = "bab";

        Naive naive = new Naive(text2, pattern);
        naive.match();
        RabinKarp rabinKarp = new RabinKarp(text2,pattern);
        rabinKarp.match();
    }
}
