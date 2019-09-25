package io.vividcode.graalvm;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class JsEvaluation {

  public static void main(String[] args) {
    Context context = Context.create();
    Value dateObject = context.eval("js", "new Date().toString()");
    System.out.println(dateObject.asString());
    context.close();
  }
}
