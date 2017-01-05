package com.tuyenmonkey.autofilledittext;

import android.widget.EditText;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/6/17.
 */

public class EmailSelectionStrategy extends SelectionStrategy {

  public EmailSelectionStrategy(List<String> suggestions) {
    super(suggestions);
  }

  @Override void apply(EditText editText, String fullText) {
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
        String nonSelectionPartOfMailTail = fullText.substring(atIndex + 1, fullText.length());
        String textBeforeMailType = fullText.substring(0, atIndex + 1);

        if (suggestion.startsWith(nonSelectionPartOfMailTail)) {
          suggested = true;

          String fullEmail = textBeforeMailType + suggestion;
          nonSelectionText = textBeforeMailType + nonSelectionPartOfMailTail;

          editText.setText(fullEmail);
          editText.setSelection(atIndex + nonSelectionPartOfMailTail.length() + 1, fullEmail.length());
          break;
        }
      }
    }
  }
}
