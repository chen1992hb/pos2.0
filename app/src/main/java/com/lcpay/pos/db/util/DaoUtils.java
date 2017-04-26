package com.lcpay.pos.db.util;

import android.content.Context;

public class DaoUtils {
  public static Context context;
  private static PersonHelper personHelper;
  public static void init(Context context) {
    DaoUtils.context = context.getApplicationContext();
  }


  /**
   * 这是一个例子
   * 单列模式获取drugUserHelper对象 * @return
   */
  public static PersonHelper getPerson() {
    if (personHelper == null) {
      personHelper = new PersonHelper(context);
    }
    return personHelper;
  }


}
