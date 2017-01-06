package com.tuyenmonkey;

import android.content.Context;
import android.content.res.TypedArray;
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
    init(context, null);
  }

  public AutoFillEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);

  }

  public AutoFillEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
    suggestions = new ArrayList<>();
    suggestions.add("gmail.com");
    suggestions.add("tiki.vn");
    textFillStrategy = new EmailFillStrategy(this, suggestions);

    if (attrs != null) {
      TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AutoFillEditText);

      try {
        CharSequence[] values = a.getTextArray(R.styleable.AutoFillEditText_suggestions);
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        a.recycle();
      }
    }
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
