package io.vividcode.graalvm;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess.Export;

public class JsHostAccess {

  public static void main(String[] args) {
    Context context = Context.create();
    Pointer pointer = new Pointer(0, 0);
    context.getBindings("js").putMember("pointer", pointer);
    Pointer movedPointer = context.eval("js", "pointer.move(1, 1)").as(Pointer.class);
    System.out.println(movedPointer);
  }

  public static class Pointer {
    private final int x;
    private final int y;

    Pointer(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Export
    public int getX() {
      return x;
    }

    @Export
    public int getY() {
      return y;
    }

    @Export
    public Pointer move(int deltaX, int deltaY) {
      return new Pointer(x + deltaX, y + deltaY);
    }

    @Override
    public String toString() {
      return String.format("[%d, %d]", x, y);
    }
  }
}
