package com.tuyenmonkey.autofilledittext;

import android.widget.EditText;
import java.util.List;

/**
 * Created by Tuyen Nguyen on 1/5/17.
 */

public abstract class SelectionStrategy {

  protected List<String> suggestions;
  protected boolean suggested;
  protected String nonSelectionText;

  abstract void apply(EditText editText, String fullText);
}
