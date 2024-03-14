package src.Utility;

public class ConvertUtility {

    public static int hexToDecimal(String hexString) {
        int binaryInt = 0;
        for (int i = 0; i < hexString.length(); i++) {
            char c = hexString.charAt(i);
            int digit = Character.digit(c, 16);
            binaryInt = (binaryInt << 4) | digit; // Shift previous bits left by 4 and add new digit
        }
        return binaryInt;
    }
}
