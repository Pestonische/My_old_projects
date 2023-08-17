#define FUSE_USE_VERSION 30
#define _FILE_OFFSET_BITS 64


#include <stdbool.h>
#include <fuse.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <fcntl.h>

#define N 68
#define example_txt "Hello world! Student Alexei Kozunov,1923383"
#define readme_txt "Student Kozunov Alexei,1923383"
#define str_txt "Some information"

char system_path[256] = "";
char test_txt[N][100];

bool isFoo = true, isBin = true, isBaz = true, isBar = true;

static int get_att(const char* path, struct stat *st)
{
	memset(st, 0, sizeof(struct stat));

	if(strcmp(path,"/") == 0)
	{
		st->st_mode = S_IFDIR | 0755;
	}
	else if(strcmp(path, "/bin") == 0 && isBin)
	{
		st->st_mode = S_IFDIR | 755;
	}
	else if(strcmp(path, "/foo") == 0 && isFoo)
	{
		st->st_mode = S_IFDIR | 665;
	}
	else if(strcmp(path, "/bin/bar") == 0 && isBar)
	{
		st->st_mode = S_IFDIR | 777;
	}
	else if(strcmp(path, "/bin/baz") == 0 && isBaz)
	{
		st->st_mode = S_IFDIR | 744;
	}
	else if(strcmp(path, "/bin/baz/readme.txt") == 0 && isBaz)
	{
		st->st_mode = S_IFREG | 444;
		st->st_size = strlen(readme_txt);
	}
	else if(strcmp(path, "/bin/baz/example") == 0 && isBaz)
	{
		st->st_mode = S_IFREG | 200;
		st->st_size = strlen(example_txt);
	}
	else if(strcmp(path,"/bin/baz/cat") == 0 && isBaz)
	{
		st->st_mode = S_IFREG | 677;

		struct stat buffer;
		stat("/usr/bin/cat",&buffer);

		st->st_size = buffer.st_size;
	}
	else if(strcmp(path,"/foo/test.txt") == 0 && isFoo) 
	{
		st->st_mode = S_IFREG | 556;

		st->st_size = 0;
		for(int i = 0;i<N;i++)
		{
			st->st_size += strlen(test_txt[i])+1;
		}
	}
	else
	{
		return -ENOENT;
	}
	return 0;
}

static int read_directory(const char* path, void* buf, fuse_fill_dir_t filler, off_t offset, struct fuse_file_info * fi)
{
	filler(buf,".",NULL,0);
	filler(buf,"..",NULL,0);

	if(strcmp(path,"/") == 0)
	{
		filler(buf,"bin",NULL,0);
		filler(buf,"foo",NULL,0);
		if(strcmp(system_path,"/mnt/fuse/")!=0)
		{
			filler(buf, system_path+1,NULL,0);
		}
		return 0;
	}
	else if(strcmp(path,"/bin") == 0 && isBin)
	{
		filler(buf,"bar",NULL,0);
		filler(buf,"baz",NULL,0);
		return 0;
	}
	else if(strcmp(path,"/bin/bar") == 0 && isBar)
	{		
		return 0;
	}
	else if(strcmp(path,"/bin/baz") == 0 && isBaz)
	{
		filler(buf,"example",NULL,0);
		filler(buf,"readme.txt",NULL,0);
		filler(buf,"cat",NULL,0);
		return 0;
	}
	else if (strcmp(path,"/foo") == 0 && isFoo)
	{
		filler(buf,"test.txt",NULL,0);
		return 0;
	}
	return -ENOENT;
}

static int read_file(const char* path, char* buf, size_t size,off_t offset, struct fuse_file_info* fi)
{
	size_t length;
	char* read_data;

	if(strcmp(path,"/bin/baz/readme.txt") == 0)
	{
		length = strlen(readme_txt);
		read_data = readme_txt;
	}
	else if(strcmp(path,"/bin/baz/example") == 0)
	{
		length = strlen(example_txt);
		read_data = example_txt;
	}
	else if(strcmp(path,"/bin/baz/cat") == 0)
	{
		struct stat touch_stat;
		stat("/usr/bin/cat",&touch_stat);
		length = touch_stat.st_size;
		
		FILE* f = fopen("/usr/bin/cat","rb");
		unsigned char buffer[length];
		fread(buffer,length,1,f);
		read_data = buffer;
		fclose(f);
	}
	else if(strcmp(path,"/foo/test.txt") == 0)
	{
		char temp[N*50+400];
		strcpy(temp,"");
		for(int i = 0;i<N;i++){
			strcat(temp,test_txt[i]);
			strcat(temp,"\n");
		}
		length = strlen(temp);
		read_data = temp;
	}
	else
	{
		return -ENOENT;
	}


	if(offset < length)
	{
		if(offset + size > length)
		{
			size = length-offset;
		}
		memcpy(buf, read_data + offset, size);
		return size;
	}

	return 0;
}

static int remove_directory(const char* path)
{
	if(strcmp(path,"/bin/baz") == 0)
	{
		isBaz = false;
	}
	else if(strcmp(path,"/bin/bar") == 0)
	{
		isBar = false;
	}
	else if(strcmp(path,"/bin") == 0)
	{
		isBar = false;
		isBaz = false;
		isBin = false;
	}
	else if(strcmp(path,"/foo") == 0)
	{
		isFoo = false;
	}
	else
	{
		return -ENOENT;
	}
}

static struct fuse_operations operations = {
		.getattr = get_att,
		.readdir = read_directory,
		.rmdir = remove_directory,
		.read = read_file,
};

int main(int argc, char** argv)
{
	strcpy(system_path,argv[1]);

	char number_line[8];
	for(int i = 0; i<N ; i++)
	{
		strcat(test_txt[i], str_txt);
	}

	return fuse_main(argc,argv,&operations,NULL);
}