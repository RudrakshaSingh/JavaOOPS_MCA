#include <iostream>
using namespace std;
void callByValue(int x, int y) {
    int temp = x;
    x = y;
    y = temp;
    cout << "After swapping in callByValue: x = " << x << ", y = " << y << endl;
}
void callByReference(int &x, int &y) {
    int temp = x;
    x = y;
    y = temp;
    cout << "After swapping in callByReference: x = " << x << ", y = " << y << endl;
}
int main() {
    int a, b;
    cout << "Enter value for a: ";
    cin >> a;
    cout << "Enter value for b: ";
    cin >> b;

    cout << "CALL BY VALUE:" << endl;
    cout << "Original values: a = " << a << ", b = " << b << endl;
    callByValue(a, b);
    cout << "Values outside scope of function in callByValue: a = " << a << ", b = " << b << endl;

    cout << "\nCALL BY REFERENCE:" << endl;
    cout << "Original values: a = " << a << ", b = " << b << endl;
    callByReference(a, b);
    cout << "Values outside scope of function in callByReference: a = " << a << ", b = " << b << endl;
    return 0;
}
