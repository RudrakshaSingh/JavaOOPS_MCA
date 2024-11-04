#include <iostream>
using namespace std;
class Triangle {
private:
    double base;
    double height;
public:
    Triangle() {
        base = 1.0;
        height = 1.0;
        cout << "No-argument constructor called. Default Base: " << base << ", Default Height: " << height << endl;
    }
    Triangle(double side) {
        base = side;
        height = side;
        cout << "One-argument constructor called. Base: " << base << ", Height: " << height << endl;
    }
    Triangle(double b, double h) {
        base = b;
        height = h;
        cout << "Two-argument constructor called. Base: " << base << ", Height: " << height << endl;
    }
    Triangle(const Triangle &tri) {
        base = tri.base;
        height = tri.height;
        cout << "Copy constructor called. Base: " << base << ", Height: " << height << endl;
    }
    double area() {
        return 0.5 * base * height;
    }
};
int main() {
    Triangle tri1;// No-argument constructor
    Triangle tri2(5.0);// One-argument constructor
    Triangle tri3(4.0, 6.0);// Two-argument constructor
    Triangle tri4(tri3);// Copy constructor
    cout << "Area of tri1: " << tri1.area() << endl;
    cout << "Area of tri2: " << tri2.area() << endl;
    cout << "Area of tri3: " << tri3.area() << endl;
    cout << "Area of tri4 (copy of tri3): " << tri4.area() << endl;
    return 0;
}
