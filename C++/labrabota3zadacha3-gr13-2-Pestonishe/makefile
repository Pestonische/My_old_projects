all: consumer

consumer: source.o consumer.o
	gcc -o consumer source.o consumer.o

source.o: src/consumer.c
	gcc -c -o source.o src/source.c

consumer.o: src/consumer.c
	gcc -c -o consumer.o src/consumer.c
