# include <stdio.h>
# include <stdlib.h>

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** letterCombinations(char* digits, int* returnSize) {
    int i, j, k, upper, size = 0, retind = 0, curind = 0, ind, indrec = 0;
	char ch[10][5] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	char *tmp = digits, **ret = NULL, **tmpr;

    //memset(indrec, 0, sizeof(int)*10);
   /* for (i = 2; i <= 9; i++)
    {
    	if (i == 7 || i == 9)
    		upper = 4;
    	else
    		upper = 3;
    	for (j = 0; j < upper; j++) {
    		ch[i][j] = 'a' + (i-2)*3 + j;
    	}
    }*/

    if (*digits == '\0') {
    	*returnSize = 0;
    	return ret;
    }

    *returnSize = 1;
    for (tmp; *tmp != '\0'; tmp++) {
    	size++;
		if (*tmp == '7' || *tmp == '9')
    		*returnSize *= 4;
		else
			*returnSize *= 3;
    }

    ret = (char**)malloc(sizeof(char*)*(*returnSize));
	tmpr = (char**)malloc(sizeof(char*)*(*returnSize));
	for (i = 0; i < *returnSize; i++) {
		ret[i] = (char*)malloc(sizeof(char)*size);
		tmpr[i] = (char*)malloc(sizeof(char)*size);
	}
    for (i = 0; i < size; i++) {
    	ind = digits[i] - '0';
    	if (ind == 7 || ind == 9)
    		upper = 4;
    	else
    		upper = 3;
    	for (j = 0; j < upper; j++) {
			if (retind == 0) {
				tmpr[curind][indrec] = ch[ind][j];
				tmpr[curind++][indrec+1] = '\0';
			}		
    		for (k = 0; k < retind; k++) {
    			strcpy(tmpr[curind], ret[k]);
    			tmpr[curind][indrec] = ch[ind][j];
    			tmpr[curind][indrec+1] = '\0'; 
    			curind++;
    		}
    	}
    	retind = curind;
    	indrec++;
    	for (j = 0; j < curind; j++) 
    		strcpy(ret[j], tmpr[j]);
    	curind = 0;
    }

    return ret;
}

int main()
{
	int i, *size = (int*)malloc(sizeof(int));
	char** out = letterCombinations("8", size);
	for (i = 0; i < *size; i++)
		printf("%s\n", out[i]);
	return 0;
}

