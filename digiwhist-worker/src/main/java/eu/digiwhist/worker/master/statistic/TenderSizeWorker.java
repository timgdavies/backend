package eu.digiwhist.worker.master.statistic;

import java.util.Arrays;

import eu.digiwhist.dataaccess.dao.DAOFactory;
import eu.digiwhist.dataaccess.utils.PopulateUtils;
import eu.dl.dataaccess.dao.MasterBodyDAO;
import eu.dl.dataaccess.dao.MasterTenderDAO;
import eu.dl.dataaccess.dao.TransactionUtils;
import eu.dl.dataaccess.dto.codetables.TenderSize;
import eu.dl.dataaccess.dto.master.MasterTender;
import eu.dl.worker.BaseWorker;
import eu.dl.worker.Message;
import eu.dl.worker.master.utils.TenderSizeUtils;

/**
 * This worker helpes to generate messages for statistic calulations workers.
 *
 * @author Jakub Krafka
 */
public final class TenderSizeWorker extends BaseWorker {

    private static final String INCOMING_EXCHANGE_NAME = "master";

    private static final String OUTGOING_EXCHANGE_NAME = "master";

    private static final String VERSION = "1.0";

    private static TransactionUtils transactionUtils;

    private static MasterTenderDAO masterDao;

    private static MasterBodyDAO masterBodyDao;

    private static PopulateUtils populateUtils;

    /**
     * Initialization of everythong.
     */
    public TenderSizeWorker() {
        super();
        transactionUtils = DAOFactory.getDAOFactory().getTransactionUtils();

        masterDao = DAOFactory.getDAOFactory().getMasterTenderDAO(getName(), VERSION);

        masterBodyDao = DAOFactory.getDAOFactory().getMasterBodyDAO(getName(), VERSION);

        populateUtils = new PopulateUtils(masterBodyDao, null);
    }

    @Override
    protected String getVersion() {
        return VERSION;
    }

    @Override
    protected String getIncomingExchangeName() {
        return INCOMING_EXCHANGE_NAME;
    }

    @Override
    protected String getIncomingQueueName() {
        return getIncomingQueueNameFromConfig();
    }

    @Override
    protected String getOutgoingExchangeName() {
        return OUTGOING_EXCHANGE_NAME;
    }

    @Override
    public void doWork(final Message message) {
        transactionUtils.begin();
    		
        String id = message.getValue("id");

        final MasterTender tender = masterDao.getById(id);

        if (tender != null) {
            MasterTender populatedTender = populateUtils.populateBodies(Arrays.asList(tender)).get(0);
            if (populatedTender == null || populatedTender.getSize() != null) {
                // do not overwrite tender size
                return;
            }

            // calculate new tender size
            TenderSize tenderSize = TenderSizeUtils.calculate(populatedTender);
            if (tenderSize != null) {
                // tender size calculated, save the updated tender
                tender.setSize(tenderSize);
                masterDao.save(tender);
            }
        }
        
        transactionUtils.commit();
    }

    @Override
    protected void resend(final String version, final String dateFrom, final String dateTo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected TransactionUtils getTransactionUtils() {
        return DAOFactory.getDAOFactory().getTransactionUtils();
    }
}
