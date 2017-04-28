package com.lcpay.pos.feature.http;

import rx.Subscription;

public interface LifeSubscription {
    void bindSubscription(Subscription subscription);
}
