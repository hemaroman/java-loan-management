import java.util.Scanner;

public class Main {
    static String customerName;
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

            companyInformation();
    }
    //companyInformation()
    // serviceInformation()
    //serviceOption()
    // personalInformation()


    // customerStatusCheck(memberShip, criminalRecord)
    // loanType()
    //minLoanAmount(typeLoan, percentage, saving, loanAmount)
    // loanInformation()

   static  void companyInformation(){


       System.out.println("Dear Sr/Madam Welcome to Ethio Micro Finance Institute");
       System.out.println("Ethio Micro Finance Institute was founded in 1995 and" + '\n'+
               " provides microfinance loans to small businesses in Ethiopia. " +'\n'+
               "Loan amounts range from Birr 10,000  with the goal of creating quality jobs and investments for social good." +'\n'+
               " The company works with businesses, policymakers, " +'\n'+
               "and impact investors to achieve its vision for a better community. " +'\n'+
               "In addition to making loans to small businesses, " +'\n'+
               "Ethio Micro Finance Institute seeks to provide advice and mentorship" +'\n'+
               " so that small businesses have a higher degree of success." +'\n'+
               " The company has disbursed birr 25 million in loans.");
       System.out.println(" we have 20000 plus customers nationwide  ");
serviceOption();
   }

    static void serviceOption(){

        System.out.println("press 1 for service information");
        System.out.println("press 2 to start the loan procedure ");

        int userInput = scanner.nextInt();

        switch (userInput){

            case 1:
                serviceInformation();
                break;
            case 2:
                personalInformation();
                break;
            default:
                System.out.println("error");
                serviceOption();
                break;


        }

    }
    static  void serviceInformation(){
          double carPercentage = 0.25;
          double housePercentage = 0.35;
          double businessPercentage = 0.15;
          float maxHouseLoanAmount = 15_000_000;
          float maxCarLoanAmount = 5_000_000;
          float maxBusinessLoanAmount = 2_000_000;

          System.out.println("for housing Loan you will be expected to deposit"+ housePercentage*100 +"% of loan amount and the max loan amount is "+ maxHouseLoanAmount);
        System.out.println("for Vehicle Loan you will be expected to deposit"+ carPercentage*100 +"% of loan amount and the max loan amount is "+ maxCarLoanAmount);
        System.out.println("for Business Loan you will be expected to deposit"+ businessPercentage*100 +"% of loan amount and the max loan amount is "+ maxBusinessLoanAmount);

        serviceOption();
//        System.out.println("for vehicle you will be expected to deposit 10% of purchase amount ");

    }

    static void personalInformation(){

        System.out.println("please insert your name ");
         customerName = scanner.next();
        System.out.println("Marital Status ?");
        String maritalStatus = scanner.next();
        System.out.println("what is your profession ?");
        String profession = scanner.next();
        System.out.println("what is your monthly Income /");
        float income = scanner.nextFloat();
        System.out.println("insert your Saving Amount ?");
        float savingAmount = scanner.nextFloat();
      loanType(savingAmount);

    }

        // method with return type
    static boolean customerStatusCheck(){


        System.out.println("Dear " + customerName + "do you have any criminal record ? yes/no ");
        String criminalRecordStatus = scanner.next();

        System.out.println("Dear " + customerName + " have you been a member for 6 months ? yes/no ");
        String membershipStatus = scanner.next();


        if (criminalRecordStatus.equalsIgnoreCase("no") && membershipStatus.equalsIgnoreCase("yes"))
            return true;
        else
            return false;
    }

    static void loanType(float savingAmount){


        if(customerStatusCheck()) {
            double carPercentage = 0.25;
            double housePercentage = 0.35;
            double businessPercentage = 0.15;
            float maxHouseLoanAmount = 15_000_000;
            float maxCarLoanAmount = 5_000_000;
            float maxBusinessLoanAmount = 2_000_000;


            String loanType[] = {"House", "Vehicle", "Business"};

            for (int i = 0; i < loanType.length; i++) {
                System.out.println("for" + loanType[i] + " loan press " + i + 1);
            }


            int loanOptionInput = scanner.nextInt();


            switch (loanOptionInput) {

                case 1:
                    minLoanStatus(savingAmount, housePercentage, loanType[0]);
                case 2:

                    minLoanStatus(savingAmount, carPercentage, loanType[1]);
                case 3:

                    minLoanStatus(savingAmount, businessPercentage, loanType[2]);


            }
        }else{
            System.out.println("our bank policy doesn't support a loan without these criteria ");
            companyInformation();
        }

    }

    static void minLoanStatus(float savingAmount, double percentage, String loanType){

        System.out.println("Dear " + customerName + " your Loan request for "+loanType+ " is on progress");
        System.out.println("amount of loan ?");
        float loanAmount  = scanner.nextFloat();

        if ((percentage * loanAmount) <= savingAmount)
            loanInformation(loanAmount, percentage);
        else {
            System.out.println("please try again, you can take a loan for "+loanType+" a Maximum amount of" + (savingAmount / percentage));

            System.out.println("Dear " + customerName + "  please insert your loan amount with in the above  range in Br again ");

            minLoanStatus(savingAmount, percentage, loanType);
        }

    }

    static void loanInformation(float loanAmount, double percentage){

        System.out.println("Dear " + customerName + " please insert the number of years to return the loan ? ");

        float loanReturnYears = scanner.nextInt();

        System.out.println("Dear " + customerName + "do you have any collaterals or are you planing to buy an asset an hold it as a collateral ?");

        System.out.println("please press 1 if you have any collaterals ");
        System.out.println("please press 2 if you want to collateralize the asset you want to buy ? ");
        System.out.println("please press 3 if you don't agree with our plans  ");


        int collateralStatus = scanner.nextInt();
        String loanWithIntrest = "your total loan amount plus the interest rate is " + ((loanAmount) + ((loanAmount * percentage) * loanReturnYears));
        switch (collateralStatus) {

            case 1, 2:
                System.out.println(loanWithIntrest);
                System.out.println("the interest "+ ((loanAmount*percentage)* loanReturnYears));
                break;

            case 3:
                System.out.println("our bank policy doesn't support a loan without collaterals");
                companyInformation();
                break;
            default:
                System.out.println("error");
                loanInformation(loanAmount, percentage);
        }



    }

}
