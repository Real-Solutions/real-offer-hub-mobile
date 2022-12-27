package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
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

/** This is an auto generated class representing the Message type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Messages", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byOffer", fields = {"offerId","date"})
public final class Message implements Model {
  public static final QueryField ID = field("Message", "id");
  public static final QueryField BODY = field("Message", "body");
  public static final QueryField DATE = field("Message", "date");
  public static final QueryField OFFER = field("Message", "offerId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String body;
  private final @ModelField(targetType="AWSDate", isRequired = true) Temporal.Date date;
  private final @ModelField(targetType="Offer") @BelongsTo(targetName = "offerId", targetNames = {"offerId"}, type = Offer.class) Offer offer;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getBody() {
      return body;
  }
  
  public Temporal.Date getDate() {
      return date;
  }
  
  public Offer getOffer() {
      return offer;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Message(String id, String body, Temporal.Date date, Offer offer) {
    this.id = id;
    this.body = body;
    this.date = date;
    this.offer = offer;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Message message = (Message) obj;
      return ObjectsCompat.equals(getId(), message.getId()) &&
              ObjectsCompat.equals(getBody(), message.getBody()) &&
              ObjectsCompat.equals(getDate(), message.getDate()) &&
              ObjectsCompat.equals(getOffer(), message.getOffer()) &&
              ObjectsCompat.equals(getCreatedAt(), message.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), message.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getBody())
      .append(getDate())
      .append(getOffer())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Message {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("body=" + String.valueOf(getBody()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("offer=" + String.valueOf(getOffer()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BodyStep builder() {
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
  public static Message justId(String id) {
    return new Message(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      body,
      date,
      offer);
  }
  public interface BodyStep {
    DateStep body(String body);
  }
  

  public interface DateStep {
    BuildStep date(Temporal.Date date);
  }
  

  public interface BuildStep {
    Message build();
    BuildStep id(String id);
    BuildStep offer(Offer offer);
  }
  

  public static class Builder implements BodyStep, DateStep, BuildStep {
    private String id;
    private String body;
    private Temporal.Date date;
    private Offer offer;
    @Override
     public Message build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Message(
          id,
          body,
          date,
          offer);
    }
    
    @Override
     public DateStep body(String body) {
        Objects.requireNonNull(body);
        this.body = body;
        return this;
    }
    
    @Override
     public BuildStep date(Temporal.Date date) {
        Objects.requireNonNull(date);
        this.date = date;
        return this;
    }
    
    @Override
     public BuildStep offer(Offer offer) {
        this.offer = offer;
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
    private CopyOfBuilder(String id, String body, Temporal.Date date, Offer offer) {
      super.id(id);
      super.body(body)
        .date(date)
        .offer(offer);
    }
    
    @Override
     public CopyOfBuilder body(String body) {
      return (CopyOfBuilder) super.body(body);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.Date date) {
      return (CopyOfBuilder) super.date(date);
    }
    
    @Override
     public CopyOfBuilder offer(Offer offer) {
      return (CopyOfBuilder) super.offer(offer);
    }
  }
  
}
