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

    public void decode() {
        int command = rom.readAddress(ram.readRegister(0, 2));
        int secondBlock = (command >> 8) & 0b001111;
        //decode for literal & control commands
        switch (command >> 12) {
            case 0b11:
                switch (secondBlock) {
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
                if ((secondBlock) == 0b1000) {
                    System.out.println("goto");
                } else {
                    System.out.println("call");
                }
                break;
            case 0b00:
                if ((secondBlock) == 0) {
                    //last 4 bits?
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
                        //two operations from BYTE-ORIENTED FILE REGISTER OPERATIONS with 00
                        case 0:
                            //3 block starts with?
                            if ((command >> 7) == 1) {
                                System.out.println("MOVWF");
                            } else {
                                System.out.println("NOP");
                            }
                            break;
                        default:
                            System.out.println("No for 00 Command");
                            break;
                    }
                } else {
                    //BYTE-ORIENTED FILE REGISTER OPERATIONS
                    switch (secondBlock) {
                        case 0b0111:
                            System.out.println("ADDWF");
                            break;
                        case 0b0101:
                            System.out.println("ANDWF");
                            break;
                        case 0b0001:
                            //destination bit set?
                            if (((command & 128) >> 7) == 1) {
                                System.out.println("CLRF");
                            } else {
                                System.out.println("CLRW");
                            }
                            break;
                        case 0b1001:
                            System.out.println("COMF");
                            break;
                        case 0b0011:
                            System.out.println("DECF");
                            break;
                        case 0b1011:
                            System.out.println("DECFSZ");
                            break;
                        case 0b1010:
                            System.out.println("INCF");
                            break;
                        case 0b1111:
                            System.out.println("INCFSZ");
                            break;
                        case 0b0100:
                            System.out.println("IORWF");
                            break;
                        case 0b1000:
                            System.out.println("MOVF");
                            break;
                        case 0b1101:
                            System.out.println("RLF");
                            break;
                        case 0b1100:
                            System.out.println("RRF");
                            break;
                        case 0b0010:
                            System.out.println("SUBWF");
                            break;
                        case 0b1110:
                            System.out.println("SWAPF");
                            break;
                        case 0b0110:
                            System.out.println("XORWF");
                            break;
                    }
                }
                break;
            // bit oriented file register operations
            case 0b01:
                switch (secondBlock >> 2) {
                    case 0b00:
                        System.out.println("BCF");
                        break;
                    case 0b01:
                        System.out.println("BSF");
                        break;
                    case 0b10:
                        System.out.println("BTFSC");
                        break;
                    case 0b11:
                        System.out.println("BTFSS");
                        break;
                }
                break;
            default:
                System.out.println("no command with that 2 starting bits");
                break;
        }
    }

    public void addLW(){

    }
}
