package com.tuyenmonkey;

import android.widget.EditText;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/5/17.
 */

public abstract class SelectionStrategy {

  protected EditText editText;
  protected List<String> suggestions;
  protected boolean suggested;
  protected String nonSelectionText;

  public SelectionStrategy(EditText editText, List<String> suggestions) {
    this.editText = editText;
    this.suggestions = suggestions;
    this.nonSelectionText = "";
  }

  abstract void apply(String fullText);
}
