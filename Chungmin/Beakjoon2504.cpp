#include <iostream>
using namespace std;

const int MAX = 1e5;

class Stack {
private:
    int data[MAX];
    int index;
public:
    Stack();
    bool empty();
    void push(char x);
    void pop();
    int top();
    int size();
};

Stack::Stack() {
    index = -1;
}

bool Stack::empty() {
    return index == -1;
}

void Stack::push(char x) {
    index += 1;
    data[index] = x;
}

void Stack::pop() {
    index -= 1;
}

int Stack::top() {
    return data[index];
}

int Stack::size() {
    return index+1;
}

Stack st;
string str;
bool impossible = false;

int solution(const string& str)
{
	int answer = 0;
	int temp = 1;
	for (int i = 0; i < str.size(); i++)
	{
		if (str[i] == '(')
		{
			temp *= 2;
			st.push(str[i]);
            cout << "index : " << i  << "temp : "<< temp << endl;
		}
		else if (str[i] == '[')
		{
			temp *= 3;
			st.push(str[i]);
            cout << "index : " << i  << "temp : " << temp << endl;
		}
		else if (str[i] == ')' && (st.empty() || st.top() != '('))
		{
			impossible = true;
			break;
		}
		else if (str[i] == ']' && (st.empty() || st.top() != '['))
		{
			impossible = true;
			break;
		}
		else if (str[i] == ')')
		{
			if (str[i - 1] == '(') {
				answer += temp;
                cout << answer << endl;
            }
			st.pop();
			temp /= 2;
		}
		else if (str[i] == ']')
		{
			if (str[i - 1] == '[') {
				answer += temp;
                cout << answer << endl;
            }
			st.pop();
			temp /= 3;
		}
	}
	if (impossible || !st.empty())
		return 0;
	else
		return answer;
}

int main() 
{
    cin >> str;
	cout << solution(str) << endl;
	return 0;
}