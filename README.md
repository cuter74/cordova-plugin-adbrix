cordova-plugin-adbrix
=====================

Cordova (PhoneGap) 3.0+ plugin to open an application on native Marketplace app, aka Google Play for Android or App Store for iOS.
Currently this plugin is compatible only with Android and iOS. Feel free to add support for the platform you need!

#Installation

This plugin follows the Cordova 3.0 plugin spec, so it can be installed through the Cordova CLI in your existing Cordova project:

    cordova plugin add https://github.com/cuter74/cordova-plugin-adbrix

#How to use it

add mainactivity

	@Override
    public void onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml=
        IgawCommon.startApplication(MainActivity.this);
        loadUrl(launchUrl);
    }
	
    @Override
    protected void onResume() {
        super.onResume();
        IgawCommon.startSession(MainActivity.this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        IgawCommon.endSession();
    }
    
    
#SDK File DownLoad Link

https://github.com/IGAWorksDev/IgaworksSDK/blob/master/01-android-sdk/IGAWorks_Android_SDK_Full_Package_160905_v1.zip?raw=true

#USE SDK COMMENT Page

http://help.igaworks.com/hc/ko/3_3/Content/Article/sdk_installation_aos

#Release Notes

Version 0.7.1



#Contact

If you are using cordova-plugin-adbrix in your app and have any suggestion or question:


