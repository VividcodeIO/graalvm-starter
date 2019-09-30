package io.vividcode.graalvm;

import java.util.HashMap;
import java.util.Map;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class JsBindings {

  public static void main(String[] args) {
    try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
      Value bindings = context.getBindings("js");
      Map<String, String> data = new HashMap<>();
      data.put("name", "Test");
      bindings.putMember("data", data);
      Value content = context.eval("js", "data.get('name')");
      System.out.println(content.asString());
    }
  }
}
