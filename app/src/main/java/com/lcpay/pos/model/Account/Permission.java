package com.lcpay.pos.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lcpay.pos.model.Entity;
import org.parceler.Parcel;

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true) public class Permission extends Entity {

  public String name;

  @JsonProperty("display_name") public String displayName;

  public String description;
}
