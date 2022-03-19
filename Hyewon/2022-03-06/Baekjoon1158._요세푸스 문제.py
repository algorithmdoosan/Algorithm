# 백준알고리즘 - 큐 1158. 요세푸스 문제

# 1) 리스트로 생각함
n, k = tuple(map(int,input().split()))
n_circle = list(range(1,(n+1)))
a = list()

order = -1
while(n != 0):
  order += k
  if (order >= n):
    order = order%n
  a.append(n_circle.pop(order))
  n -= 1
  order -= 1

print("<"+str(a)[1:-1]+">")

# 2). 큐
# 큐 : 선입선출 FIFO
# PYTHON 에서
# (1). list
#       리스트 append(추가하고싶은값), pop(0) 으로 선입선출 가능
#
# (2). deque
#       collections 모듈의 deque는 double-ended queue의 약자로 데이터를 양방향에서 추가하고 제거할 수 있는 자료 구조
#       >> from collections import deque
#       popleft() 라는 함수가있음 (=pop(0)의미같음, 대신 리스트를 deque(리스트)로 선언해줘야함)
# 
# (3). Queue
#       queue 모듈의 Queue 클래스를 사용 (주로 멀티 쓰레딩(threading) 환경에서 사용 : 내부적으로 라킹(locking)을 지원하여 여러 개의 쓰레드가 동시에 데이터를 추가하거나 삭제 가능)
#       deque와 달리 방향성이 없기 때문에 데이터 추가와 삭제가 하나의 메서드로 처리됩니다. 따라서, 데이터가 추가하려면 put(x) 메서드를 사용하고, 데이터를 삭제하려면 get() 메서드를 사용
#       >> from queue import Queue
#       선입선출 que = Queue()로 선언 후 que.put(선입값), que.get() 선출값
#
#
# python에서는 딱히 queue로 풀 필요없는둣?
