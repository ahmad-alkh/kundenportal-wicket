/**
 * 
 */
package de.intellinet.schulung.wicket.kundenportal.pages.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.IModel;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * @author aakh1
 *
 */
public class CheckListeLink {

	List<Person> persons;
//		

	public CheckListeLink(IModel<Person> model) {
		super();
		persons = new ArrayList<Person>();
	}

	private void liste() {
//		persons.add(model);

	}
}
