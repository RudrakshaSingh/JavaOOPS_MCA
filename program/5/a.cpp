#include <iostream>
using namespace std;
class Student {
public:
    virtual void inputMarks(){
        cout << "Input is not provided yet." << endl;
    };
    virtual void displayTotalMarks(){
        cout << "Marks is not given yet." << endl;
    };
};
class TotalMarks : public Student {
protected:
    int marks1, marks2, marks3;
public:
    void inputMarks()  {
        marks1 = 85;
        marks2 = 90;
        marks3 = 78;
        cout << "Marks have been set automatically." << endl;
    }
    void displayTotalMarks()  {
        int total = marks1 + marks2 + marks3;
        cout << "Total Marks: " << total << endl;
    }
};
int main() {
    Student* student;   //  or // Student* student = new TotalMarks(); 
    TotalMarks t;
    student = &t;
    
    student->inputMarks();
    student->displayTotalMarks();
    return 0;
}