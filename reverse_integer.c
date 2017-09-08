# include <stdio.h>
# include <stdlib.h>
# include <string.h>

int reverse(int x) {
	int t_x = x;
	long long sum = 0;

	while (t_x != 0) {
		sum *= 10;
		sum += t_x % 10;
		if ((sum > INT_MAX) || (sum < INT_MIN))
			return 0;
		t_x = t_x / 10;
	}

	return sum;
}


int main()
{
	int x = -123;
	int ret = reverse(x);
	printf("%d\n", ret);
	return 0;
}