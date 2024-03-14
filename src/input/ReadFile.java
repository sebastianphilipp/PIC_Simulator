package src.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public void readFile() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("Tests/TestProg_PicSim_20230413/TPicSim1.LST"));
            String line = reader.readLine();

            while (line != null) {
                if (!line.startsWith(" ")) {
                    System.out.println(line);
                }

                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

