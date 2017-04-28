package com.lcpay.pos.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.multidex.MultiDex;
import android.support.v4.content.ContextCompat;

import com.blankj.utilcode.utils.Utils;
import com.lcpay.pos.BuildConfig;

import com.lcpay.pos.feature.injector.component.AppComponent;

import com.lcpay.pos.log.MyLogImp;
import com.lcpay.pos.util.PosApplicationContext;
import com.lcpay.pos.util.PreferencesHelper;
import com.lcpay.pos.util.TinkerManager;
import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

import lcpay.starter.kit.retrofit.Network;


//这是一个appliaction的代理类，注册使用application
@SuppressWarnings("unused")
@DefaultLifeCycle(application = "com.lcpay.pos.PosApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class ApplicationLike extends DefaultApplicationLike {
    private static final String TAG = "Pos.ApplicationLike";
    //private static AppInfo mAppInfo;
    private static volatile Handler sAppHandler;
    public static AppComponent appComponent;
    private static Application instance;

    public ApplicationLike(Application application, int tinkerFlags,
                           boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime,
                           long applicationStartMillisTime,
                           Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent);
    }

    /**
     * install multiDex before install tinker
     * so we don't need to put the tinker lib classes in the main dex
     *
     * @param base
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        PosApplicationContext.application = getApplication();
        PosApplicationContext.context = getApplication();
        TinkerManager.setTinkerApplicationLike(this);
        TinkerManager.initFastCrashProtect();
        //should set before tinker is installed
        TinkerManager.setUpgradeRetryEnable(true);
        //optional set logIml, or you can use default debug log
        TinkerInstaller.setLogIml(new MyLogImp());
        //installTinker after load multiDex
        //or you can put com.tencent.tinker.** to main dex
        TinkerManager.installTinker(this);
        Tinker tinker = Tinker.with(getApplication());
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        getApplication().registerActivityLifecycleCallbacks(callback);
    }

  /*  public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .initAccoutModule(new InitAccoutModule())
                    .build();
        }
        return appComponent;
    }*/

    @Override
    public void onCreate() {
        super.onCreate();
        //mAppInfo = null;

        init();
        instance = PosApplicationContext.application;
        Utils.init(PosApplicationContext.application);//一个utils库的初始化 https://github.com/Blankj/AndroidUtilCode/blob/master/README-CN.md
        //InitializeUtil.initialize();

//    new Network.Builder()
//        .networkDebug(BuildConfig.DEBUG)
//        //.accept(Constant.API_ACCEPT)
//        .client(SaobeiHttpClient.newInstance())
//        .baseUrl(Constant.API_ENDPOINT).build();
    }

    private void init() {
        sAppHandler = new Handler(PosApplicationContext.application.getMainLooper());
    }


    /**
     * @return application context
     */
    public static Context appContext() {
        return PosApplicationContext.context;
    }

    /**
     * @return application resource
     */
    public static Resources appResources() {
        return appContext().getResources();
    }

    /**
     * @return Resource dimension value multiplied by the appropriate metric.
     */
    public static float dimen(@DimenRes int dimenRes) {
        return appResources().getDimension(dimenRes);
    }

    public static int color(@ColorRes int colorRes) {
        return ContextCompat.getColor(appContext(), colorRes);
    }

    public static Drawable drawable(@DrawableRes int drawableRes) {
        return ContextCompat.getDrawable(appContext(), drawableRes);
    }

    /**
     * @return application handler
     */
    public static Handler appHandler() {
        return sAppHandler;
    }


    ///**
    // * 更新本地versionCode
    // */
    //public static void enterApp() {
    //  PreferencesHelper.INSTANCE.setVersionCode(appInfo().versionCode);
    //}
    //
    ///**
    // * 是否有版本更新显示引导页
    // */
    //public static boolean shouldEnterApp() {
    //  return appInfo().versionCode > PreferencesHelper.INSTANCE.getVersionCode();
    //}

    @Override
    public void onTerminate() {
        super.onTerminate();
        sAppHandler = null;
        //mAppInfo = null;
    }
}
