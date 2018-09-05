package zxary.project.com.tw.battlecatsdatabasedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import zxary.project.com.tw.battlecatsdatabasedemo.R;
import zxary.project.com.tw.battlecatsdatabasedemo.parse.thread.CrawlingData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        new CrawlingData().start();
    }
}
