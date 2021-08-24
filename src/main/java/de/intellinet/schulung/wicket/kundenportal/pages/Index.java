
package de.intellinet.schulung.wicket.kundenportal.pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.CSVExport;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenSuchService;
import de.intellinet.schulung.wicket.kundenportal.panel.KundenUebersichtPanel;

public class Index extends KundenportalPage {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Index.class);
	private KundenSuchService kundenSuchService = new KundenSuchService();

	private KundenUebersichtPanel kundenUebersicht;

	public Index() {
		super();

		ArrayList<Person> ergebnisliste = new ArrayList<>(kundenSuchService.sucheAlle());

		// KundenModel kundenModel = new KundenModel();
		kundenUebersicht = new KundenUebersichtPanel("kundenUebersicht", new Model<>(ergebnisliste));

		add(new DownloadLink("download", new IModel<File>() {

			private static final long serialVersionUID = 1L;

			@Override
			public File getObject() {
				File tempFile;
				try {
					tempFile = File.createTempFile("testdatei", ".csv");
					CSVExport cSVexport = new CSVExport();
//					InputStream data1  = cSVService.exportAllPersonen();
					FileWriter filewriter = new FileWriter(tempFile);
					cSVexport.exportCsv(filewriter, ergebnisliste);
					filewriter.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}

				return tempFile;
			}

		}, "testdatei.csv").setCacheDuration(Duration.NONE).setDeleteAfterDownload(true));

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		logger.info("Index init");
		// ArrayList<Person> personen = new ArrayList<>(new
		// KundenSuchService().sucheAlle());
		//
		// add(new ListView<Person>("cheese", new Model<ArrayList<Person>>(personen)) {
		add(kundenUebersicht);

		// add(new WarenkorbPanel("warenkorb"));
		// add(new HinzufuegenKundeLink("add"));
		// add(new SuchKundeLink("suche"));
//       add(new SpeicherAlsCsvLink("speicher",  item.getModel()));

		add(new Link<Void>("add2") {

			@Override
			public void onClick() {
				setResponsePage(KundenHinzufuegen.class);

			}
		});
		add(new Link<Void>("such") {

			@Override
			public void onClick() {
				setResponsePage(KundenSuche.class);

			}
		});

	}

}
