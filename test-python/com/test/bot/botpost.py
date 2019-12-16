import requests
import json


def get_translate_data(word=None):
    url = 'http://fanyi.youdao.com/translate_o?smartresult=dict&smartresult=rule'
    form_data = {'i': word, 'from': 'zh-CHS', 'to': 'en', 'smartresult': 'dict', 'client': 'fanyideskweb',
                 'salt': '15712202013210', 'sign': 'd6a68f3606f89eaee456fa3726a4d23c', 'ts': '1571220201321',
                 'bv': 'ca3dedaa9d15daa003dbdaaa991540d1', 'doctype': 'json', 'version': '2.1', 'keyfrom': 'fanyi.web',
                 'action': 'FY_BY_CLICKBUTTION'}
    # 请求表单数据
    response = requests.post(url, data=form_data)
    # 将Json格式字符串转字典
    content = json.loads(response.text)
    print(content)
    # 打印翻译后的数据
    # print(content['translateResult'][0][0]['tgt'])


if __name__ == '__main__':
    get_translate_data('大兄弟')
