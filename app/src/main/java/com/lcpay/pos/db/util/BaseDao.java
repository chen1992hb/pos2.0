package com.lcpay.pos.db.util;

import android.content.Context;
import android.util.Log;
import com.lcpay.pos.db.DaoSession;
import java.util.List;

public class BaseDao {
  public static final String TAG = BaseDao.class.getSimpleName();
  public static final boolean DUBUG = true;
  public DaoManager manager;
  public DaoSession daoSession;

  public BaseDao(Context context) {
    manager = DaoManager.getInstance();
    manager.init(context);
    daoSession = manager.getDaoSession();
    manager.setDebug(DUBUG);
  }

  /**************************数据库插入操作***********************/
  /**
   * 插入单个对象 * @param object * @return
   */
  public <T> boolean insertObject(T object) {
    boolean flag = false;
    try {
      flag = manager.getDaoSession().insertOrReplace(object) != -1 ? true : false;
    } catch (Exception e) {
      Log.e(TAG, e.toString());
    }
    return flag;
  }

  /**
   * 插入多个对象，并开启新的线程 * @param objects * @return
   */
  public boolean insertMultObject(final List objects) {
    boolean flag = false;
    if (null == objects || objects.isEmpty()) {
      return false;
    }
    try {
      manager.getDaoSession().runInTx(new Runnable() {
        @Override
        public void run() {
          for (Object object : objects) {
            manager.getDaoSession().insertOrReplace(object);
          }
        }
      });
      flag = true;
    } catch (Exception e) {
      Log.e(TAG, e.toString());
      flag = false;
    } finally {
      //            manager.CloseDataBase();
    }
    return flag;
  }

  /**************************数据库更新操作***********************/
  /**
   * 以对象形式进行数据修改 * 其中必须要知道对象的主键ID * @param object * @return
   */

  public <T> void updateObject(T object) {
    if (null == object) {
      return;
    }
    try {
      manager.getDaoSession().update(object);
    } catch (Exception e) {
      Log.e(TAG, e.toString());
    }
  }

  /**
   * 删除某个数据库表 * @param clss * @return
   */
  public boolean deleteAll(Class clss) {
    boolean flag = false;
    try {
      manager.getDaoSession().deleteAll(clss);
      flag = true;
    } catch (Exception e) {
      Log.e(TAG, e.toString());
      flag = false;
    }
    return flag;
  }

  /**
   * 删除某个对象 * @param object * @return
   */
  public <T> void deleteObject(T object) {
    try {
      daoSession.delete(object);
    } catch (Exception e) {
      Log.e(TAG, e.toString());
    }
  }
  /**
   * 获得某个表名 * @return
   */
  public String getTablename(Class object) {
    return daoSession.getDao(object).getTablename();
  }

  /**
   * 根据主键ID来查询 * @param id * @return= null; List objects = null; try { obj =
   * daoSession.getDao(object); if (null == obj){ return null; } objects =
   * daoSession.getDao(object).queryRaw(where,params); } catch (Exception e) { Log.e(TAG,
   * e.toString()); }  return objects; } /** * 查询所有对象 * @param object * @return
   */
  public List QueryAll(Class object) {
    List objects = null;
    try {
      objects = (List) daoSession.getDao(object).loadAll();
    } catch (Exception e) {
      Log.e(TAG, e.toString());
    }
    return objects;
  }  /***************************关闭数据库*************************/
  /**
   * 关闭数据库一般在Odestory中使用
   */
  public void CloseDataBase() {
    manager.closeDataBase();
  }

  public <T> T QueryById(long id, Class object) {
    return (T) daoSession.getDao(object).loadByRowId(id);
  }

  public List QueryObject(Class object, String where, String... params) {
    Object obj = null;
    List objects = null;
    try {
      obj = daoSession.getDao(object);
      if (null == obj) {
        return null;
      }
      objects = daoSession.getDao(object).queryRaw(where, params);
    } catch (Exception e) {
      Log.e(TAG, e.toString());
    }
    return objects;
  }
}
