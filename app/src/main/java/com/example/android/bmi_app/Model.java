package com.example.android.bmi_app;


import android.widget.EditText;





public class Model {
    private static int lowerAgeRange = 0;
    private static int upperAgeRange = 120;
    private static int lowerFeetRange = 3 ;
    private static int upperFeetRange = 9;
    private static int lowerInchesRange = 0;
    private static int upperInchesRange = 11;
    private static int lowerPoundsRange = 10;
    private static int upperPoundsRange = 250;




    /* Form Validation */


    //Valid Feet
    static boolean isValidFeet(EditText field){

        //check if empty
        if(IsEmpty(field)){
            field.setError("Feet is empty");
            return  false;
        }
      try {
        int data = Integer.parseInt(field.getText().toString());
          if(IsInRange(data,lowerFeetRange,upperFeetRange)){
              return true;
          }
          else {
              field.setError("Feet must be between"+lowerFeetRange +
                      " & "+ upperFeetRange + ".");
              return false;
          }
      }
      catch (Exception e){
         field.setError("Enter feet as number(not character)");
          return false;
      }
    }

    //Valid Inches

    static boolean isValidInches(EditText field){
        //check if empty
        if(IsEmpty(field)){
            field.setError("Inches is empty");
            return false;
        }
        try {
            int data = Integer.parseInt(field.getText().toString());
            if(IsInRange(data,lowerInchesRange,upperInchesRange)){
                return true;
            }
            else {
                field.setError("Inches must be between"+ lowerInchesRange +
                        " & "+ upperInchesRange);
                return false;
            }
        }
        catch (Exception e){

            field.setError("Enter Inches as number(not character)");
            return false;
        }
    }

    //Valid Pounds

    static boolean isValidPounds(EditText field){
        //check if empty
        if(IsEmpty(field)){
            field.setError("weight is empty");
            return false;
        }
        try {
            int data = Integer.parseInt(field.getText().toString());
            if(IsInRange(data,lowerPoundsRange,upperPoundsRange)){
                return true;
            }
            else {
                field.setError("Pounds must be between"+ lowerPoundsRange +
                        " & "+ upperPoundsRange);
                return false;
            }
        }
        catch (Exception e){

            field.setError("Enter Pound as number(not character)");
            return false;
        }
    }

    //Valid Age

    static boolean isValidAge(EditText field){
        //check if empty
        if(IsEmpty(field)){
            field.setError("Age is empty");
            return false;
        }
        try {
            int data = Integer.parseInt(field.getText().toString());
            if(IsInRange(data,lowerAgeRange,upperAgeRange)){
                return true;
            }
            else {
                field.setError("Age must be between"+ lowerAgeRange +
                        " & "+ upperAgeRange);
                return false;
            }
        }
        catch (Exception e){

            field.setError("Enter Age as number(not character)");
            return false;
        }
    }
     // check is  Empty

    static boolean IsEmpty(EditText field){
        if(field.getText().length()==0){
             return true;
        }
        else{
            return false;
        }
    }
    // check is Range

     static boolean IsInRange(int data, int lower ,int upper){
           if(data >= lower && data <= upper){
               return true;
           }
           else {
               return  false;
           }

    }

    static String calculateBMI(EditText feetPass, EditText inchesPass, EditText poundsPass){
        String results = "";
        if(isValidFeet(feetPass)&& isValidInches(inchesPass)&& isValidPounds(poundsPass)){
            int inches = Integer.parseInt(inchesPass.getText().toString());
            int feet = Integer.parseInt(feetPass.getText().toString());
            int total_inches = feet*12 + inches;
            int kilo = Integer.parseInt(poundsPass.getText().toString());
            double bmi;
            bmi = Math.round(kilo *703/ Math.pow(total_inches,2) );
            results += bmi ;

        }
        else {
            results += "Error";
        }

        return results;

    }
    //Calculate Daily Calorie Amount for Male
    static String calculateCalorie( EditText AgePass,EditText feetPass, EditText inchesPass, EditText poundsPass  ){
        String results = "";

        if(isValidFeet(feetPass)&& isValidInches(inchesPass)&& isValidPounds(poundsPass)&& isValidAge(AgePass)){
            int inches = Integer.parseInt(inchesPass.getText().toString());
            int age  = Integer.parseInt(AgePass.getText().toString());
            int feet = Integer.parseInt(feetPass.getText().toString());
            int total_inches = feet*12 + inches;
            int kilo = Integer.parseInt(poundsPass.getText().toString());
            double calorie ;
            calorie = (10*kilo + 6.25*total_inches*2.54 - 5*age+5)*1.55;

            results += calorie ;

        }
        else {
            results += "wrong Input";
        }

        return results;

    }

//Calculate Daily Calorie Amount for female
    static String calculateCalorieFemale( EditText AgePass,EditText feetPass, EditText inchesPass, EditText poundsPass  ){
        String results = "";

        if(isValidFeet(feetPass)&& isValidInches(inchesPass)&& isValidPounds(poundsPass)&& isValidAge(AgePass)){
            int inches = Integer.parseInt(inchesPass.getText().toString());
            int age  = Integer.parseInt(AgePass.getText().toString());
            int feet = Integer.parseInt(feetPass.getText().toString());
            int total_inches = feet*12 + inches;
            int kilo = Integer.parseInt(poundsPass.getText().toString());
            double calorie ;
            calorie = (10*kilo + 6.25*total_inches*2.54 - 5*age-161)*1.55;

            results += calorie ;

        }
        else {
            results += "wrong Input";
        }

        return results;

    }

//Calories=(10*weight + 6.25*height - 5*age+5)*1.55

}


