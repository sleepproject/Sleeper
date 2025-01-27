package com.example.Sleeper;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class UI_1_2_permission_activity extends AppCompatActivity {
    public static int OVERLAY_PERMISSION_REQ_CODE = 1234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_1_2_permission_layout);
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //다음버튼을 눌러 권한 설정을 하게된다. 설정이 끝났다면 다음 액티비티로 넘어간다. 권한이 다 설정되있다면 바로 다음으로 넘어간다
        Button okbtn = (Button)findViewById(R.id.okbtn);
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mNotificationManager.isNotificationPolicyAccessGranted() && checkPermission() && android.provider.Settings.canDrawOverlays(getApplicationContext())){
                    Intent loginIntent=new Intent(getApplicationContext(),UI_1_3_login_activity.class);
                    startActivity(loginIntent);
                    finish();
                }else{
                    //소리조절을 위한 권한 있는지 체크 후 없으면 권한 설정창으로 이동시켜줌
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
                            && !mNotificationManager.isNotificationPolicyAccessGranted())
                    {
                        Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(UI_1_2_permission_activity.this,
                                "권한이 설정되지 않았습니다. 확인 후 진행해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    //앱 실행기록을 위한 권한이 부여되어있는지 확인 후 되어있지 않다면 권한 설정 화면으로 이동
                    if(!checkPermission()) {
                        startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
                    }
                    else
                    {
                        Toast.makeText(UI_1_2_permission_activity.this,
                                "권한이 설정되지 않았습니다. 확인 후 진행해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    //다른 앱 위에 그리기를 위한 권한 호출 창
                    if(!android.provider.Settings.canDrawOverlays(getApplicationContext())){
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                    Uri.parse("package:"+getPackageName()));
                            startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
                        }
                    }
                    else
                    {
                        Toast.makeText(UI_1_2_permission_activity.this,
                                "권한이 설정되지 않았습니다. 확인 후 진행해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    boolean test1 = mNotificationManager.isNotificationPolicyAccessGranted();
                    boolean test2 = checkPermission();
                    boolean test3 = android.provider.Settings.canDrawOverlays(getApplicationContext());
                    Log.d("permissionTest",test1 +"\t"+test2+"\t"+test3);
                }
            }
        });
    }
    //앱 실행기록을 위한 권한 체크
    private boolean checkPermission(){
        boolean granted = false;
        AppOpsManager appOps = (AppOpsManager) getApplicationContext()
                .getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(), getApplicationContext().getPackageName());
        if (mode == AppOpsManager.MODE_DEFAULT) {
            granted = (getApplicationContext().checkCallingOrSelfPermission(
                    android.Manifest.permission.PACKAGE_USAGE_STATS) == PackageManager.PERMISSION_GRANTED);
        }
        else {
            granted = (mode == AppOpsManager.MODE_ALLOWED);
        }
        return granted;
    }
}