# include <stdio.h>

bool isPalindrome(int x) {
	int sum = 0, t_x = x;
	if (t_x < 0)
		return false;

    while (t_x != 0) {
    	sum *= 10;
    	sum += t_x%10;
    	if (sum > INT_MAX || sum < INT_MIN)
    		return false;

    	t_x /= 10;
    }

    return (sum == x);
}

int main()
{
	printf("%d\n", isPalindrome(123));
	return 0;
}