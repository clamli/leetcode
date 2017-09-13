# include <stdio.h>
# include <stdlib.h>
# include <string.h>


// method 1
int isMatch(char* s, char* p) {
	int len_s = 0, len_p = 0, i, ind_s = 0, ind_p = 0;
	char *s_p = s, *p_p = p, **dp;
	for (; *s_p != '\0'; s_p++)
		len_s++;
	for (; *p_p != '\0'; p_p++)
		len_p++;
	dp = (char**)malloc(sizeof(char*)*(len_s+1));
	for (i = 0; i <= len_s; i++) {
		dp[i] = (char*)malloc(sizeof(char)*(len_p+1));
		memset(dp[i], 0, sizeof(char)*(len_p+1));
	}

	dp[0][0] = 1;
	for (ind_s = 0; ind_s <= len_s; ind_s++) {
		for (ind_p = 1; ind_p <= len_p; ind_p++) {
			if (p[ind_p-1] != '*') {
				dp[ind_s][ind_p] = ind_s>0 && dp[ind_s-1][ind_p-1] && ((p[ind_p-1] == '.') || (p[ind_p-1] == s[ind_s-1]));
			} else if (p[ind_p-1] == '*') {
				dp[ind_s][ind_p] = dp[ind_s][ind_p-2] || (ind_s>0 && dp[ind_s-1][ind_p] && (s[ind_s-1] == p[ind_p-2] || p[ind_p-2] == '.'));
			}
		}
	}

	return dp[len_s][len_p];
}

// method 2
int isMatch(char *s, char *p)
{
	if (*p == '\0')
		return *s == '\0';
	if (*(p + 1) != '*')
		return *s != '\0' && ((*p == *s) || (*p == '.')) && isMatch(s + 1, p + 1);
	do { /* *(p+1) == '*' */
		if (isMatch(s, p + 2))
			return 1;
	} while (*s != '\0' && (*s++ == *p || *p == '.'));
	return 0;
}

int main()
{
	printf("%d\n", isMatch("a", ".*..a*"));
	printf("%d\n", isMatch("aa", "aa"));
	printf("%d\n", isMatch("aaa", "aa"));
	printf("%d\n", isMatch("aa", "a*"));
	printf("%d\n", isMatch("aa", ".*"));
	printf("%d\n", isMatch("ab", ".*"));
	printf("%d\n", isMatch("aab", "c*a*b"));
	return 0;
}