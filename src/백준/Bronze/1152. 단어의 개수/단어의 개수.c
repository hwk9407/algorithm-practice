#include <stdio.h>

int main() {
	char ch1, ch2='\0';
	int wordCount=0;


	while (1) {
		ch1 = getchar();

		if (ch1 == ' ' && ch2 == '\0') {			// 첫 문자열 공백
			ch2 = 0;
		}
		else if (ch1 == '\n' && ch2 == ' ') {	// 문자열 끝 공백
			break;
		}
		else if (ch1 == '\n' && ch2 != '\0') {
			wordCount++;
			break;
		}
		else if (ch1 == ' ' && ch2 != '\0') {
			wordCount++;
			ch2 = ch1;
		}
		else if (ch1 != 10){
			ch2 = ch1;
		}
		else if (ch1 == '\n' && ch2 == '\0') {
			break;
		}
	}
	printf("%d\n", wordCount);
	return 0;
}