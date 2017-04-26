package com.lcpay.pos.model.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Test {
  @Id
  private long id;
  private String name;
  private int age;
  @Generated(hash = 2090172677)
  public Test(long id, String name, int age) {
      this.id = id;
      this.name = name;
      this.age = age;
  }
  @Generated(hash = 372557997)
  public Test() {
  }
  public long getId() {
      return this.id;
  }
  public void setId(long id) {
      this.id = id;
  }
  public String getName() {
      return this.name;
  }
  public void setName(String name) {
      this.name = name;
  }
  public int getAge() {
      return this.age;
  }
  public void setAge(int age) {
      this.age = age;
  }

}
