#include <iostream>
#include <stdexcept>

struct ArrayList
{
    int** blocks = nullptr;

    size_t elements = 0;
    size_t blockCount = 0;

    static const size_t BLOCK_SIZE = 5;

    void increaseBuffer()
    {
        size_t newCount;

        if (blockCount == 0)
        {
            newCount = 1;
        }
        else
        {
            newCount = blockCount * 2;
        }

        int** temp = new int*[newCount];

        for (size_t i = 0; i < blockCount; i++)
        {
            temp[i] = blocks[i];
        }

        for (size_t i = blockCount; i < newCount; i++)
        {
            temp[i] = nullptr;
        }

        delete[] blocks;
        blocks = temp;

        blockCount = newCount;
    }

    void ensureSpace()
    {
        if (elements < blockCount * BLOCK_SIZE)
        {
            return;
        }

        size_t oldCount = blockCount;

        increaseBuffer();

        for (size_t i = oldCount; i < blockCount; i++)
        {
            blocks[i] = new int[BLOCK_SIZE];
        }
    }

    void setValue(size_t index, int value)
    {
        size_t row = index / BLOCK_SIZE;
        size_t col = index % BLOCK_SIZE;

        blocks[row][col] = value;
    }

    int getValue(size_t index)
    {
        size_t row = index / BLOCK_SIZE;
        size_t col = index % BLOCK_SIZE;

        return blocks[row][col];
    }

    void pushBack(int value)
    {
        ensureSpace();

        setValue(elements, value);
        elements++;
    }

    void insert(size_t index, int value)
    {
        if (index > elements)
        {
            throw std::out_of_range("Invalid index");
        }

        ensureSpace();

        for (size_t i = elements; i > index; i--)
        {
            setValue(i, getValue(i - 1));
        }

        setValue(index, value);
        elements++;
    }

    void erase(size_t index)
    {
        if (index >= elements)
        {
            throw std::out_of_range("Invalid index");
        }

        for (size_t i = index; i < elements - 1; i++)
        {
            setValue(i, getValue(i + 1));
        }

        elements--;
    }

    int at(size_t index)
    {
        if (index >= elements)
        {
            throw std::out_of_range("Invalid index");
        }

        return getValue(index);
    }

    size_t size()
    {
        return elements;
    }

    size_t capacity()
    {
        return blockCount * BLOCK_SIZE;
    }
};

void printMenu()
{
    std::cout << "\n===== ARRAY LIST =====\n";
    std::cout << "1. Add element to end\n";
    std::cout << "2. Insert element by index\n";
    std::cout << "3. Delete element by index\n";
    std::cout << "4. Get element by index\n";
    std::cout << "5. Show amount of elements\n";
    std::cout << "6. Show buffer size\n";
    std::cout << "7. Show all elements\n";
    std::cout << "0. Exit\n";
    std::cout << "Choice: ";
}

int main()
{
    ArrayList list;

    int choice;

    do
    {
        printMenu();
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

                    list.pushBack(value);
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

                    list.insert(index, value);
                    break;
                }

                case 3:
                {
                    size_t index;

                    std::cout << "Index: ";
                    std::cin >> index;

                    list.erase(index);
                    break;
                }

                case 4:
                {
                    size_t index;

                    std::cout << "Index: ";
                    std::cin >> index;

                    std::cout << "Element: "
                              << list.at(index)
                              << std::endl;

                    break;
                }

                case 5:
                {
                    std::cout << "Elements: "
                              << list.size()
                              << std::endl;

                    break;
                }

                case 6:
                {
                    std::cout << "Buffer: "
                              << list.capacity()
                              << std::endl;

                    break;
                }

                case 7:
                {
                    std::cout << "Data: ";

                    for (size_t i = 0; i < list.size(); i++)
                    {
                        std::cout << list.at(i) << " ";
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

    for (size_t i = 0; i < list.blockCount; i++)
    {
        delete[] list.blocks[i];
    }

    delete[] list.blocks;

    return 0;
}