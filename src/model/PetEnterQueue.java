package model;

public class PetEnterQueue {
  private Pet pet;// 无需继承，创建父类对象即可！！
  private long count;

  public PetEnterQueue(Pet pet, long count) {
    this.pet = pet;
    this.count = count;
  }

  public Pet getPet() {
    return pet;
  }

  public long getCount() {
    return count;
  }

  // 毕竟不是继承，需要手动提供父类中某方法的“映像”
  public String getEnterPetType() {
    return this.pet.getPetType();
  }

}