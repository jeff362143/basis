from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
import time

# 将chrome浏览器缓存载入到新打开的chrome进程中，浏览器缓存被多次使用的话selenium就报错(即只能打开一个浏览器窗口)
option=webdriver.ChromeOptions()
option.add_argument(r"user-data-dir=/Users/jeff/Library/Application Support/Google/Chrome/")

driver = webdriver.Chrome(chrome_options=option)
driver.get('https://chirp.apple.com')
time.sleep(5)
# 使用控制台中的chrome浏览器打开网站
# 使用selenuim打开的浏览器是无法使用已有缓存的(因此我们需要复用已打开的网站或者获取到响应的缓存加入到新打开的浏览器中)

inputTag = driver.find_element(By.TAG_NAME, 'html')
print(inputTag.get_dom_attribute())


