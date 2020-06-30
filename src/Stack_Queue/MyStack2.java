package Stack_Queue;

import java.util.Stack;

public class MyStack2 {
  private Stack<Integer> stackData;
  private Stack<Integer> stackMin;

  public MyStack2() {
    this.stackData = new Stack<Integer>();
    this.stackMin = new Stack<Integer>();
  }

  public void push(int newNum) {
    if (this.stackMin.isEmpty()) {
      this.stackMin.push(newNum);
    } else if (newNum <= this.getMin()) {
      this.stackMin.push(newNum);
    } else {
      // 如果不用更新最小值，则重复推入原来的最小值
      int newMin = this.stackMin.peek();
      this.stackMin.push(newMin);
    }
    this.stackData.push(newNum);
  }

  public int pop() {
    if (this.stackData.isEmpty()) {
      throw new RuntimeException("Your stack is empty");
    }
    // int value = this.stackData.pop();
    // if (value == this.getMin()) {
    // this.stackMin.pop();
    // }
    this.stackMin.pop();// 因为推入数据时做了冗余同步，所以此处只需简单的pop即可
    return this.stackData.pop();
  }

  public int getMin() {
    if (this.stackMin.isEmpty()) {
      throw new RuntimeException("Your stack is empty");
    }
    return this.stackMin.peek();
  }
}