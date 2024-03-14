package src;

import src.memory.Ram;
import src.memory.Rom;

public class Processor {
    Ram ram;
    Rom rom;

    public Processor(Ram ram, Rom rom) {
        this.ram = ram;
        this.rom = rom;
    }

    public int[] decode() {

        return new int[1];
    }
}
