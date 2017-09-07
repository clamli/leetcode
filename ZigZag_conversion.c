# include <stdio.h>
# include <stdlib.h>

char* convert(char* s, int numRows) {
	int strLen = 0, i, loop = numRows+(numRows-2), lloop, rem, cloop = numRows-1, nloop, remain, col, lowb, value;
	char *sp = s, *news = NULL;
	int *rowa = NULL;
	for (sp; *sp != '\0'; sp++) {
		strLen++;
	}
	if (strLen < numRows || strLen == 1 || numRows == 1)
		return s;

	news = (char*)malloc(sizeof(char)*(strLen+1));
	rowa = (int*)malloc(sizeof(int)*(numRows+1));
	nloop = strLen / loop;
	remain = strLen - loop*nloop;
	col = nloop;
	if (remain >= 1) {
		col += 1;
	} 

	rowa[0] = 0;
	rowa[1] = col;
	value = 2*col - 1;
	if (remain == 0) {
		for (i = 2; i < numRows; i++) {
			rowa[i] = value + 1 + rowa[i-1];
		}
		rowa[numRows] = col + rowa[numRows-1];
	} else if (remain >= 1 && remain <= numRows) {
		for (i = 2; i <= remain; i++) {
			rowa[i] = value + rowa[i-1];
		}
		for (i; i < numRows; i++) {
			rowa[i] = value - 1 + rowa[i-1];
		}
		if (remain == numRows) {
			rowa[numRows] = col + rowa[numRows-1];
		} else {
			rowa[numRows] = col - 1 + rowa[numRows-1];
		}
	} else if (remain > numRows) {
		lowb = numRows - (remain - numRows);
		for (i = 2; i < lowb; i++) {
			rowa[i] = value + rowa[i-1];
		}
		for (i; i <= numRows-1; i++) {
			rowa[i] = value + 1 + rowa[i-1];
		}
		rowa[numRows] = col + rowa[numRows-1];
	}

	int currow = 1;
	int curcol = 1;
	for (i = 0; i < strLen; i++) {
		lloop = (i+1)/loop;
		rem = (i+1)%loop;
		if ( rem > numRows) {
			curcol = lloop * 2 + 2;
			currow = numRows-(rem-numRows);
		} else if (rem == 0) {
			if (numRows == 2)
				curcol = lloop;
			else
				curcol = lloop * 2;
			currow = 2;
		} else {
			if (rem == numRows || rem == 1)
				curcol = lloop + 1;
			else
				curcol = lloop * 2 + 1;
			currow = rem;
		}

		news[rowa[currow-1]+curcol-1] = s[i];
	}
	news[strLen] = '\0';
	return news;
}

int main()
{
	char* s = "AB";
	char* ret = convert(s, 2);
	printf("%s\n", ret);
	s = "PAYPALISHIRING";
	ret = convert(s, 3);
	printf("%s\n", ret);
	return 0;
}