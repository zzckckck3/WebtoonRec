import requests
from bs4 import BeautifulSoup
from selenium import webdriver
from time import sleep
import pandas as pd
import openpyxl

wb = openpyxl.Workbook()

raw = requests.get("https://comic.naver.com/webtoon/weekdayList?week=dailyplus&view=list&order=User",
                   headers = {"User-Agent" : "Mozilla/5.0"})
html = BeautifulSoup(raw.text, 'html.parser')
webtoons = html.select("tbody > tr")

id_list = [] ; thumbnail_list = [] ; title_list = [] ; author_list = [] ; url_list = [] ;
day_list = [] ; genre_list = [] ; story_list = [] ; platform_list = []
num = 0


for webtoon in webtoons:
    sleep(0.5)

    title = webtoon.select_one("td:nth-of-type(1) a")
    url = title.attrs["href"]

    each_raw = requests.get("https://comic.naver.com" + url,
                            headers = {"User-Agent" : "Mozilla/5.0"})
    each_html = BeautifulSoup(each_raw.text, 'html.parser')

    tt = each_html.select_one("div.detail h2 span.title").text
    title_list.append(tt)  # 제목 리스트에 추가
    # day_list.append(day) # 요일 리스트에 추가
    platform_list.append('네이버 웹툰') # 플랫폼 리스트에 추가

    author = each_html.select_one("div.detail h2 span.wrt_nm").text
    author_list.append(author) # 작가 리스트에 추가

    genre = each_html.select_one("p.detail_info span.genre").text
    genre_list.append(genre) # 장르 리스트에 추가

    story = each_html.select_one("div.detail p").text
    story_list.append(story) # 줄거리 리스트에 추가

    thumb = each_html.find_all("div", {"class": "thumb"})
    for m in thumb:
        week_check = m.a.get('href')
        week_check = week_check[-3:]
    imgUrl = m.find_all('img')
    img_link = imgUrl[0].get('src')
    thumbnail_list.append(img_link)

    web = each_html.find_all('head')
    web = each_html.find('meta', {'property': 'og:url'})
    web = str(web)
    web = web.split('"')
    url_list.append(web[1])

total_data = pd.DataFrame()
total_data['thumbnail'] = thumbnail_list
total_data['title'] = title_list
total_data['author'] = author_list
# total_data['day'] = day_list
total_data['genre'] = genre_list
total_data['story'] = story_list
total_data['platform'] = platform_list
total_data['url'] = url_list
total_data.to_csv('네이버_웹툰_매일.csv', encoding = 'utf-8-sig')