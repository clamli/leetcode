# include <stdio.h>

double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
	int m, n;
	double median = 0;
	int *A, *B;
	int iMax, iMin;
	int i, j;
	int leftMax, rightMin;

	if (nums1Size >= nums2Size) {
		n = nums1Size; m = nums2Size; A = nums2; B = nums1;
	}
	else {
		n = nums2Size; m = nums1Size; A = nums1; B = nums2;
	}

	iMax = m, iMin = 0;
	while (iMax >= iMin) {
		i = (iMax + iMin) / 2;
		j = (m + n + 1) / 2 - i;
		if (i > 0 && A[i - 1] > B[j]) {
			iMax = i - 1;
		}
		else if (i < m && B[j - 1] > A[i]) {
			iMin = i + 1;
		}
		else {
			if (i == 0) {
				leftMax = B[j - 1];
			}
			else if (j == 0) {
				leftMax = A[i - 1];
			}
			else {
				if (A[i - 1] > B[j - 1]) {
					leftMax = A[i - 1];
				}
				else {
					leftMax = B[j - 1];
				}
			}
			
			if (i == m) {
				rightMin = B[j];
			}
			else if (j == n) {
				rightMin = A[i];
			}
			else{
				if (A[i] < B[j]) {
					rightMin = A[i];
				}
				else {
					rightMin = B[j];
				}	
			}

			if ((n + m) % 2 == 1) {
				median = leftMax;
			}
			else {
				median = (leftMax + rightMin) / 2.0;
			}
			break;
		}
	}

	return median;
}

int main()
{
	int arr1[2] = { 1, 2 }, arr2[2] = { 3, 4 };
	double median = findMedianSortedArrays(arr1, 2, arr2, 2);
	printf("%.1lf\n", median);
	return 0;
}