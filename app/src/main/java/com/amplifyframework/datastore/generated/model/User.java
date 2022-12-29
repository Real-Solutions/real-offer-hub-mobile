package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

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

/** This is an auto generated class representing the User type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byUserType", fields = {"userTypeId","email"})
public final class User implements Model {
  public static final QueryField ID = field("User", "id");
  public static final QueryField EMAIL = field("User", "email");
  public static final QueryField COGNITO_ID = field("User", "cognitoID");
  public static final QueryField USER_TYPE = field("User", "userTypeId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String email;
  private final @ModelField(targetType="String", isRequired = true) String cognitoID;
  private final @ModelField(targetType="Client") @HasMany(associatedWith = "user", type = Client.class) List<Client> clients = null;
  private final @ModelField(targetType="UserType") @BelongsTo(targetName = "userTypeId", targetNames = {"userTypeId"}, type = UserType.class) UserType userType;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getEmail() {
      return email;
  }
  
  public String getCognitoId() {
      return cognitoID;
  }
  
  public List<Client> getClients() {
      return clients;
  }
  
  public UserType getUserType() {
      return userType;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private User(String id, String email, String cognitoID, UserType userType) {
    this.id = id;
    this.email = email;
    this.cognitoID = cognitoID;
    this.userType = userType;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      User user = (User) obj;
      return ObjectsCompat.equals(getId(), user.getId()) &&
              ObjectsCompat.equals(getEmail(), user.getEmail()) &&
              ObjectsCompat.equals(getCognitoId(), user.getCognitoId()) &&
              ObjectsCompat.equals(getUserType(), user.getUserType()) &&
              ObjectsCompat.equals(getCreatedAt(), user.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), user.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getEmail())
      .append(getCognitoId())
      .append(getUserType())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("User {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("cognitoID=" + String.valueOf(getCognitoId()) + ", ")
      .append("userType=" + String.valueOf(getUserType()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static EmailStep builder() {
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
  public static User justId(String id) {
    return new User(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      email,
      cognitoID,
      userType);
  }
  public interface EmailStep {
    CognitoIdStep email(String email);
  }
  

  public interface CognitoIdStep {
    BuildStep cognitoId(String cognitoId);
  }
  

  public interface BuildStep {
    User build();
    BuildStep id(String id);
    BuildStep userType(UserType userType);
  }
  

  public static class Builder implements EmailStep, CognitoIdStep, BuildStep {
    private String id;
    private String email;
    private String cognitoID;
    private UserType userType;
    @Override
     public User build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new User(
          id,
          email,
          cognitoID,
          userType);
    }
    
    @Override
     public CognitoIdStep email(String email) {
        Objects.requireNonNull(email);
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep cognitoId(String cognitoId) {
        Objects.requireNonNull(cognitoId);
        this.cognitoID = cognitoId;
        return this;
    }
    
    @Override
     public BuildStep userType(UserType userType) {
        this.userType = userType;
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
    private CopyOfBuilder(String id, String email, String cognitoId, UserType userType) {
      super.id(id);
      super.email(email)
        .cognitoId(cognitoId)
        .userType(userType);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder cognitoId(String cognitoId) {
      return (CopyOfBuilder) super.cognitoId(cognitoId);
    }
    
    @Override
     public CopyOfBuilder userType(UserType userType) {
      return (CopyOfBuilder) super.userType(userType);
    }
  }
  
}
