package Tools;

import java.util.Stack;

public class Tool {

  // 获取并移除栈底元素（递归实现）
  public static int getAndRemoveLastElement(Stack<Integer> stack) {
    int result = stack.pop();
    if (stack.empty()) {
      return result;
    } else {
      int last = getAndRemoveLastElement(stack);
      stack.push(result);
      return last;
    }
  }

  // 逆序一个栈
  public static void reverse(Stack<Integer> stack) {
    if (stack.empty()) {
      return;
    }
    int i = getAndRemoveLastElement(stack);
    reverse(stack);
    stack.push(i);
  }

}