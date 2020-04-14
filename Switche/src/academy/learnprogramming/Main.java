package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
       String numberAsString = "2018";
       int number = Integer.parseInt(numberAsString);
       numberAsString += 1;
       number += 1;
        System.out.println(getLargestPrime(45));
    }
    public static int getLargestPrime(int number){
        if(number < 0) return -1;
        int prime = 1;
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                
                prime = i;
            }
        }
        return prime;
    }



}
