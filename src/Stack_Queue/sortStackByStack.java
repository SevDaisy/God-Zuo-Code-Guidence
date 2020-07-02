package Stack_Queue;

import java.util.Stack;

public class sortStackByStack {
  public static void sortStackByStack(Stack<Integer> stack) {
    Stack<Integer> help = new Stack<Integer>();
    /*
     * 第 1 个循环 target：原栈中的元素从小到大放在辅栈中，即 辅栈一直pop的话得到的值会越来越大。
     */
    while (!stack.isEmpty()) {
      // 遍历 原栈的所有元素
      int cur = stack.pop();
      while (!help.isEmpty() && help.peek() < cur) {
        // 如果 辅栈非空
        // 同时 辅栈元素 小于 原栈元素
        // 那么 辅栈元素 逐个 导回原栈
        // 直至 不满足上述条件
        stack.push(help.pop());
      }
      // 如果 辅栈空了
      // 或者 辅栈元素 不小于 原栈元素
      // 原栈元素 入 辅栈
      help.push(cur);
    }
    while (!help.empty()) {
      stack.push(help.pop());
    }
  }
}