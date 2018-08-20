import io
import os
import sys
from google.cloud import vision
from google.cloud.vision import types
from PIL import Image

def detect_logos(path):
    client = vision.ImageAnnotatorClient()
    with io.open(path, 'rb') as image_file:
        content = image_file.read()
    
    image = vision.types.Image(content=content)

    response = client.logo_detection(image=image)
    logos = response.logo_annotations

    l=[]
    for logo in logos:
        for i in logo.description.split(' '):
            l.append(i)
    return l

def findLogo(ans,logo_list):
    for item in ans:
        if item.lower() in logo_list:
            return item

def findComp(logo_list, im_file):
    os.environ['GOOGLE_APPLICATION_CREDENTIALS']='hack-701f558afdcf.json'
    #image_file = sys.argv[1]
    ans=detect_logos(im_file)
    print(ans)
    return findLogo(ans,logo_list)


