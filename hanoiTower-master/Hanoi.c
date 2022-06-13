/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   main.c
 * Author: stelios
 *
 * Created on 13 ��������� 2016, 1:45 ��
 */

#include <stdio.h>
#include <stdlib.h>

/*
 *
 */
int main(int argc, char** argv) {
    int i;

    printf("Give me the number of the rings: ");
    scanf("%d", &i);
    printf("The sequence of moves involved in the Tower of Hanoi are :\n");
    towers(i, 'A', 'C', 'B');

}

void towers(int i, char from, char to, char using) {
    if (i == 1) {
        printf("\n Move disk 1 from  %c to  %c", from, to);
        return;
    }
    towers(i - 1, from, using, to);
    printf("\n Move disk %d from  %c to  %c", i, from, to);
    towers(i - 1, using, to, from);
}
