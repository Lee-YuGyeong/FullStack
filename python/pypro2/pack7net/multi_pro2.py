# 웹 데이터 크롤링(스크래핑)
# 멀티 프로세싱으로 시간 단축하기
import requests
from bs4 import BeautifulSoup as bs
import time
from multiprocessing import Pool

def get_link():
    data = requests.get("https://beomi.github.io/beomi.github.io_old/").text
    soup = bs(data, 'html.parser')
    #print(soup)
    my_title = soup.select('h3 > a')
    data = []
    
    for title in my_title:
        data.append(title.get('href'))
    
    #print(data)
    return data

def get_data(link):
    #print(link)
    abc_link = 'https://beomi.github.io'   + link 
    #print(abc_link) # 각각의 제목에 대한 완전한 URL이 작성됨    
    data = requests.get(abc_link).text
    soup = bs(data, 'html.parser')
    # 해당 제목의 컨텐츠를 가져다가 뭔가를 할 수 있다. 하지만 우리는 웹 데이터 수집 시 지연시간이 알고 싶을 뿐...
    print(soup.select('h1')[0].text)  # 그냥 허전해서 제목하나 찍기


if __name__ == '__main__':
    start_time = time.time()
    print('읽은 제목 수는 : ', len(get_link()))
    
    """  멀티 프로세싱을 사용하지 않은 경우
    for link in get_link():
        get_data(link)
    """
    
    # 멀티 프로세싱을 사용한 경우
    pool = Pool(processes = 4)
    pool.map(get_data, get_link())  # get_link 함수가 반환한 값으로 get_data 함수를 실행
    
    print("--- %s 초 걸림 ---"%(time.time() - start_time))

    

