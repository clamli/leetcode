# include <stdio.h>

int romanToInt(char* s) {
	int sum = 0;
	char *sp;

	while (*s != '\0') {
		if (*s == 'M') {
			for (; *s == 'M'; s++)
				sum += 1000;	
		} else if (*s == 'C') {
			for (; *s == 'C'; s++)
				sum += 100;       // <= 300
			if (*s == 'D') {
				sum += 300;       // == 400
				s++;
			} else if (*s == 'M') {
				sum += 800;       // == 900
				s++;
			}
		} else if (*s == 'D') {
			sum += 500;           // 800 => x >= 500
			for (s = s+1; *s == 'C'; s++)
				sum += 100;        
		} else if (*s == 'X') {
			for (; *s == 'X'; s++)
				sum += 10;       // <= 30
			if (*s == 'L') {
				sum += 30;       // == 40
				s++;
			} else if (*s == 'C') {
				sum += 80;       // == 90
				s++;
			}
		} else if (*s == 'L') {
			sum += 50;           // 8 => x >= 5
			for (s = s+1; *s == 'X'; s++)
				sum += 10;        
		} else if (*s == 'I') {
			for (; *s == 'I'; s++)
				sum += 1;       // <= 3
			if (*s == 'V') {
				sum += 3;       // == 4
				s++;
			} else if (*s == 'X') {
				sum += 8;       // == 9
				s++;
			}
		} else if (*s == 'V') {
			sum += 5;           // 8 => x >= 5
			for (s = s+1; *s == 'I'; s++)
				sum += 1;        
		}
	}
		
    return sum;
}

int main()
{
	printf("%d\n", romanToInt("MCMXCVI"));
	return 0;
}