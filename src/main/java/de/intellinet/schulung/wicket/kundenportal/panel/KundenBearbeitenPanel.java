/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.panel;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.extensions.markup.html.form.datetime.LocalDateTextField;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Anrede;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenAktualisierenService;
import de.intellinet.schulung.wicket.kundenportal.pages.Index;
import de.intellinet.schulung.wicket.kundenportal.utils.ExactErrorLevelFilter;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 01.04.2020
 */
public class KundenBearbeitenPanel extends Panel implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(KundenBearbeitenPanel.class);
    private IModel<Person> model = new Model<>(new Person());
    // private Model<Person> modelKontakt = new Model<>(new Person().getk);
    private List<Anrede> anredeList = Arrays.asList(Anrede.HERR, Anrede.FRAU, Anrede.UNBEKANNT);
    private DropDownChoice<Anrede> anrede;
    private TextField<String> nameField;
    private TextField<String> vornameField;
    private TextField<String> geburtsortField;
    private TextField<String> emailField;
    private TextField<String> mobilField;
    private TextField<String> telefonField;
    private TextField<String> strasseField;
    private TextField<String> hausnummerField;
    private TextField<String> plzField;
    private TextField<String> ortField;
    private DropDownChoice<String> laenderSelect;
    private DropDownChoice<String> staatsangehoerigkeitSelect;
    private List<String> laender = Arrays.asList("DE", "SY", "FR");
    private LocalDateTextField geburtsdatumField;
    private Form<Person> form;

    // DE - Deutschland
    // SY - Syrien
    // AT - Üsterreich

    /**
     * Constructor.
     *
     * @param id
     * @param model2
     * @param model
     */
    public KundenBearbeitenPanel(String id, IModel<Person> model2) {
        super(id);
        this.model = model2;

        form = createForm();
        anrede = new DropDownChoice<Anrede>("anrede");
        nameField = new TextField<String>("name", new PropertyModel<>(model, "name")); // Hier wird das Fild erstellt
        nameField.setRequired(true);
        vornameField = new TextField<String>("vorname", new PropertyModel<>(model, "vorname")); // Hier wird
        vornameField.setRequired(true); // das Fild erstellt
        geburtsortField = new TextField<String>("geburtsort", new PropertyModel<>(model, "geburtsort")); // Hier wird
        geburtsortField.setRequired(true);
        // Hier
        // wird
        geburtsdatumField =
                new LocalDateTextField("geburtsdatum", new PropertyModel<>(model, "geburtsdatum"), "yyyy-MM-dd") {

                    @Override
                    protected String[] getInputTypes() {

                        return new String[] {"text", "date"};
                    }

                };

        staatsangehoerigkeitSelect = new DropDownChoice<String>("staatsangehoerigkeitSelect",
                new PropertyModel<>(model, "staatsangehoerigkeit"), laender);

        laenderSelect =
                new DropDownChoice<String>("laenderSelect", new PropertyModel<>(model, "adresse.land"), laender);
        emailField = new TextField<String>("email", new PropertyModel<>(model, "kontakt.email"));
        emailField.add(EmailAddressValidator.getInstance());
        mobilField = new TextField<String>("mobil", new PropertyModel<>(model, "kontakt.mobil"));

        telefonField = new TextField<String>("telefon", new PropertyModel<>(model, "kontakt.telefon"));
        strasseField = new TextField<String>("strasse", new PropertyModel<>(model, "adresse.strasse"));
        hausnummerField = new TextField<String>("hausnummer", new PropertyModel<>(model, "adresse.hausnummer"));
        plzField = new TextField<String>("plz", new PropertyModel<>(model, "adresse.plz"));
        ortField = new TextField<String>("ort", new PropertyModel<>(model, "adresse.ort"));

    }

    public Form<Person> createForm() {
        return new Form<Person>("addNewPersonForm", model) {

            @Override
            protected void onSubmit() {
                logger.debug("onSubmit clicked");
                Person person = model.getObject();

                logger.debug(person.getName());
                logger.debug("Hinzufuegen");

                logger.trace("Person: {}", person);

                try {
                    kundenSpeichern(person);
                    setResponsePage(Index.class);
                } catch (Exception e) {
                    logger.error("fehler passiert", e);
                }
            }

        };

    }

    public void kundenSpeichern(Person person) throws ClassNotFoundException, SQLException {
        KundenAktualisierenService kundenAktualisierenService = new KundenAktualisierenService();

        kundenAktualisierenService.hinzufuegen(person);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        form.add(anrede); // hier wird die name Feld in die Form zugewiesen
        form.add(nameField); // hier wird die name Feld in die Form zugewiesen
        form.add(vornameField); // hier wird die name Feld in die Form zugewiesen
        form.add(geburtsortField); // hier wird die name Feld in die Form zugewiesen
        form.add(staatsangehoerigkeitSelect); // hier wird die name Feld in die Form zugewiesen
        form.add(geburtsdatumField); // hier wird die name Feld in die Form zugewiesen
        form.add(emailField); // hier wird die name Feld in die Form zugewiesen
        form.add(mobilField); // hier wird die name Feld in die Form zugewiesen
        form.add(telefonField); // hier wird die name Feld in die Form zugewiesen
        form.add(strasseField); // hier wird die name Feld in die Form zugewiesen
        form.add(hausnummerField); // hier wird die name Feld in die Form zugewiesen
        form.add(plzField); // hier wird die name Feld in die Form zugewiesen
        form.add(ortField); // hier wird die name Feld in die Form zugewiesen
        form.add(laenderSelect); // hier wird die name Feld in die Form zugewiesen
        add(form); // hier wird die form im der Seite zugefügt
        add(new FeedbackPanel("feedbackMessag" + "e", new ExactErrorLevelFilter(FeedbackMessage.ERROR)));
        add(new FeedbackPanel("successMessage", new ExactErrorLevelFilter(FeedbackMessage.SUCCESS)));
    }
    // String name = (String) nameField.getDefaultModelObject();
    // nameField = new TextField<>("name");
    // nameField.setRequired(true);
    //
    // return form.add(nameField);
    // @Override
    // public final void onSubmit() {
    //
    // System.out.println(("Hallo " + name));
    // boservices.proccessOrder(warenkorb.getObject());
    // warenkorb.getObject().getCheeses().clear();
    // setResponsePage(Index.class);
    // }

}
