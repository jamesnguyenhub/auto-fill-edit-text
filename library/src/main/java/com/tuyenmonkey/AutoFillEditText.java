package com.tuyenmonkey;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/3/17.
 */

public class AutoFillEditText extends AppCompatEditText {

  private TextFillStrategy textFillStrategy;
  private List<String> suggestions;
  private boolean firstChange;

  public AutoFillEditText(Context context) {
    super(context);
    init();
  }

  public AutoFillEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();

  }

  public AutoFillEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    suggestions = new ArrayList<>();
    suggestions.add("gmail.com");
    suggestions.add("tiki.vn");
    textFillStrategy = new EmailFillStrategy(this, suggestions);
  }

  @Override
  protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
    if (!firstChange) {
      firstChange = true;
      return;
    }

    textFillStrategy.apply(text.toString());
  }

  public void addSuggestions(List<String> suggestions) {
    this.suggestions.addAll(suggestions);
  }
}
