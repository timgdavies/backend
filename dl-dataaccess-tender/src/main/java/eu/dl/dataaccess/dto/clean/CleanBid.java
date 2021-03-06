package eu.dl.dataaccess.dto.clean;

import static eu.dl.dataaccess.utils.ClassUtils.removeNonsenses;

import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import eu.dl.dataaccess.annotation.Transformable;
import eu.dl.dataaccess.dto.generic.Document;
import eu.dl.dataaccess.dto.generic.Payment;
import eu.dl.dataaccess.dto.generic.Price;
import eu.dl.dataaccess.dto.generic.UnitPrice;
import eu.dl.dataaccess.utils.ValidationUtils;

// TODO: Auto-generated Javadoc
/**
 * Bid.
 */
@Transformable
public class CleanBid implements Validable {
    /**
     * Winning bid.
     */
    private Boolean isWinning;

    /**
     * Bid was disqualified.
     */
    private Boolean isDisqualified;

    /**
     * Stated reason for disqualification.
     */
    private String disqualificationReason;

    /**
     * Bidders.
     */
    private List<CleanBody> bidders;

    /**
     * List of offered unit prices.
     */
    private List<UnitPrice> unitPrices;

    /**
     * List of associated documents, such as bid, final tender or document
     * describing ownership structure.
     */
    private List<Document> documents;

    /**
     * Ex post buyer evaluation of quality.
     */
    private Boolean wasInRequestedQuality;

    /**
     * Based on completionTime, or may be ex post buyer evaluation of time.
     */
    private Boolean wasFinishedOnTime;

    /**
     * Based on payment and bidPrice, or ex post evaluation by buyer.
     */
    private Boolean wasForEstimatedValue;

    /**
     * List of actual payments.
     */
    private List<Payment> payments;

    /**
     * Subcontractor is involved.
     */
    private Boolean isSubcontracted;

    /**
     * Percentage of tender volume to be subcontracted.
     */
    private Integer subcontractedProportion;

    /**
     * Value of the tender likely to be subcontracted to third parties.
     */
    private Price subcontractedValue;

    /**
     * Offered price.
     */
    private Price price;

    /**
     * Final calculated price (only for winning bid), calculated according to the algorithm described on
     * zindex wiki (http://wiki.zindex.cz/doku.php?id=internal:urceni_ceny).
     */
    private Price robustPrice;

    /**
     * Number of years for annual price.
     */
    private Integer annualPriceYearsCount;

    /**
     * Number of months for monthly price.
     */
    private Integer monthlyPriceMonthsCount;

    /**
     * Ad hoc consortium formed by multiple bodies. If true, leading body is
     * specified as bidder.
     */
    private Boolean isConsortium;

    /**
     * List of all subcontractors, includint the indirect ones.
     */
    private List<CleanBody> subcontractors;

    /**
     * Bid id. This one must be unique within superior lot object.
     */
    private String bidId;

    /**
     * Gets the checks if is winning.
     *
     * @return the isWinning
     */
    public final Boolean getIsWinning() {
        return isWinning;
    }

    /**
     * Sets the is winning.
     *
     * @param isWinning
     *            the isWinning to set
     * @return this instance for chaining
     */
    public final CleanBid setIsWinning(final Boolean isWinning) {
        this.isWinning = isWinning;
        return this;
    }

    /**
     * Gets the checks if is disqualified.
     *
     * @return the isDisqualified
     */
    public final Boolean getIsDisqualified() {
        return isDisqualified;
    }

    /**
     * Sets the is disqualified.
     *
     * @param isDisqualified
     *            the isDisqualified to set
     * @return this instance for chaining
     */
    public final CleanBid setIsDisqualified(final Boolean isDisqualified) {
        this.isDisqualified = isDisqualified;
        return this;
    }

    /**
     * Gets the disqualification reason.
     *
     * @return the disqualificationReason
     */
    public final String getDisqualificationReason() {
        return disqualificationReason;
    }

    /**
     * Sets the disqualification reason.
     *
     * @param disqualificationReason
     *            the disqualificationReason to set
     * @return this instance for chaining
     */
    public final CleanBid setDisqualificationReason(final String disqualificationReason) {
        this.disqualificationReason = disqualificationReason;
        return this;
    }

    /**
     * Gets the bidders.
     *
     * @return the list of bidders
     */
    public final List<CleanBody> getBidders() {
        return bidders;
    }

    /**
     * Sets the bidders.
     *
     * @param bidders
     *            the list of bidders to set
     * @return this instance for chaining
     */
    public final CleanBid setBidders(final List<CleanBody> bidders) {
        this.bidders = bidders;
        return this;
    }

    /**
     * Gets the unit prices.
     *
     * @return the unitPrices
     */
    public final List<UnitPrice> getUnitPrices() {
        return unitPrices;
    }

    /**
     * Sets the unit prices.
     *
     * @param unitPrices
     *            the unitPrices to set
     * @return this instance for chaining
     */
    public final CleanBid setUnitPrices(final List<UnitPrice> unitPrices) {
        this.unitPrices = unitPrices;
        return this;
    }

    /**
     * Gets the documents.
     *
     * @return the documents
     */
    public final List<Document> getDocuments() {
        return documents;
    }

    /**
     * Sets the documents.
     *
     * @param documents
     *            the documents to set
     * @return this instance for chaining
     */
    public final CleanBid setDocuments(final List<Document> documents) {
        this.documents = documents;
        return this;
    }

    /**
     * Gets the was in requested quality.
     *
     * @return the wasInRequestedQuality
     */
    public final Boolean getWasInRequestedQuality() {
        return wasInRequestedQuality;
    }

    /**
     * Sets the was in requested quality.
     *
     * @param wasInRequestedQuality
     *            the wasInRequestedQuality to set
     * @return this instance for chaining
     */
    public final CleanBid setWasInRequestedQuality(final Boolean wasInRequestedQuality) {
        this.wasInRequestedQuality = wasInRequestedQuality;
        return this;
    }

    /**
     * Gets the was finished on time.
     *
     * @return the wasFinishedOnTime
     */
    public final Boolean getWasFinishedOnTime() {
        return wasFinishedOnTime;
    }

    /**
     * Sets the was finished on time.
     *
     * @param wasFinishedOnTime
     *            the wasFinishedOnTime to set
     * @return this instance for chaining
     */
    public final CleanBid setWasFinishedOnTime(final Boolean wasFinishedOnTime) {
        this.wasFinishedOnTime = wasFinishedOnTime;
        return this;
    }

    /**
     * Gets the was for estimated value.
     *
     * @return the wasForEstimatedValue
     */
    public final Boolean getWasForEstimatedValue() {
        return wasForEstimatedValue;
    }

    /**
     * Sets the was for estimated value.
     *
     * @param wasForEstimatedValue
     *            the wasForEstimatedValue to set
     * @return this instance for chaining
     */
    public final CleanBid setWasForEstimatedValue(final Boolean wasForEstimatedValue) {
        this.wasForEstimatedValue = wasForEstimatedValue;
        return this;
    }

    /**
     * Gets the payments.
     *
     * @return the payments
     */
    public final List<Payment> getPayments() {
        return payments;
    }

    /**
     * Sets the payments.
     *
     * @param payments
     *            the payments to set
     * @return this instance for chaining
     */
    public final CleanBid setPayments(final List<Payment> payments) {
        this.payments = payments;
        return this;
    }

    /**
     * Gets the checks if is subcontracted.
     *
     * @return the isSubcontracted
     */
    public final Boolean getIsSubcontracted() {
        return isSubcontracted;
    }

    /**
     * Sets the is subcontracted.
     *
     * @param isSubcontracted
     *            the isSubcontracted to set
     * @return this instance for chaining
     */
    public final CleanBid setIsSubcontracted(final Boolean isSubcontracted) {
        this.isSubcontracted = isSubcontracted;
        return this;
    }

    /**
     * Gets the subcontracted proportion.
     *
     * @return the subcontractedProportion
     */
    public final Integer getSubcontractedProportion() {
        return subcontractedProportion;
    }

    /**
     * Sets the subcontracted proportion.
     *
     * @param subcontractedProportion
     *            the subcontractedProportion to set
     * @return this instance for chaining
     */
    public final CleanBid setSubcontractedProportion(final Integer subcontractedProportion) {
        this.subcontractedProportion = subcontractedProportion;
        return this;
    }

    /**
     * Gets the subcontracted value.
     *
     * @return value of the tender likely to be subcontracted to third parties
     */
    public final Price getSubcontractedValue() {
        return subcontractedValue;
    }

    /**
     * Sets the subcontracted value.
     *
     * @param subcontractedValue
     *            value of the tender likely to be subcontracted to third
     *            parties
     * @return this instance for chaining
     */
    public final CleanBid setSubcontractedValue(final Price subcontractedValue) {
        this.subcontractedValue = subcontractedValue;
        return this;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public final Price getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price
     *            the price to set
     * @return this instance for chaining
     */
    public final CleanBid setPrice(final Price price) {
        this.price = price;
        return this;
    }

    /**
     * Gets the robust price.
     *
     * @return the robust price
     */
    public final Price getRobustPrice() {
        return robustPrice;
    }

    /**
     * Sets the robust price.
     *
     * @param robustPrice
     *            the robust price
     * @return the clean bid
     */
    public final CleanBid setRobustPrice(final Price robustPrice) {
        this.robustPrice = robustPrice;
        return this;
    }

    /**
     * Gets the annual price years count.
     *
     * @return number of years for annual price
     */
    public final Integer getAnnualPriceYearsCount() {
        return annualPriceYearsCount;
    }

    /**
     * Sets the annual price years count.
     *
     * @param annualPriceYearsCount
     *            number of years for annual price
     * @return this instance for chaining
     */
    public final CleanBid setAnnualPriceYearsCount(final Integer annualPriceYearsCount) {
        this.annualPriceYearsCount = annualPriceYearsCount;
        return this;
    }

    /**
     * Gets the monthly price months count.
     *
     * @return number of months for monthly price
     */
    public final Integer getMonthlyPriceMonthsCount() {
        return monthlyPriceMonthsCount;
    }

    /**
     * Sets the monthly price months count.
     *
     * @param monthlyPriceMonthsCount
     *            number of months for monthly price
     * @return this instance for chaining
     */
    public final CleanBid setMonthlyPriceMonthsCount(final Integer monthlyPriceMonthsCount) {
        this.monthlyPriceMonthsCount = monthlyPriceMonthsCount;
        return this;
    }

    /**
     * Gets the checks if is consortium.
     *
     * @return the isConsortium
     */
    public final Boolean getIsConsortium() {
        return isConsortium;
    }

    /**
     * Sets the is consortium.
     *
     * @param isConsortium
     *            the isConsortium to set
     * @return this instance for chaining
     */
    public final CleanBid setIsConsortium(final Boolean isConsortium) {
        this.isConsortium = isConsortium;
        return this;
    }

    /**
     * Gets the subcontractors.
     *
     * @return the subcontractors
     */
    public final List<CleanBody> getSubcontractors() {
        return subcontractors;
    }

    /**
     * Sets the subcontractors.
     *
     * @param subcontractors
     *            the subcontractors to set
     * @return this instance for chaining
     */
    public final CleanBid setSubcontractors(final List<CleanBody> subcontractors) {
        this.subcontractors = subcontractors;
        return this;
    }
    
    /**
     * Gets the bid id.
     *
     * @return the bid id
     */
    public final String getBidId() {
        return bidId;
    }

    /**
     * Sets the bid id.
     *
     * @param bidId
     *            the bid id
     * @return the clean bid
     */
    public final CleanBid setBidId(final String bidId) {
        this.bidId = bidId;
        return this;
    }

    @Override
    @Transient
    @JsonIgnore
    public final CleanBid getValid() {
        setBidders(ValidationUtils.getValid(bidders));
        setDocuments(ValidationUtils.getValid(documents));
        setPayments(ValidationUtils.getValid(payments));
        setPrice(removeNonsenses(price));
        setRobustPrice(removeNonsenses(robustPrice));
        setSubcontractedValue(removeNonsenses(subcontractedValue));
        setSubcontractors(ValidationUtils.getValid(subcontractors));
        setUnitPrices(ValidationUtils.getValid(unitPrices));

        return ValidationUtils.getValid(this, annualPriceYearsCount, bidId, bidders, disqualificationReason, documents,
            isConsortium, isDisqualified, isSubcontracted, isWinning, monthlyPriceMonthsCount, payments, price,
            robustPrice, subcontractedProportion, subcontractedValue, subcontractors, unitPrices, wasFinishedOnTime,
            wasForEstimatedValue, wasInRequestedQuality);
    }
}
