# include <stdio.h>

int maxArea(int* height, int heightSize) {
	int maxcon = 0, contain, i = 0, j = heightSize - 1, len;
    while (i < j) {
    	if (height[i] > height[j]) {
            len = height[j];
            contain = height[j]*(j-i);
            do {
    		  j--;
            } while (height[j] <= len);
    	} else {
            len = height[i];
    		contain = height[i]*(j-i);
    		do {
                i++;
            } while (height[i] <= len);
    	}
    	
    	if(maxcon < contain)
    		maxcon = contain;
    }

    return maxcon;
}

int main()
{
	int height[4] = {1,2,4,3};
	printf("%d\n", maxArea(height, 4));
	return 0;
}