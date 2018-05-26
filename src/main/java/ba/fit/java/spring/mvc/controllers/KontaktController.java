package ba.fit.java.spring.mvc.controllers;

import ba.fit.java.spring.mvc.models.Contact;
import ba.fit.java.spring.mvc.models.Kontakt;
import ba.fit.java.spring.mvc.viewmodels.kontakti.KontaktVM;
import ba.fit.java.spring.mvc.viewmodels.kontakti.KontaktIndexVM;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/kontakti")
public class KontaktController {
    public static File _jsonDbFile;

    @GetMapping("/novi")
    public ModelAndView dodaj(HttpServletRequest request, HttpServletResponse response) {
        KontaktVM model = new KontaktVM();
        return new ModelAndView("kontakti/kontakt", "model", model);
    }

    @PostMapping(value = "/snimi")
    public ModelAndView snimi(@ModelAttribute("model") KontaktVM input)
    {
        Contact novi = new Contact(input.id, input.ime, input.prezime, input.telefon, input.adresa, input.website, input.email);

        List<Contact> kontakti = getKontakteDb();

        if  (novi.contactId == 0) {
            novi.contactId = ++Iterables.getLast(kontakti).contactId;
        }

        kontakti.add(novi);
        setKontakteDb(kontakti);

        KontaktIndexVM model = new KontaktIndexVM();
        model.rows = kontakti
                .stream()
                .map(a -> {
                    KontaktIndexVM.Row row = new KontaktIndexVM.Row();
                    row.id = a.contactId;
                    row.ime = a.ime;
                    row.prezime = a.prezime;
                    row.website = a.website;
                    row.telefon = a.telefon;
                    row.email = a.email;
                    row.adresa = a.adresa;
                    return row;
                })
                .collect(toList());

        return new ModelAndView("kontakti/index", "model", model);
    }

    @GetMapping("")
    public ModelAndView prikaz()
    {
        List<Contact> kontakti = getKontakteDb();

        KontaktIndexVM model = new KontaktIndexVM();
        model.rows = kontakti
                .stream()
                .map(a -> {
                    KontaktIndexVM.Row row = new KontaktIndexVM.Row();
                    row.id = a.contactId;
                    row.ime = a.ime;
                    row.prezime = a.prezime;
                    row.website = a.website;
                    row.telefon = a.telefon;
                    row.email = a.email;
                    row.adresa = a.adresa;
                    return row;
                })
                .collect(toList());

        return new ModelAndView("kontakti/index", "model", model);
    }

    private void setKontakteDb(List<Contact> kontakti) {
        _jsonDbFile = new File(getClass().getClassLoader().getResource("mydb_contacts.json").getFile());
        try(Writer writer = new FileWriter(_jsonDbFile)){
            Gson gson = new GsonBuilder().create();
            gson.toJson(kontakti, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<Contact> getKontakteDb() {
        _jsonDbFile = new File(getClass().getClassLoader().getResource("mydb_contacts.json").getFile());
        Gson gson1 = new Gson();
        List<Contact> kontakti = new ArrayList<Contact>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(_jsonDbFile));
            //convert the json string back to object
            Type type = new TypeToken<ArrayList<Contact>>() {}.getType();
            kontakti = gson1.fromJson(br, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kontakti;
    }

    // izbriši testnu funkciju
    private void upis() {
        _jsonDbFile = new File(getClass().getClassLoader().getResource("mydb_contacts.json").getFile());
        List<Contact> kontakti = new ArrayList<Contact>();
        kontakti.add(new Contact(1, "Eldar", "Jahijagic", "62 / 001-125", "Marsala 5b", "g.com", "eldar.jahijagic@edu.fit.ba"));
        kontakti.add(new Contact(1, "Almir", "Suljic", "61 / 123-456", "Sabana Zahe 21", "g.com", "almir.suljuc@gmail.com"));

        try (Writer writer = new FileWriter(_jsonDbFile)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(kontakti, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void addKontaktDb() {
        // napisati funkciju za unos jednog kontakta.
    }

}
