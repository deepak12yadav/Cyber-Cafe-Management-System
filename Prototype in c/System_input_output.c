#include "Structures.c"
#include "Constants_hash_define.c"
#include<stdio.h>
#include<malloc.h>

int exists(const char *fname)
{
    FILE *file;
    if (file = fopen(fname, "r"))
    {
        fclose(file);
        return 1;
    }
    return 0;
}

void input_sys_info()
{
    System_info *S;
    Terminal_info *T;
    int i;
    S=(System_info *)malloc(sizeof(System_info));
    printf("***** Welcome to Cyber Management system *****\n\n");
    printf("Enter the name of the owner :");
    scanf(" %[^\n]s",S->name);
    printf("\nEnter no of Systems\n");
    scanf("%d",&S->no_of_systems);
    printf("\nEnter the type of the systems continuously \n");
    
    for(i=0;i<S->no_of_systems;i++)
    {
        T=(Terminal_info*)malloc(sizeof(Terminal_info));
        T->id=i+1;
        scanf("%d",&T->type);
        T->waiting_time=0;
        S->T[i]=*T;
    }
    
    printf("\nEnter the no Xerox machines\n");
    scanf("%d",&S->no_xerox);
    
    for(;i<S->no_of_systems+S->no_xerox;i++)
    {
        T=(Terminal_info*)malloc(sizeof(Terminal_info));
        T->id=i+1;
        T->type= Xerox_type;
        T->waiting_time=0;
        S->T[i]=*T;
        
    }
    
    printf("\nEnter the no of printers\n");
    scanf("%d",&S->no_printers);
    printf("\nEnter the types continuously \n");
    
    for(;i<S->no_of_systems+S->no_xerox+S->no_printers;i++)
    {
        T=(Terminal_info*)malloc(sizeof(Terminal_info));
        T->id=i+1;
        scanf("%d",&T->type);
        T->waiting_time=0;
        S->T[i]=*T;
    }
    
    printf("\nEnter rates for different types of systems , for browsing per min and for others per paper\n");
    printf("Note::Enter in ascending order of types,if you have confusion see types chart in help file\n");
    
    for(i=1;i<=6;i++)
    {
        scanf("%f",&S->rate[i]);
    }
    S->ID=1;
    
    FILE *fp;
    if ((fp = fopen("System_information.bin","wb")) == NULL)
    {
       printf("Error! opening file");
    }
    fwrite(S , sizeof(*S) ,1, fp );
    fclose(fp);
}

System_info* print_sys_info()               //return the system information 
{
    System_info *S;
    Terminal_info T;
    FILE *fp;
    int i=0;
    S=(System_info *)malloc(sizeof(System_info));
    printf("\n\n##### System Information #####\n\n");
    if ((fp = fopen("System_information.bin","rb")) == NULL)
    {
       printf("Error! opening file");
    }
    printf("\n*********IMPORTANT********\n");
    printf("Help manual is provided with the project in which description of types is present.\nIt also describes the working of the system which is necessary to use it .\nPlease refer that before proceeding.\nHappy Using \n");
    fread(S , sizeof(*S),1 , fp );
    printf("\n------------------------------\n");
    printf("Type 1 : Browsing Systems \n");
    printf("Type 2 : Gaming Systems \n");
    printf("Type 3 : Academics purpose Systems \n");
    printf("Type 4 : Plain Printer \n");
    printf("Type 5 : Colour Printer \n");
    printf("Type 6 : Simple Xerox Machine \n");
    printf("------------------------------\n");
    printf("\nOwner Name :: %s",S->name);
    printf("\nNo of systems ::%d\n",S->no_of_systems);
    
    for(;i<S->no_of_systems;i++)
    {
        T=S->T[i];
        printf("Id :%d\tType :%d\n",T.id,T.type);   
    }
    
    printf("\nNo of xerox machines ::%d\n",S->no_xerox);
    
    for(;i<S->no_of_systems+S->no_xerox;i++)
    {
        T=S->T[i];
        printf("Id :%d\tType :%d\n",T.id,T.type);
    }
    
    printf("\nNo of printers ::%d\n",S->no_printers);
    
    for(;i<S->no_of_systems+S->no_xerox+S->no_printers;i++)
    {
        T=S->T[i];
        printf("Id :%d\tType :%d\n",T.id,T.type);   
    }
    
    printf("\nRates for different types of systems , for browsing per min and for others per paper\n");
    printf("Note::For better clarification see types chart\n");
    
    for(i=1;i<=6;i++)
    {
        printf("\nType %d : %f",i,S->rate[i]);
    }
    
    fclose(fp);
    return S;
}

System_info * create_text_file_sys_info()
{
	System_info *S;
    Terminal_info T;
    FILE *fp;
    int i=0;
    S=(System_info *)malloc(sizeof(System_info));
    if ((fp = fopen("System_information.bin","rb")) == NULL)
    {
       printf("Error! opening file");
    }
    fprintf(fp,"\n\n##### System Information #####\n\n");
    fread(S , sizeof(*S),1 , fp );
    fprintf(fp,"\nOwner Name :: %s",S->name);
    fprintf(fp,"\nNo of systems ::%d\n",S->no_of_systems);
    
    for(;i<S->no_of_systems;i++)
    {
        T=S->T[i];
        fprintf(fp,"Id :%d\tType :%d\n",T.id,T.type);   
    }
    
    fprintf(fp,"\nNo of xerox machines ::%d\n",S->no_xerox);
    
    for(;i<S->no_of_systems+S->no_xerox;i++)
    {
        T=S->T[i];
        fprintf(fp,"Id :%d\tType :%d\n",T.id,T.type);
    }
    
    fprintf(fp,"\nNo of printers ::%d\n",S->no_printers);
    
    for(;i<S->no_of_systems+S->no_xerox+S->no_printers;i++)
    {
        T=S->T[i];
        fprintf(fp,"Id :%d\tType :%d\n",T.id,T.type);   
    }
    
    fprintf(fp,"\nRates for different types of systems , for browsing per min and for others per paper\n");

    for(i=1;i<=6;i++)
    {
        fprintf(fp,"Type %d : %f",i,S->rate[i]);
    }
    
    fclose(fp);
    return S;
}

