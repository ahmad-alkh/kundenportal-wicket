/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.utils;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;

/**
 * [TODO Insert description here.]
 * 
 * @author chrnie
 *
 * @since 28 Feb 2020
 */
public class ExactErrorLevelFilter implements IFeedbackMessageFilter {

    private int errorLevel;

    /**
     * Constructor.
     *
     * @param error
     */
    public ExactErrorLevelFilter(int error) {
        this.errorLevel = error;
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean accept(FeedbackMessage message) {
        return message.getLevel() == errorLevel;
    }

}
