package filme;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Gui gui;
    private Dateihandler dateiHandler;
    private List<Film> alleFilme;

    public Controller() {
        this.dateiHandler = new Dateihandler();
        // Pfad ggf. auf "src/FilmListe.txt" anpassen, falls Datei dort liegt
        this.alleFilme = dateiHandler.leseDatei("FilmListe.txt");
        this.gui = new Gui();
        
        gui.setzeFilmeInListe(alleFilme);
        initController();
    }

    private void initController() {
        gui.getBtnAufsteigend().addActionListener(e -> {
            alleFilme.sort(Comparator.comparing(Film::getTitel));
            gui.setzeFilmeInListe(alleFilme);
        });

        gui.getBtnAbsteigend().addActionListener(e -> {
            alleFilme.sort(Comparator.comparing(Film::getTitel).reversed());
            gui.setzeFilmeInListe(alleFilme);
        });

        gui.getBtnSuchen().addActionListener(e -> {
            String filter = gui.getTextSuchwort().getText().toLowerCase();
            List<Film> gefiltert = alleFilme.stream()
                .filter(f -> f.getTitel().toLowerCase().contains(filter))
                .collect(Collectors.toList());
            gui.setzeFilmeInListe(gefiltert);
        });

        gui.getBtnZurueck().addActionListener(e -> gui.setzeFilmeInListe(alleFilme));
    }
}