import time
import datetime

if __name__ == '__main__':
    print(time.time())
    print(time.clock())
    startTime=time.time()
    start=time.clock()
    time.sleep(1)
    end =time.clock()
    endTime =time.time()
    print("----------------------------")
    print(endTime-startTime)
    print("----------------------------")
    print(end-start)


    print(datetime.date.ctime())