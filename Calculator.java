/*
 Morwakgadi MAmabolo
 */

/**
 *
 * @author HP
 */
import java.io.*; 
import java.util.*; 
 public class calculator
  {
     private double result;
      private double precision = 0.0001;
     //Numbers this close to zero are treated as if equal to zero.
  
     public static void main(String[] args)
      {
          calculator clerk = new calculator();
          try
          {
              System.out.println("Calculator is on.");
              System.out.print("Format of each line: ");
             System.out.println("operator space number");
              System.out.println("For example: + 3");
              System.out.println("To end, enter the letter e.");
              clerk.doCalculation();
          }         catch (Exception e)
          {
              clerk.handleUnknownOpException(e);
          }
          
          System.out.println("The final result is " + clerk.getResult());
         System.out.println("Calculator program ending.");
      }
  
      public void Calculator()
     {
          result = 0;
      }
 
      public void reset()
      {
          result = 0;
      }
  
      public void setResult
      (
          double newResult
      )
      {
          result = newResult;
      }
 
      public double getResult()
     {
          return result;
      }
  
      /**
       * The heart of a calculator. This does not give
       * instructions. Input errors throw exceptions.
       */
      public void doCalculation()
         throws Exception
      {
         Scanner keyboard = new Scanner(System.in);
  
          boolean done = false;
          result = 0;
          System.out.println("result = " + result);
          while (!done)
          {
              char nextOp = (keyboard.next()).charAt(0);
              if ((nextOp == 'e') || (nextOp == 'E'))
                  done = true;
              else
              {
                  double nextNumber = keyboard.nextDouble();
                  result = evaluate(nextOp, result, nextNumber);
                  System.out.println("result " + nextOp + " "
                      + nextNumber + " = " + result);
                  System.out.println("updated result = " + result);
              }
          }
      }
  
      /**
       * Returns n1 op n2, provided op is one of '+', '-', '*',or '/'.
       * Any other value of op throws UnknownOpException.
       */
      public double evaluate
      (
          char op,
          double n1,
          double n2
      ) throws Exception, Exception
     {
         double answer;
         switch (op)
         {
         case '+':
             answer = n1 + n2;
             break;
         case '-':
             answer = n1 - n2;
             break;
         case '*':
            answer = n1 * n2;
             break;
         case '/':
             if ((-precision < n2) && (n2 < precision))
                 throw new Exception();
             answer = n1 / n2;
             break;
         default:
            throw new Exception();
         }
         return answer;
     }
 
     public void handleDivideByZeroException
     (
         Exception e
     )
     {         System.out.println("Dividing by zero.");
         System.out.println("Program aborted");
         System.exit(0);
     }
 
     public void handleUnknownOpException
     (
         Exception e
     )
     {
         System.out.println(e.getMessage());
         System.out.println("Try again from the beginning:");
 
         try
         {
             System.out.print("Format of each line: ");
             System.out.println("operator number");
             System.out.println("For example: + 3");
             System.out.println("To end, enter the letter e.");
             doCalculation();
         }
         catch (Exception e2)
         {
             System.out.println(e2.getMessage());
             System.out.println("Try again at some other time.");
             System.out.println("Program ending.");
             System.exit(0);
         }
        
     }
}

