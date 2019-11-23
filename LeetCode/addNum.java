#include<stdio.h>
#include<string.h>
int main()
{
	char ch[1000];
	scanf("%s",&ch);
	int arr[10]={0};
	int i;
	for(i=0;i<strlen(ch);i++){
		arr[ch[i]-'0']++;
	}
	for(i=0;i<10;i++){
		if(arr[i]){
		printf("%d:%d\n",i,arr[i]);
 	 }
   }
 } 