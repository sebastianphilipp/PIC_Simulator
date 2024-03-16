package src.memory;

public class Rom {
    private int[] programCounter;

    public Rom(int size) {
        programCounter = new int[size];
    }

    public void writeAddress(int address, int val) {
        programCounter[address] = val;
    }

    public int readAddress(int address) {
        return programCounter[address];
    }
}
