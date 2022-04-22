from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get('https://www.apple.com.cn/shop/buy-mac/macbook-air')
time.sleep(2)
driver.quit()

# 使用控制台中的chrome浏览器打开百度