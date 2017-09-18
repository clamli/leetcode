# include <stdio.h>
# include <stdlib.h>

char* longestCommonPrefix(char** strs, int strsSize) {
    char ch, *ret;
    int i, j, ind = 0;

    if (strsSize == 0)
    	return "";

	while (1) {
		if (strs[0][ind] == '\0')
			break;

		ch = strs[0][ind];
		for (i = 1; i < strsSize; i++) {
			if (strs[i][ind] != ch)
				break;
		}  
		if (i != strsSize)
			break;
		else
			ind++;
	} 

	ret = (char*)malloc(sizeof(char)*(ind+1));
	for (i = 0; i < ind; i++)
		ret[i] = strs[0][i];
	ret[ind] = '\0';
	
	return ret;
}

int main()
{
	int i;
	char **strs;
	strs = (char**)malloc(sizeof(char*)*5);
	for (i = 0; i < 5; i++) {
		strs[i] = (char*)malloc(sizeof(char)*6);
	}
	strs[0] = "hello";
	strs[1] =  "hel";
	strs[2] =  "hela";
	strs[3] = "he";
	strs[4] = "";

	printf("%s\n", longestCommonPrefix(strs, 5));
	return 0;
}