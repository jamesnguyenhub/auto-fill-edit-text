package com.tuyenmonkey.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //AutoFillEditText editText = (AutoFillEditText)findViewById(R.id.afetEmail);
    //editText.addSuggestions(Arrays.asList("0935939393", "0961342123"));
  }
}
