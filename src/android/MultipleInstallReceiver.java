package com.mscbrain.lib.tracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;

import com.google.android.gms.analytics.CampaignTrackingService;
import com.igaworks.IgawReceiver;


public class MultipleInstallReceiver extends BroadcastReceiver {

    static Object zzamr = new Object();
    static Boolean zzcrx;

    public MultipleInstallReceiver() {
    }

    @RequiresPermission(
            allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
    )

    @Override
    public void onReceive(Context var1, Intent var2) {

        //IGAW 구글 인스톨 리시버 등록
        IgawReceiver igawReceiver = new IgawReceiver();
        igawReceiver.onReceive(var1, var2);
        //INSTALL_REFERRER 를 전달받아야 하는 다른 리시버들을 등록합니다.
    }

    protected Class<? extends CampaignTrackingService> zzvv() {
        return CampaignTrackingService.class;
    }

    protected void zzh(Context var1, String var2) {
    }
}
