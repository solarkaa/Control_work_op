#include <iostream>
#include <cmath>
#include <ctime>
#include <cstdlib>

using namespace std;

struct Point {
    double x;
    double y;
};

double distanceBetweenPoints(Point a, Point b)
{
    double dx = b.x - a.x;
    double dy = b.y - a.y;

    return sqrt(dx * dx + dy * dy);
}

double calculateArea(Point* points, int size)
{
    if (size != 4) {
        return 0;
    }

    double sideA = distanceBetweenPoints(points[0], points[1]);
    double sideB = distanceBetweenPoints(points[1], points[2]);

    return sideA * sideB;
}

bool checkRectangle(Point* points, int size)
{
    if (size != 4) {
        return false;
    }

    double side1 = distanceBetweenPoints(points[0], points[1]);
    double side2 = distanceBetweenPoints(points[1], points[2]);
    double side3 = distanceBetweenPoints(points[2], points[3]);
    double side4 = distanceBetweenPoints(points[3], points[0]);

    double diagonal1 = distanceBetweenPoints(points[0], points[2]);
    double diagonal2 = distanceBetweenPoints(points[1], points[3]);

    if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0) {
        return false;
    }

    if (side1 == side3 && side2 == side4 && diagonal1 == diagonal2) {
        return true;
    }

    return false;
}

int main()
{
    srand(time(0));

    int size = 4;
    Point* rectangle = new Point[size];

    int choice;

    cout << "Выберите способ заполнения координат:" << endl;
    cout << "1 - Ввести вручную" << endl;
    cout << "2 - Сгенерировать автоматически" << endl;
    cout << "Ваш выбор: ";
    cin >> choice;

    if (choice == 1) {
        for (int i = 0; i < size; i++) {
            cout << "Введите x для точки " << i + 1 << ": ";
            cin >> rectangle[i].x;

            cout << "Введите y для точки " << i + 1 << ": ";
            cin >> rectangle[i].y;
        }
    }
    else if (choice == 2) {
        double x1 = rand() % 10;
        double y1 = rand() % 10;

        double width = 1 + rand() % 10;
        double height = 1 + rand() % 10;

        rectangle[0].x = x1;
        rectangle[0].y = y1;

        rectangle[1].x = x1 + width;
        rectangle[1].y = y1;

        rectangle[2].x = x1 + width;
        rectangle[2].y = y1 + height;

        rectangle[3].x = x1;
        rectangle[3].y = y1 + height;
    }
    else {
        cout << "Ошибка выбора" << endl;
        delete[] rectangle;
        return 0;
    }

    cout << endl;
    cout << "Координаты прямоугольника:" << endl;

    for (int i = 0; i < size; i++) {
        cout << "Точка " << i + 1 << ": ";
        cout << "(" << rectangle[i].x << ", " << rectangle[i].y << ")" << endl;
    }

    if (checkRectangle(rectangle, size)) {
        double area = calculateArea(rectangle, size);
        cout << "Площадь прямоугольника = " << area << endl;
    }
    else {
        cout << "Введённые точки не образуют корректный прямоугольник" << endl;
    }

    delete[] rectangle;

    return 0;
}