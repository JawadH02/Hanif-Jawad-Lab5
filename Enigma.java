//TODO
public class Enigma {
    String[] rotorOptions = { "#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV",
            "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE", "#TGOWHLIFMCSZYRVXQABUPEJKND" };

    Rotor innerRotor;
    Rotor middleRotor;
    Rotor outerRotor;

    public Enigma(int inner, int middle, int outer, String startingStr) {
        innerRotor = new Rotor(rotorOptions[inner - 1], startingStr.charAt(0));
        middleRotor = new Rotor(rotorOptions[middle - 1], startingStr.charAt(1));
        outerRotor = new Rotor(rotorOptions[outer - 1], startingStr.charAt(2));
    }

    public String encrypt(String message) {
        return process(message, "Encrypt");
    }

    public String decrypt(String message) {
        return process(message, "Decrypt");
    }

    public String process(String message, String typeOfProcess) {
        char[] messageArr = message.toCharArray();
        for (int i = 0; i < messageArr.length; i++) {
            
            int encryptInnerCharIndex = innerRotor.getIndexOfChar(messageArr[i]);
            char encryptOuterChar = outerRotor.getCharAtIndex(encryptInnerCharIndex);
            int encryptMiddleCharIndex = middleRotor.getIndexOfChar(encryptOuterChar);
            char encrypedChar = outerRotor.getCharAtIndex(encryptMiddleCharIndex);
            
            int decryptOuterCharIndex = outerRotor.getIndexOfChar(messageArr[i]);
            char decryptMiddleChar = middleRotor.getCharAtIndex(decryptOuterCharIndex);
            int decryptOuterChar = outerRotor.getIndexOfChar(decryptMiddleChar);
            char decryptedChar = innerRotor.getCharAtIndex(decryptOuterChar);

            if(typeOfProcess.compareTo("Encrypt") == 0) {
                messageArr[i] = encrypedChar;
            } else {
                messageArr[i] = decryptedChar;
            }
            rotationProcess();
        }
        return String.valueOf(messageArr);
    }

    public void rotationProcess() {
        String rotatedInnerRotor = innerRotor.rotateClockwise();
        innerRotor.setRotor(rotatedInnerRotor);
        if (Character.compare(innerRotor.getStartingChar(), innerRotor.getRotor().charAt(0)) == 0) {
            middleRotor.setRotor(middleRotor.rotateClockwise());
        }
    }
}