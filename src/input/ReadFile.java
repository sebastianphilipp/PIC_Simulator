package src.input;

import src.memory.Rom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public void readFile(String filePath, Rom memory) {
        int address;
        int value;
        try (BufferedReader reader = new BufferedReader((new FileReader(filePath)))) {
            String line = reader.readLine();

            while (line != null) {
                if (!line.startsWith(" ")) {
                    String[] lineSplit = line.split(" ");
                    if (!(lineSplit[0].length() == 4 && lineSplit[1].length() == 4)) {
                        continue;
                    }
                    address = Integer.parseInt(lineSplit[0], 16);
                    value = Integer.parseInt(lineSplit[1], 16);

                    memory.writeAddress(address, value);
                }
                // read next line
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

