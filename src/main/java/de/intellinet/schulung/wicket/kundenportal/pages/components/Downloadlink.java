/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages.components;

import java.util.List;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.file.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 27.03.2020
 */
public class Downloadlink extends Link<List<Person>> {

    private static final Logger logger = LoggerFactory.getLogger(Downloadlink.class);

    public Downloadlink(String id, IModel<List<Person>> model) {
        super(id);
    }

    @Override
    public void onClick() {
        List<Person> list = getModelObject();
        logger.info("download");

        final File file = (File) getModelObject();

        // IResourceStream resourceStream = new FileResourceStream(file);
        // getRequestCycle().setRequestTarget(.../* uses resourceStream */...);
        //
    }
}
