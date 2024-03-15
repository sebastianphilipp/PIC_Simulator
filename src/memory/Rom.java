package src.memory;

public class Rom {
    private int[] programmCounter;

    public Rom(int size) {
        programmCounter = new int[size];
    }

    public void writeAddress(int address, int val) {
        programmCounter[address] = val;
    }

    public int readAddress(int address) {
        return programmCounter[address];

    }
}
