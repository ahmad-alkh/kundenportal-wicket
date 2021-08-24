/**
 * 
 */

package de.intellinet.schulung.wicket.kundenportal.panel;

import java.util.List;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * @author aakh1
 *
 */
public class KundenUebersichtPanel extends Panel {

    private KundenListView listView;

    public KundenUebersichtPanel(String id, IModel<? extends List<Person>> listModel) {
        super(id, listModel);

        listView = new KundenListView("personDateView", listModel);
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(listView);
    }

    @Override
    protected void onConfigure() {

        super.onConfigure();
        // add(listView);
    }
}
