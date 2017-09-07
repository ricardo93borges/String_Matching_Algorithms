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
        FiniteAutomata finiteAutomata = new FiniteAutomata(text2,pattern);
        finiteAutomata.match();
    }

    /*
    (0) -b-> (1) -a-> (2) -b-> (3)
     _______________
    | s | a | b | c |
    |---------------|
    | 0 | 0 | 1 | 0 |
    | 1 | 2 | 1 | 0 |
    | 2 | 0 | 3 | 0 |
    | 3 | 0 | 1 | 0 |
    |_______________|
     */
}
