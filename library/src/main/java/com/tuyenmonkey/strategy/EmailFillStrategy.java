package com.tuyenmonkey.strategy;

import android.widget.EditText;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/6/17.
 */

public class EmailFillStrategy extends TextFillStrategy {

  public EmailFillStrategy(EditText editText, List<String> suggestions) {
    super(editText, suggestions);
  }

  @Override public void apply(String fullText) {
    if (fullText.length() <= nonSelectionText.length()) {
      nonSelectionText = fullText;
      suggested = false;
      return;
    }

    if (suggested) {
      suggested = false;
      return;
    }

    for (String suggestion : suggestions) {
      int atIndex = fullText.lastIndexOf('@');

      if (atIndex > -1 && atIndex < fullText.length() - 1) {
        String nonSelectionTextOfEmailTail = fullText.substring(atIndex + 1, fullText.length());
        String username = fullText.substring(0, atIndex + 1);

        if (suggestion.startsWith(nonSelectionTextOfEmailTail)) {
          suggested = true;

          String fullEmail = username + suggestion;
          nonSelectionText = username + nonSelectionTextOfEmailTail;

          editText.setText(fullEmail);
          editText.setSelection(atIndex + nonSelectionTextOfEmailTail.length() + 1, fullEmail.length());
          break;
        }
      }
    }
  }
}
