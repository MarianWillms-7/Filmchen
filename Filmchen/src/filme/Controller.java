package filme;

import java.util.List;

public class Controller {
	private Gui gui;
    private Dateihandler dateiHandler;

	public Controller() {
        this.dateiHandler = new Dateihandler();
		this.gui = new Gui(this);
        
		filmeAnzeigen();
	}

	public void filmeAnzeigen() {
		List<String> filme = dateiHandler.leseDateiMitNIO("FilmListe.txt");
        
        gui.setzeFilmeInListe(filme);
	}
	
}