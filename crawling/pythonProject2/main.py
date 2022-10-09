import requests
from bs4 import BeautifulSoup
from selenium import webdriver
from time import sleep
import pandas as pd
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


#403 forbidden 해결하기 위한 옵션들
options = webdriver.ChromeOptions() 
# options.add_argument('headless')
options.add_argument("--disable-extensions") 
options.add_argument("disable-infobars") 
options.add_argument("window-size=1920x1080") 
options.add_argument("no-sandbox") 
options.add_argument("disable-gpu") 
options.add_argument("--lang=ko_KR") 
options.add_argument('user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.74 Safari/537.36') 


driver = webdriver.Chrome('C:\Codingworkspace\광운대 빅데이터\py_temp\chromedriver', options=options) # 크롬 사용하니까

URL = 'https://webtoon.kakao.com/original-webtoon?tab=mon'
driver.get(URL)

sleep(1)


html = driver.page_source #page_source 적용해야함, request말고 request 사용해서 계속 빈값이 나온거였음
soup=BeautifulSoup(html, 'html.parser')

data = soup.find_all('div', {'class' : 'h-full relative'}) # div태그에서 class=''인 html소스를 찾아 할당
title_list = [] ; writer_list = [] ; genre_list = [] ; desc_list = [] ; weburl_list = []
keyword_list=[]
num = 0

url_list=[]

for href in data:
    url_list.append(href.find('a')['href'])


a=0
for i in url_list:
    

    if i != '#none':
        info_url='https://webtoon.kakao.com/original-webtoon?tab=mon' + i
        driver.get(info_url)
        sleep(1.5)
        
        
        #성인웹툰은 로그인해야하기 때문에 try~except문으로 제외
        try:
            
            html = driver.page_source 
            soup=BeautifulSoup(html, 'html.parser')



            #웹툰 url
            web_url=soup.select_one('meta[property="og:url"]')['content']
            #웹툰 줄거리
            desc = soup.select_one('meta[name="description"]')['content']
            #장르
            genre=soup.find('p',{'class':'whitespace-pre-wrap break-all break-words s12-regular-white ml-3 opacity-85'}).text
            
            #제목           
            information = soup.select_one('meta[name="twitter:title"]')['content'].split('|')
            title=information[0]

            
            #작품정보란으로 이동
            element = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CLASS_NAME, 'overflow-hidden.cursor-pointer')))
            element.click()
            
            #속도를 위해 Explicitly Wait사용
            ekey = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.XPATH, '//*[@id="root"]/main/div/div/div/div[1]/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[2]/a[4]/p')))

            
            #글작가, 그림작가
            w_list=[]
            writer=driver.find_element_by_xpath('//*[@id="root"]/main/div/div/div/div[1]/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div/div/dl/div[1]/dd').text
            drawer=driver.find_element_by_xpath('//*[@id="root"]/main/div/div/div/div[1]/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div/div/dl/div[2]/dd').text
            if writer == drawer:
                w_list.append(writer)
            else:
                w_list.append(writer+','+drawer)

            #키워드는 4개
            keyword1=driver.find_element_by_xpath('//*[@id="root"]/main/div/div/div/div[1]/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[2]/a[1]/p').text
            keyword2=driver.find_element_by_xpath('//*[@id="root"]/main/div/div/div/div[1]/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[2]/a[2]/p').text
            keyword3=driver.find_element_by_xpath('//*[@id="root"]/main/div/div/div/div[1]/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[2]/a[3]/p').text
            keyword4=driver.find_element_by_xpath('//*[@id="root"]/main/div/div/div/div[1]/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[2]/a[4]/p').text

            keywords=keyword1+' '+keyword2+' '+keyword3+' '+keyword4
            
            print(keywords)
            
            keyword_list.append(keywords)
            title_list.append(title)
            desc_list.append(desc)
            genre_list.append(genre)
            weburl_list.append(web_url)
            writer_list.append(w_list[0])
                       
            a+=1
            print(a, 'complete')
            sleep(1.5)
          
        except:
            print('fail')
            sleep(3)
            pass
    

total_data = pd.DataFrame()
total_data['제목'] = title_list
total_data['작가'] = writer_list
total_data['장르'] = genre_list
total_data['줄거리'] = desc_list
total_data['키워드'] = keyword_list
total_data['url']=weburl_list

total_data.to_csv('.csv', encoding='utf-8-sig')