package com.tuyenmonkey;

import android.widget.EditText;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/5/17.
 */

public abstract class TextFillStrategy {

  protected EditText editText;
  protected List<String> suggestions;
  protected boolean suggested;
  protected String nonSelectionText;

  public TextFillStrategy(EditText editText, List<String> suggestions) {
    this.editText = editText;
    this.suggestions = suggestions;
    this.nonSelectionText = "";
  }

  abstract void apply(String fullText);
}
