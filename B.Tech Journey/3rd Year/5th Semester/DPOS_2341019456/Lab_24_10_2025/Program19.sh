#!/bin/bash
read -p "Enter a single character: " ch
case $ch in
	[aAeEiIoOuU]) echo "$ch is a vowel" ;;
	*) echo "$ch is a consonant" ;;
esac

