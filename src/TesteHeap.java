package src;

public class TesteHeap
{
    public static void main (String[] args)
    {
        System.out.println ("*** Classe de teste da Heap ***");
        int[] v = {4,1,3,2,16,9,10,14,8,7};
        printEntrada (v);
        System.out.println ("========================================");
        System.out.println ("*** MIN-HEAP ***");
        Heap hp = new MinHeap ();
        hp.buildHeap (v);
        System.out.println ("========================================");
        System.out.println ("*** MAX-HEAP ***");
        Heap hp1 = new MaxHeap ();
        hp1.buildHeap (v);
    }

    public static void printEntrada (int[] v)
    {
        String tmp = new String ();
        for (int i = 0; i < v.length; i++)
        {
            tmp = tmp + "|" + v [i];
            if (i == (v.length - 1))
            {
                tmp += "|";
            }
        }
        System.out.println ("Entrada: " + tmp);
    }
}

