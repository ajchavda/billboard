import math
import pymysql
import sys
from pro3 import findComp
db = pymysql.connect("localhost","root","","hwi")
cursor = db.cursor()

def findangle(lat1,long1,lat2,long2):
    dLon = (long2 - long1)
    y = math.sin(dLon) * math.cos(lat2)
    x = math.cos(lat1) * math.sin(lat2)-math.sin(lat1)*math.cos(lat2)*math.cos(dLon)

    brng = math.atan2(y, x)

    brng = math.degrees(brng)
    brng = (brng + 360) % 360
    return brng

def finddistance(lat1,lon1,lat2,lon2) :
    R = 6378.137
    dLat = lat2 * math.pi / 180 - lat1 * math.pi / 180
    dLon = lon2 * math.pi / 180 - lon1 * math.pi / 180
    a = math.sin(dLat/2) * math.sin(dLat/2) +math.cos(lat1 * math.pi / 180) * math.cos(lat2 * math.pi / 180)*math.sin(dLon/2) * math.sin(dLon/2)
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a))
    d = R * c
    return d * 1000

def ispresent(lat,lon,angle,checklat,checklon) :
    dist = finddistance(lat,lon,checklat,checklon)
    ang  = findangle(lat,lon,checklat,checklon)
    #print(dist)
    #print(ang)
    if dist>50 :
        return False
    left = angle-15
    if left<0 :
        left=left+360
    right = (angle+15)%360

    if right-left<0 :
        if ang>right and ang<left :
            return False
        return True

    if ang>=left and ang<=right:   
        return True
    return False

#print(ispresent(0,0,0,9))
lat,lon,angle=0,0,0
#with open('gps.txt') as f :
    #lat = (float)(f.readline())
    #lon = (float)(f.readline())
    #angle = (float)(f.readline())    
#print(lat,lon,angle)
lat = (float)(input())
lon = (float)(input())
angle=(float)(input())
img = input()
sql = "select lat,lon,name from boardings"
cursor.execute(sql)
res = cursor.fetchall()
products = []
for lin in res :
    #print(lin)
    if(ispresent(lat,lon,angle,lin[0],lin[1])) :
	    #print(lin)
	    products.append(lin[2])
print(findComp(products, img),end='')




