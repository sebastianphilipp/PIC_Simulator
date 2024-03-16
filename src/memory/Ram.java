package src.memory;

public class Ram {
    int[][] register;
    private int programCounter;

    public Ram(int registerAmount, int capacity) {
        programCounter = 0;
        this.register = new int[registerAmount][capacity];
    }

    public int[][] getRegister() {
        return register;
    }

    public int getProgramCounter() {
        return programCounter;
    }
}
