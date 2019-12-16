import json


class Price:
    name = str
    price = float

    def __init__(self, d):
        self.__dict__ = d

    def __str__(self):
        return '名称：{}  价格：%'.format(self.name, self.price)


class Person:
    name = str
    shares = int
    price = Price

    def __init__(self, d):
        self.__dict__ = d


if __name__ == '__main__':
    data = {'name': 'ACME', 'shares': 100, 'price': {'name': 'ACME', 'price': 100.89}}
    json_str = json.dumps(data)
    result = json.loads(json_str, object_hook=Person)
    print(type(result))
    print(result.name)
    print(result.shares)
    print(result.price.price)

    price = Price
    price.name = 'test'
    price.price = 12.9
    print(price)
