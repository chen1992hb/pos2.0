package com.lcpay.pos.db.util;

import android.content.Context;
import com.lcpay.pos.db.PersonDao;
import com.lcpay.pos.model.database.sample.Person;
import java.util.List;


// 老版本需要clear一下daoSession，否则会使用缓存，新版本不用
//这是一个非常个性化的一个查询类，我们可以封装一些想要的数据库操作
public class PersonHelper extends BaseDao {

  public PersonHelper(Context context) {
    super(context);
  }
  //sample 通过ID查询对象 * @param id * @return
  public Person getPersonById(Long id){
    return daoSession.getPersonDao().load(id);
  }
  /**
   * 获取某个对象的主键ID * @param person * @return
   */
  private Long getID(Person person){
    return daoSession.getPersonDao().getKey(person);
  }

  /*
  * 通过某些条件查询,返回list
  * */
  private List getPsersonByName(String name){
    List<Person> list =
        daoSession.getPersonDao().queryBuilder().where(PersonDao.Properties.Name.eq(name)).build().list();
    return list;
  }

  /*
  * 如果某些数据是唯一的，例如id是唯一
  * */
  private Person getPsersonByName(Long id){
    return daoSession.getPersonDao()
        .queryBuilder()
        .where(PersonDao.Properties.Id.eq(id))
        .build()
        .unique();
  }


  /*
  * where能进行多条件查询
  * */
  private Person getPsersonByNameAndId(String name,Long id){
    return daoSession.getPersonDao().queryBuilder()
        .where(PersonDao.Properties.Name.eq(name),PersonDao.Properties.Id.eq(id))
        .build().unique();
  }

  /***************************数据库删除*************************/
  /**
   * 根据ID进行数据库的删除操作 * @param id
   */
  private void deleteById(long id) {
    daoSession.getPersonDao().deleteByKey(id);
    daoSession.clear();
  }

  /**
   * 根据ID同步删除数据库操作 * @param ids
   */
  private void deleteByIds(List ids) {
    daoSession.getPersonDao().deleteByKeyInTx(ids);
    daoSession.clear();
  }


}
