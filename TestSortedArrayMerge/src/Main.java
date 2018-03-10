import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner;
        int[] x={1,2,3,4,5};
        int[] y={4,5,6,7};

        System.out.println("ENTER FIRST SORTED ARRAY SIZE");
        scanner=new Scanner(System.in);

        int firstArrayCount=scanner.nextInt();

        System.out.println("Enter array items ");
        int[] firstArray=arrayInput(firstArrayCount);

        System.out.println("ENTER SECOND SORTED ARRAY SIZE");
        scanner=new Scanner(System.in);
        int secondArrayCount=scanner.nextInt();

        int[] secondArray=arrayInput(secondArrayCount);


        int[] mergerd=merge(firstArray,secondArray);

        for (int integ:mergerd){

            System.out.println(integ);
        }

    }

    private static int[] arrayInput(int size){
        int i=0;
        int[] array=new int[size];
        while (i<size) {
            Scanner numScanner = new Scanner(System.in);

            try {
                array[i] = numScanner.nextInt();
                i++;
            }catch (InputMismatchException e){
                System.out.println("INVALID NUMBER");
            }
        }
        return array;
    }

    private static int[] merge(int[] firstArray, int[] secondArray) {

        int[] answer = new int[firstArray.length + secondArray.length];
        int i = 0, j = 0, k = 0;

        while (i < firstArray.length && j < secondArray.length) {
            answer[k++] = firstArray[i] < secondArray[j] ? firstArray[i++] : secondArray[j++];
        }

        while (i < firstArray.length) {
            answer[k++] = firstArray[i++];
        }

        while (j < secondArray.length) {
            answer[k++] = secondArray[j++];
        }
        return answer;
    }
    }
