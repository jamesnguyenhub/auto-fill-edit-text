package com.tuyenmonkey.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tuyenmonkey.AutoFillEditText;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    AutoFillEditText editText = (AutoFillEditText)findViewById(R.id.afetEmail);
    editText.addSuggestions(Arrays.asList("hotmail.com", "microsoft.com"));
  }
}
