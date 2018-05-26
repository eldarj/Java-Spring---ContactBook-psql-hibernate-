package ba.fit.java.spring.mvc.models;

public class Kontakt {
    public String ime;

    public String prezime;

    public String telefon;

    public Kontakt(String ime) {
        this.ime = ime;
    }

    public Kontakt(String ime, String prezime, String telefon) {
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
