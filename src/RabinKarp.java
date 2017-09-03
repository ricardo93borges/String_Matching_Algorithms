/**
 * Created by ricardo on 26/08/17.
 */
public class RabinKarp {

    // Tamanho do alfabeto
    public static final int alphabetSize = 256;
    public static final int primeNumber = 101;
    private String text;
    private String pattern;

    public RabinKarp(String text, String pattern) {
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

    public void match()
    {
        int M = getPattern().length();
        int N = getText().length();
        int i, j;
        int p = 0; // hash para o padrão
        int t = 0; // hash para o texto
        int h = 1;

        // Valor de h
        for (i = 0; i < M-1; i++)
            h = (h*alphabetSize)%primeNumber;

        //Calcula o hash para o padrão e a primeira substring do texto
        for (i = 0; i < M; i++) {
            p = (alphabetSize*p + getPattern().charAt(i))%primeNumber;
            t = (alphabetSize*t + getText().charAt(i))%primeNumber;
        }

        // Move o padrão pelo texto caracter por caracter
        for (i = 0; i <= N - M; i++) {
            /**
             * Verifica se o hash do padrão é igual ao hash da substring do texto atual
             * Se forem iguais compara cada caracter
             */
            if ( p == t ) {
                for (j = 0; j < M; j++) {
                    if (getText().charAt(i+j) != getPattern().charAt(j))
                        break;
                }

                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            /**
             * Calcula o hash para a próxima substring do texto removendo
             * o primeiro e último digito
             */
            if ( i < N-M ) {
                t = (alphabetSize*(t - getText().charAt(i)*h) + getText().charAt(i+M))%primeNumber;
                //Se o hash for negativo converte para positivo
                if (t < 0) {
                    t = (t + primeNumber);
                }
            }
        }
    }
}
