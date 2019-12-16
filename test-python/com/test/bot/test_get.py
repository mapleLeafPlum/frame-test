import requests
import json

if __name__ == '__main__':
    url = 'http://localhost:8282/uis/system/inspectionObject/inspectionObjectInstDetail?organId=67&inspectionObjectId=2'
    str_html = requests.get(url)
    print(type(str_html.text))
    data = json.loads(str_html.text)
    #print(str_html.text)
    # lxml lxml-xml  html.parser html5lib
    # "html", "html5", "xml"
    requests.delete(url)
    requests.put(url)
    requests.head(url)
    requests.options(url)
    print(type(data))
    print(data)
