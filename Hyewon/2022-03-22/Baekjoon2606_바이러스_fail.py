# 알고리즘이용 X, 틀린이유찾기 
relation = [1]
l=[]

n = int(input())
connection = int(input())
for i in range(connection):
  f, s = tuple(map(int,input().split()))
  if f>s:
    l.append((s,f))
  else:
    l.append((f,s))

l = sorted(l)
for i in l:
  if i[0] in relation: 
    relation.append(i[1])
  if i[1] in relation:
    relation.append(i[0])
print(len(set(relation))-1)