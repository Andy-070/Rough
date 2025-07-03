# print("hi","bye")
# print("hi","bye")

name="andy"
# namee1='a'
# name2 = '''a'''
age=50
# print(name,age)
win = True
# print(type(win))
# print(2*"a"*1)

# a,b=1,2
# print(a*b)
# print("1"+"00")

# print(3/2)
# print(3//2) #its gives floor of(3/2)

# n = input("name: ")
# print(n)

# a = int(input("a:" ))

# a = int(input("age: "))
# if(a>=18) : print("vote")
# elif(a<18) : print("not")
# else : print("sleep")
# if(a>18 and a<20) : print("brand")

# b = "vote" if a>18 else "no"
# print(b)

# print("votee") if a>18 or a<100 else print("dont you dare")

# result = a*(0.1,0.2) [a>50000] 
# print(result)


# print(len("jkfshfjbj"))
# print("nbjj"+"jbjfg")
# print(name[0])
# print(name[0:2]) #[:3],[0:]

# print(name.capitalize())
# print(name.endswith("dy"))
# print(name.find("y"))
# print(name.replace("a","s"))
# print(name.count('a'))


# marks=[1,2,3,4,5,6,7]
# marks[0]=100
# print(marks[0])
# print(marks[0:6])
# marks.append(10)
# print(marks.reverse())
# print(marks)
# marks.insert(0,-1)
# print(marks)

# asd=['a','d','b']
# asd.sort(reverse=True)
# print(asd)
# asd.remove('a')
# print(asd)
# asd.pop(0)
# print(asd)


# tup =(1,2,3)
# print(tup)
# print(tup.index(2))
# print(tup.count(1))

# tup_copy = tup.reverse()
# if(tup == tup_copy):print("palin")



# info = {
#     "name":"andy",
#     "age":20,
#     "year":"3rd",
#     "marks":{
#         "dm":"p",
#         "java":'p',
#         "coa":'p'
#     },
#     "perrsonality":"super",
    #   "jb":[]
    #    "jvf":()
# }
# info["ht"]=6

# print(info["marks"]["java"])
# print(len(list(info.keys())))
# print(info.values())
# print(info.items())
# print(info.get("name"))
# info.update({"wt":100,"contct":100})
# print(info)


# coll = {1,2,2}
# print(coll)

# col= set()
# col.add(1)
# col.add(2)
# col.add(3)
# col.add(4)
# print(col)
# col.add("andy")
# print(col)
# col.remove(1)
# print(col)
# print(col.pop())
# print(len(col))

# col1={3,4,5,6}
# print(col.union(col1))
# print(col.intersection(col1))

# i=0
# while i<6 : print(i) 
# i+=1


# i=0
# while i<6 :
#     if(i==3): 
#         i+=1
#         # continu
#         break
#     print(i)
#     i+=1
    
# for el in name : 
#     print(el)
#     if(el=="d"):
#         print("found")
#         break
# else : print("end")

# i1=3
# sum=2
# while i1<6:
#  sum*=i1
#  i1+=1
# print(sum)

# for i in range(1,6): 
#  sum*=i
# print(sum)

# def cal_sum(a,b=10):
#     return a+b

# print(cal_sum(7))

# def cal_sum(a):
#     if(a==0) :return 0
#     return a + cal_sum(a-1)

# print(cal_sum(10))



# f=open("New Document.txt","r")

# data=f.read()
# data=f.read(5)
# data=f.readline()
# print(data)
# print(type(data))
# f.close()

# f=open("New Document.txt","w")
# f.write("hello")
# f.close()

# f=open("New Document.txt","a")
# f.write("hii")
# f.close()

# f=open("New Document.txt","r+")
# print(f.read())
# f.write("bye")
# f.close()

# f=open("New Document.txt","w+")
# f.write("bol na")
# f.read()
# f.close()

# with open("New Document.txt","r") as f:
#     print(f.read())
#     f.close()

# with open("New.txt","w") as f:
#     print(f.write("kay"))
#     f.close()   

# import os
# os.remove("New.txt")


# print(type(str(123)))

# data = "hgfdsfhf"

# print("hgf" in data)
# print(1 in [1,3])

# class Student:
#     clg_name = "ABC"
#     def __init__(self,name,marks):
#         print("created instance")
#         self.__name = name
#         self.marks = marks
          
#     def hello(self):
#         return "Welcome"
    
#     def getName(self):
#         return self.__name
        
#     # @staticmethod
    # def hello():
    #     return "WWelcome"
    

# s1 = Student("amdy",97)
# print(s1,s1.getName(),s1.marks,s1.clg_name)
# print(s1.hello())
# s1.__name = "andy"
# del s1.__name
# print(s1.__name)


# class Car:
#     @staticmethod
#     def start():
#         return "started"
    
# class Mahindra(Car):
#     def __init__(self,type):
#         self.type = type

# class Thar(Mahindra,Car):
#     def __init__(self, price,type):
#         self.price = price
#         super().__init__(type)

# c1 = Thar(20,"ev")
# print(c1.price,c1.type,c1.start())



# class info:
#     name = "aass"

    # def changename(self,name):
        # self.name = name
        # info.name = name
        # self.__class__.name = name
    
    # @classmethod
    # def changename(cls,name):
    #     cls.name = name
    
    # def __init__(self,a,b):
    #     self.a = a
    #     self.b = b
    
    # @property
    # def avg(self):
    #     return (self.a + self.b)

# i1  = info(10,20)
# i1.changename("andy")
# print(i1.name)
# print(info.name)
# print(i1.avg())
# i1.a = 20
# print (i1.avg())



# print([1,2,3]+[1,4,5])

# class Complex:
#     def __init__(self,real,img):
#         self.real = real
#         self.img= img
    
#     def show(self):
#         return str(self.real) + "i" + str(self.img) + "j"

    # def sum(self,c2):
    #     newr = self.real + c2.real
    #     newi = self.img + c2.img
    #     return Complex(newr,newi)

#     def __add__(self,c2):
#         newr = self.real + c2.real
#         newi = self.img + c2.img
#         return Complex(newr,newi)

# c1 = Complex(2,3)
# c2 = Complex(5,7)
# print(c1.show(),c2.show())

# c3 = c1.sum(c2)
# c3 = c1 + c2
# print(c3.show())

print(1+2+'3')