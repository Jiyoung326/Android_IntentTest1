package kr.or.womanup.nambu.hjy.intenttest_1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String[] permissionList={Manifest.permission.CALL_PHONE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //앱2의 서브 액티비티 동작,,  명시적 인텐트
                Intent intent = new Intent("kr.or.seoulwomansup.nambu.app2_sub");
                //startActivity(intent);
                startActivityForResult(intent,555); //응답 받고 싶을 때
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://naver.com");
                //묵시적 인텐트
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:37.46308962241543, 126.9059481769363");
                //묵시적 인텐트
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:010-1234-1234");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);

            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
//                    int chk = checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE);
//                    if(chk == PackageManager.PERMISSION_DENIED){
//                        return;
//                    }
//                }
                Uri uri = Uri.parse("tel:010-1234-1234");
                Intent intent = new Intent(Intent.ACTION_CALL,uri); //위험권한
                startActivity(intent);
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
    }
    public void checkPermission(){
        for(String permission:permissionList){
            requestPermissions(permissionList,101);
            break;
        }
    }
}