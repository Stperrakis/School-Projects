#!/bin/bash

#This is a Scricpt that telling us , if a password is strong under given circumstances

echo "Enter a Password: " 	#printing a message 
read input 	#read input

length="${#input}" #storring the length
a=0 # This is an indicator that holds the number of tests that the password will pass

if [ "$length" -lt 10 ] ; then #if it's less than 10 the length of the entry 
	echo "The length of the Password is lower than 10." #print a message where entry fails
	else ((a++)) #increasing the value of the failed tests
fi


if echo "$input" | grep -q '[0-9]' #if the password has digits
	then ((a++))	#then increase the failed tests
	else echo "No digits - weak Password."
fi


if echo "$input" | grep -q '[a-z]'  #if the password has lower case letters
	then ((a++))
	else echo "No lower-case letters."
fi


if echo "$input" | grep -q '[A-Z]' #if the password has upper case letters
	then ((a++))
	else echo "No Upper-case letters."
fi

if [ "$a" -lt 4 ] ; then #a is a lower than 4 that means somewhere has failed to be strong as password
	echo "Try fix the above , your Password, it might be stronger."
	else echo "This is a strong Password!"
fi