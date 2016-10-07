package com.mscbrain.lib.tracking;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.igaworks.IgawCommon;
import com.igaworks.adbrix.IgawAdbrix;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.chromium.base.Log;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by cuter74 on 2016. 9. 8..
 */
public class AdBrixPlugin  extends CordovaPlugin {
    private static final String LOG_TAG = "AdBrixPlugin";
    private static volatile Activity currentActivity;
    private CallbackContext callbackContext;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        Log.v(LOG_TAG, "AdBrixPlugininitialize");
        super.initialize(cordova, webView);
        currentActivity = this.cordova.getActivity();
    }
    /**
     * Execute plugin
     * @param action
     * @param options
     * @param callbackContext
     */
    public boolean execute(final String action, JSONArray options, final CallbackContext callbackContext) throws JSONException
    {
        Log.v(LOG_TAG, "adBrixPlugin : execute " + action);
        this.callbackContext = callbackContext;
        if(action.equals("end")){
        	Log.v(LOG_TAG, "adBrixPlugin :  " + action);
        }else if(action.equals("retention")){
        	Log.v(LOG_TAG, "adBrixPlugin :  " + action);
            final String menuName = options.getString(0);
            IgawAdbrix.retention(menuName);
        }else if(action.equals("age")){
            Log.v(LOG_TAG, "adBrixPlugin :  " + action);
            final int age = options.getInt(0);
            Log.v(LOG_TAG, "adBrixPlugin age :  " + action);
            IgawCommon.setAge(age);
        }else if(action.equals("gender")){
            Log.v(LOG_TAG, "adBrixPlugin :  " + action);
            final String gender = options.getString(0);
            Log.v(LOG_TAG, "adBrixPlugin gender :  " + gender);
            if(gender.equals("F")){
                IgawCommon.setGender(IgawCommon.Gender.FEMALE);
            }else {
                IgawCommon.setGender(IgawCommon.Gender.MALE);
            }
        }else if(action.equals("member")){
        	Log.v(LOG_TAG, "adBrixPlugin :  " + action);
        	
        }
        return true;
    }
}
