import java.io.*;
import java.util.*;

public class PokerHands{

  public static String[] cardRank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
  public static void main(String[] args){


    /*System.out.println(run("AS, KS, QS, JS, 10S"));
    System.out.println(run("AS, KS, QS, JS, 10S"));
    System.out.println(run("10S, 10S, 10S, 9S, 10S"));
    System.out.println(run("KS, KS, KS, 5S, 5S"));
    System.out.println(run("KS, KS, KS, 5S, 5S"));
    System.out.println(run("AS, KS, QS, JS, 10S"));
    System.out.println(run("10S, 10S, 10S, 9S, 10S"));
    System.out.println(run("10S, 10S, 10S, 9S, 10S"));
    System.out.println(run("2S, 3S, 4S, 3S, 2S"));
    System.out.println(run("2S, 3S, 4S, 3D, 2H"));

    System.out.println(run("10S, 10S, 10S, 9S, 10S"));
    System.out.println(run("2S, 3S, 4S, 3S, 2S"));
    System.out.println(run("2S, 3S, 4S, 3S, 10S"));
    System.out.println(run("AS, 10S, 10S, 9S, AH"));
    System.out.println(run("QS, 3S, QS, 3S, QS"));
    System.out.println(run("2S, JH, JD, JS, JS"));
    System.out.println(run("2S, JH, QD, AS, 10S"));*/

    System.out.println(run("AS, 10C, 10H, 3D, 3S"));

    System.out.println(run("QC,KC,AC,2C,3C"));
    System.out.println(run("AH,KH,QH,JH,10H"));
    System.out.println(run("5C,5D,5H,5S,2D"));
    System.out.println(run("8S,8D,8H,7D,7C"));
    System.out.println(run("KC,10C,7C,6C,4C"));
    System.out.println(run("7C,6S,5S,4H,3H"));
    System.out.println(run("3D,3S,3C,KS,2S"));
    System.out.println(run("6D,6H,QD,8H,3S"));
    System.out.println(run("7S,5C,4D,3D,2C"));
    /*System.out.println(run("2S, 3S, 4S, 3D, 2H"));

    System.out.println(run("10S, 10S, 10S, 9S, 10S"));
    System.out.println(run("2S, 3S, 4S, 3S, 2S"));
    System.out.println(run("2S, 3S, 4S, 3S, 10S"));
    System.out.println(run("AS, 10S, 10S, 9S, AH"));
    System.out.println(run("QS, 3S, QS, 3S, QS"));
    System.out.println(run("2S, JH, JD, JS, JS"));
    System.out.println(run("2S, JH, QD, AS, 10S"));

    System.out.println(run("AS, 10C, 10H, 3D, 3S"));*/


  }

  public static String run(String deck){
    if(isRoyalFlush(deck)){
      return "Royal Flush";
    }else if(isStraightFlush(deck)){
      return "Straight Flush";
    }else if(isFourOfAKind(deck)){
      return "Four of a Kind";
    }else if(isFullHouse(deck)){
      return "Full House";
    }else if(isFlush(deck)){
      return "Flush";
    }else if(isStraight(deck)){
      return "Straight";
    }else if(isThreeOfAKind(deck)){
      return "Three of a Kind";
    }else if(isTwoPair(deck)){
      return "Two Pair";
    }else if(isOnePair(deck)){
      return "One Pair";
    }else{
      return "High Card";
    }
  }

  public static boolean isRoyalFlush(String deck){
      boolean toReturn = false;

      if(!deck.contains("A")
      || !deck.contains("K")
      || !deck.contains("Q")
      || !deck.contains("J")
      || !deck.contains("10")){
        return false;

      }else{
        if(isSameSuit(deck)){
          //System.out.println("isSequantial");
          if(isSequantial(deck)){
            toReturn = true;
          }
        }

        return toReturn;
     }
    }

    public static boolean isStraightFlush(String deck){
      boolean toReturn = false;
      //System.out.println("isSameSuit");
      if(isSameSuit(deck)){
        //System.out.println("isSequantial");
        if(isSequantial(deck)){
          toReturn = true;
        }
      }

      return toReturn;
    }

    public static boolean isFourOfAKind(String theDeck){
      int[] deckIndeces = new int[5];

      theDeck = theDeck.replace(" ","").trim();
      String[] deck = theDeck.split(",");
      String[] indeces = cardRank;

      int count = 0;
      boolean check = true;
      for(int i = 0;i<deck.length;i++){
        for(int j = 0;j<indeces.length;j++){
          //System.out.println(deck[i].substring(0,deck[i].length()-1)+" -- "+indeces[j]);
          if(deck[i].substring(0,deck[i].length()-1).equalsIgnoreCase(indeces[j])){
            deckIndeces[i] = j;
            //System.out.println(j);
            break;
          }
        }
      }
      Arrays.sort(deckIndeces);
      for(int k =1;k<deckIndeces.length;k++){
        //System.out.println(deckIndeces[k]+" - "+ deckIndeces[k-1]);
        if(deckIndeces[k]-deckIndeces[k-1]==0){
            //System.out.println(count);
            count++;
        }else{
          if(count!=3){
            count = 0;
          }
        }
      }
      //System.out.println(count);
      if(count!=3){
        check = false;
      }
      return check;
    }

    public static boolean isFullHouse(String theDeck){
      int[] deckIndeces = new int[5];

      theDeck = theDeck.replace(" ","").trim();
      String[] deck = theDeck.split(",");
      String[] indeces = cardRank;

      int count = 0;
      int count2 = 0;
      boolean check = false;
      for(int i = 0;i<deck.length;i++){
        for(int j = 0;j<indeces.length;j++){
          //System.out.println(deck[i].substring(0,deck[i].length()-1)+" -- "+indeces[j]);
          if(deck[i].substring(0,deck[i].length()-1).equalsIgnoreCase(indeces[j])){
            deckIndeces[i] = j;
            //System.out.println(j);
            break;
          }
        }
      }
      Arrays.sort(deckIndeces);
      if(deckIndeces[0]==deckIndeces[1] && deckIndeces[0]==deckIndeces[2]  && deckIndeces[3]==deckIndeces[4]){
        check = true;
      }else if(deckIndeces[0]==deckIndeces[1] && deckIndeces[2]==deckIndeces[3] && deckIndeces[2]==deckIndeces[4]){
        check = true;
      }
      /*for(int k =1;k<deckIndeces.length;k++){
        //System.out.println(deckIndeces[k]+" - "+ deckIndeces[k-1]);
        if(deckIndeces[k]-deckIndeces[k-1]==0){
            count++;
        }
      }
      if(count!=4){
        check = false;
      }*/
      return check;
    }

    public static boolean isFlush(String deck){
      return isSameSuit(deck);
    }

    public static boolean isStraight(String deck){
      return isSequantial(deck);
    }

    public static boolean isThreeOfAKind(String theDeck){
      int[] deckIndeces = new int[5];

      theDeck = theDeck.replace(" ","").trim();
      String[] deck = theDeck.split(",");
      String[] indeces = cardRank;

      int count = 0;
      boolean check = true;
      for(int i = 0;i<deck.length;i++){
        for(int j = 0;j<indeces.length;j++){
          //System.out.println(deck[i].substring(0,deck[i].length()-1)+" -- "+indeces[j]);
          if(deck[i].substring(0,deck[i].length()-1).equalsIgnoreCase(indeces[j])){
            deckIndeces[i] = j;
            //System.out.println(j);
            break;
          }
        }
      }
      Arrays.sort(deckIndeces);
      for(int k =1;k<deckIndeces.length;k++){
        //System.out.println(deckIndeces[k]+" - "+ deckIndeces[k-1]);
        if(deckIndeces[k]-deckIndeces[k-1]==0){
          //System.out.println(count);
            count++;
        }else{
          if(count!=2){
            count = 0;
          }
        }
      }
      //System.out.println(count);
      if(count!=2){
        check = false;
      }
      return check;
    }

    public static boolean isTwoPair(String theDeck){
      int[] deckIndeces = new int[5];

      theDeck = theDeck.replace(" ","").trim();
      String[] deck = theDeck.split(",");
      String[] indeces = cardRank;

      int count = 0;
      int count2 = 0;
      boolean check = false;
      for(int i = 0;i<deck.length;i++){
        for(int j = 0;j<indeces.length;j++){
          //System.out.println(deck[i].substring(0,deck[i].length()-1)+" -- "+indeces[j]);
          if(deck[i].substring(0,deck[i].length()-1).equalsIgnoreCase(indeces[j])){
            deckIndeces[i] = j;
            //System.out.println(j);
            break;
          }
        }
      }
      Arrays.sort(deckIndeces);
      if(deckIndeces[0]==deckIndeces[1] && deckIndeces[2]==deckIndeces[3]){
        check = true;
      }else if(deckIndeces[1]==deckIndeces[2] && deckIndeces[3]==deckIndeces[4]){
        check = true;
      }else if(deckIndeces[0]==deckIndeces[1] && deckIndeces[4]==deckIndeces[5]){
        check = true;
      }

      /*for(int k =1;k<deckIndeces.length;k++){
        //System.out.println(deckIndeces[k]+" - "+ deckIndeces[k-1]);
        if(deckIndeces[k]-deckIndeces[k-1]==0){
            count++;
        }
      }
      if(count!=4){
        check = false;
      }*/
      return check;
    }

    public static boolean isOnePair(String theDeck){
      int[] deckIndeces = new int[5];

      theDeck = theDeck.replace(" ","").trim();
      String[] deck = theDeck.split(",");
      String[] indeces = cardRank;

      int count = 0;
      int count2 = 0;
      boolean check = false;
      for(int i = 0;i<deck.length;i++){
        for(int j = 0;j<indeces.length;j++){
          //System.out.println(deck[i].substring(0,deck[i].length()-1)+" -- "+indeces[j]);
          if(deck[i].substring(0,deck[i].length()-1).equalsIgnoreCase(indeces[j])){
            deckIndeces[i] = j;
            //System.out.println(j);
            break;
          }
        }
      }
      Arrays.sort(deckIndeces);
      if(deckIndeces[0]==deckIndeces[1] ){
        check = true;
      }else if(deckIndeces[1]==deckIndeces[2]){
        check = true;
      }else if(deckIndeces[2]==deckIndeces[3]){
        check = true;
      }else if(deckIndeces[3]==deckIndeces[4]){
        check = true;
      }

      /*for(int k =1;k<deckIndeces.length;k++){
        //System.out.println(deckIndeces[k]+" - "+ deckIndeces[k-1]);
        if(deckIndeces[k]-deckIndeces[k-1]==0){
            count++;
        }
      }
      if(count!=4){
        check = false;
      }*/
      return check;
    }

    public static boolean isHighCard(String deck){
      return false;
    }

    public static boolean isSameSuit(String deck){
      boolean toReturn = true;
      String[] temp = deck.split(",");
      String currentSuit = temp[0].substring(temp[0].length()-1);
      //System.out.println(temp.length);
      //System.out.println(temp[0].substring(temp[0].length()-1));
      for(int i =1;i<temp.length;i++){
        //System.out.println(temp[i].substring(temp[i].length()-1));
        if(!currentSuit.equalsIgnoreCase(temp[i].substring(temp[i].length()-1))){
          toReturn = false;
          break;
        }
      }
      return toReturn;
    }

    public static boolean isSequantial(String theDeck){
      int[] deckIndeces = new int[5];
      boolean check = true;


      theDeck = theDeck.replace(" ","").trim();
      String[] deck = theDeck.split(",");
      String[] indeces = cardRank;

      for(int i = 0;i<deck.length;i++){
        for(int j = 0;j<indeces.length;j++){
          //System.out.println(deck[i].substring(0,deck[i].length()-1)+" -- "+indeces[j]);
          if(deck[i].substring(0,deck[i].length()-1).equalsIgnoreCase(indeces[j])){
            deckIndeces[i] = j;
            //System.out.println(j);
            break;
          }
        }
      }
      Arrays.sort(deckIndeces);
      for(int k =1;k<deckIndeces.length;k++){
        //System.out.print(deckIndeces[k-1]+" -");
        //System.out.println(deckIndeces[k]);
        if(deckIndeces[k]-deckIndeces[k-1]!=1){
          check = false;
          break;
        }
      }
      return check;
    }


}
