package Stack_Queue;

import java.util.Stack;

public class MyStack1 {
  private Stack<Integer> stackData;
  private Stack<Integer> stackMin;

  public MyStack1() {
    this.stackData = new Stack<Integer>();
    this.stackMin = new Stack<Integer>();
  }

  public void push(int newNum) {
    if (this.stackMin.isEmpty()) {
      // 若 当前最小值栈为空
      this.stackMin.push(newNum);
    } else if (newNum <= this.getMin()) {
      // 若 当前值不比最小值大 !!!千万注意小于等于，而不是小于
      this.stackMin.push(newNum);
    }
    this.stackData.push(newNum);
  }

  public int pop() {
    if (this.stackData.isEmpty()) {
      throw new RuntimeException("Your stack is empty");
    }
    int value = this.stackData.pop();
    if (value == this.getMin()) {
      // 若 最小值被pop了，那么最小值栈也pop更新
      this.stackMin.pop();
    }
    return value;
  }

  public int getMin() {
    if (this.stackMin.isEmpty()) {
      throw new RuntimeException("Your stack is empty");
    }
    return this.stackMin.peek();
  }
}