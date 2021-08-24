/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.models;

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
public class KundenModel extends Model<ArrayList<Person>> {

    KundenSuchService kundenSuchService = new KundenSuchService();

    @Override
    public ArrayList<Person> getObject() {
        return new ArrayList<>(kundenSuchService.sucheAlle());

    }

}
