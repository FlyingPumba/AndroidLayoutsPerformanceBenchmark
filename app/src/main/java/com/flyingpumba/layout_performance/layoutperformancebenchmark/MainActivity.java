package com.flyingpumba.layout_performance.layoutperformancebenchmark;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

  long startTime;
  long endTime;

  @Override protected void onCreate(Bundle savedInstanceState) {
    startTime = System.currentTimeMillis();
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_main);
    setContentView(createHugeLayout());
  }

  @Override protected void onResume() {
    super.onResume();
    endTime = System.currentTimeMillis();
    long diff = endTime - startTime;
    String output = String.format("%d milliseconds", diff);
    Log.d("MainAcitivity", output);
    Toast.makeText(MainActivity.this, output, Toast.LENGTH_LONG).show();
  }

  private LinearLayout createHugeLayout() {
    LinearLayout linearLayout = new LinearLayout(this);
    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT));
    linearLayout.setOrientation(VERTICAL);

    for (int i = 0; i < 5000; i++) {
      TextView textView = new TextView(this);
      textView.setText("Hello World!");
      textView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
      linearLayout.addView(textView);
    }

    return linearLayout;
  }
}
