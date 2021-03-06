package com.lcpay.pos.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.lcpay.pos.model.database.sample.Friend;
import com.lcpay.pos.model.database.sample.Head;
import com.lcpay.pos.model.database.sample.Person;
import com.lcpay.pos.model.database.Test;

import com.lcpay.pos.db.FriendDao;
import com.lcpay.pos.db.HeadDao;
import com.lcpay.pos.db.PersonDao;
import com.lcpay.pos.db.TestDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig friendDaoConfig;
    private final DaoConfig headDaoConfig;
    private final DaoConfig personDaoConfig;
    private final DaoConfig testDaoConfig;

    private final FriendDao friendDao;
    private final HeadDao headDao;
    private final PersonDao personDao;
    private final TestDao testDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        friendDaoConfig = daoConfigMap.get(FriendDao.class).clone();
        friendDaoConfig.initIdentityScope(type);

        headDaoConfig = daoConfigMap.get(HeadDao.class).clone();
        headDaoConfig.initIdentityScope(type);

        personDaoConfig = daoConfigMap.get(PersonDao.class).clone();
        personDaoConfig.initIdentityScope(type);

        testDaoConfig = daoConfigMap.get(TestDao.class).clone();
        testDaoConfig.initIdentityScope(type);

        friendDao = new FriendDao(friendDaoConfig, this);
        headDao = new HeadDao(headDaoConfig, this);
        personDao = new PersonDao(personDaoConfig, this);
        testDao = new TestDao(testDaoConfig, this);

        registerDao(Friend.class, friendDao);
        registerDao(Head.class, headDao);
        registerDao(Person.class, personDao);
        registerDao(Test.class, testDao);
    }
    
    public void clear() {
        friendDaoConfig.clearIdentityScope();
        headDaoConfig.clearIdentityScope();
        personDaoConfig.clearIdentityScope();
        testDaoConfig.clearIdentityScope();
    }

    public FriendDao getFriendDao() {
        return friendDao;
    }

    public HeadDao getHeadDao() {
        return headDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public TestDao getTestDao() {
        return testDao;
    }

}
