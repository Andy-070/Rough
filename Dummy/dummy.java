//import packex.neweg;

interface Soundmake{
  
  public String getSound();
  final int price = 10;
  
  public static void main(String[] args){
    Animal a = new Animal("Human",10);
    System.out.println(a.getSound());
    
    Animal d = new Dog("Badal",108, true);
    System.out.println(d.getSound());
    
    Animal c = new Cat("Meow",10, true);
    System.out.println(c.getSound());
  }
}

class Animal implements Soundmake {
  String name;
  int age;
  
  Animal(String name, int age){
    this.name = name;
    this.age = age;
  }
  
  public String getSound(){
    return "Animal Sound";
  }
}

class Dog extends Animal implements Soundmake{
  boolean isHunterDog;
  
  Dog(String name, int age, boolean isHunterDog){
    super(name, age);
    this.isHunterDog = isHunterDog;
  } 
  
   public String getSound(){
    return "Bark";
  }
}

class Cat extends Animal implements Soundmake{
  boolean isWildCat;
  
  Cat(String name, int age, boolean isWildCat){
    super(name, age);
    this.isWildCat = isWildCat;
  }
  
  public String getSound(){
    return "Meoww";
  }
}





/*abstract class Animal {
    abstract void makeSound(); 
    void eat() { System.out.println("Eating food."); }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark!");
    }
}

class AbstractExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
        dog.eat();
    }
}*/




/*class InnerClassExample {

  static class Outer {
   static void display1() { System.out.println("Inside Inner Class."); }
    static class Inner{
         void display() { System.out.println("Inside Inner Class."); }
        }
    }


    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();
        obj.display();
    }
}*/




 /* class w {
    int c =30;
  }
  
class q{
  
  static int a = 10;
  int b = 20;
  public static void main(String[] args){
      q q1 = new q();
      w w1 = new w();
      System.out.println(q1.a);
      System.out.println(q1.b);
      System.out.println(w1.c);
  }
}*/




/*abstract class Greeting {
    abstract void sayHello();
}

class AnonymousClassExample {
    public static int age;
    public static void main(String[] args) {
        //neweg n = new neweg();
        //n.getAge();
        Greeting obj = new Greeting() {
            void sayHello() { System.out.println("Hello from Anonymous Class!"); }
        };
        obj.sayHello();
    }
}*/





