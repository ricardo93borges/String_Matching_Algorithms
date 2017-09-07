/**
 * Created by ricardo on 26/08/17.
 */
public class FiniteAutomata {

    // Tamanho do alfabeto
    public static final int alphabetSize = 256;
    public static final int primeNumber = 101;
    private String text;
    private String pattern;

    public FiniteAutomata(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Define o próximo estado (state) dado um estado
     * @param pat
     * @param M
     * @param state
     * @param x
     * @return
     */
    public int getNextState(char[] pat, int M, int state, int x) {
        /**
         * Incrementa state se o caractere é o mesmo que o próximo
         */
        if (state < M && x == pat[state]){
            return state + 1;
        }
        int ns, i;

        for (ns = state; ns > 0; ns--) {
            if (pat[ns - 1] == x) {
                for (i = 0; i < ns - 1; i++) {
                    if (pat[i] != pat[state - ns + 1 + i]){
                        break;
                    }
                }
                if (i == ns - 1){
                    return ns;
                }
            }
        }
        return 0;
    }

    /**
     * Monta a tebela do automato finito
     * @param pat
     * @param M
     * @param TF
     */
    public void computeTF(char[] pat, int M, int[][] TF) {
        int state, x;
        for (state = 0; state <= M; ++state){
            for (x = 0; x < alphabetSize; ++x){
                TF[state][x] = getNextState(pat, M, state, x);
            }
        }
    }

    /**
     * Procura as ocorrencias de pattern em text
     */
    public void match() {
        char[] pat = this.pattern.toCharArray();
        char[] txt = this.text.toCharArray();
        int M = pat.length;
        int N = txt.length;
        int[][] TF = new int[M + 1][alphabetSize];

        computeTF(pat, M, TF);

        int i, state = 0;
        for (i = 0; i < N; i++) {
            state = TF[state][txt[i]];
            if (state == M) {
                System.out.println("Pattern found at " + (i - M + 1));
            }
        }
    }
}
