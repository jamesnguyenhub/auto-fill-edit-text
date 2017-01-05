package com.tuyenmonkey.autofilledittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/3/17.
 */

public class AutoFilledEditText extends AppCompatEditText {

  private SelectionStrategy selectionStrategy;
  private List<String> suggestions;
  private boolean firstChange;

  public AutoFilledEditText(Context context) {
    super(context);
    init();
  }

  public AutoFilledEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();

  }

  public AutoFilledEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    suggestions = new ArrayList<>();
    suggestions.add("gmail.com");
    suggestions.add("tiki.vn");
    selectionStrategy = new EmailSelectionStrategy(suggestions);
  }

  @Override
  protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
    if (!firstChange) {
      firstChange = true;
      return;
    }

    selectionStrategy.apply(this, text.toString());
  }

  public void setSuggestions(List<String> suggestions) {
    this.suggestions = suggestions;
  }
}
