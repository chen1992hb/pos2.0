package com.lcpay.pos.feature.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.lcpay.pos.R;
import com.lcpay.pos.db.util.DaoUtils;
import com.lcpay.pos.db.util.PersonHelper;
import com.lcpay.pos.model.database.sample.Person;

/*
* 热更新需要执行代码
*  TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
 *  Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
 *  下载的文件路径，不一定要使用apk为后缀名
* */
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupView();

    DaoUtils.init(this); // 绑定数据库的context
    PersonHelper person = DaoUtils.getPerson();
    //操作数据库
    Person insertdata = new Person();
    insertdata.setId(null);//设置null会自增，没有设置默认为null
    person.insertObject(insertdata);
    Person personById = person.getPersonById(1L);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    DaoUtils.getPerson().CloseDataBase();//使用完毕可以在onDestory中选择关闭
  }

  private void setupView() {
    SimpleFragmentPagerAdapter
        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this);
    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    viewPager.setAdapter(pagerAdapter);
    TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
    tabLayout.setupWithViewPager(viewPager);
    tabLayout.setTabMode(TabLayout.MODE_FIXED);
  }
}
