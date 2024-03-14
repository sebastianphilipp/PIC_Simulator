package src.memory;

public class Ram {
    int[][] register;

    public Ram(int registerAmount, int capacity) {
        this.register = new int[registerAmount][capacity];
    }
}
