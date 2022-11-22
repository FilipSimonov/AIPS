package faks.vezbi;
import java.util.Scanner;

public class Podlista {

    private static boolean isPodList(DLL<Integer> list,DLL<Integer> tmp, int tmpSize){
        DLLNode<Integer> inNode = list.getFirst();
        DLLNode<Integer> tmpNode = tmp.getFirst();

        while (inNode!=null && tmpNode!=null){
            if (inNode.element==tmpNode.element){
                DLLNode<Integer> position = inNode;

                while (position!=null && tmpNode!=null && tmpSize>0){
                    if (position.element !=tmpNode.element)
                        break;

                    position = position.succ;
                    tmpNode = tmpNode.succ;
                    tmpSize--;
                }
                if (tmpSize == 0)
                    return true;
            }

            inNode = inNode.succ;
        }
        return false;


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DLL<Integer> list = new DLL<Integer>();
        DLL<Integer> tmp = new DLL<Integer>();

        int n = input.nextInt();
        for (int i=0;i<n;i++){
            list.insertLast(input.nextInt());
        }

        int m = input.nextInt();
        for (int i=0;i<m;i++){
            tmp.insertLast(input.nextInt());
        }
        System.out.println(isPodList(list,tmp,m));

    }
}
