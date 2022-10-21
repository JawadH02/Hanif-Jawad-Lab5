//TODO
public class Rotor {

    private String rotor;
    private char startingChar;

    public Rotor(String rotor, char startingChar) {
        this.rotor = rotor;
        this.startingChar = startingChar;
        setRotorBeginningChar(startingChar);
    }

    public String rotateClockwise() {
        return rotor.substring(rotor.length() - 1) + rotor.substring(0, rotor.length() - 1);
    }

    public int getIndexOfChar(char initialChar) {
        return rotor.indexOf(initialChar);
    }

    public char getCharAtIndex(int index) {
        return rotor.charAt(index);
    }

    public String getRotor() {
        return rotor;
    }

    public char getStartingChar() {
        return startingChar;
    }

    private void setRotorBeginningChar(char initialChar) {
        int index = getIndexOfChar(initialChar);

        setRotor(rotor.substring(index) + rotor.substring(0, index));
    }

    public void setRotor(String prevRotor) {
        this.rotor = prevRotor;
    }
}