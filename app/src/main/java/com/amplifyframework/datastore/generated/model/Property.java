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

/** This is an auto generated class representing the Property type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Properties", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byUser", fields = {"userId","address"})
public final class Property implements Model {
  public static final QueryField ID = field("Property", "id");
  public static final QueryField ADDRESS = field("Property", "address");
  public static final QueryField PRICE = field("Property", "price");
  public static final QueryField INITIAL_POSTING = field("Property", "initialPosting");
  public static final QueryField NUMBER_OF_ROOMS = field("Property", "numberOfRooms");
  public static final QueryField NUMBER_OF_BATHROOMS = field("Property", "numberOfBathrooms");
  public static final QueryField SQUARE_FOOTAGE = field("Property", "squareFootage");
  public static final QueryField YEAR_BUILT = field("Property", "yearBuilt");
  public static final QueryField PRICE_STRING = field("Property", "priceString");
  public static final QueryField SQUARE_FOOTAGE_STRING = field("Property", "squareFootageString");
  public static final QueryField USER = field("Property", "userId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String address;
  private final @ModelField(targetType="Float", isRequired = true) Double price;
  private final @ModelField(targetType="AWSDate", isRequired = true) Temporal.Date initialPosting;
  private final @ModelField(targetType="Int", isRequired = true) Integer numberOfRooms;
  private final @ModelField(targetType="Int", isRequired = true) Integer numberOfBathrooms;
  private final @ModelField(targetType="Float", isRequired = true) Double squareFootage;
  private final @ModelField(targetType="Int", isRequired = true) Integer yearBuilt;
  private final @ModelField(targetType="String") String priceString;
  private final @ModelField(targetType="String") String squareFootageString;
  private final @ModelField(targetType="Offer") @HasMany(associatedWith = "property", type = Offer.class) List<Offer> offers = null;
  private final @ModelField(targetType="User") @BelongsTo(targetName = "userId", targetNames = {"userId"}, type = User.class) User user;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getAddress() {
      return address;
  }
  
  public Double getPrice() {
      return price;
  }
  
  public Temporal.Date getInitialPosting() {
      return initialPosting;
  }
  
  public Integer getNumberOfRooms() {
      return numberOfRooms;
  }
  
  public Integer getNumberOfBathrooms() {
      return numberOfBathrooms;
  }
  
  public Double getSquareFootage() {
      return squareFootage;
  }
  
  public Integer getYearBuilt() {
      return yearBuilt;
  }
  
  public String getPriceString() {
      return priceString;
  }
  
  public String getSquareFootageString() {
      return squareFootageString;
  }
  
  public List<Offer> getOffers() {
      return offers;
  }
  
  public User getUser() {
      return user;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Property(String id, String address, Double price, Temporal.Date initialPosting, Integer numberOfRooms, Integer numberOfBathrooms, Double squareFootage, Integer yearBuilt, String priceString, String squareFootageString, User user) {
    this.id = id;
    this.address = address;
    this.price = price;
    this.initialPosting = initialPosting;
    this.numberOfRooms = numberOfRooms;
    this.numberOfBathrooms = numberOfBathrooms;
    this.squareFootage = squareFootage;
    this.yearBuilt = yearBuilt;
    this.priceString = priceString;
    this.squareFootageString = squareFootageString;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Property property = (Property) obj;
      return ObjectsCompat.equals(getId(), property.getId()) &&
              ObjectsCompat.equals(getAddress(), property.getAddress()) &&
              ObjectsCompat.equals(getPrice(), property.getPrice()) &&
              ObjectsCompat.equals(getInitialPosting(), property.getInitialPosting()) &&
              ObjectsCompat.equals(getNumberOfRooms(), property.getNumberOfRooms()) &&
              ObjectsCompat.equals(getNumberOfBathrooms(), property.getNumberOfBathrooms()) &&
              ObjectsCompat.equals(getSquareFootage(), property.getSquareFootage()) &&
              ObjectsCompat.equals(getYearBuilt(), property.getYearBuilt()) &&
              ObjectsCompat.equals(getPriceString(), property.getPriceString()) &&
              ObjectsCompat.equals(getSquareFootageString(), property.getSquareFootageString()) &&
              ObjectsCompat.equals(getUser(), property.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), property.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), property.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getAddress())
      .append(getPrice())
      .append(getInitialPosting())
      .append(getNumberOfRooms())
      .append(getNumberOfBathrooms())
      .append(getSquareFootage())
      .append(getYearBuilt())
      .append(getPriceString())
      .append(getSquareFootageString())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Property {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("address=" + String.valueOf(getAddress()) + ", ")
      .append("price=" + String.valueOf(getPrice()) + ", ")
      .append("initialPosting=" + String.valueOf(getInitialPosting()) + ", ")
      .append("numberOfRooms=" + String.valueOf(getNumberOfRooms()) + ", ")
      .append("numberOfBathrooms=" + String.valueOf(getNumberOfBathrooms()) + ", ")
      .append("squareFootage=" + String.valueOf(getSquareFootage()) + ", ")
      .append("yearBuilt=" + String.valueOf(getYearBuilt()) + ", ")
      .append("priceString=" + String.valueOf(getPriceString()) + ", ")
      .append("squareFootageString=" + String.valueOf(getSquareFootageString()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static AddressStep builder() {
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
  public static Property justId(String id) {
    return new Property(
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      address,
      price,
      initialPosting,
      numberOfRooms,
      numberOfBathrooms,
      squareFootage,
      yearBuilt,
      priceString,
      squareFootageString,
      user);
  }
  public interface AddressStep {
    PriceStep address(String address);
  }
  

  public interface PriceStep {
    InitialPostingStep price(Double price);
  }
  

  public interface InitialPostingStep {
    NumberOfRoomsStep initialPosting(Temporal.Date initialPosting);
  }
  

  public interface NumberOfRoomsStep {
    NumberOfBathroomsStep numberOfRooms(Integer numberOfRooms);
  }
  

  public interface NumberOfBathroomsStep {
    SquareFootageStep numberOfBathrooms(Integer numberOfBathrooms);
  }
  

  public interface SquareFootageStep {
    YearBuiltStep squareFootage(Double squareFootage);
  }
  

  public interface YearBuiltStep {
    BuildStep yearBuilt(Integer yearBuilt);
  }
  

  public interface BuildStep {
    Property build();
    BuildStep id(String id);
    BuildStep priceString(String priceString);
    BuildStep squareFootageString(String squareFootageString);
    BuildStep user(User user);
  }
  

  public static class Builder implements AddressStep, PriceStep, InitialPostingStep, NumberOfRoomsStep, NumberOfBathroomsStep, SquareFootageStep, YearBuiltStep, BuildStep {
    private String id;
    private String address;
    private Double price;
    private Temporal.Date initialPosting;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private Double squareFootage;
    private Integer yearBuilt;
    private String priceString;
    private String squareFootageString;
    private User user;
    @Override
     public Property build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Property(
          id,
          address,
          price,
          initialPosting,
          numberOfRooms,
          numberOfBathrooms,
          squareFootage,
          yearBuilt,
          priceString,
          squareFootageString,
          user);
    }
    
    @Override
     public PriceStep address(String address) {
        Objects.requireNonNull(address);
        this.address = address;
        return this;
    }
    
    @Override
     public InitialPostingStep price(Double price) {
        Objects.requireNonNull(price);
        this.price = price;
        return this;
    }
    
    @Override
     public NumberOfRoomsStep initialPosting(Temporal.Date initialPosting) {
        Objects.requireNonNull(initialPosting);
        this.initialPosting = initialPosting;
        return this;
    }
    
    @Override
     public NumberOfBathroomsStep numberOfRooms(Integer numberOfRooms) {
        Objects.requireNonNull(numberOfRooms);
        this.numberOfRooms = numberOfRooms;
        return this;
    }
    
    @Override
     public SquareFootageStep numberOfBathrooms(Integer numberOfBathrooms) {
        Objects.requireNonNull(numberOfBathrooms);
        this.numberOfBathrooms = numberOfBathrooms;
        return this;
    }
    
    @Override
     public YearBuiltStep squareFootage(Double squareFootage) {
        Objects.requireNonNull(squareFootage);
        this.squareFootage = squareFootage;
        return this;
    }
    
    @Override
     public BuildStep yearBuilt(Integer yearBuilt) {
        Objects.requireNonNull(yearBuilt);
        this.yearBuilt = yearBuilt;
        return this;
    }
    
    @Override
     public BuildStep priceString(String priceString) {
        this.priceString = priceString;
        return this;
    }
    
    @Override
     public BuildStep squareFootageString(String squareFootageString) {
        this.squareFootageString = squareFootageString;
        return this;
    }
    
    @Override
     public BuildStep user(User user) {
        this.user = user;
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
    private CopyOfBuilder(String id, String address, Double price, Temporal.Date initialPosting, Integer numberOfRooms, Integer numberOfBathrooms, Double squareFootage, Integer yearBuilt, String priceString, String squareFootageString, User user) {
      super.id(id);
      super.address(address)
        .price(price)
        .initialPosting(initialPosting)
        .numberOfRooms(numberOfRooms)
        .numberOfBathrooms(numberOfBathrooms)
        .squareFootage(squareFootage)
        .yearBuilt(yearBuilt)
        .priceString(priceString)
        .squareFootageString(squareFootageString)
        .user(user);
    }
    
    @Override
     public CopyOfBuilder address(String address) {
      return (CopyOfBuilder) super.address(address);
    }
    
    @Override
     public CopyOfBuilder price(Double price) {
      return (CopyOfBuilder) super.price(price);
    }
    
    @Override
     public CopyOfBuilder initialPosting(Temporal.Date initialPosting) {
      return (CopyOfBuilder) super.initialPosting(initialPosting);
    }
    
    @Override
     public CopyOfBuilder numberOfRooms(Integer numberOfRooms) {
      return (CopyOfBuilder) super.numberOfRooms(numberOfRooms);
    }
    
    @Override
     public CopyOfBuilder numberOfBathrooms(Integer numberOfBathrooms) {
      return (CopyOfBuilder) super.numberOfBathrooms(numberOfBathrooms);
    }
    
    @Override
     public CopyOfBuilder squareFootage(Double squareFootage) {
      return (CopyOfBuilder) super.squareFootage(squareFootage);
    }
    
    @Override
     public CopyOfBuilder yearBuilt(Integer yearBuilt) {
      return (CopyOfBuilder) super.yearBuilt(yearBuilt);
    }
    
    @Override
     public CopyOfBuilder priceString(String priceString) {
      return (CopyOfBuilder) super.priceString(priceString);
    }
    
    @Override
     public CopyOfBuilder squareFootageString(String squareFootageString) {
      return (CopyOfBuilder) super.squareFootageString(squareFootageString);
    }
    
    @Override
     public CopyOfBuilder user(User user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  
}
