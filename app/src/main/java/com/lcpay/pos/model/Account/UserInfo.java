package com.lcpay.pos.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lcpay.pos.model.Entity;
import org.parceler.Parcel;

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)public class UserInfo extends Entity {
  @JsonProperty("user_id") public String userId;
  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserInfo userInfo = (UserInfo) o;

    return userId.equals(userInfo.userId);
  }

  @Override public int hashCode() {
    return userId.hashCode();
  }
}
