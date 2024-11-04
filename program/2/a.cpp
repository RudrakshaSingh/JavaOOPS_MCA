#include <iostream>
using namespace std;

double calculateSimpleInterest(double principal, double time, double rate = 5.0) {
    return (principal * rate * time) / 100.0;
}

int main() {
    double principal, time, rate;

    cout << "Enter the principal amount: ";
    cin >> principal;
    cout << "Enter the time (in years): ";
    cin >> time;

    char choice;
    cout << "Do you want to enter a rate of interest? (y/n): ";
    cin >> choice;

    if (choice == 'y' || choice == 'Y') {
        cout << "Enter the rate of interest: ";
        cin >> rate;
        double simpleInterest = calculateSimpleInterest(principal, time, rate);
        cout << "The Simple Interest with rate of "<<rate<<"% is: " << simpleInterest << endl;
    } else {
        double simpleInterest = calculateSimpleInterest(principal, time);
        cout << "The Simple Interest with default rate of 5% is: " << simpleInterest << endl;
    }

    return 0;
}
