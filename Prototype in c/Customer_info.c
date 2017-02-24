#include <time.h>
#include <stdio.h>

Customer* input_cutomer_info(System_info *S)
{
    Customer *C;
    FILE *fp;
    int i=0;
    int in;
    time_t t = time(NULL);
    C=(Customer*)malloc(sizeof(Customer));
    C->ID=S->ID;
    S->ID++;
    printf("\n####Customer Information Input####\n");
    printf("\nName ::");
    scanf(" %[^\n]s",C->name);
    printf("\nAge ::");
    scanf(" %d",&C->age);
    printf("\nEmail address ::");
    scanf(" %s",C->email_add);
    printf("\nAddress ::");
    scanf(" %[^\n]s",C->address);
    C->Time_date = *localtime(&t);


    /*Writting the customer information in the txt file ***************************************/

    if ((fp = fopen("Customers_information.txt","a")) == NULL)
    {
       printf("Error! opening file");
    }
    fprintf(fp,"\n\n**************************************************");
    fprintf(fp,"\nID ::%d",C->ID);
    fprintf(fp ,"\nTime: %s", asctime(localtime(&t)));
    fprintf(fp,"\nName ::%s",C->name);
    fprintf(fp,"\nAge ::%d",C->age);
    fprintf(fp,"\nPhone No ::%s",C->phone_no);
    fprintf(fp,"\nEmail Adress ::%s",C->email_add);
    fprintf(fp,"\nAddress ::%s",C->address);


    for(i=0;i<4;i++)
    {
    	C->cost[i]=0;
    }
    printf("\nEnter number of types (How many types of machines like printer,xerox,systems customer want to use (total 6 types are available):");
    scanf("%d",&C->no_types);

    
    for(i=0;i<C->no_types;i++)
    {
        printf("\nEnter type :");
        scanf("%d",&C->Types[i]);
        if(C->Types[i]>=1 && C->Types[i]<=3)
        {
            int min=0;
            int id;
            int j;
            for( j=0;j<S->no_of_systems;j++)
            {
                if(S->T[j].type==C->Types[i]&&S->T[j].waiting_time<=min)
                {
                    min=S->T[j].waiting_time;
                    id=S->T[j].id;
                }
            }
            printf("\nEnter duration in minutes :");
            scanf("%d",&in);
            C->cost[i]=in*S->rate[C->Types[i]];
            C->Terminal_no[i]=id;
            S->T[j].waiting_time+=(in*60+EXIT_TIME);
            C->waiting_time=min;
            C->duration=in*60;
            printf(" \nCustomer is alloted Terminal no :%d with waiting time in min %f",id,min*1.0/60);
            fprintf(fp ,"\nCustomer is alloted Terminal no :%d with waiting time in min %f",id,min*1.0/60);
        }
        else if(C->Types[i]==4||C->Types[i]==5)
        {
            int j=S->no_of_systems+S->no_xerox;
            int id;
            for( j=0;j<S->no_of_systems+S->no_xerox+S->no_printers;j++)
            {
                if(S->T[j].type==C->Types[i])
                {
                    id=S->T[j].id;
                }
            }
            printf("\nEnter no of prints :");
            scanf("%d",&in);
            C->cost[i]=in*S->rate[C->Types[i]];
            printf(" \nCustomer is alloted Terminal no :%d for printing",id);
            fprintf(fp ,"\nCustomer is alloted Terminal no :%d for printing",id);
        }
        else
        {
            int id=rand() % (S->no_of_systems+S->no_xerox + 1 - S->no_of_systems+1) + S->no_of_systems+1;
            printf("\nEnter no of xerox :");
            scanf("%d",&in);
            C->cost[i]=in*S->rate[C->Types[i]];
            C->Terminal_no[i]=id;
            printf(" \nCustomer is alloted Terminal no :%d for xerox",id);
            fprintf(fp ,"\nCustomer is alloted Terminal no :%d for xerox",id);
        }
        
    }
    printf("\nCUSTOMER COST ::%f\n",C->cost[0]+C->cost[1]+C->cost[2]+C->cost[3]);
    fprintf(fp ,"\nCUSTOMER COST ::%f\n",C->cost[0]+C->cost[1]+C->cost[2]+C->cost[3]);
    fclose(fp);
  
    if ((fp = fopen("Customers_information.bin","ab")) == NULL)
    {
       printf("Error! opening file");
    }
    fwrite(C , sizeof(*C) ,1, fp );
    fclose(fp);

    return C;
    
}
