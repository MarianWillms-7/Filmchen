package filme;

import java.util.Objects;

public class Film {
    private int id;
    private String titel;
    private String genre;
    private int dauer;

    public Film(int id, String titel, String genre, int dauer) {
        this.id = id;
        this.titel = titel;
        this.genre = genre;
        this.dauer = dauer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && Objects.equals(titel, film.titel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titel);
    }

    @Override
    public String toString() {
        return id + " | " + titel + " | " + genre + " | " + dauer;
    }

    public String getTitel() {
        return titel;
    }
}