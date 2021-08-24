/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.panel;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.schulung.wicket.kundenportal.pages.KundenUpdate;
import de.intellinet.schulung.wicket.kundenportal.pages.components.LoeschenKundeLink;
import de.intellinet.schulung.wicket.kundenportal.pages.components.SchufaAbfrageLink;
import de.intellinet.schulung.wicket.kundenportal.pages.components.SpeicherAlsCsvLink;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 22.04.2020
 */
public class KundenListView extends ListView<Person> {

    /**
     * Constructor.
     *
     * @param id
     * @param list
     */
    public KundenListView(String id, List<Person> list) {
        super(id, list);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor.
     *
     * @param id
     * @param list
     * @param listModel
     */
    public KundenListView(String id, IModel<? extends List<Person>> listModel) {

        super(id, listModel);
    }

    @Override
    protected void populateItem(ListItem<Person> item) {
        Person person = item.getModelObject();

        item.add(new Label("id", new PropertyModel<>(person, "id")));
        item.add(new Label("anrede", new PropertyModel<>(person, "anrede")));
        item.add(new Label("name", new PropertyModel<>(person, "name")));
        item.add(new Label("vorname", new PropertyModel<>(person, "vorname")));
        item.add(new Label("staatsangehoerigkeit", new PropertyModel<>(person, "staatsangehoerigkeit")));
        item.add(new Label("geburtsort", new PropertyModel<>(person, "geburtsort")));
        item.add(new Label("geburtsdatum", new PropertyModel<>(person, "geburtsdatum")));
        item.add(new Label("email", new PropertyModel<>(person, "kontakt.email")));
        item.add(new Label("mobil", new PropertyModel<>(person, "kontakt.mobil")));
        item.add(new Label("telefon", new PropertyModel<>(person, "kontakt.telefon")));
        item.add(new Label("hausnummer", new PropertyModel<>(person, "adresse.hausnummer")));
        item.add(new Label("strasse", new PropertyModel<>(person, "adresse.strasse")));
        item.add(new Label("plz", new PropertyModel<>(person, "adresse.plz")));
        item.add(new Label("ort", new PropertyModel<>(person, "adresse.ort")));
        item.add(new Label("land", new PropertyModel<>(person, "adresse.land")));

        // item.add(new Label("description", new PropertyModel<>(cheese,
        // "description")));
        // item.add(new Label("price", "$" + cheese.getPrice()));
        // item.add(new CheckBox("bool"));
        item.add(new SpeicherAlsCsvLink("speicher", item.getModel()));
        item.add(new LoeschenKundeLink("delete", item.getModel()));
        item.add(new SchufaAbfrageLink("Schufa", item.getModel()));

        // item.add(new Link("edit", item.getModel()));
        // item.add(new UpdateKundeLink("update", item.getModel()));
        // item.add(new Form<Void>("ch") {
        // @Override
        // protected void onSubmit() {
        //
        // info("checkbox0 : " + getModelObject().toString());
        //
        // }
        // });

        item.add(new CheckBox("checkbox0", Model.of(Boolean.FALSE)) {

            protected void onSelectionChanged() {

                getModelObject();

            }
        });
        item.add(new Link<Void>("update2") {

            @Override
            public void onClick() {
                setResponsePage(new KundenUpdate(new Model<>(person)));

            }
        });

    }

    @Override
    public boolean isVisible() {

        return CollectionUtils.isNotEmpty(this.getModelObject());
    }
}
