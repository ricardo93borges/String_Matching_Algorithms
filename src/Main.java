/**
 * Created by ricardo on 26/08/17.
 */
public class Main {

    public static void main (String[] args){
        String text = "aaaabbcc";
        String pattern = "cc";

        Naive naive = new Naive(text, pattern);
        naive.match();
    }
}
