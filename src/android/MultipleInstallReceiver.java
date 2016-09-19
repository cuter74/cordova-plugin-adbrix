package com.mscbrain.lib.tracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;

import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;
import com.igaworks.IgawReceiver;


public class MultipleInstallReceiver extends BroadcastReceiver {

    static Object zzamr = new Object();
    static zzvw zzcrw;
    static Boolean zzcrx;

    public MultipleInstallReceiver() {
    }

    public static boolean zzav(Context var0) {
        zzab.zzy(var0);
        if(zzcrx != null) {
            return zzcrx.booleanValue();
        } else {
            boolean var1 = zzao.zzb(var0, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
            zzcrx = Boolean.valueOf(var1);
            return var1;
        }
    }

    @RequiresPermission(
            allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
    )

    @Override
    public void onReceive(Context var1, Intent var2) {
        zzf var3 = zzf.zzay(var1);
        zzaf var4 = var3.zzyx();
        //IGAW 구글 인스톨 리시버 등록
        IgawReceiver igawReceiver = new IgawReceiver();
        igawReceiver.onReceive(var1, var2);
        //INSTALL_REFERRER 를 전달받아야 하는 다른 리시버들을 등록합니다.
        if(var2 == null) {
            var4.zzek("CampaignTrackingReceiver received null intent");
        } else {
            String var5 = var2.getStringExtra("referrer");
            String var6 = var2.getAction();
            var4.zza("CampaignTrackingReceiver received", var6);
            if("com.android.vending.INSTALL_REFERRER".equals(var6) && !TextUtils.isEmpty(var5)) {
                boolean var7 = CampaignTrackingService.zzaw(var1);
                if(!var7) {
                    var4.zzek("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
                }

                this.zzh(var1, var5);
                if(var3.zzyy().zzabc()) {
                    var4.zzel("Received unexpected installation campaign on package side");
                } else {
                    Class var8 = this.zzvv();
                    zzab.zzy(var8);
                    Intent var9 = new Intent(var1, var8);
                    var9.putExtra("referrer", var5);
                    Object var10 = zzamr;
                    synchronized(zzamr) {
                        var1.startService(var9);
                        if(var7) {
                            try {
                                if(zzcrw == null) {
                                    zzcrw = new zzvw(var1, 1, "Analytics campaign WakeLock");
                                    zzcrw.setReferenceCounted(false);
                                }

                                zzcrw.acquire(1000L);
                            } catch (SecurityException var13) {
                                var4.zzek("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                            }

                        }
                    }
                }
            } else {
                var4.zzek("CampaignTrackingReceiver received unexpected intent without referrer extra");
            }
        }
    }

    protected Class<? extends CampaignTrackingService> zzvv() {
        return CampaignTrackingService.class;
    }

    protected void zzh(Context var1, String var2) {
    }
}
