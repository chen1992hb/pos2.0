package com.lcpay.pos.model.Account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcpay.pos.model.Entity;
import java.util.ArrayList;
import org.parceler.Parcel;

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true) public class User extends Entity
    implements Account {

  @JsonProperty("tel_code") public String telCode;

  @JsonProperty("agent_type") public String agentType;
  @JsonProperty("auth_token") public String authToken;
  @JsonProperty("choose_member") public UserInfo chooseMember;

  public String mobile;
  public String token;

  public String number;

  @JsonProperty("user_info") public UserInfo userInfo;

  public ArrayList<UserInfo> members;
  public ArrayList<Permission> permissions;

  @Override public String name() {
    return null;
  }

  @Override public String token() {
    return authToken;
  }

  @Override public String toJson() {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  public boolean hasPermission(String permission) {
    if (permissions == null) {
      return true;
    }
    for (Permission perm : permissions) {
      if (perm.name.equals(permission)) {
        return true;
      }
    }
    return false;
  }

  //public String getAgentCodeIn() {
  //  if (chooseMember == null) return "";
  //  return chooseMember.agentCodeIn;
  //}
}