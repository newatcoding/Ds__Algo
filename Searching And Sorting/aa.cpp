#include<stdio.h>

int foo(){
    printf("Hello");
    return 0;
}
int bar(){
    printf("Hi");
    return 1;
}
int main(){
    int x=foo() && bar();
}