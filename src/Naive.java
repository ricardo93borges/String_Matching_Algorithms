/**
 * Created by ricardo on 26/08/17.
 */
public class Naive {

    private String text;
    private String pattern;

    public Naive(String text, String pattern) {
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

    public void match(){
        int textLen = getText().length();
        int patternLen = getPattern().length();

        for(int i=0; i<textLen-patternLen+1; i++){
            int j;
            for(j=0; j<patternLen; j++){
                if(getText().charAt(i+j) != getPattern().charAt(j)){
                    break;
                }
            }
            if(j == patternLen){
                System.out.println("Pattern found at index "+i);
            }
        }
    }
}
