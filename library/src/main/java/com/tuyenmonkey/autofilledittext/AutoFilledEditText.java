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

  private List<String> suggestions;
  private boolean suggested;
  private String nonSelectionText;
  private boolean firstRequest;

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
    nonSelectionText = "";
    suggestions = new ArrayList<>();
  }

  @Override
  protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
    if (!firstRequest) {
      firstRequest = true;
      return;
    }

    if (nonSelectionText.length() >= text.length()) {
      suggested = false;
      nonSelectionText = text.toString();
      return;
    }

    if (suggested) {
      suggested = false;
      return;
    }

    for (String suggestion : suggestions) {
      if (suggestion.contains(text)) {
        suggested = true;
        setText(suggestion);
        setSelection(text.length(), suggestion.length());
        nonSelectionText = text.toString();
        break;
      }
    }
  }

  public void setSuggestions(List<String> suggestions) {
    this.suggestions = suggestions;
  }
}
