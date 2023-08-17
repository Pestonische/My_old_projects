all: students

students: source.o students.o
	gcc -o students source.o students.o

source.o: src/source.c
	gcc -c -o source.o src/source.c

students.o: src/students.c
	gcc -c -o students.o src/students.c
