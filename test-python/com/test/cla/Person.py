


class Person:
    name = ''
    age = 0
    def __init__(self,name,age):
        self.name=name;
        self.age=age;


    def getAge(self):
        return self.age;

    def getName(self):
        return self.name;

if __name__ == '__main__':
    person = Person('nma', 1000)
    print(person.getName())
    print(person.getAge())
    print("abc")
