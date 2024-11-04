#include <iostream>
using namespace std;

class Animal {
public:
    void eat() {
        cout << "Animal is eating." << endl;
    }
};

class Mammal : public Animal {
public:
    void walk() {
        cout << "Mammal is walking." << endl;
    }
};

class Dog : public Mammal {
public:
    void bark() {
        cout << "Dog is barking." << endl;
    }
};

int main() {
    Dog dogObj;

    dogObj.eat();  // Inherited from Animal
    dogObj.walk(); // Inherited from Mammal
    dogObj.bark(); // Defined in Dog

    return 0;
}
