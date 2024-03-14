package src;

import src.input.ReadFile;
import src.memory.Ram;
import src.memory.Rom;

public class mainclass {
    public static void main(String[] args) {
        String filePath = "Tests/TestProg_PicSim_20230413/TPicSim101.LST";
        ReadFile readFile = new ReadFile();

        Rom rom = new Rom(1024);
        Ram ram = new Ram(2, 128);
        Processor processor = new Processor(ram, rom);

        readFile.readFile(filePath, rom);

        processor.decode();
    }
}
