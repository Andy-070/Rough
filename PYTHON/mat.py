import matplotlib.pyplot as mt
import numpy as np
import pandas as pd



# n = np.array([10,30,3,5,10,15,20])
# m = np.array([5,40,10,14,1,35,20])
# mt.plot(n,m)
# mt.show()

# data ={
#     "student":["andy",'sandy',"mandy",'tundy',"andy"],
#     "marks":[90,98,76,60,100],
#     "rank":[3,2,4,5,1],
#     "id":[1,2,3,4,5]
# }

# df = pd.DataFrame(data)
# mt.plot(df["marks"],df["rank"])
# mt.title("score")
# mt.title("score",loc="right")
# mt.title("score",loc="left")
# mt.xlabel("marks")
# mt.ylabel("rank")
# mt.grid()


# a = np.arange(5)
# b = [2,3,5,7,9]
# c= [2,4,5,6,10]

# fig = mt.figure()
# ax = mt.subplot()

# ax.plot(a,b,'k--',label="freq")
# ax.plot(a,c,'k:',label="per")

# ax.legend()
# ax.legend(loc="lower left",fontsize="large")
# ax.legend().get_frame().set_facecolor('red')


# mt.show()

# student = ["andy","mandy","sandy"]
# salary = [100,150,200]

# mt.bar(student,salary)
# mt.pie(salary,labels=student,autopct="%1.2f%%")


# arr = [10,12,10,12,14,14,15,1,6,26,6,2,3,4,3,4,10]

# mt.hist(arr,bins = [0,20,40,60,80])

# student = ["andy","mandy","sandy"]
# salary = [100,150,200]
# mt.scatter(student,salary,color='r')


# student = ["andy","mandy","sandy"]
# emp  = ["asdf","qwerty","mnc"]
# salary = [100,150,200]
# mt.scatter(student,salary,color='r')
# mt.scatter(emp,salary,color='b')
# mt.xlabel("person")
# mt.ylabel("rojgaar")
