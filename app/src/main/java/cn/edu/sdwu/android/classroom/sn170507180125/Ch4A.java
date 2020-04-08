package cn.edu.sdwu.android.classroom.sn170507180125;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Ch4A extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面
        setContentView(R.layout.ch41);
        //1）获取普通界面组件；必须在setContentView之后，调用 findViewById方法
        Button button=(Button) findViewById(R.id.button1);
        ImageView imageView=(ImageView) findViewById(R.id.ch4_iv);
        //3）调用事件源的setXXXXXListener方法注册监听器
        button.setOnClickListener(new MyClickListener());
        //3.使用内部匿名类注册监听器
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //设置壁纸
                WallpaperManager wallpaperManager=(WallpaperManager) getSystemService(WALLPAPER_SERVICE);
                try{
                    wallpaperManager.setResource(R.raw.img);
                }catch(Exception e){
                    Log.e(Ch4A.class.toString(),e.toString());
                }

                return true;
            }
        });
    }
    //2）实现事件监听类，该监听是一个特殊的Java类，必须实现一个XXXListener接口；
    class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Log.i(Ch4A.class.toString(),"button click");
        }
    }


}
