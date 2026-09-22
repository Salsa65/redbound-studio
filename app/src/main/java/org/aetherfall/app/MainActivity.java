package org.aetherfall.app;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;

public class MainActivity extends Activity {
 private WebView web;
 private PermissionRequest pending;
 private static final int MIC=71;
 @Override public void onCreate(Bundle b){
  super.onCreate(b);
  web=new WebView(this); setContentView(web);
  WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setMediaPlaybackRequiresUserGesture(false);
  web.setWebViewClient(new WebViewClient());
  web.setWebChromeClient(new WebChromeClient(){
   @Override public void onPermissionRequest(PermissionRequest r){
    runOnUiThread(()->{
     boolean audio=false; for(String x:r.getResources()) if(PermissionRequest.RESOURCE_AUDIO_CAPTURE.equals(x)) audio=true;
     if(!audio){r.deny();return;}
     pending=r;
     if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.RECORD_AUDIO)==PackageManager.PERMISSION_GRANTED) r.grant(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE});
     else ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.RECORD_AUDIO},MIC);
    });
   }
  });
  web.loadUrl("https://redbound-rpg.hatchable.site");
 }
 @Override public void onRequestPermissionsResult(int req,String[] p,int[] g){
  super.onRequestPermissionsResult(req,p,g);
  if(req==MIC&&pending!=null){if(g.length>0&&g[0]==PackageManager.PERMISSION_GRANTED)pending.grant(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE});else pending.deny();pending=null;}
 }
 @Override public void onBackPressed(){if(web.canGoBack())web.goBack();else super.onBackPressed();}
}
