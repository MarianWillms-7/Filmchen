package filme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Dateihandler {
    
    public List<String> leseDateiMitNIO(String dateipfad) {
        try {
            return Files.readAllLines(Paths.get(dateipfad));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}