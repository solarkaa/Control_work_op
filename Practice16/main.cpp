#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

void printArray(float*** arr, int size)
{
    for (int i = 0; i < size; i++) {
        cout << "Block " << i + 1 << ":" << endl;

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                cout << arr[i][j][k] << " ";
            }

            cout << endl;
        }

        cout << endl;
    }
}

int main()
{
    srand(time(0));

    cout << "Завдання 1" << endl;

    char* charValue = new char;
    short* shortValue = new short;
    int* intValue = new int;
    long* longValue = new long;
    float* floatValue = new float;
    double* doubleValue = new double;

    cout << "Введіть char: ";
    cin >> *charValue;

    cout << "Введіть short: ";
    cin >> *shortValue;

    cout << "Введіть int: ";
    cin >> *intValue;

    cout << "Введіть long: ";
    cin >> *longValue;

    cout << "Введіть float: ";
    cin >> *floatValue;

    cout << "Введіть double: ";
    cin >> *doubleValue;

    cout << "char: " << *charValue << endl;
    cout << "short: " << *shortValue << endl;
    cout << "int: " << *intValue << endl;
    cout << "long: " << *longValue << endl;
    cout << "float: " << *floatValue << endl;
    cout << "double: " << *doubleValue << endl;

    delete charValue;
    delete shortValue;
    delete intValue;
    delete longValue;
    delete floatValue;
    delete doubleValue;

    cout << endl;

    cout << "Завдання 2" << endl;

    double* pointerValue = new double;

    cout << "Введіть число double: ";
    cin >> *pointerValue;

    double& linkValue = *pointerValue;

    cout << "Значення через посилання: " << linkValue << endl;

    delete pointerValue;

    cout << endl;

    cout << "Завдання 3" << endl;

    int size;

    cout << "Введіть розмір масиву: ";
    cin >> size;

    int* numbers = new int[size];

    for (int i = 0; i < size; i++) {
        numbers[i] = size - 1 - i;
    }

    cout << "Масив: ";

    for (int i = 0; i < size; i++) {
        cout << numbers[i] << " ";
    }

    cout << endl;

    delete[] numbers;

    cout << endl;

    cout << "Завдання 4" << endl;

    int cubeSize;

    cout << "Введіть розмір тривимірного масиву: ";
    cin >> cubeSize;

    float*** cube = new float**[cubeSize];

    for (int i = 0; i < cubeSize; i++) {
        cube[i] = new float*[cubeSize];

        for (int j = 0; j < cubeSize; j++) {
            cube[i][j] = new float[cubeSize];
        }
    }

    for (int i = 0; i < cubeSize; i++) {
        for (int j = 0; j < cubeSize; j++) {
            for (int k = 0; k < cubeSize; k++) {
                cube[i][j][k] = rand() % 100;
            }
        }
    }

    printArray(cube, cubeSize);

    for (int i = 0; i < cubeSize; i++) {
        for (int j = 0; j < cubeSize; j++) {
            delete[] cube[i][j];
        }

        delete[] cube[i];
    }

    delete[] cube;

    return 0;
}