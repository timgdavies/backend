package eu.dl.worker.raw.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import eu.dl.core.RecoverableException;

/**
 * Created by tomasposepny.
 */
public final class CrawlerUtils {
    private static final Logger logger = LoggerFactory.getLogger(CrawlerUtils.class);

    /**
     * Suppress default constructor for noninstantiability.
     */
    private CrawlerUtils() {
        throw new AssertionError();
    }
    /**
     * Simulates clicking on an element given by it's XPath expression.
     *
     * @param actualPage
     *         actual page where the element can be found
     * @param elementXPath
     *         XPath expression specifying the element that should be clicked
     *
     * @return page that has focus after the element has been clicked
     */
    public static HtmlPage clickElement(final HtmlPage actualPage, final String elementXPath) {
        final HtmlElement clickableElement = actualPage.getFirstByXPath(elementXPath);
        if (clickableElement == null) {
            return null;
        }
        try {
            return clickableElement.click();
        } catch (IOException e) {
            logger.error("Failed while trying to click on element given by {} xpath.", elementXPath, e);
            throw new RecoverableException("Failed while trying to click on element.", e);
        }
    }
}
