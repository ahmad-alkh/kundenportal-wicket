/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.panel;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.wicket.extensions.markup.html.form.datetime.LocalDateTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenSuchService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 09.04.2020
 */
public class KundenSuchePanel extends Panel implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(KundenSuchePanel.class);
	private Model<Person> model = new Model<>(new Person());
	private TextField<String> nameField;
	private TextField<String> vornameField;
	private LocalDateTextField geburtsdatumField;
	private Form<Person> form;

	private Model<ArrayList<Person>> modelGefundenePersonen = new Model<>(new ArrayList<>());
	private Person person = model.getObject();

	KundenSuchService kundenSuchService = new KundenSuchService();
	private KundenUebersichtPanel kundenUebersicht;

	/**
	 * Constructor.
	 *
	 */
	public KundenSuchePanel(String id, Model<Person> person) {
		super(id, person);
		form = createForm();

		nameField = new TextField<String>("name", new PropertyModel<>(model, "name")); // Hier wird das Fild erstellt
		vornameField = new TextField<String>("vorname", new PropertyModel<>(model, "vorname")); // Hier wird
		kundenUebersicht = new KundenUebersichtPanel("kundenUebersicht", modelGefundenePersonen);

	}

	// geburtsdatumField =
	// new LocalDateTextField("geburtsdatum", new PropertyModel<>(model,
	// "geburtsdatum"), "yyyy-MM-dd")
	// {
	//
	// @Override
	// protected String[] getInputTypes() {
	//
	// return new String[] {"text", "date"};
	// }
	//
	// };

	/**
	 * TODO Comment
	 * 
	 * @return
	 */
	private Form<Person> createForm() {
		return new Form<Person>("sucheKunden", model) {

			@Override
			protected void onSubmit() {
				logger.info("onSubmit clicked");

				// logger.info("Person : {}, {}", person.getName(), person.getVorname());
				// logger.info("suche");
				// logger.info("Person: {}", person);

				try {
					modelGefundenePersonen.setObject(
							new ArrayList<>(kundenSuchService.sucheNachVorOderNachNameOderGeburtsdatum(person.getName(),
									person.getVorname(), person.getGeburtsdatum())));

					// setResponsePage(Index.class);
					logger.info("gefunden {}", modelGefundenePersonen.getObject().size());

				} catch (Exception e) {
					logger.error("fehler suche", e);
				}
			}

		};
	}

	@Override
	public void onInitialize() {
		super.onInitialize();
		form.add(nameField); // hier wird die name Feld in die Form zugewiesen
		form.add(vornameField); //

		add(form);
		// form.add(geburtsdatumField); //

		add(kundenUebersicht);
	}

	@Override
	protected void onConfigure() {
		// TODO Auto-generated method stub
		super.onConfigure();
//		add(listView);
	}

}
