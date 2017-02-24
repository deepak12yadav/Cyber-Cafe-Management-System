/* 
 * File:   main.c
 * Author: Deepak Yadav
 * Rool No :15CS10012
 * Created on 13 January, 2017, 9:58 PM
 */

#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include "System_input_output.c"
#include "Customer_info.c"

/*
 * 
 */

void *session_end(void *SS)
 {
 	thread_pass *C;
 	FILE * pFile;
 	C=(thread_pass*)SS;
 	time_t Time_now;

 	while(time(NULL)<C->session_start)
 	{

 	}
   
  	pFile = fopen (C->fname,"a");
  	Time_now=time(NULL);
  	fprintf(pFile,"\n\n***********************************************************************************\n\n");
  	fprintf (pFile, "Local Time : %s  Customer ID : %d  Terminal Number : %d ----> Session Started \n", asctime(localtime(&Time_now)),C->id,C->terminal_no);
  	fprintf(pFile,"***********************************************************************************");
  	fclose (pFile);

  	while(time(NULL)<C->session_end)
 	{

 	}

 	pFile = fopen (C->fname,"a");
  	Time_now=time(NULL);
  	fprintf(pFile,"\n\n***********************************************************************************\n\n");
  	fprintf (pFile, "Local Time : %s  Customer ID : %d  Terminal Number : %d ----> Session Ended \n", asctime(localtime(&Time_now)),C->id,C->terminal_no);
  	fprintf (pFile, "Customer cost : %f \n\n",C->cost);
  	fprintf(pFile,"***********************************************************************************");
  	fclose (pFile);

 	pthread_exit(NULL);
 }

int main(int argc, char** argv) {

	System_info *S;
	pthread_t threads[NUM_THREADS];
	Customer* C;
	time_t Time;
	int a,flag=0,i=0,rc,thread_no=0;
	thread_pass *t;
    t=(thread_pass*)malloc(sizeof(thread_pass));
	S=(System_info *)malloc(sizeof(System_info));
	if(exists("System_information.bin")==1)
		S=print_sys_info();
	else {
		input_sys_info();
		S=print_sys_info();
	}


	/*#######################################################################################*/
	//The file in which the messages will be sent to the user regarding session end
	FILE *fp;
    if ((fp = fopen("Interactive_Sesson.txt","a")) == NULL)
    {
       printf("Error! opening file");
    }
    /*#######################################################################################*/
    

    while(1)
    {
		printf("\n\n\n\n\n");
		printf("****** Customer Information Page ******\n");
    	printf("\nTo enter customer information type 1 \n");
    	printf("To exit type (Remember after exiting you will not be informed of the sessions )2\n ");
    	scanf("%d",&a);

    	switch(a)
    	{
    		case 1:{

    				C=input_cutomer_info(S);
    				t->id=C->ID;
    				for(i=0;i<C->no_types;i++)
    				{
    					if(C->Types[i]>=1&&C->Types[i]<=3)
    					{
    						t->terminal_no=C->Terminal_no[i];
    						break;
    					}
    				}

    				if(C->Types[i]>=1&&C->Types[i]<=3){
    				t->fname="Interactive_Sesson.txt";
    				Time=time(NULL);
    				t->session_start=Time+C->waiting_time;
    				t->session_end=Time+C->waiting_time+C->duration;
    				t->cost=C->cost[0]+C->cost[1]+C->cost[2]+C->cost[3];
    				rc = pthread_create(&threads[thread_no], NULL, session_end, (void *)t);
    				printf("hello\n");
       				if (rc)
       				{
          				printf("ERROR; return code from pthread_create() is %d\n", rc);
          				exit(-1);
       				}
       			}
       			//printf("hello\n");
       		}
       		break;

    		case 2:flag=1;
    				break;
    		default:printf("Wrong Input !!Please try again\n");
    				break;
    	}
    	if(flag==1)
    		break;
    }

    for(i=0;i<100;i++)
    {
    	S->T[i].waiting_time=0;
    }
    if ((fp = fopen("System_information.bin","wb")) == NULL)
    {
       printf("Error! opening file");
    }
    fwrite(S , sizeof(*S) ,1, fp );
    fclose(fp);

    pthread_exit(NULL);
    return (EXIT_SUCCESS);
}

