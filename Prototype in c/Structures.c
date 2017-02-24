#include <time.h>

typedef struct r
{
    int id;
    int type;             //based on the operation to perform
    int waiting_time;    //in seconds
}Terminal_info;

typedef struct dd
{
	int id;
	int terminal_no;
	char* fname;
	time_t  session_start;
	time_t  session_end;
	float cost;
}thread_pass;

typedef struct a
{
    int ID;
    int age;
    char name[50];
    char phone_no[10];
    char email_add[50];
    char address[100];
    int no_types;
    int Types[4];
    int Terminal_no[4];
    float cost[4];
    struct tm Time_date;  //arrival time
    int waiting_time;
    int duration;
    
}Customer;

typedef struct q
{
    char name[20];     //name of the owner
    int no_of_systems;
    int no_xerox;
    int no_printers;
    Terminal_info T[100];
    float rate[7];       //rate with respect to types
    int ID;
}System_info;