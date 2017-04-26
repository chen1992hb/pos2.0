package com.lcpay.pos.model.database.sample;

import java.util.List;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.lcpay.pos.db.DaoSession;
import com.lcpay.pos.db.FriendDao;
import com.lcpay.pos.db.HeadDao;
import com.lcpay.pos.db.PersonDao;
import org.greenrobot.greendao.annotation.Unique;

//entity建立数据库表对象
@Entity
public class Person {
  /*
  * 基础操作
  * */
  @Id(autoincrement = true)  //允许自增
  private Long id;  // 主键ID需要为Long

  @Property(nameInDb = "MyAge") //简历数据库字段的名称
  private int age; //这里默认会使用age作为列名

  @Unique  //不重复唯一
  @NotNull
  private String name;  //非空

  @Transient
  private int tempValue;//不用保存在数据库中使用Transient标记
  /*
  * 表关联，常用的是一对一和一对多关系
  * 本质是使用外键关联主键
  * */

  //一对一关系,首先建立外键,然后关联关联对象
  private Long hid;
  @ToOne(joinProperty = "hid")
  private Head head;
  /*
  *     Person p = new Person();
        p.setId(null);
        p.setHid(13l);//这里的hid是head的id,就是这样通过id构建起关联的
        p.setName("jafir");
  * */

  //一对多关系
  @ToMany(referencedJoinProperty = "tid")//指定与之关联的其他类的id
  private List<Friend> friends;

  /** Used to resolve relations */
  @Generated(hash = 2040040024)
  private transient DaoSession daoSession;

  /** Used for active entity operations. */
  @Generated(hash = 778611619)
  private transient PersonDao myDao;

  @Generated(hash = 902691004)
  public Person(Long id, int age, @NotNull String name, Long hid) {
      this.id = id;
      this.age = age;
      this.name = name;
      this.hid = hid;
  }

  @Generated(hash = 1024547259)
  public Person() {
  }

  public Long getId() {
      return this.id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public int getAge() {
      return this.age;
  }

  public void setAge(int age) {
      this.age = age;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public Long getHid() {
      return this.hid;
  }

  public void setHid(Long hid) {
      this.hid = hid;
  }

  @Generated(hash = 80859862)
  private transient Long head__resolvedKey;

  /** To-one relationship, resolved on first access. */
  @Generated(hash = 257687018)
  public Head getHead() {
      Long __key = this.hid;
      if (head__resolvedKey == null || !head__resolvedKey.equals(__key)) {
          final DaoSession daoSession = this.daoSession;
          if (daoSession == null) {
              throw new DaoException("Entity is detached from DAO context");
          }
          HeadDao targetDao = daoSession.getHeadDao();
          Head headNew = targetDao.load(__key);
          synchronized (this) {
              head = headNew;
              head__resolvedKey = __key;
          }
      }
      return head;
  }

  /** called by internal mechanisms, do not call yourself. */
  @Generated(hash = 2105847700)
  public void setHead(Head head) {
      synchronized (this) {
          this.head = head;
          hid = head == null ? null : head.getId();
          head__resolvedKey = hid;
      }
  }

  /**
   * To-many relationship, resolved on first access (and after reset).
   * Changes to to-many relations are not persisted, make changes to the target entity.
   */
  @Generated(hash = 19491398)
  public List<Friend> getFriends() {
      if (friends == null) {
          final DaoSession daoSession = this.daoSession;
          if (daoSession == null) {
              throw new DaoException("Entity is detached from DAO context");
          }
          FriendDao targetDao = daoSession.getFriendDao();
          List<Friend> friendsNew = targetDao._queryPerson_Friends(id);
          synchronized (this) {
              if (friends == null) {
                  friends = friendsNew;
              }
          }
      }
      return friends;
  }

  /** Resets a to-many relationship, making the next get call to query for a fresh result. */
  @Generated(hash = 1638260638)
  public synchronized void resetFriends() {
      friends = null;
  }

  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 128553479)
  public void delete() {
      if (myDao == null) {
          throw new DaoException("Entity is detached from DAO context");
      }
      myDao.delete(this);
  }

  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 1942392019)
  public void refresh() {
      if (myDao == null) {
          throw new DaoException("Entity is detached from DAO context");
      }
      myDao.refresh(this);
  }

  /**
   * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
   * Entity must attached to an entity context.
   */
  @Generated(hash = 713229351)
  public void update() {
      if (myDao == null) {
          throw new DaoException("Entity is detached from DAO context");
      }
      myDao.update(this);
  }

  /** called by internal mechanisms, do not call yourself. */
  @Generated(hash = 2056799268)
  public void __setDaoSession(DaoSession daoSession) {
      this.daoSession = daoSession;
      myDao = daoSession != null ? daoSession.getPersonDao() : null;
  }

  //多对多的关系

  /*
  * #person类中
    @Id(autoincrement = true)
    private Long id;
    private String name;
   // 对多，@JoinEntity注解：entity 中间表；sourceProperty 实体属性；targetProperty 外链实体属性
    @ToMany
    @JoinEntity(
            entity = JoinStudentToPerson.class,
            sourceProperty = "pid",
            targetProperty = "sid"
    )
    private List<Student> students;


    //中间表   “第三者”
@Entity
public class JoinStudentToPerson {
   @Id(autoincrement = true)
    private Long id;
    //和person关联的id
    private Long pid;
    //和student关联的id
    private Long sid;
}

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    // 对多，@JoinEntity注解：entity 中间表；sourceProperty 实体属性；targetProperty 外链实体属性
    @ToMany
    @JoinEntity(
            entity = JoinStudentToPerson.class,
            sourceProperty = "sid",
            targetProperty = "pid"
    )
    private List<Person> persons;
}
    */
}
