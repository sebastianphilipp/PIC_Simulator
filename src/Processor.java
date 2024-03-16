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
        int command = rom.readAddress(ram.getProgramCounter());
        System.out.println(Integer.toBinaryString(rom.readAddress(0)));
        System.out.println(Integer.toBinaryString(command));
        switch (command >> 12) {
            case 0b11:
                switch ((command >> 8) & 0b001111) {
                    case 0b1110:
                        System.out.println("addlw");
                        break;
                    case 0b1001:
                        System.out.println("andlw");
                        break;
                    case 0b1000:
                        System.out.println("iorlw");
                        break;
                    case 0b0000:
                        System.out.println("movlw");
                        break;
                    case 0b0100:
                        System.out.println("retlw");
                        break;
                    case 0b1100:
                        System.out.println("sublw");
                        break;
                    case 0b1010:
                        System.out.println("xorlw");
                        break;
                    default:
                        System.out.println("No Command");
                        break;
                }
                break;

            default:
                System.out.println("default");
                break;
        }

        return new int[1];
    }
}
