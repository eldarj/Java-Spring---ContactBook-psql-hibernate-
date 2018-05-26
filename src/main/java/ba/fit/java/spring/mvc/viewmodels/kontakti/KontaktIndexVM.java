package ba.fit.java.spring.mvc.viewmodels.kontakti;

import ba.fit.java.spring.mvc.models.Contact;
import com.sun.rowset.internal.Row;

import java.util.ArrayList;
import java.util.List;

public class KontaktIndexVM {
    public List<Row> rows;
    public static class Row
    {
        public int id;
        public String ime;
        public String prezime;
        public String telefon;
        public String adresa;
        public String website;
        public String email;
    }
}
