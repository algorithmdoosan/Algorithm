#include <iostream>
using namespace std;

const int MAX = 1e5;

class Queue {
private:
    int data[MAX];
    int index_front;
    int index_back;
public:
    Queue();
    bool empty();
    void push(int x);
    void pop();
    int front();
    int back();
    int size();
};

Queue::Queue() {
    index_front = 0;
    index_back = 0;
}

bool Queue::empty() {
    return index_front == index_back;
}

void Queue::push(int x) {
    index_back = (index_back+1) % MAX;
    data[index_back] = x;
}

void Queue::pop() {
    index_front = (index_front+1) % MAX;
}

int Queue::front() {
    return data[(index_front+1)%MAX];
}

int Queue::back() {
    return data[index_back];
}

int Queue::size() {
    return (index_back-index_front+MAX)%MAX;
}

int main()
{
    Queue q;
    int n, k;
	cin >> n >> k;

	for (int i = 1; i <=n; i++){
		q.push(i);
	}

	cout << "<";
	while (!q.empty()){
		int number;
		for (int i = 0; i < k-1; i++){
			number = q.front();
			q.pop();
			q.push(number);
		}
		number = q.front();
		q.pop();
		if (q.size() > 0)	cout << number << ", ";
		else cout << number<<">";
	}
}