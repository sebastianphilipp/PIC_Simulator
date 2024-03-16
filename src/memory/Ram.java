package src.memory;

public class Ram {
    int[][] register;

    public Ram(int registerAmount, int capacity) {
        this.register = new int[registerAmount][capacity];
        //init PCL in bank 0 on 02h
        this.register[0][2] = 0;
    }

    public int readRegister(int bank, int fileAddress) {
        return register[bank][fileAddress];
    }

    public int writeRegister(int bank, int fileAddress, int value) {
        return register[bank][fileAddress] = value;
    }
}
