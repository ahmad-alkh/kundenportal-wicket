/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.schulung.wicket.kundenportal.panel.KundenBearbeitenPanel;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 01.04.2020
 */
public class KundenHinzufuegen extends KundenportalPage {

    private static final long serialVersionUID = 1L;

    public KundenHinzufuegen() {
        super();

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new KundenBearbeitenPanel("kundenpanel", Model.of(new Person())));

        add(new Link<Void>("zurueck") {

            @Override
            public void onClick() {
                setResponsePage(Index.class);

            }

        });

    }

}
