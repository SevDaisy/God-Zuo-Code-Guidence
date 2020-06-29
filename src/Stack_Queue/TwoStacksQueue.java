package Stack_Queue;

import java.util.Stack;

public class TwoStacksQueue {
  private Stack<Integer> stackPush;
  private Stack<Integer> stackPop;

  public TwoStacksQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
    this.stackPush = stackPush;
    this.stackPop = stackPop;
  }

  private void pushToPop() {
    // 当且仅当stackPop为空时，才能接受导入
    if (stackPop.empty()) {
      // 一次导入必须要导入全部
      while (!stackPush.empty()) {
        stackPop.push(stackPush.pop());
      }
    }
  }

  public void add(int pushInt) {
    stackPush.push(pushInt);
    this.pushToPop();
  }

  public int poll() {
    if (stackPop.empty() && stackPush.empty()) {
      throw new RuntimeException("Your Stack is Empty");
    }
    this.pushToPop();
    return stackPop.pop();
  }

  public int peek() {
    if (stackPop.empty() && stackPush.empty()) {
      throw new RuntimeException("Queue is Empty!");
    }
    this.pushToPop();
    return stackPop.peek();
  }
}