# include <stdio.h>

char* intToRoman(int num) {
	int tnum = num, cnt = 0, ind = 0, digit[4], i, j;
	char *res = (char*)malloc(sizeof(char) * 20);
    while (tnum != 0) {
    	digit[cnt++] = tnum % 10;
    	tnum /= 10;
    }

    for (i = cnt-1; i >= 0; i--) {
    	if (i == 3) {
    		for (j = 0; j < digit[i]; j++)
    			res[ind++] = 'M';
    	} else if (i == 2) {
    		if (digit[i] <= 3)
    			for (j = 0; j < digit[i]; j++)
    				res[ind++] = 'C';
    		else if (digit[i] == 4) {
    			res[ind++] = 'C';
    			res[ind++] = 'D';
    		}
    		else if (digit[i] == 9) {
    			res[ind++] = 'C';
    			res[ind++] = 'M';
    		} 
    		else {
    			res[ind++] = 'D';
    			for (j = 5; j < digit[i]; j++) 
    				res[ind++] = 'C';
    		}
    	} else if (i == 1) {
    		if (digit[i] <= 3)
    			for (j = 0; j < digit[i]; j++)
    				res[ind++] = 'X';
    		else if (digit[i] == 4) {
    			res[ind++] = 'X';
    			res[ind++] = 'L';
    		}
    		else if (digit[i] == 9) {
    			res[ind++] = 'X';
    			res[ind++] = 'C';
    		} 
    		else {
    			res[ind++] = 'L';
    			for (j = 5; j < digit[i]; j++) 
    				res[ind++] = 'X';
    		}
    	} else if (i == 0) {
    		if (digit[i] <= 3)
    			for (j = 0; j < digit[i]; j++)
    				res[ind++] = 'I';
    		else if (digit[i] == 4) {
    			res[ind++] = 'I';
    			res[ind++] = 'V';
    		}
    		else if (digit[i] == 9) {
    			res[ind++] = 'I';
    			res[ind++] = 'X';
    		} 
    		else {
    			res[ind++] = 'V';
    			for (j = 5; j < digit[i]; j++) 
    				res[ind++] = 'I';
    		}
    	}
    }

    res[ind] = '\0';
    return res;
}

int main()
{
	printf("%s\n", intToRoman(1234));
	return 0;
}