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
        //decode for literal & control commands
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
                        System.out.println("No for literal 11 Command");
                        break;
                }
                break;
            case 0b10:
                if (((command >> 8) & 0b001111) == 0b1000) {
                    System.out.println("goto");
                } else {
                    System.out.println("call");
                }
                break;
            case 0b00:
                switch (command & 0b1111) {
                    case 0b0100:
                        System.out.println("CLRWDT");
                        break;
                    case 0b1001:
                        System.out.println("RETFIE");
                        break;
                    case 0b1000:
                        System.out.println("RETURN");
                        break;
                    case 0b0011:
                        System.out.println("SLEEP");
                        break;
                    default:
                        System.out.println("No for literal 00 Command");
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
