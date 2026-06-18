#include <iostream>
#include <stdexcept>

struct Vector
{
    int* arr = nullptr;
    size_t count = 0;
    size_t buffer = 0;

    void expand()
    {
        size_t newBuffer;

        if (buffer == 0)
        {
            newBuffer = 2;
        }
        else
        {
            newBuffer = buffer * 2;
        }

        int* temp = new int[newBuffer];

        for (size_t i = 0; i < count; i++)
        {
            temp[i] = arr[i];
        }

        delete[] arr;
        arr = temp;
        buffer = newBuffer;
    }

    void push_back(int value)
    {
        if (count >= buffer)
        {
            expand();
        }

        arr[count] = value;
        count++;
    }

    void insert(size_t position, int value)
    {
        if (position > count)
        {
            throw std::out_of_range("Invalid index");
        }

        if (count >= buffer)
        {
            expand();
        }

        for (size_t i = count; i > position; i--)
        {
            arr[i] = arr[i - 1];
        }

        arr[position] = value;
        count++;
    }

    void erase(size_t position)
    {
        if (position >= count)
        {
            throw std::out_of_range("Invalid index");
        }

        for (size_t i = position; i < count - 1; i++)
        {
            arr[i] = arr[i + 1];
        }

        count--;
    }

    int get(size_t position)
    {
        if (position >= count)
        {
            throw std::out_of_range("Invalid index");
        }

        return arr[position];
    }

    size_t size()
    {
        return count;
    }

    size_t capacity()
    {
        return buffer;
    }
};

void showMenu()
{
    std::cout << "\n===== VECTOR MENU =====\n";
    std::cout << "1. Add element to end\n";
    std::cout << "2. Insert element by index\n";
    std::cout << "3. Delete element by index\n";
    std::cout << "4. Get element by index\n";
    std::cout << "5. Show number of elements\n";
    std::cout << "6. Show buffer size\n";
    std::cout << "7. Show vector\n";
    std::cout << "0. Exit\n";
    std::cout << "Choice: ";
}

int main()
{
    Vector vec;

    int choice;

    do
    {
        showMenu();
        std::cin >> choice;

        try
        {
            switch (choice)
            {
                case 1:
                {
                    int value;

                    std::cout << "Value: ";
                    std::cin >> value;

                    vec.push_back(value);
                    break;
                }

                case 2:
                {
                    size_t index;
                    int value;

                    std::cout << "Index: ";
                    std::cin >> index;

                    std::cout << "Value: ";
                    std::cin >> value;

                    vec.insert(index, value);
                    break;
                }

                case 3:
                {
                    size_t index;

                    std::cout << "Index: ";
                    std::cin >> index;

                    vec.erase(index);
                    break;
                }

                case 4:
                {
                    size_t index;

                    std::cout << "Index: ";
                    std::cin >> index;

                    std::cout << "Element: "
                              << vec.get(index)
                              << std::endl;

                    break;
                }

                case 5:
                {
                    std::cout << "Elements: "
                              << vec.size()
                              << std::endl;

                    break;
                }

                case 6:
                {
                    std::cout << "Buffer: "
                              << vec.capacity()
                              << std::endl;

                    break;
                }

                case 7:
                {
                    std::cout << "Vector: ";

                    for (size_t i = 0; i < vec.size(); i++)
                    {
                        std::cout << vec.get(i) << " ";
                    }

                    std::cout << std::endl;
                    break;
                }

                case 0:
                    break;

                default:
                    std::cout << "Wrong choice\n";
            }
        }
        catch (const std::exception& error)
        {
            std::cout << error.what() << std::endl;
        }

    } while (choice != 0);

    delete[] vec.arr;

    return 0;
}