import numpy as np
from numpy import *
import matplotlib.pyplot as plt


def draws():
    dataSet = [[-0.017, 14.053], [-1.39, 4.66], [-0.75, 6.53]]
    dataMat = np.mat(dataSet).T

    plt.scatter(dataMat[0].tolist(), dataMat[1].tolist())
    X = np.linspace(-2, 2, 100)
    Y = 2.8 * X + 10
    plt.plot(X, Y)
    plt.show()


def getparam(arg, *args, **kwargs):
    print(arg, args, kwargs)


if __name__ == '__main__':
    getparam(6, 7, 8, 9, a=1, b=2, c=3)
