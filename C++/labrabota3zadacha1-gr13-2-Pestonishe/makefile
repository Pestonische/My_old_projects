all: magicNumbers

magicNumbers: source.o magicNumbers.o
	gcc -o magicNumbers source.o magicNumbers.o

source.o: src/source.c
	gcc -c -o source.o src/source.c

magicNumbers.o: src/magicNumbers.c
	gcc -c -o magicNumbers.o src/magicNumbers.c
