package com.tuyenmonkey.autofilledittext;

import android.widget.EditText;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/5/17.
 */

public class NormalSelectionStrategy extends SelectionStrategy {

  public NormalSelectionStrategy(EditText editText, List<String> suggestions) {
    super(editText, suggestions);
  }

  @Override void apply(String fullText) {
    if (nonSelectionText.length() >= fullText.length()) {
      suggested = false;
      nonSelectionText = fullText;
      return;
    }

    if (suggested) {
      suggested = false;
      return;
    }

    for (String suggestion : suggestions) {
      if (suggestion.startsWith(fullText)) {
        suggested = true;
        editText.setText(suggestion);
        editText.setSelection(fullText.length(), suggestion.length());
        nonSelectionText = fullText;
        break;
      }
    }
  }
}
