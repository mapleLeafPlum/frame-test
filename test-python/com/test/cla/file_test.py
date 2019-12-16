import os

if __name__ == '__main__':
    os.mkdir('D:\env\config.txt')



    os.mkdir('D:\env\config.txt')


    file = open('D:\env\config.txt', encoding='utf-8')
    print(file.readline())
    print("---------------------------")
    line = file.read()
    print(line)

    file.close()

    file = open('D:\env\config.txt', encoding='utf-8')
    print(file.readline())
    print("---------------------------")
    line = file.read()
    print(line)

    file.close()
