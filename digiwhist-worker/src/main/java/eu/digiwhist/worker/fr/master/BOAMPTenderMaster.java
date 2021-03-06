package eu.digiwhist.worker.fr.master;

import java.util.Currency;
import java.util.List;

import eu.digiwhist.worker.master.BaseDigiwhistTenderMaster;
import eu.dl.dataaccess.dto.master.MasterTender;
import eu.dl.dataaccess.dto.matched.MatchedTender;

/**
 * Tender master for France.
 *
 * @author Marek Mikes
 */
public class BOAMPTenderMaster extends BaseDigiwhistTenderMaster {
    private static final String VERSION = "1";

    @Override
    protected final String getVersion() {
        return VERSION;
    }

    @Override
    protected final String getIncomingQueueName() {
        return getIncomingQueueNameFromConfig();
    }

    @Override
    protected final void registerSpecificPlugins() {
    }

    @Override
    protected final List<MatchedTender> sourceSpecificPreprocessData(final List<MatchedTender> items) {
        return items;
    }
    
    @Override
    protected final Currency getNationalCurrency() {
        return Currency.getInstance("EUR");
    }

    @Override
    protected final MasterTender sourceSpecificPostprocessData(final MasterTender item) {
        return item;
    }
}
