public class TesteHeap
{
    public static void main (String[] args)
    {
        System.out.println ("*** Classe de teste da Heap ***");
        //int[] v = {4,1,3,2,16,9,10,14,8,7};
        InfoTime time = new InfoTime();
        time.setNome("Time 1");
        ObjetoOrdenado obj = new ObjetoOrdenado();
        obj.setPropriedadeOrdenada(4);
        obj.setTime(time);
        
        InfoTime time2 = new InfoTime();
        time2.setNome("Time 2");
        ObjetoOrdenado obj2 = new ObjetoOrdenado();
        obj2.setPropriedadeOrdenada(14);
        obj2.setTime(time2);
        
        ObjetoOrdenado[] v = { obj, obj2};
       
        //printEntrada (v);
        System.out.println ("========================================");
        System.out.println ("*** MIN-HEAP ***");
        Heap hp = new MinHeap ();
        printHeap((ObjetoOrdenado[])hp.buildHeap(v));
        System.out.println ("========================================");
        System.out.println ("*** MAX-HEAP ***");
        Heap hp1 = new MaxHeap ();
        printHeap((ObjetoOrdenado[])hp1.buildHeap(v));
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
    
    public static void printHeap(ObjetoOrdenado[] v)
    {
        String tmp = new String ();
        for (int i = 0; i < v.length; i++)
        {
            tmp = tmp + "|" + v [i].getTime().getNome();
            if (i == (v.length - 1))
            {
                tmp += "|";
            }
        }
        System.out.println ("Heap: " + tmp);
    }
}

