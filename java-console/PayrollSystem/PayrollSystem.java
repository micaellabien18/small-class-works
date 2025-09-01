import java.io.*;
import java.util.*;
public class PayrollSystem {
	public static void main(String[]args) throws IOException{

String id1="1001",lname1="Rizal",fname1="Jose",mname1="A",position1="Manager",department="IT",sstatus="Single";
double deductions,totalincome1,overtime1,overhrs1,hrspay=350,monthsal1=99840,allo1=4500,houseloan,carloan,totalloan,grosspay=0,
       numworks=192,late,abse,absehrs=8,absetot,tothrs,rate1=520,totincome,minuteded=50,minute=1,minut=0,
       hourded=150,hour,totalhrs,tax,SSS,PH,PGBG,netpay;
int undertime,undertot,underhrs=4;
char ans;

String id2="1002",lname2="Bonifacio",fname2="Andres",mname2="C",position2="Assistant Manager";
double totalincome2,overtime2,overhrs2,monthsal2=86400,allo2=2500,rate2=450;

String id3="1003",lname3="Santos",fname3="Sophia",mname3="S",position3="Secretary",mstatus="Married";
double totalincome3,overtime3,overhrs3,monthsal3=67200,allo3=1500,rate3=350;

String id4="1004",lname4="Alawi",fname4="Ivana",mname4="S",position4="Assistant Secretary",wstatus="Widow";
double totalincome4,overtime4,overhrs4,monthsal4=57600,allo4=1000,rate4=300;

int sel, EmpNum;

Scanner in=new Scanner(System.in);

do{
System.out.println("-------------------------------------------------------");
System.out.println("            TAGUIG CITY Payroll System 101");
System.out.println("------------------------------------------------------");
System.out.println("------------------------------------------------------");
System.out.println("-----------------------------------------------------------------------------------------------------------------------");
System.out.println("|          |                      |                 |            |        |         |            |       Official     |");
System.out.println("| Employee |                      |                 |            |  Rate/ | Monthly |            |    Time = 8hours   |");
System.out.println("|  Number  |    Employee Name     |    Position     | Department |  Hour  | Salary  | Allowances |                    |");
System.out.println("|          |                      |                 |            |        |         |            | Overtime Exceeding |");
System.out.println("|          |                      |                 |            |        |         |            |     1 hour=P350    |");
System.out.println(" ---------------------------------------------------------------------------------------------------------------------");
System.out.println("|   1001   |     Jose Rizal A     |     Manager     |     IT     |  520   | 99,840  |   4,500    |                    |");
System.out.println("|   1002   |  Andres Bonifacio C  |  Asst. Manager  |     IT     |  450   | 86,400  |   2,500    |                    |");
System.out.println("|   1003   |     Sophia Santos S      |    Secretary    |     IT     |  350   | 67,200  |   1,500    |                    |");
System.out.println("|   1004   |    Ivana Alawi S     | Asst. Secretary |     IT     |  300   | 57,600  |   1,000    |                    |");
System.out.println("-----------------------------------------------------------------------------------------------------------------------");

System.out.println("\nEnter Employee's Data\n");

System.out.print("Employee Number :");
EmpNum=in.nextInt();
switch (EmpNum){
case 1001 :
    System.out.println("Last Name       :"+lname1);
    System.out.println("First Name      :"+fname1);
    System.out.println("Middle Name     :"+mname1);
    System.out.println("Position        :"+position1);
    System.out.println("Department      :"+department);
    System.out.println("Status          :"+sstatus);
    System.out.println("Monthly Salary  :P"+monthsal1);
    System.out.println("Allowances      :P"+allo1);
    System.out.print("Overtime        :");
overhrs1=in.nextDouble();
overtime1=overhrs1*hrspay;
       System.out.println("OvertimePay	:P"+overtime1);
totalincome1=monthsal1 + allo1 + overtime1;
        System.out.println("TOTAL INCOME    :P"+totalincome1);

System.out.println("\n------------------------------------------------------");
System.out.println("                 D E D U C T I O N S                   ");
System.out.println("------------------------------------------------------");
        System.out.println("Number of Works  :"+numworks);
	System.out.print("Late(Hour)       :");
hour=in.nextDouble();
totalhrs=hour*hourded;
	System.out.print("Late(Minutes)    :");
minute=in.nextDouble();
if(minute>=1 && minute<=55) {
	minute=minuteded;
}
else if(minute==0){
	minute=minut;
}
late=minute+totalhrs;
	System.out.print("Absences         :");
abse=in.nextDouble();
absetot=absehrs*abse;
	System.out.print("Undertime        :");
undertime=in.nextInt();
undertot=undertime*underhrs;
tothrs=numworks-undertot-absetot-hour;
	System.out.println("Total Hours      :"+tothrs);
	System.out.println("Rate             :P"+rate1);
	totincome=tothrs*rate1+allo1+overtime1-late;
	System.out.println("Total Income     :P"+totincome);

System.out.print("\nSpecify Tax Bracket\n");
System.out.print("[1]Single\n[2]Married\n[3]Widow");

System.out.print("\nEnter Bracket   :");

sel=in.nextInt();
if(sel==1)
{
tax= totincome*.20;
SSS= totincome*0.07;
PGBG= totincome*0.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}

else if(sel==2)
{
tax= totincome*.10;
SSS= totincome*0.03;
PGBG= totincome*0.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}
else
{
tax= totincome*.08;
SSS= totincome*.02;
PGBG= totincome*.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}

System.out.println("\n------------------------------------------------------");
System.out.println("                    PAYROLL SLIP                      ");
System.out.println("------------------------------------------------------");
System.out.println("Employee Number :"+id1);
System.out.println("Last Name       :"+lname1);
System.out.println("First Name      :"+fname1);
System.out.println("Middle Name     :"+mname1);
System.out.println("Position        :"+position1);
System.out.println("Department      :"+department);
System.out.println("Status          :"+sstatus);
System.out.print("\n    Monthly Salary  :P"+monthsal1);
System.out.print("\n    Allowances      :P"+allo1);
System.out.print("\n    Overtime        :P"+overtime1);
System.out.print("\n    Total Income    :P"+totincome);

System.out.print("\n\n    TAX             :P"+tax);
System.out.print("\n    SSS             :P"+SSS);
System.out.print("\n    Pag-IBIG        :P"+PGBG);
System.out.print("\n    PhilHealth      :P"+PH);
System.out.print("\n    Total Deduction :P"+deductions);

System.out.println("\n\n    Others");
System.out.print("    House Loan      :P");
houseloan=in.nextDouble();
System.out.print("    Car Loan        :P");
carloan=in.nextDouble();
totalloan=houseloan+carloan;
System.out.print("    Total Loan      :P"+totalloan);
grosspay= totincome - deductions;
System.out.print("\n\n TOTAL GROSS PAY    :P"+grosspay);
netpay=grosspay-totalloan;
System.out.print("\n TOTAL NET PAY      :P"+netpay);
break;

case 1002 :
    System.out.println("Last Name       :"+lname2);
    System.out.println("First Name      :"+fname2);
    System.out.println("Middle Name     :"+mname2);
    System.out.println("Position        :"+position2);
    System.out.println("Department      :"+department);
    System.out.println("Status          :"+sstatus);
    System.out.println("Monthly Salary  :P"+monthsal2);
    System.out.println("Allowances      :P"+allo2);
    System.out.print("Overtime        :");
overhrs2=in.nextDouble();
overtime2=overhrs2*hrspay;
       System.out.println("OvertimePay	:P"+overtime2);
totalincome2=monthsal2 + allo2 + overtime2;
        System.out.println("TOTAL INCOME    :P"+totalincome2);

System.out.println("\n------------------------------------------------------");
System.out.println("                 D E D U C T I O N S                   ");
System.out.println("------------------------------------------------------");
        System.out.println("Number of Works  :"+numworks);
	System.out.print("Late(Hour)       :");
hour=in.nextDouble();
totalhrs=hour*hourded;
	System.out.print("Late(Minutes)    :");
minute=in.nextDouble();
if(minute>=1 && minute<=55) {
	minute=minuteded;
}
else if(minute==0){
	minute=minut;
}
late=minute+totalhrs;
	System.out.print("Absences         :");
abse=in.nextDouble();
absetot=absehrs*abse;
	System.out.print("Undertime        :");
undertime=in.nextInt();
undertot=undertime*underhrs;
tothrs=numworks-undertot-absetot-hour;
	System.out.println("Total Hours      :"+tothrs);
	System.out.println("Rate             :P"+rate2);
	totincome=tothrs*rate2+allo2+overtime2-late;
	System.out.println("Total Income     :P"+totincome);

System.out.print("\nSpecify Tax Bracket\n");
System.out.print("[1]Single\n[2]Married\n[3]Widow");

System.out.print("\nEnter Bracket   :");

sel=in.nextInt();
if(sel==1)
{
tax= totincome*.20;
SSS= totincome*0.07;
PGBG= totincome*0.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}

else if(sel==2)
{
tax= totincome*.10;
SSS= totincome*0.03;
PGBG= totincome*0.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}
else
{
tax= totincome*.08;
SSS= totincome*.02;
PGBG= totincome*.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}

System.out.println("\n------------------------------------------------------");
System.out.println("                    PAYROLL SLIP                      ");
System.out.println("------------------------------------------------------");
System.out.println("Employee Number :"+id2);
System.out.println("Last Name       :"+lname2);
System.out.println("First Name      :"+fname2);
System.out.println("Middle Name     :"+mname2);
System.out.println("Position        :"+position2);
System.out.println("Department      :"+department);
System.out.println("Status          :"+sstatus);
System.out.print("\n    Monthly Salary  :P"+monthsal2);
System.out.print("\n    Allowances      :P"+allo2);
System.out.print("\n    Overtime        :P"+overtime2);
System.out.print("\n    Total Income    :P"+totincome);

System.out.print("\n\n    TAX             :P"+tax);
System.out.print("\n    SSS             :P"+SSS);
System.out.print("\n    Pag-IBIG        :P"+PGBG);
System.out.print("\n    PhilHealth      :P"+PH);
System.out.print("\n    Total Deduction :P"+deductions);

System.out.println("\n\n    Others");
System.out.print("    House Loan      :P");
houseloan=in.nextDouble();
System.out.print("    Car Loan        :P");
carloan=in.nextDouble();
totalloan=houseloan+carloan;
System.out.print("    Total Loan      :P"+totalloan);
grosspay= totincome - deductions;
System.out.print("\n\n TOTAL GROSS PAY    :P"+grosspay);
netpay=grosspay-totalloan;
System.out.print("\n TOTAL NET PAY      :P"+netpay);
break;

case 1003 :
    System.out.println("Last Name       :"+lname3);
    System.out.println("First Name      :"+fname3);
    System.out.println("Middle Name     :"+mname3);
    System.out.println("Position        :"+position3);
    System.out.println("Department      :"+department);
    System.out.println("Status          :"+wstatus);
    System.out.println("Monthly Salary  :P"+monthsal3);
    System.out.println("Allowances      :P"+allo3);
    System.out.print("Overtime        :");
overhrs3=in.nextDouble();
overtime3=overhrs3*hrspay;
       System.out.println("OvertimePay	:P"+overtime3);
totalincome3=monthsal3 + allo3 + overtime3;
        System.out.println("TOTAL INCOME    :P"+totalincome3);

System.out.println("\n------------------------------------------------------");
System.out.println("                 D E D U C T I O N S                   ");
System.out.println("------------------------------------------------------");
        System.out.println("Number of Works  :"+numworks);
	System.out.print("Late(Hour)       :");
hour=in.nextDouble();
totalhrs=hour*hourded;
	System.out.print("Late(Minutes)    :");
minute=in.nextDouble();
if(minute>=1 && minute<=55) {
	minute=minuteded;
}
else if(minute==0){
	minute=minut;
}
late=minute+totalhrs;
	System.out.print("Absences         :");
abse=in.nextDouble();
absetot=absehrs*abse;
	System.out.print("Undertime        :");
undertime=in.nextInt();
undertot=undertime*underhrs;
tothrs=numworks-undertot-absetot-hour;
	System.out.println("Total Hours      :"+tothrs);
	System.out.println("Rate             :P"+rate3);
	totincome=tothrs*rate3+allo3+overtime3-late;
	System.out.println("Total Income     :P"+totincome);

System.out.print("\nSpecify Tax Bracket\n");
System.out.print("[1]Single\n[2]Married\n[3]Widow");

System.out.print("\nEnter Bracket   :");

sel=in.nextInt();
if(sel==1)
{
tax= totincome*.20;
SSS= totincome*0.07;
PGBG= totincome*0.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}

else if(sel==2)
{
tax= totincome*.10;
SSS= totincome*0.03;
PGBG= totincome*0.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}
else
{
tax= totincome*.08;
SSS= totincome*.02;
PGBG= totincome*.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}

System.out.println("\n------------------------------------------------------");
System.out.println("                    PAYROLL SLIP                      ");
System.out.println("------------------------------------------------------");
System.out.println("Employee Number :"+id3);
System.out.println("Last Name       :"+lname3);
System.out.println("First Name      :"+fname3);
System.out.println("Middle Name     :"+mname3);
System.out.println("Position        :"+position3);
System.out.println("Department      :"+department);
System.out.println("Status          :"+wstatus);
System.out.print("\n    Monthly Salary  :P"+monthsal3);
System.out.print("\n    Allowances      :P"+allo3);
System.out.print("\n    Overtime        :P"+overtime3);
System.out.print("\n    Total Income    :P"+totincome);

System.out.print("\n\n    TAX             :P"+tax);
System.out.print("\n    SSS             :P"+SSS);
System.out.print("\n    Pag-IBIG        :P"+PGBG);
System.out.print("\n    PhilHealth      :P"+PH);
System.out.print("\n    Total Deduction :P"+deductions);

System.out.println("\n\n    Others");
System.out.print("    House Loan      :P");
houseloan=in.nextDouble();
System.out.print("    Car Loan        :P");
carloan=in.nextDouble();
totalloan=houseloan+carloan;
System.out.print("    Total Loan      :P"+totalloan);
grosspay= totincome - deductions;
System.out.print("\n\n TOTAL GROSS PAY    :P"+grosspay);
netpay=grosspay-totalloan;
System.out.print("\n TOTAL NET PAY      :P"+netpay);
break;

case 1004 :
    System.out.println("Last Name       :"+lname4);
    System.out.println("First Name      :"+fname4);
    System.out.println("Middle Name     :"+mname4);
    System.out.println("Position        :"+position4);
    System.out.println("Department      :"+department);
    System.out.println("Status          :"+wstatus);
    System.out.println("Monthly Salary  :P"+monthsal4);
    System.out.println("Allowances      :P"+allo4);
    System.out.print("Overtime        :");
overhrs4=in.nextDouble();
overtime4=overhrs4*hrspay;
       System.out.println("OvertimePay	:P"+overtime4);
totalincome4=monthsal4 + allo4 + overtime4;
        System.out.println("TOTAL INCOME    :P"+totalincome4);

System.out.println("\n------------------------------------------------------");
System.out.println("                 D E D U C T I O N S                   ");
System.out.println("------------------------------------------------------");
        System.out.println("Number of Works  :"+numworks);
	System.out.print("Late(Hour)       :");
hour=in.nextDouble();
totalhrs=hour*hourded;
	System.out.print("Late(Minutes)    :");
minute=in.nextDouble();
if(minute>=1 && minute<=55) {
	minute=minuteded;
}
else if(minute==0){
	minute=minut;
}
late=minute+totalhrs;
	System.out.print("Absences         :");
abse=in.nextDouble();
absetot=absehrs*abse;
	System.out.print("Undertime        :");
undertime=in.nextInt();
undertot=undertime*underhrs;
tothrs=numworks-undertot-absetot-hour;
	System.out.println("Total Hours      :"+tothrs);
	System.out.println("Rate             :P"+rate4);
	totincome=tothrs*rate4+allo4+overtime4-late;
	System.out.println("Total Income     :P"+totincome);

System.out.print("\nSpecify Tax Bracket\n");
System.out.print("[1]Single\n[2]Married\n[3]Widow");

System.out.print("\nEnter Bracket   :");

sel=in.nextInt();
if(sel==1)
{
tax= totincome*.20;
SSS= totincome*0.07;
PGBG= totincome*0.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}

else if(sel==2)
{
tax= totincome*.10;
SSS= totincome*0.03;
PGBG= totincome*0.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}
else
{
tax= totincome*.08;
SSS= totincome*.02;
PGBG= totincome*.01;
PH= totincome*0.01;
deductions= tax + SSS + PGBG + PH;

System.out.println("TAX             :P"+tax);
System.out.println("SSS             :P"+SSS);
System.out.println("Pag-IBIG        :P"+PGBG);
System.out.println("PhilHealth      :P"+PH);
System.out.println("\nDeductions      :P"+deductions);
}

System.out.println("\n------------------------------------------------------");
System.out.println("                    PAYROLL SLIP                      ");
System.out.println("------------------------------------------------------");
System.out.println("Employee Number :"+id4);
System.out.println("Last Name       :"+lname4);
System.out.println("First Name      :"+fname4);
System.out.println("Middle Name     :"+mname4);
System.out.println("Position        :"+position4);
System.out.println("Department      :"+department);
System.out.println("Status          :"+wstatus);
System.out.print("\n    Monthly Salary  :P"+monthsal4);
System.out.print("\n    Allowances      :P"+allo4);
System.out.print("\n    Overtime        :P"+overtime4);
System.out.print("\n    Total Income    :P"+totincome);

System.out.print("\n\n    TAX             :P"+tax);
System.out.print("\n    SSS             :P"+SSS);
System.out.print("\n    Pag-IBIG        :P"+PGBG);
System.out.print("\n    PhilHealth      :P"+PH);
System.out.print("\n    Total Deduction :P"+deductions);

System.out.println("\n\n    Others");
System.out.print("    House Loan      :P");
houseloan=in.nextDouble();
System.out.print("    Car Loan        :P");
carloan=in.nextDouble();
totalloan=houseloan+carloan;
System.out.print("    Total Loan      :P"+totalloan);
grosspay= totincome - deductions;
System.out.print("\n\n TOTAL GROSS PAY    :P"+grosspay);
netpay=grosspay-totalloan;
System.out.print("\n TOTAL NET PAY      :P"+netpay);
break;

default:
System.out.println("Invalid Number");
break; 

}
    System.out.println("\n\nDo you want to select again? [Y/N]");
    ans=(char)System.in.read();
    System.in.read();
    }while(ans== 'Y' || ans == 'y');
}
}