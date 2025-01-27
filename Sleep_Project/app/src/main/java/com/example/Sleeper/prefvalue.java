package com.example.Sleeper;

import android.content.SharedPreferences;
import android.util.Log;

public class prefvalue {
    SharedPreferences pref;

    public prefvalue(){ //생성자로 pref 가져옴
        if(SettingsActivity.pref == null){
            Log.d("prefnull","Null");
        }
        else{
            Log.d("prefnull","Not Null");
            pref = SettingsActivity.pref;
        }
    }

    //메소드로 pref에 설정된 밝기값 가져옴
    public int getbrightvalue(){
        return pref.getInt("bright",0);
    }
    //메소드로 소리방식 설정된 값 가져옴
    public String getAlertvalue(){
        return pref.getString("alert","소리");
    }
    //메소드로 푸시알림설정에 설정된 값 가져옴
    public boolean getPushvalue(){
        return pref.getBoolean("push",true);
    }
    //메소드로 알람음 설정한 uri값 string으로 가져옴
    public String getRingValue(){
        return pref.getString("alarmring","");
    }
    //메소드로 선택적 어플잠금유무? 가져옴 - 방식고민

    //메소드로 모닝콜 문제설정 여부 설정된 값 가져옴
    public boolean getQuesvalue(){
        return pref.getBoolean("ques",true);
    }
}
