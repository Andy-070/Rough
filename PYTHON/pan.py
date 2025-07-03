import pandas as pd
import matplotlib.pyplot as mt

data ={
    "student":["andy",'sandy',"mandy",'tundy',"andy"],
    "marks":[90,98,76,60,100],
    "rank":[3,2,4,5,1],
    "id":[1,2,3,4,5]
}

data1={
    "age":[20,21,22,23]
}

df = pd.DataFrame(data)
df1=pd.DataFrame(data1)


# print(df)

# df = pd.DataFrame(data,index=['A','B','C','D'])
# print(df)

# print(df["marks"])
# print("value: ",df.loc['A','student'])
# print(df.iloc[[2,3]])
# print(df.iloc[[2,3],2])
# print(df.iloc[2])

# print(df[["marks","rank"]])
# print(df[df.columns[1:]])

# for col in df:
#     print(col)

# print(df.dtypes)
# print(df.ndim)
# print(df.size)
# print(df.shape)  row-col
# print(df.index)
# print(df.T)
# print(df.head(2))
# print(df.tail(2))

# print(df.join(df1))
# print(pd.concat([df,df1]))

# df = pd.DataFrame({"a":list("andy")},dtype="category")
# print(df.dtypes,df)
# df1=pd.DataFrame(data1,dtype="category")
# print(df1,df1.dtypes)

qwerty = [1,2,3,4,5]
ty = [6,7,8,9,0]

s = pd.Series(qwerty)
t=pd.Series(ty)

# print(s)
# print(s[1])
# s=pd.Series(qwerty,index=['q','w','e','r','t'])
# print(s)
# print(s['t'])

# print(s.dtype)
# print(s.ndim)
# print(s.size)
# print(s.shape)
# print(s.head(3))
# print(s.tail(3))

# s = pd.Series(qwerty,name="andy")
# print(s.name)

# print(s.hasnans)
# print(s.index)
# print(s.info())

# def comp(x,y):
#     if(x>y): return x
#     else : return y

# print(s.combine(t,comp))

# s = pd.Series(qwerty,dtype="category")
# print(s.cat.add_categories(6))
# print(s.cat.remove_categories(5))

# file = pd.read_csv("path")
# print(file)
# print(file.head(),file.tail())

# file = pd.read_excel("path")
# print(file)
# print(file.head(),file.tai())


# print(file["col name"])
# print(file.loc['index','col'])
# print(file.iloc[[row no]])

# df.insert(3,"bool",[1,1,0,0])
# print(df)
# print(df.assign(bool1=['t','f','t','f']))


# print(df.drop("bool",axis="columns"))
# print(df.drop("bool",axis=1))
# print(df.drop(3,axis="index"))
# print(df.drop("bool",axis=0))


# for row in df.iterrows():
#     print(row)

# for row in df.itertuples():
#     print(row)

# for a,b in df.items():
#     print(a)
#     print(b)

# print(df.sort_values(by=['student']))
# print(df.sort_values(by=['student'],ascending=False))

# print(df.duplicated())
# print(df.drop_duplicates())

# file = pd.read_csv("/home/andy/Documents/New.csv")
# print(file.isnull())
# print(file.notnull())
# print(file.dropna()) drops the while row consisting of null values
# print(file.fillna("value to replace with null"))


str1 = ["S",'D','F']
sd = pd.Series(str1)
# print(sd.str.lower())
# print(sd.str.upper())
# print(sd.str.title()) first letter caps
# print(sd.str.len())
# print(sd.count())   it counts all non empty cells 
# print(sd.str.contains("S"))


# print(pd.Timestamp.now())
time = pd.Timestamp(year=2025,month=6,day=9)
# print(time,time.day_of_week)
# print(pd.Timestamp(year=2025,month=6,day=9).day_of_week)
# print(time.day_of_year)
# print(time.days_in_month)
# print(time.is_leap_year)
# print(time.is_month_end)
# print(time.is_year_end)

str2 = ["S l",'\nD',' F ']
sdt = pd.Series(str2)
# print(sdt.str.strip())
# print(sdt.str.lstrip())
# print(sdt.str.rstrip())

# print(df.groupby('student').first())

# for a,b in df.groupby('student'):
#     print(a)
#     print(b)

# print(df.groupby('student').groups)

# print(df.groupby('student')['rank'].mean())
# print(df.groupby('student').size())

# print(df.sum())
# print(df.count()) 
# print(df.max())
# print(df.min())
# print(df.mean())
# print(df.median())
# print(df.std())
# print(df.describe())

# df.plot()
# mt.show()

# df["marks"].plot(kind='hist')   #frequency of each value
# mt.show()


# df.plot.pie(y="marks")
# mt.show()

# df.plot(kind="scatter",x="marks",y="rank")   relation of two col

# df.plot.area()