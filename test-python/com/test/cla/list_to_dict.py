
if __name__ == '__main__':
    i = ['a', 'b']
    l = [1, 2]
    print(dict([i, l]))

    print("--------------------------------")
    fp = open('D:\\test\\test1.txt')
    a = fp.read()
    fp.close()
    print(a)
    print("--------------------------------")
    fp1 = open('D:\\test\\test2.txt')
    b = fp1.read()
    fp1.close()
    print(b)
    print("--------------------------------")
    fp2 = open('D:\\test\\test4.txt', 'a')
    combine = list(a + b)
    # combine.sort()
    print(combine)
    s = ''
    s = s.join(combine)
    print(s)
    fp2.write("----------------------------------------")
    fp2.write(s)
    fp2.flush()
    fp2.close()

