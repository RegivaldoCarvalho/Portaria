#!/usr/bin/python

import requests
import base64
import json
import urllib
import wget
import json
import os



# Sample image file is available at http://plates.openalpr.com/ea7the.jpg
# diretorio com a imagem para a leitura do OCR

url = input('Digite a url da imagem\n')
#url = 'http://plates.openalpr.com/ea7the.jpg'
IMAGE_PATH = 'D:\\GitHub\\Portaria\\ocr\\test4.jpg'
SECRET_KEY = 'sk_f91d36e7e074cc2f1b614cb1'
#IMAGE_PATH2 = requests.get(url, stream=True)
#r = requests.get(url)
#i = Image.open(StringIO(r.content))


image_name = 'test4.jpg'
wget.download(url, image_name)


with open(IMAGE_PATH, 'rb') as image_file:
    img_base64 = base64.b64encode(image_file.read())

#img_base64 = base64.b64encode(Image.open(file_name.read())

url = 'https://api.openalpr.com/v2/recognize_bytes?recognize_vehicle=1&country=us&secret_key=%s' % (SECRET_KEY)
r = requests.post(url, data = img_base64)

#print(json.dumps(r.json(), indent=2))
info = r.json()
os.remove('test4.jpg')
print('\n')
for item in info['results']:
    print('Plate', item['plate'])
    print('Confidence', item['confidence'])
