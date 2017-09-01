/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
# include <stdio.h>
# include <stdlib.h>



struct ListNode {
	int val;
	struct ListNode *next;
};

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
   	int num1 = 0, num2 = 0, flag = 0, digit;
    struct ListNode* retL;
    struct ListNode* curP = NULL;

    do {
    	if (l1 != NULL)
    		num1 = l1->val;
    	if (l2 != NULL)
    		num2 = l2->val;

    	digit = (num1+num2+flag) % 10;
    	flag = (num1+num2+flag) / 10;
    	if (curP == NULL) {
    		curP = (struct ListNode*)malloc(sizeof(struct ListNode));
    		retL = curP;
    		curP->val = digit;
    		curP->next = NULL;
    	} else {
    		curP->next = (struct ListNode*)malloc(sizeof(struct ListNode));
    		curP->next->val = digit;
    		curP->next->next = NULL;
    		curP = curP->next;
    	}

    	if (l1 != NULL)
    		l1 = l1->next;
    	if (l2 != NULL)
    		l2 = l2->next;

    	num1 = 0; num2 = 0;
    } while (!(l1 == NULL && l2 == NULL));

    if (flag != 0) {
    	curP->next = (struct ListNode*)malloc(sizeof(struct ListNode));
    	curP->next->val = flag;
    	curP->next->next = NULL;
    }

    return retL;
}

int main()
{
	struct ListNode* l1 = (struct ListNode*)malloc(sizeof(struct ListNode));
	struct ListNode* l2 = (struct ListNode*)malloc(sizeof(struct ListNode));
	struct ListNode* res;

	l1->val = 2;
	l1->next = (struct ListNode*)malloc(sizeof(struct ListNode));
	l1->next->val = 4;
	l1->next->next = (struct ListNode*)malloc(sizeof(struct ListNode));
	l1->next->next->val = 3;
	l1->next->next->next = NULL;

	l2->val = 5;
	l2->next = (struct ListNode*)malloc(sizeof(struct ListNode));
	l2->next->val = 6;
	l2->next->next = (struct ListNode*)malloc(sizeof(struct ListNode));
	l2->next->next->val = 4;
	l2->next->next->next = NULL;

	res = addTwoNumbers(l1, l2);

	while (res->next != NULL) {
		printf("%d->", res->val);
		res = res->next;
	}
	printf("%d\n", res->val);

	return 0;
}