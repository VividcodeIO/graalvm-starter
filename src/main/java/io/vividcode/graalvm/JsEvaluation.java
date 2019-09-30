package io.vividcode.graalvm;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class JsEvaluation {

  public static void main(String[] args) {
    try (Context context = Context.create()) {
      Value date = context.eval("js", "new Date().toString()");
      System.out.println(date.asString());
    }
  }
}
