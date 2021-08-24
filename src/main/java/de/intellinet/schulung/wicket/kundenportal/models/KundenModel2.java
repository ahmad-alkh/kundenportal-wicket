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
public class KundenModel2 extends Model<ArrayList<Person>> {

    private String vorname;
    private String nachname;
    private LocalDate geburtsDaum;
    KundenSuchService kundenSuchService = new KundenSuchService();

    public KundenModel2(String vorname, String nachname, LocalDate geburtsDaum) {
        this.geburtsDaum = geburtsDaum;
        this.nachname = nachname;
        this.vorname = vorname;

    }

    @Override
    public ArrayList<Person> getObject() {
        try {
            return new ArrayList<>(
                    kundenSuchService.sucheNachVorOderNachNameOderGeburtsdatum(nachname, vorname, geburtsDaum));

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            // FIXME Logger einbauen
            e.printStackTrace();
        }
        return new ArrayList<Person>();
    }

}
