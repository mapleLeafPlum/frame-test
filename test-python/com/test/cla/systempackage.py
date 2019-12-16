import logging
import json
import pickle
import random
if __name__ == '__main__':
    logger = logging.getLogger()
    myName = "cadfdf"
    print(myName)
    logger.info('fucking')
    logging.info("fkdsjfkdfj")

    print(123132)
    dic = {"name": "caoxu"}
    str_dic = json.dumps(dic)
    print(type(str_dic))
    print(str_dic)

    dic2 = json.loads(str_dic)
    print(type(dic2))
    print(dic2)

    str_dic = pickle.dumps(dic2)
    print(type(str_dic))
    print(str_dic)

    dic2 = pickle.loads(str_dic)
    print(type(dic2))
    print(dic2)
    # random
    print(random.random())
    # 1-5的小数
    print(random.uniform(1, 5))
    # 1-5的整数
    print(random.randint(1, 5))
    # 1-10的奇数
    print(random.randrange(1, 10, 2))
    # 3-10的奇数
    print(random.randrange(3, 10, 2))
    # 2-10的偶数 第一个参数是偶数就是偶数 是奇数就是奇数
    print(random.randrange(2, 10, 2))

    lst = ['张开', '宝元', '佩奇', '太白']
    # 随机抽一个人出来
    print(random.choice(lst))
    # 随机抽出两个来　　
    print(random.choices(lst, k=3))
    # 随机排序的
    random.shuffle(lst)
    print(lst)
