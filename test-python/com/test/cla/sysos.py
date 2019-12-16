import os
import sys
import hashlib
import collections

if __name__ == '__main__':
    # os.mkdir("D:\downloads333")
    # os.listdir("D:\download")
    print("os--------------------------------")
    print(os.pathsep)
    print(os.name)
    print(os.sep)
    print(os.linesep)

    print(os.environ)
    # sys
    print("sys--------------------------------")
    print(sys.path)
    print(sys.platform)
    print(sys.version)
    print(sys.argv)
    print("hashlib--------------------------------")

    md5 = hashlib.md5()
    md5.update('how to use sha1 in'.encode('utf-8'))
    md5.update('python hashlib?'.encode('utf-8'))
    print(md5.hexdigest())

    sha1 = hashlib.sha1()
    sha1.update('how to use sha1 in'.encode('utf-8'))
    sha1.update('python hashlib?'.encode('utf-8'))
    print(sha1.hexdigest())

    sha256 = hashlib.sha256()
    sha256.update('how to use sha1 in'.encode('utf-8'))
    sha256.update('python hashlib?'.encode('utf-8'))
    print(sha256.hexdigest())

    print("collections--------------------------------")
