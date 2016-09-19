package com.mscbrain.lib.tracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igaworks.IgawReceiver;


public class MultipleInstallReceiver extends BroadcastReceiver {

    public MultipleInstallReceiver() {
    }
    @Override
    public void onReceive(Context var1, Intent var2) {
        //IGAW 구글 인스톨 리시버 등록
        IgawReceiver igawReceiver = new IgawReceiver();
        igawReceiver.onReceive(var1, var2);
        //INSTALL_REFERRER 를 전달받아야 하는 다른 리시버들을 등록합니다.
    }

}
