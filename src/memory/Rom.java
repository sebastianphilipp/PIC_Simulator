package src.memory;

public class Rom {
    private int[] programmCounter = new int[1024];

    public void writeAddress(int address, int val){
        programmCounter[address] = val;
    }

    public int readAddress(int address){
        return programmCounter[address];
    }
}
