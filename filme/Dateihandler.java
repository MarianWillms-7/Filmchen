package filme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Dateihandler {
    
    public List<Film> leseDatei(String dateipfad) {
        Set<Film> filmSet = new LinkedHashSet<>();
        try {
            List<String> zeilen = Files.readAllLines(Paths.get(dateipfad));
            for (String zeile : zeilen) {
                // Prüfung ohne continue: Nur verarbeiten, wenn nicht leer und kein Header
                if (!zeile.isEmpty() && !zeile.startsWith("Film") && !zeile.startsWith("[")) {
                    String[] daten = zeile.split(";");
                    if (daten.length >= 4) {
                        int id = Integer.parseInt(daten[0].trim());
                        String titel = daten[1].trim();
                        String genre = daten[2].trim();
                        int dauer = Integer.parseInt(daten[3].trim());
                        filmSet.add(new Film(id, titel, genre, dauer));
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(filmSet);
    }
}