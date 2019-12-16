from com.test.cla.Person import Person


if __name__ == '__main__':

    print(Person.__dict__)
    print(Person.__name__)
    print(Person.__bases__)
    print(Person.__doc__)
    # print(Person.__annotations__)
    print(Person.__hash__)
    try:
        print(1)
    except Exception:
        raise Exception
    finally:
        print(2)
    person = Person('name', 3)
    print(person.age)
    del person.age
    print(person.name)
    person.age = 100
    print(person.age)
    print("over")

    tryvales = 0
    try:
        tryvales=20
    except Exception:
        raise Exception
    else:
        tryvales=40

