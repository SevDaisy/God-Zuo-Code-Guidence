package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

import Model.Cat;
import Model.Dog;
import Model.Pet;
import Model.PetEnterQueue;

public class DogCatQueue {
  private Queue<PetEnterQueue> dogQ;
  private Queue<PetEnterQueue> catQ;
  private long count;

  public DogCatQueue() {
    this.dogQ = new LinkedList<PetEnterQueue>();
    this.catQ = new LinkedList<PetEnterQueue>();
    this.count = 0;
  }

  public void add(Pet pet) {
    // if-else 处理 各回各家
    // 特殊的：type::getPetType 可以用 .class() 代替
    // 左神之所以选择这种写法，应该是为了削弱Java的语言特性
    if (pet.getPetType().equals("dog")) {
      this.dogQ.add(new PetEnterQueue(pet, this.count++));
    } else if (pet.getPetType().equals("cat")) {
      this.catQ.add(new PetEnterQueue(pet, this.count++));
    } else {
      throw new RuntimeException("err, not dog or cat");
    }
  }

  public Pet pollAll() {
    // if-else 分流
    // 都非空 则按 时间戳 处理
    // 否则 谁不空 输出谁
    if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
      if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
        return this.dogQ.poll().getPet();
      } else {
        return this.catQ.poll().getPet();
      }
    } else if (!this.dogQ.isEmpty()) {
      return this.dogQ.poll().getPet();
    } else if (!this.catQ.isEmpty()) {
      return this.catQ.poll().getPet();
    } else {
      throw new RuntimeException("err, queue is empty!");
    }
  }

  public Dog pollDog() {
    if (!this.isDogQueueEmpty()) {
      return (Dog) this.dogQ.poll().getPet();
    } else {
      throw new RuntimeException("Dog queue is empty!");
    }
  }

  public Cat pollCat() {
    if (!this.isCatQueueEmpty()) {
      return (Cat) this.catQ.poll().getPet();
    } else
      throw new RuntimeException("Cat queue is empty!");
  }

  public boolean isEmpty() {
    return this.dogQ.isEmpty() && this.catQ.isEmpty();
  }

  public boolean isDogQueueEmpty() {
    return this.dogQ.isEmpty();
  }

  public boolean isCatQueueEmpty() {
    return this.catQ.isEmpty();
  }
}