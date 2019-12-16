import requests
import bs4
import re

if __name__ == '__main__':
    url = 'http://www.cntour.cn/'
    str_html = requests.get(url)
    # print(str_html.text)
    # lxml lxml-xml  html.parser html5lib
    # "html", "html5", "xml"
    # print(str_html.text)
    soup = bs4.BeautifulSoup(str_html.text, 'html.parser')

    data = soup.select('#main>div>div.mtop.firstMod.clearfix>div.centerBox>ul.newsList>li>a')
    for item in data:
        # print(item)
        result = {
            "title": item.get_text(),
            "link": item.get('href'),
            'ID': re.findall('\d+', item.get('href'))
        }
        print(result)

    print("------------------------------------------------------------------------")
    # html = bs4.BeautifulSoup(str_html.text, 'html.parser')
    # all_a = html.select('ul>li>a')
    ''' 
    print(type(all_a))
    for d in all_a:
        print(d)

    # print(data)
    '''
