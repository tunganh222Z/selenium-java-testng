package javaTester.javaOOP;

// Abstract class
public abstract class AbstractAnimal {

    //Variable
    String animalName = "Dog";

    // Method
    // Không có phần thân body {}
    // vẫn có thể kết hợp với public protected
    // bắt buộc các class con phải override các hàm này lại
    protected abstract void setAnimalName();
}
