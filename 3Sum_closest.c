/**
 * Return an array of arrays of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdio.h>
#include <stdlib.h>

int left(int i)
{
	return 2 * i + 1;
}

int right(int i)
{
	return 2 * i + 2;
}

void swap(int* pa, int* pb)
{
	if (*pa != *pb)
	{
		*pa += *pb;
		*pb = *pa - *pb;
		*pa = *pa - *pb;
	}
}

void heap_maxify(int* base, int inx, int size)
{
	int largest = 0;
	int l = 0;
	int r = 0;
	while (1) {
		l = left(inx);
		r = right(inx);
		if (l < size && base[inx] < base[l])
			largest = l;
		else
			largest = inx;
		if (r < size && base[largest] < base[r])
			largest = r;

		if (largest != inx) {
			swap(base + inx, base + largest);
			inx = largest;
		}
		else
			break;
	}
}

void build_heap(int* base, int len)
{
	int i;
	for (i = len / 2 - 1; i >= 0; i--)
		heap_maxify(base, i, len);
}

void heap_sort(int* base, int len)
{
	int i;
	if (base == NULL || len == 0)
		return;
	build_heap(base, len);
	for (i = len - 1; i >= 0; i--) {
		swap(base, base + i);
		heap_maxify(base, 0, i);
	}
}


int threeSumClosest(int* nums, int numsSize, int target) {
	int i, front, rear, sum, minval = 50000, red, minsum, j, k, upper = numsSize - 1;

	heap_sort(nums, numsSize);

	for (i = 0; i < numsSize - 2; i++) {
		if (i != 0 && nums[i] == nums[i - 1])
			continue;

		// method 1: slow
		/*for (j = i + 1; j < upper; j++) {
			for (k = j + 1; k < numsSize; k++) {
				sum = nums[i] + nums[j] + nums[k];
				red = sum - target;
				if (red >= 0) {
					if (red < minval) {
						minval = red;
						minsum = sum;
					}
					upper = k;
					break;
				}
				else {
					if (-red < minval) {
						minval = -red;
						minsum = sum;
					}
				}
			}
		}*/

		// method 2: fast
		front = i + 1;
		rear = numsSize - 1;

		while (front < rear) {
			sum = nums[i] + nums[front] + nums[rear];
			red = sum - target;

			if (red < 0) {
				if ((-red) < minval) {
					minval = -red;
					minsum = sum;			
				}
				front++;
				while (front < rear && nums[front] == nums[front - 1])
					front++;
			}
			else if (red >= 0) {
				if (red < minval) {
					minval = red;
					minsum = sum;
				}
				rear--;
				while (rear > front && nums[rear] == nums[rear + 1])
					rear--;
			}
		}
	}

	return minsum;
}

int main()
{
	int arr[3] = {0,1,2};
	int sum = threeSumClosest(arr, 3, 3);
	printf("%d\n", sum);
	return 0;
}