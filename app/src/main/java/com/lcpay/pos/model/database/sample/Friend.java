package com.lcpay.pos.model.database.sample;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Friend {
  @Id
  private Long id;
  private Long tid;//这个就是外键 就是person的id
  @Generated(hash = 644738920)
  public Friend(Long id, Long tid) {
      this.id = id;
      this.tid = tid;
  }
  @Generated(hash = 287143722)
  public Friend() {
  }
  public Long getId() {
      return this.id;
  }
  public void setId(Long id) {
      this.id = id;
  }
  public Long getTid() {
      return this.tid;
  }
  public void setTid(Long tid) {
      this.tid = tid;
  }
}
