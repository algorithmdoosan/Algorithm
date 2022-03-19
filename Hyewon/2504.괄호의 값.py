bracket = list(input())
n = len(bracket)
print(bracket)

caculate = []
a=0 
before = 1

for i in range(n):
  print("i",i)
  now = bracket.pop()
  print("calculate: ",caculate)
  
  if now == "[":
    caculate.pop()
    before *= 3
  elif now == "(":
    caculate.pop()
    before *= 2
  elif before == 1:
    caculate.append(now)
  else:
    if (not caculate):
      # caculate is empty
      a += before
      before = 1
      print(a)
    else:
      # caculate is not empty
      before += before
    caculate.append(now)
    
if before != 1:
  a += before
print(a)