package com.tuyenmonkey;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import com.tuyenmonkey.strategy.EmailFillStrategy;
import com.tuyenmonkey.strategy.Mode;
import com.tuyenmonkey.strategy.NormalTextFillStrategy;
import com.tuyenmonkey.strategy.TextFillStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/3/17.
 */

public class AutoFillEditText extends AppCompatEditText {

  private Mode mode;
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
    mode = Mode.NORMAL;

    if (attrs != null) {
      TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AutoFillEditText);

      try {
        CharSequence[] suggestionsValue = a.getTextArray(R.styleable.AutoFillEditText_suggestions);
        String modeValue = a.getString(R.styleable.AutoFillEditText_mode);

        if (suggestionsValue != null) {
          for (CharSequence value : suggestionsValue) {
            suggestions.add(value.toString());
          }
        }

        if (modeValue != null && modeValue.equals("email")) {
          mode = Mode.EMAIL;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        a.recycle();
      }
    }

    textFillStrategy = (mode == Mode.EMAIL)
        ? new EmailFillStrategy(this, suggestions)
        : new NormalTextFillStrategy(this, suggestions);
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

  public void addSuggestion(String suggestion) {
    this.suggestions.add(suggestion);
  }
}
