/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdio.h>
#include <stdlib.h>
int* twoSum(int* nums, int numsSize, int target) {
    int i, j;
    int flag = 0;
    for (i=0; i<numsSize-1; i++) {
        for (j=i+1; j<numsSize; j++) {
            if(nums[i]+nums[j] == target) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            break;
        }
    }
    int* p = (int*)malloc(sizeof(int)*2);
    p[0] = i;
    p[1] = j;
    return p;
}

int main()
{
    int arr[4] = {2, 7, 11, 15};
    int size = 4;
    int target = 9;
    int* p = twoSum(arr, size, target);
    printf("(%d %d)\n", p[0], p[1]);
    return 0;
}
