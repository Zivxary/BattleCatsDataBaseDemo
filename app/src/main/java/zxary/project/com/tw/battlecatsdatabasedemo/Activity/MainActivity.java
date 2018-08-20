package zxary.project.com.tw.battlecatsdatabasedemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.WebCombine;
import zxary.project.com.tw.battlecatsdatabasedemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new WebCombine().start();
    }
}
