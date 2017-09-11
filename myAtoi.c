# include <stdio.h>
# include <stdlib.h>

int myAtoi(char* str) {
	int sign = 1;
	long long sum = 0;
	char *pstr = str, flag = 0, overflow = 0;

	for (pstr; *pstr != '\0'; pstr++) {
		if (*pstr == ' ') {
			if (!flag)
				continue;
			else
				break;
		}

		if ((!flag) && *pstr == '-') {
			if (*(pstr + 1) <= '9' && *(pstr + 1) >= '0') {
				flag = 1;
				sign = -1;
				continue;
			}
			else {
				break;
			}
		} 
		else if ((!flag) && *pstr == '+') {
			if (*(pstr + 1) <= '9' && *(pstr + 1) >= '0') {
				flag = 1;
				sign = 1;
				continue;
			}
			else {
				break;
			}
		}
		else if (*pstr > '9' || *pstr < '0')
			break;

		if (flag == 0)
			flag = 1;
		sum *= 10;
		sum += sign * (*pstr-'0');
		if (sum > INT_MAX)
			return INT_MAX;
		else if (sum < INT_MIN)
			return INT_MIN;
	}   

	if (flag == 0)
		return 0;
	else
		return (int)sum;
}

int main()
{
	printf("%d\n", myAtoi("  -0012a42"));
	return 0;
}