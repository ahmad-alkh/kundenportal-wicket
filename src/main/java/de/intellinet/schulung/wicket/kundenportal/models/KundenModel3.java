/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.models;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.wicket.model.Model;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenSuchService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 26.03.2020
 */
public class KundenModel3 extends Model<ArrayList<Person>> {

    KundenSuchService kundenSuchService = new KundenSuchService();
    private Model<Person> model = new Model<>(new Person());

    public KundenModel3(String vorname, String nachname, LocalDate geburtsDaum) {

        Person person = new Person();
        person.setGeburtsdatum(geburtsDaum);
        person.setName(nachname);
        person.setVorname(vorname);
        model = new Model<>(person);
    }

    @Override
    public ArrayList<Person> getObject() {
        try {
            Person person = model.getObject();
            return new ArrayList<>(kundenSuchService.sucheNachVorOderNachNameOderGeburtsdatum(person.getName(),
                    person.getVorname(), person.getGeburtsdatum()));

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            // FIXME Logger einbauen
            e.printStackTrace();
        }
        return new ArrayList<Person>();
    }

}
