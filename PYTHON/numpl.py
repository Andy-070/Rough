# import numpy as np
# from numpy import random

# n = np.array((1,2))
# n1=np.array([1,2,3])
# print(n1)
# print(type(n1))

# n = np.array(1)
# n = np.array((1,1,1,1))
# n = np.array([[1,2,3,4,5,6],[1,2,3,4,5,6]])
# n= np.array([[[1,2,3],[4,5,6],[3,3,3]],[[7,8,9],[10,11,12],[4,4,4]]])

# print(n.ndim)

# n = np.zeros([2,3])
# print(n)

# print(n1.dtype)

# n = np.array(["1","2","3"],dtype="S3")
# print(n.dtype)

# n = np.array(['10','20'])
# print(n.dtype)

# n2 = n.astype('i')
# print(n2.dtype)

# print(n1[1])
# print(n[0,1])
# print(n[1,1,2])

# print(n[-1])
# print(n[1,-2])

# print(n[1:2])
# print(n[0:9:2]) step
# print(n[0,2:8])
# print(n[0:2,2:8])

# print(n.ndim,n.shape) 0
# print(n.ndim,n.shape) 1
# print(n.ndim,n.shape) 
# print(n.ndim,n.shape) 3

# print(n.reshape(2,1))  1d into 2d
# print(n.reshape(2,2,1)) 1d into 3d
# print(n.reshape(-1))  many into 1d
# print(n.reshape(2,3,2)) 2d into 3d
# print(n.reshape(6,3))  3d into 2d

# for a in n : print(a,type(a))


# n=np.array([1,1,3])
# n1=np.array([4,5,6])
# print(np.concatenate((n,n1))) #it joins two arraes of same dim (merge) 1d remains 1d  asd

# print(np.stack((n,n1)))     qwe             #1d to 2d
# print(np.stack((n,n1),axis=1))       zxc       #''

# print(np.hstack((n,n1))) 1d   asd

# print(np.vstack((n,n1)))   2d  qwe

# print(np.dstack((n,n1))) #along height

# print(np.column_stack((n,n1)))    zxc #same as above

# n3=  np.array_split(n,3)
# for a in n3:
#  print(a)
# print(n3[0],n3[1])
# print(n3)

# print(np.array_split(n,3)[1])

# print(np.where(n==1))

# n= np.array([2,4,2,7,0,4,7,9])
# print(n,np.sort(n),n)

# s=np.array(['as','egw','ty','pgh'])
# print(np.sort(s))

# n2d= np.array([[20,3,4,1,2],[11,18,13,6,21]])
# print(np.sort(n2d))


# n= np.array([2,4,2,7,0,4,7,9])
# print(n.min())

# n2d= np.array([[20,3,4,1,2],[11,18,13,6,21]])
# print(n2d.min(axis=0))
# print(n2d.min(axis=1))

# a=np.array([1,1,4,5])
# b=np.array([4,5,6])
# print(np.intersect1d(a,b))

# a=np.array([5,1,4,1])
# b=np.array([4,6,5])
# print(np.intersect1d(a,b))

# a=np.array([1,2,3])
# b=np.array([4,5,6])
# print(np.intersect1d(a,b))

# a=np.array([5,1,4,1])
# b=np.array([4,6,5])
# print(np.setdiff1d(a,b),np.setdiff1d(b,a))

# a=np.array([10,11,12,13,14,15])
# b=np.array([14,16,17,18,19,20])
# print(np.sum((a,b)))
# print(np.sum((a,b),axis=0))
# print(np.sum((a,b),axis=1))

# print(np.subtract(a,b))

# print(np.multiply(a,b))

# print(np.divide(a,b),np.divide(b,a))

# print(a,b)
# print(a+10,b+10)
# print(a-10,b-10)
# print(a*10,b*10)
# print(a/10,b/10)

# print(np.mean(a),np.mean(a))
# print(np.median(a),np.median(b))
# print(np.std(a),np.std(b))

# print(random.randint(5))
# print(random.randint(2,10))
# print(random.choice([1,2,3,4,10]))
# print(random.randint(10,size=5))

# print(np.log2(a),np.log10(a))

# a,b = 3,12
# print(np.lcm(a,b),np.gcd(a,b))