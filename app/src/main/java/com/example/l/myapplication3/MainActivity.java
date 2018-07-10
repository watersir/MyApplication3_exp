package com.example.l.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearlayout;
    private ImageView main_imageview;
    private int i = 0;
    public Timer timer = new Timer();// 定时器


  private Handler handler = new Handler()
  {
    @Override
    public void handleMessage(Message msg)
    {

      Log.e("@@@", i + "");
      //index=msg.what;
      switch(i){
          case 1:
              main_imageview.setImageResource(R.drawable.map3);
              break;
          case 2:
              main_imageview.setImageResource(R.drawable.map4);
              break;
          default:
              main_imageview.setImageResource(R.drawable.map4);
              break;
          //linearlayout.invalidate();
          }
      linearlayout.invalidate();

      super.handleMessage(msg);
    }
  };

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
  }

  public void initView()
  {
    linearlayout = (LinearLayout) findViewById(R.id.background_main);
    main_imageview = (ImageView) findViewById(R.id.imageView);

    timer.scheduleAtFixedRate(new TimerTask()
    {
      @Override
      public void run()
      {
          i++;
        Message mesasge = new Message();
        mesasge.what = i;
        handler.sendMessage(mesasge);
          }
        // TODO Auto-generated method stub

    }, 0, 5000);
  }

  @Override
  protected void onDestroy()
  {
    // TODO Auto-generated method stub
    timer.cancel();
    super.onDestroy();
  }

}
