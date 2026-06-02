// Завдання 1

// #include <iostream>
// #include <ctime>
// #include <cstdlib>

// int main()
// {
//     srand(time(0));

//     int numbers[10];

//     for (int index = 0; index < 10; index++) {
//         numbers[index] = rand() % 100;
//     }

//     std::cout << "Ваш массив: ";

//     for (int index = 0; index < 10; index++) {
//         std::cout << numbers[index] << " ";
//     }

//     return 0;
// }


// Завдання 2

// #include <iostream>

// int main()
// {
//     int count = 0;

//     std::cout << "Введите количество углов: " << std::endl;
//     std::cin >> count;

//     int angles[20];
//     int total = 0;

//     std::cout << "Введите значения углов: " << std::endl;

//     for (int index = 0; index < count; index++) {
//         std::cin >> angles[index];
//         total += angles[index];
//     }

//     std::cout << "Сумма углов = " << total << std::endl;

//     if (total == 180 * (count - 2)) {
//         std::cout << "Такой многоугольник может существовать" << std::endl;
//     }
//     else {
//         std::cout << "Такой многоугольник не может существовать" << std::endl;
//     }

//     return 0;
// }


// Завдання 3

// #include <iostream>
// #include <ctime>
// #include <cstdlib>

// int main()
// {
//     std::cout << "Введите размер массива: " << std::endl;

//     int length = 0;
//     std::cin >> length;

//     int values[100];

//     srand(time(0));

//     for (int index = 0; index < length; index++) {
//         values[index] = rand() % 100;
//     }

//     std::cout << "Массив: ";

//     for (int index = 0; index < length; index++) {
//         std::cout << values[index] << " ";
//     }

//     std::cout << std::endl;

//     std::cout << "Введите номер элемента массива, который нужно изменить: " << std::endl;

//     int position = 0;
//     std::cin >> position;

//     std::cout << "Введите новое значение: " << std::endl;

//     int newValue = 0;
//     std::cin >> newValue;

//     values[position] = newValue;

//     std::cout << "Изменённый массив: ";

//     for (int index = 0; index < length; index++) {
//         std::cout << values[index] << " ";
//     }

//     return 0;
// }


// Завдання 4

// Pass


// Завдання 5

// #include <iostream>
// #include <ctime>
// #include <cstdlib>

// int main()
// {
//     int data[100];

//     std::cout << "Введите размер массива: " << std::endl;

//     int length = 0;
//     std::cin >> length;

//     srand(time(0));

//     for (int index = 0; index < length; index++) {
//         data[index] = rand() % 100;
//     }

//     std::cout << "Массив: ";

//     for (int index = 0; index < length; index++) {
//         std::cout << data[index] << " ";
//     }

//     std::cout << "\nВыберите порядок проверки массива (1 - по возрастанию, 2 - по убыванию)" << std::endl;

//     int selectedOption = 0;
//     std::cin >> selectedOption;

//     bool isSorted = true;

//     if (selectedOption == 1) {
//         for (int index = 0; index < length - 1; index++) {
//             if (data[index] > data[index + 1]) {
//                 isSorted = false;
//                 break;
//             }
//         }

//         if (isSorted) {
//             std::cout << "Массив расположен по возрастанию" << std::endl;
//         }
//         else {
//             std::cout << "Массив не расположен по возрастанию" << std::endl;
//         }
//     }
//     else if (selectedOption == 2) {
//         for (int index = 0; index < length - 1; index++) {
//             if (data[index] < data[index + 1]) {
//                 isSorted = false;
//                 break;
//             }
//         }

//         if (isSorted) {
//             std::cout << "Массив расположен по убыванию" << std::endl;
//         }
//         else {
//             std::cout << "Массив не расположен по убыванию" << std::endl;
//         }
//     }
//     else {
//         std::cerr << "Ошибка" << std::endl;
//     }

//     return 0;
// }