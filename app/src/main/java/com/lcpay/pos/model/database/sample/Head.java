package com.lcpay.pos.model.database.sample;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Head {
  @Id(autoincrement = true)
  private Long id;

  @NotNull
  private String name;

  @Generated(hash = 1672944631)
  public Head(Long id, @NotNull String name) {
      this.id = id;
      this.name = name;
  }

  @Generated(hash = 1745729831)
  public Head() {
  }

  public Long getId() {
      return this.id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }
}
