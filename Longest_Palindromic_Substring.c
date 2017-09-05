# include <stdio.h>
# include <stdlib.h>
# include <string.h>
char* longestPalindrome(char* s) {
	/* notice that to minimize the space complexity,
	   remember to use char** dp rather than int** */
	char **dp;
	int len = 0, i, j, front = 0, rear = 0, maxdis = 1;
	char *sp = s, *retstr = NULL;
	for (sp; *sp != '\0'; sp++)
		len++;
	dp = (char**)malloc(sizeof(char*)*len);
	for (i = 0; i < len; i++) {
		dp[i] = (char*)malloc(sizeof(char)*len);
		memset(dp[i], 0, sizeof(char)*len);
	}

	for (i = 0; i < len; i++) {
		dp[i][i] = 1;
		if (i < len - 1) {
			dp[i][i + 1] = (s[i] == s[i + 1]);
			if (dp[i][i + 1]) {
				front = i;
				rear = i + 1;
				maxdis = 2;
			}
		}	
	}

	for (j = 2; j < len; j++) {
		for (i = 0; i <= j - 2; i++) {
			if (dp[i + 1][j - 1] && (s[i] == s[j])) {
				dp[i][j] = 1;
				if (j - i + 1 >= maxdis) {
					front = i;
					rear = j;
					maxdis = j - i + 1;
				}
			}
		}
		// printf("%d\n", i);
	}

	retstr = (char*)malloc(sizeof(char)*(maxdis+1));
	for (i = front, j = 0; i <= rear; i++, j++) {
		retstr[j] = s[i];
	}
	retstr[j] = '\0';
	return retstr;
}

int main()
{
	char *s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	//printf("%d", sizeof(s1));
	char *s2 = "aaaa";
	printf("%s\n", longestPalindrome(s1));
	//printf("%s\n", longestPalindrome(s2));
	return 0;
}