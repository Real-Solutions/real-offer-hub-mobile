package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.BelongsTo;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Offer type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Offers", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byProperty", fields = {"propertyId","offerPrice"})
public final class Offer implements Model {
  public static final QueryField ID = field("Offer", "id");
  public static final QueryField BUYERS_FIRST_NAME = field("Offer", "buyersFirstName");
  public static final QueryField BUYERS_LAST_NAME = field("Offer", "buyersLastName");
  public static final QueryField OFFER_PRICE = field("Offer", "offerPrice");
  public static final QueryField ERNEST_MONEY_AMOUNT = field("Offer", "ernestMoneyAmount");
  public static final QueryField DOWN_PAYMENT = field("Offer", "downPayment");
  public static final QueryField CLOSE_OF_ESCROW = field("Offer", "closeOfEscrow");
  public static final QueryField CONCESSIONS = field("Offer", "concessions");
  public static final QueryField LOAN_TYPE = field("Offer", "loanType");
  public static final QueryField CONTINGENT_BUYER = field("Offer", "contingentBuyer");
  public static final QueryField PERSONAL_PROPERTY_REQUESTED = field("Offer", "personalPropertyRequested");
  public static final QueryField HOA = field("Offer", "hoa");
  public static final QueryField HOME_WARRANTY = field("Offer", "homeWarranty");
  public static final QueryField INSPECTION_PERIOD = field("Offer", "inspectionPeriod");
  public static final QueryField ESCALATION = field("Offer", "escalation");
  public static final QueryField RESPONSE_DATE = field("Offer", "responseDate");
  public static final QueryField RESPONSE_TIME = field("Offer", "responseTime");
  public static final QueryField ADDITIONAL_TERMS_AND_CONDITIONS = field("Offer", "additionalTermsAndConditions");
  public static final QueryField PRICE_STRING = field("Offer", "priceString");
  public static final QueryField DOWN_PAYMENT_STRING = field("Offer", "downPaymentString");
  public static final QueryField ERNEST_MONEY_AMOUNT_STRING = field("Offer", "ernestMoneyAmountString");
  public static final QueryField CONTINGENT_BUYER_STRING = field("Offer", "contingentBuyerString");
  public static final QueryField RESPONSE_DATE_STRING = field("Offer", "responseDateString");
  public static final QueryField CLOSE_OF_ESCROW_STRING = field("Offer", "closeOfEscrowString");
  public static final QueryField RESPONSE_TIME_STRING = field("Offer", "responseTimeString");
  public static final QueryField EXPANDED = field("Offer", "expanded");
  public static final QueryField PROPERTY = field("Offer", "propertyId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String buyersFirstName;
  private final @ModelField(targetType="String", isRequired = true) String buyersLastName;
  private final @ModelField(targetType="Float", isRequired = true) Double offerPrice;
  private final @ModelField(targetType="Float", isRequired = true) Double ernestMoneyAmount;
  private final @ModelField(targetType="Float", isRequired = true) Double downPayment;
  private final @ModelField(targetType="AWSDate", isRequired = true) Temporal.Date closeOfEscrow;
  private final @ModelField(targetType="String", isRequired = true) String concessions;
  private final @ModelField(targetType="String", isRequired = true) String loanType;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean contingentBuyer;
  private final @ModelField(targetType="String", isRequired = true) String personalPropertyRequested;
  private final @ModelField(targetType="String", isRequired = true) String hoa;
  private final @ModelField(targetType="String", isRequired = true) String homeWarranty;
  private final @ModelField(targetType="String", isRequired = true) String inspectionPeriod;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean escalation;
  private final @ModelField(targetType="AWSDate", isRequired = true) Temporal.Date responseDate;
  private final @ModelField(targetType="AWSTime", isRequired = true) Temporal.Time responseTime;
  private final @ModelField(targetType="String", isRequired = true) String additionalTermsAndConditions;
  private final @ModelField(targetType="String", isRequired = true) String priceString;
  private final @ModelField(targetType="String", isRequired = true) String downPaymentString;
  private final @ModelField(targetType="String", isRequired = true) String ernestMoneyAmountString;
  private final @ModelField(targetType="String", isRequired = true) String contingentBuyerString;
  private final @ModelField(targetType="String", isRequired = true) String responseDateString;
  private final @ModelField(targetType="String", isRequired = true) String closeOfEscrowString;
  private final @ModelField(targetType="String", isRequired = true) String responseTimeString;
  private final @ModelField(targetType="Boolean") Boolean expanded;
  private final @ModelField(targetType="Message") @HasMany(associatedWith = "offer", type = Message.class) List<Message> messages = null;
  private final @ModelField(targetType="Property") @BelongsTo(targetName = "propertyId", targetNames = {"propertyId"}, type = Property.class) Property property;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getBuyersFirstName() {
      return buyersFirstName;
  }
  
  public String getBuyersLastName() {
      return buyersLastName;
  }
  
  public Double getOfferPrice() {
      return offerPrice;
  }
  
  public Double getErnestMoneyAmount() {
      return ernestMoneyAmount;
  }
  
  public Double getDownPayment() {
      return downPayment;
  }
  
  public Temporal.Date getCloseOfEscrow() {
      return closeOfEscrow;
  }
  
  public String getConcessions() {
      return concessions;
  }
  
  public String getLoanType() {
      return loanType;
  }
  
  public Boolean getContingentBuyer() {
      return contingentBuyer;
  }
  
  public String getPersonalPropertyRequested() {
      return personalPropertyRequested;
  }
  
  public String getHoa() {
      return hoa;
  }
  
  public String getHomeWarranty() {
      return homeWarranty;
  }
  
  public String getInspectionPeriod() {
      return inspectionPeriod;
  }
  
  public Boolean getEscalation() {
      return escalation;
  }
  
  public Temporal.Date getResponseDate() {
      return responseDate;
  }
  
  public Temporal.Time getResponseTime() {
      return responseTime;
  }
  
  public String getAdditionalTermsAndConditions() {
      return additionalTermsAndConditions;
  }
  
  public String getPriceString() {
      return priceString;
  }
  
  public String getDownPaymentString() {
      return downPaymentString;
  }
  
  public String getErnestMoneyAmountString() {
      return ernestMoneyAmountString;
  }
  
  public String getContingentBuyerString() {
      return contingentBuyerString;
  }
  
  public String getResponseDateString() {
      return responseDateString;
  }
  
  public String getCloseOfEscrowString() {
      return closeOfEscrowString;
  }
  
  public String getResponseTimeString() {
      return responseTimeString;
  }
  
  public Boolean getExpanded() {
      return expanded;
  }
  
  public List<Message> getMessages() {
      return messages;
  }
  
  public Property getProperty() {
      return property;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Offer(String id, String buyersFirstName, String buyersLastName, Double offerPrice, Double ernestMoneyAmount, Double downPayment, Temporal.Date closeOfEscrow, String concessions, String loanType, Boolean contingentBuyer, String personalPropertyRequested, String hoa, String homeWarranty, String inspectionPeriod, Boolean escalation, Temporal.Date responseDate, Temporal.Time responseTime, String additionalTermsAndConditions, String priceString, String downPaymentString, String ernestMoneyAmountString, String contingentBuyerString, String responseDateString, String closeOfEscrowString, String responseTimeString, Boolean expanded, Property property) {
    this.id = id;
    this.buyersFirstName = buyersFirstName;
    this.buyersLastName = buyersLastName;
    this.offerPrice = offerPrice;
    this.ernestMoneyAmount = ernestMoneyAmount;
    this.downPayment = downPayment;
    this.closeOfEscrow = closeOfEscrow;
    this.concessions = concessions;
    this.loanType = loanType;
    this.contingentBuyer = contingentBuyer;
    this.personalPropertyRequested = personalPropertyRequested;
    this.hoa = hoa;
    this.homeWarranty = homeWarranty;
    this.inspectionPeriod = inspectionPeriod;
    this.escalation = escalation;
    this.responseDate = responseDate;
    this.responseTime = responseTime;
    this.additionalTermsAndConditions = additionalTermsAndConditions;
    this.priceString = priceString;
    this.downPaymentString = downPaymentString;
    this.ernestMoneyAmountString = ernestMoneyAmountString;
    this.contingentBuyerString = contingentBuyerString;
    this.responseDateString = responseDateString;
    this.closeOfEscrowString = closeOfEscrowString;
    this.responseTimeString = responseTimeString;
    this.expanded = expanded;
    this.property = property;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Offer offer = (Offer) obj;
      return ObjectsCompat.equals(getId(), offer.getId()) &&
              ObjectsCompat.equals(getBuyersFirstName(), offer.getBuyersFirstName()) &&
              ObjectsCompat.equals(getBuyersLastName(), offer.getBuyersLastName()) &&
              ObjectsCompat.equals(getOfferPrice(), offer.getOfferPrice()) &&
              ObjectsCompat.equals(getErnestMoneyAmount(), offer.getErnestMoneyAmount()) &&
              ObjectsCompat.equals(getDownPayment(), offer.getDownPayment()) &&
              ObjectsCompat.equals(getCloseOfEscrow(), offer.getCloseOfEscrow()) &&
              ObjectsCompat.equals(getConcessions(), offer.getConcessions()) &&
              ObjectsCompat.equals(getLoanType(), offer.getLoanType()) &&
              ObjectsCompat.equals(getContingentBuyer(), offer.getContingentBuyer()) &&
              ObjectsCompat.equals(getPersonalPropertyRequested(), offer.getPersonalPropertyRequested()) &&
              ObjectsCompat.equals(getHoa(), offer.getHoa()) &&
              ObjectsCompat.equals(getHomeWarranty(), offer.getHomeWarranty()) &&
              ObjectsCompat.equals(getInspectionPeriod(), offer.getInspectionPeriod()) &&
              ObjectsCompat.equals(getEscalation(), offer.getEscalation()) &&
              ObjectsCompat.equals(getResponseDate(), offer.getResponseDate()) &&
              ObjectsCompat.equals(getResponseTime(), offer.getResponseTime()) &&
              ObjectsCompat.equals(getAdditionalTermsAndConditions(), offer.getAdditionalTermsAndConditions()) &&
              ObjectsCompat.equals(getPriceString(), offer.getPriceString()) &&
              ObjectsCompat.equals(getDownPaymentString(), offer.getDownPaymentString()) &&
              ObjectsCompat.equals(getErnestMoneyAmountString(), offer.getErnestMoneyAmountString()) &&
              ObjectsCompat.equals(getContingentBuyerString(), offer.getContingentBuyerString()) &&
              ObjectsCompat.equals(getResponseDateString(), offer.getResponseDateString()) &&
              ObjectsCompat.equals(getCloseOfEscrowString(), offer.getCloseOfEscrowString()) &&
              ObjectsCompat.equals(getResponseTimeString(), offer.getResponseTimeString()) &&
              ObjectsCompat.equals(getExpanded(), offer.getExpanded()) &&
              ObjectsCompat.equals(getProperty(), offer.getProperty()) &&
              ObjectsCompat.equals(getCreatedAt(), offer.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), offer.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getBuyersFirstName())
      .append(getBuyersLastName())
      .append(getOfferPrice())
      .append(getErnestMoneyAmount())
      .append(getDownPayment())
      .append(getCloseOfEscrow())
      .append(getConcessions())
      .append(getLoanType())
      .append(getContingentBuyer())
      .append(getPersonalPropertyRequested())
      .append(getHoa())
      .append(getHomeWarranty())
      .append(getInspectionPeriod())
      .append(getEscalation())
      .append(getResponseDate())
      .append(getResponseTime())
      .append(getAdditionalTermsAndConditions())
      .append(getPriceString())
      .append(getDownPaymentString())
      .append(getErnestMoneyAmountString())
      .append(getContingentBuyerString())
      .append(getResponseDateString())
      .append(getCloseOfEscrowString())
      .append(getResponseTimeString())
      .append(getExpanded())
      .append(getProperty())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Offer {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("buyersFirstName=" + String.valueOf(getBuyersFirstName()) + ", ")
      .append("buyersLastName=" + String.valueOf(getBuyersLastName()) + ", ")
      .append("offerPrice=" + String.valueOf(getOfferPrice()) + ", ")
      .append("ernestMoneyAmount=" + String.valueOf(getErnestMoneyAmount()) + ", ")
      .append("downPayment=" + String.valueOf(getDownPayment()) + ", ")
      .append("closeOfEscrow=" + String.valueOf(getCloseOfEscrow()) + ", ")
      .append("concessions=" + String.valueOf(getConcessions()) + ", ")
      .append("loanType=" + String.valueOf(getLoanType()) + ", ")
      .append("contingentBuyer=" + String.valueOf(getContingentBuyer()) + ", ")
      .append("personalPropertyRequested=" + String.valueOf(getPersonalPropertyRequested()) + ", ")
      .append("hoa=" + String.valueOf(getHoa()) + ", ")
      .append("homeWarranty=" + String.valueOf(getHomeWarranty()) + ", ")
      .append("inspectionPeriod=" + String.valueOf(getInspectionPeriod()) + ", ")
      .append("escalation=" + String.valueOf(getEscalation()) + ", ")
      .append("responseDate=" + String.valueOf(getResponseDate()) + ", ")
      .append("responseTime=" + String.valueOf(getResponseTime()) + ", ")
      .append("additionalTermsAndConditions=" + String.valueOf(getAdditionalTermsAndConditions()) + ", ")
      .append("priceString=" + String.valueOf(getPriceString()) + ", ")
      .append("downPaymentString=" + String.valueOf(getDownPaymentString()) + ", ")
      .append("ernestMoneyAmountString=" + String.valueOf(getErnestMoneyAmountString()) + ", ")
      .append("contingentBuyerString=" + String.valueOf(getContingentBuyerString()) + ", ")
      .append("responseDateString=" + String.valueOf(getResponseDateString()) + ", ")
      .append("closeOfEscrowString=" + String.valueOf(getCloseOfEscrowString()) + ", ")
      .append("responseTimeString=" + String.valueOf(getResponseTimeString()) + ", ")
      .append("expanded=" + String.valueOf(getExpanded()) + ", ")
      .append("property=" + String.valueOf(getProperty()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuyersFirstNameStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Offer justId(String id) {
    return new Offer(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      buyersFirstName,
      buyersLastName,
      offerPrice,
      ernestMoneyAmount,
      downPayment,
      closeOfEscrow,
      concessions,
      loanType,
      contingentBuyer,
      personalPropertyRequested,
      hoa,
      homeWarranty,
      inspectionPeriod,
      escalation,
      responseDate,
      responseTime,
      additionalTermsAndConditions,
      priceString,
      downPaymentString,
      ernestMoneyAmountString,
      contingentBuyerString,
      responseDateString,
      closeOfEscrowString,
      responseTimeString,
      expanded,
      property);
  }
  public interface BuyersFirstNameStep {
    BuyersLastNameStep buyersFirstName(String buyersFirstName);
  }
  

  public interface BuyersLastNameStep {
    OfferPriceStep buyersLastName(String buyersLastName);
  }
  

  public interface OfferPriceStep {
    ErnestMoneyAmountStep offerPrice(Double offerPrice);
  }
  

  public interface ErnestMoneyAmountStep {
    DownPaymentStep ernestMoneyAmount(Double ernestMoneyAmount);
  }
  

  public interface DownPaymentStep {
    CloseOfEscrowStep downPayment(Double downPayment);
  }
  

  public interface CloseOfEscrowStep {
    ConcessionsStep closeOfEscrow(Temporal.Date closeOfEscrow);
  }
  

  public interface ConcessionsStep {
    LoanTypeStep concessions(String concessions);
  }
  

  public interface LoanTypeStep {
    ContingentBuyerStep loanType(String loanType);
  }
  

  public interface ContingentBuyerStep {
    PersonalPropertyRequestedStep contingentBuyer(Boolean contingentBuyer);
  }
  

  public interface PersonalPropertyRequestedStep {
    HoaStep personalPropertyRequested(String personalPropertyRequested);
  }
  

  public interface HoaStep {
    HomeWarrantyStep hoa(String hoa);
  }
  

  public interface HomeWarrantyStep {
    InspectionPeriodStep homeWarranty(String homeWarranty);
  }
  

  public interface InspectionPeriodStep {
    EscalationStep inspectionPeriod(String inspectionPeriod);
  }
  

  public interface EscalationStep {
    ResponseDateStep escalation(Boolean escalation);
  }
  

  public interface ResponseDateStep {
    ResponseTimeStep responseDate(Temporal.Date responseDate);
  }
  

  public interface ResponseTimeStep {
    AdditionalTermsAndConditionsStep responseTime(Temporal.Time responseTime);
  }
  

  public interface AdditionalTermsAndConditionsStep {
    PriceStringStep additionalTermsAndConditions(String additionalTermsAndConditions);
  }
  

  public interface PriceStringStep {
    DownPaymentStringStep priceString(String priceString);
  }
  

  public interface DownPaymentStringStep {
    ErnestMoneyAmountStringStep downPaymentString(String downPaymentString);
  }
  

  public interface ErnestMoneyAmountStringStep {
    ContingentBuyerStringStep ernestMoneyAmountString(String ernestMoneyAmountString);
  }
  

  public interface ContingentBuyerStringStep {
    ResponseDateStringStep contingentBuyerString(String contingentBuyerString);
  }
  

  public interface ResponseDateStringStep {
    CloseOfEscrowStringStep responseDateString(String responseDateString);
  }
  

  public interface CloseOfEscrowStringStep {
    ResponseTimeStringStep closeOfEscrowString(String closeOfEscrowString);
  }
  

  public interface ResponseTimeStringStep {
    BuildStep responseTimeString(String responseTimeString);
  }
  

  public interface BuildStep {
    Offer build();
    BuildStep id(String id);
    BuildStep expanded(Boolean expanded);
    BuildStep property(Property property);
  }
  

  public static class Builder implements BuyersFirstNameStep, BuyersLastNameStep, OfferPriceStep, ErnestMoneyAmountStep, DownPaymentStep, CloseOfEscrowStep, ConcessionsStep, LoanTypeStep, ContingentBuyerStep, PersonalPropertyRequestedStep, HoaStep, HomeWarrantyStep, InspectionPeriodStep, EscalationStep, ResponseDateStep, ResponseTimeStep, AdditionalTermsAndConditionsStep, PriceStringStep, DownPaymentStringStep, ErnestMoneyAmountStringStep, ContingentBuyerStringStep, ResponseDateStringStep, CloseOfEscrowStringStep, ResponseTimeStringStep, BuildStep {
    private String id;
    private String buyersFirstName;
    private String buyersLastName;
    private Double offerPrice;
    private Double ernestMoneyAmount;
    private Double downPayment;
    private Temporal.Date closeOfEscrow;
    private String concessions;
    private String loanType;
    private Boolean contingentBuyer;
    private String personalPropertyRequested;
    private String hoa;
    private String homeWarranty;
    private String inspectionPeriod;
    private Boolean escalation;
    private Temporal.Date responseDate;
    private Temporal.Time responseTime;
    private String additionalTermsAndConditions;
    private String priceString;
    private String downPaymentString;
    private String ernestMoneyAmountString;
    private String contingentBuyerString;
    private String responseDateString;
    private String closeOfEscrowString;
    private String responseTimeString;
    private Boolean expanded;
    private Property property;
    @Override
     public Offer build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Offer(
          id,
          buyersFirstName,
          buyersLastName,
          offerPrice,
          ernestMoneyAmount,
          downPayment,
          closeOfEscrow,
          concessions,
          loanType,
          contingentBuyer,
          personalPropertyRequested,
          hoa,
          homeWarranty,
          inspectionPeriod,
          escalation,
          responseDate,
          responseTime,
          additionalTermsAndConditions,
          priceString,
          downPaymentString,
          ernestMoneyAmountString,
          contingentBuyerString,
          responseDateString,
          closeOfEscrowString,
          responseTimeString,
          expanded,
          property);
    }
    
    @Override
     public BuyersLastNameStep buyersFirstName(String buyersFirstName) {
        Objects.requireNonNull(buyersFirstName);
        this.buyersFirstName = buyersFirstName;
        return this;
    }
    
    @Override
     public OfferPriceStep buyersLastName(String buyersLastName) {
        Objects.requireNonNull(buyersLastName);
        this.buyersLastName = buyersLastName;
        return this;
    }
    
    @Override
     public ErnestMoneyAmountStep offerPrice(Double offerPrice) {
        Objects.requireNonNull(offerPrice);
        this.offerPrice = offerPrice;
        return this;
    }
    
    @Override
     public DownPaymentStep ernestMoneyAmount(Double ernestMoneyAmount) {
        Objects.requireNonNull(ernestMoneyAmount);
        this.ernestMoneyAmount = ernestMoneyAmount;
        return this;
    }
    
    @Override
     public CloseOfEscrowStep downPayment(Double downPayment) {
        Objects.requireNonNull(downPayment);
        this.downPayment = downPayment;
        return this;
    }
    
    @Override
     public ConcessionsStep closeOfEscrow(Temporal.Date closeOfEscrow) {
        Objects.requireNonNull(closeOfEscrow);
        this.closeOfEscrow = closeOfEscrow;
        return this;
    }
    
    @Override
     public LoanTypeStep concessions(String concessions) {
        Objects.requireNonNull(concessions);
        this.concessions = concessions;
        return this;
    }
    
    @Override
     public ContingentBuyerStep loanType(String loanType) {
        Objects.requireNonNull(loanType);
        this.loanType = loanType;
        return this;
    }
    
    @Override
     public PersonalPropertyRequestedStep contingentBuyer(Boolean contingentBuyer) {
        Objects.requireNonNull(contingentBuyer);
        this.contingentBuyer = contingentBuyer;
        return this;
    }
    
    @Override
     public HoaStep personalPropertyRequested(String personalPropertyRequested) {
        Objects.requireNonNull(personalPropertyRequested);
        this.personalPropertyRequested = personalPropertyRequested;
        return this;
    }
    
    @Override
     public HomeWarrantyStep hoa(String hoa) {
        Objects.requireNonNull(hoa);
        this.hoa = hoa;
        return this;
    }
    
    @Override
     public InspectionPeriodStep homeWarranty(String homeWarranty) {
        Objects.requireNonNull(homeWarranty);
        this.homeWarranty = homeWarranty;
        return this;
    }
    
    @Override
     public EscalationStep inspectionPeriod(String inspectionPeriod) {
        Objects.requireNonNull(inspectionPeriod);
        this.inspectionPeriod = inspectionPeriod;
        return this;
    }
    
    @Override
     public ResponseDateStep escalation(Boolean escalation) {
        Objects.requireNonNull(escalation);
        this.escalation = escalation;
        return this;
    }
    
    @Override
     public ResponseTimeStep responseDate(Temporal.Date responseDate) {
        Objects.requireNonNull(responseDate);
        this.responseDate = responseDate;
        return this;
    }
    
    @Override
     public AdditionalTermsAndConditionsStep responseTime(Temporal.Time responseTime) {
        Objects.requireNonNull(responseTime);
        this.responseTime = responseTime;
        return this;
    }
    
    @Override
     public PriceStringStep additionalTermsAndConditions(String additionalTermsAndConditions) {
        Objects.requireNonNull(additionalTermsAndConditions);
        this.additionalTermsAndConditions = additionalTermsAndConditions;
        return this;
    }
    
    @Override
     public DownPaymentStringStep priceString(String priceString) {
        Objects.requireNonNull(priceString);
        this.priceString = priceString;
        return this;
    }
    
    @Override
     public ErnestMoneyAmountStringStep downPaymentString(String downPaymentString) {
        Objects.requireNonNull(downPaymentString);
        this.downPaymentString = downPaymentString;
        return this;
    }
    
    @Override
     public ContingentBuyerStringStep ernestMoneyAmountString(String ernestMoneyAmountString) {
        Objects.requireNonNull(ernestMoneyAmountString);
        this.ernestMoneyAmountString = ernestMoneyAmountString;
        return this;
    }
    
    @Override
     public ResponseDateStringStep contingentBuyerString(String contingentBuyerString) {
        Objects.requireNonNull(contingentBuyerString);
        this.contingentBuyerString = contingentBuyerString;
        return this;
    }
    
    @Override
     public CloseOfEscrowStringStep responseDateString(String responseDateString) {
        Objects.requireNonNull(responseDateString);
        this.responseDateString = responseDateString;
        return this;
    }
    
    @Override
     public ResponseTimeStringStep closeOfEscrowString(String closeOfEscrowString) {
        Objects.requireNonNull(closeOfEscrowString);
        this.closeOfEscrowString = closeOfEscrowString;
        return this;
    }
    
    @Override
     public BuildStep responseTimeString(String responseTimeString) {
        Objects.requireNonNull(responseTimeString);
        this.responseTimeString = responseTimeString;
        return this;
    }
    
    @Override
     public BuildStep expanded(Boolean expanded) {
        this.expanded = expanded;
        return this;
    }
    
    @Override
     public BuildStep property(Property property) {
        this.property = property;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String buyersFirstName, String buyersLastName, Double offerPrice, Double ernestMoneyAmount, Double downPayment, Temporal.Date closeOfEscrow, String concessions, String loanType, Boolean contingentBuyer, String personalPropertyRequested, String hoa, String homeWarranty, String inspectionPeriod, Boolean escalation, Temporal.Date responseDate, Temporal.Time responseTime, String additionalTermsAndConditions, String priceString, String downPaymentString, String ernestMoneyAmountString, String contingentBuyerString, String responseDateString, String closeOfEscrowString, String responseTimeString, Boolean expanded, Property property) {
      super.id(id);
      super.buyersFirstName(buyersFirstName)
        .buyersLastName(buyersLastName)
        .offerPrice(offerPrice)
        .ernestMoneyAmount(ernestMoneyAmount)
        .downPayment(downPayment)
        .closeOfEscrow(closeOfEscrow)
        .concessions(concessions)
        .loanType(loanType)
        .contingentBuyer(contingentBuyer)
        .personalPropertyRequested(personalPropertyRequested)
        .hoa(hoa)
        .homeWarranty(homeWarranty)
        .inspectionPeriod(inspectionPeriod)
        .escalation(escalation)
        .responseDate(responseDate)
        .responseTime(responseTime)
        .additionalTermsAndConditions(additionalTermsAndConditions)
        .priceString(priceString)
        .downPaymentString(downPaymentString)
        .ernestMoneyAmountString(ernestMoneyAmountString)
        .contingentBuyerString(contingentBuyerString)
        .responseDateString(responseDateString)
        .closeOfEscrowString(closeOfEscrowString)
        .responseTimeString(responseTimeString)
        .expanded(expanded)
        .property(property);
    }
    
    @Override
     public CopyOfBuilder buyersFirstName(String buyersFirstName) {
      return (CopyOfBuilder) super.buyersFirstName(buyersFirstName);
    }
    
    @Override
     public CopyOfBuilder buyersLastName(String buyersLastName) {
      return (CopyOfBuilder) super.buyersLastName(buyersLastName);
    }
    
    @Override
     public CopyOfBuilder offerPrice(Double offerPrice) {
      return (CopyOfBuilder) super.offerPrice(offerPrice);
    }
    
    @Override
     public CopyOfBuilder ernestMoneyAmount(Double ernestMoneyAmount) {
      return (CopyOfBuilder) super.ernestMoneyAmount(ernestMoneyAmount);
    }
    
    @Override
     public CopyOfBuilder downPayment(Double downPayment) {
      return (CopyOfBuilder) super.downPayment(downPayment);
    }
    
    @Override
     public CopyOfBuilder closeOfEscrow(Temporal.Date closeOfEscrow) {
      return (CopyOfBuilder) super.closeOfEscrow(closeOfEscrow);
    }
    
    @Override
     public CopyOfBuilder concessions(String concessions) {
      return (CopyOfBuilder) super.concessions(concessions);
    }
    
    @Override
     public CopyOfBuilder loanType(String loanType) {
      return (CopyOfBuilder) super.loanType(loanType);
    }
    
    @Override
     public CopyOfBuilder contingentBuyer(Boolean contingentBuyer) {
      return (CopyOfBuilder) super.contingentBuyer(contingentBuyer);
    }
    
    @Override
     public CopyOfBuilder personalPropertyRequested(String personalPropertyRequested) {
      return (CopyOfBuilder) super.personalPropertyRequested(personalPropertyRequested);
    }
    
    @Override
     public CopyOfBuilder hoa(String hoa) {
      return (CopyOfBuilder) super.hoa(hoa);
    }
    
    @Override
     public CopyOfBuilder homeWarranty(String homeWarranty) {
      return (CopyOfBuilder) super.homeWarranty(homeWarranty);
    }
    
    @Override
     public CopyOfBuilder inspectionPeriod(String inspectionPeriod) {
      return (CopyOfBuilder) super.inspectionPeriod(inspectionPeriod);
    }
    
    @Override
     public CopyOfBuilder escalation(Boolean escalation) {
      return (CopyOfBuilder) super.escalation(escalation);
    }
    
    @Override
     public CopyOfBuilder responseDate(Temporal.Date responseDate) {
      return (CopyOfBuilder) super.responseDate(responseDate);
    }
    
    @Override
     public CopyOfBuilder responseTime(Temporal.Time responseTime) {
      return (CopyOfBuilder) super.responseTime(responseTime);
    }
    
    @Override
     public CopyOfBuilder additionalTermsAndConditions(String additionalTermsAndConditions) {
      return (CopyOfBuilder) super.additionalTermsAndConditions(additionalTermsAndConditions);
    }
    
    @Override
     public CopyOfBuilder priceString(String priceString) {
      return (CopyOfBuilder) super.priceString(priceString);
    }
    
    @Override
     public CopyOfBuilder downPaymentString(String downPaymentString) {
      return (CopyOfBuilder) super.downPaymentString(downPaymentString);
    }
    
    @Override
     public CopyOfBuilder ernestMoneyAmountString(String ernestMoneyAmountString) {
      return (CopyOfBuilder) super.ernestMoneyAmountString(ernestMoneyAmountString);
    }
    
    @Override
     public CopyOfBuilder contingentBuyerString(String contingentBuyerString) {
      return (CopyOfBuilder) super.contingentBuyerString(contingentBuyerString);
    }
    
    @Override
     public CopyOfBuilder responseDateString(String responseDateString) {
      return (CopyOfBuilder) super.responseDateString(responseDateString);
    }
    
    @Override
     public CopyOfBuilder closeOfEscrowString(String closeOfEscrowString) {
      return (CopyOfBuilder) super.closeOfEscrowString(closeOfEscrowString);
    }
    
    @Override
     public CopyOfBuilder responseTimeString(String responseTimeString) {
      return (CopyOfBuilder) super.responseTimeString(responseTimeString);
    }
    
    @Override
     public CopyOfBuilder expanded(Boolean expanded) {
      return (CopyOfBuilder) super.expanded(expanded);
    }
    
    @Override
     public CopyOfBuilder property(Property property) {
      return (CopyOfBuilder) super.property(property);
    }
  }
  
}
