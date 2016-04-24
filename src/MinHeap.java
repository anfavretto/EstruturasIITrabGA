public class MinHeap implements Heap
{
    private int _qtElementos;
    private ObjetoOrdenado[] _arranjo;
    private int _xfactor;

    public MinHeap ()
    {
        this._qtElementos = 0;
        this._xfactor = 1;
    }

    public int parent (int index)
    {
        return ((index + this._xfactor)/2) - this._xfactor;
    }

    public int left (int index)
    {
        return (2 * (index + this._xfactor)) - this._xfactor;
    }

    public int right (int index)
    {
        return (2 * (index + this._xfactor) + 1) - this._xfactor;
    }

    public ObjetoOrdenado[] buildHeap (ObjetoOrdenado[] arranjo)
    {
        this._arranjo = new ObjetoOrdenado[arranjo.length];
        System.arraycopy (arranjo, 
                          0, 
                          this._arranjo, 
                          0, 
                          arranjo.length); 

        this._qtElementos = this._arranjo.length;
        int limite = ((this._arranjo.length - this._xfactor) / 2);
        for (int i = limite;i >= 0; i--)
        {
            this.heapfy(i);
        }
        return this._arranjo;
    }

    public void heapfy (int indexRoot)
    {
        int left = this.left (indexRoot);
        int right = this.right (indexRoot);
        int menor = indexRoot;

        if (left < this._qtElementos &&
        this._arranjo[left].getPropriedadeOrdenada() < this._arranjo[indexRoot].getPropriedadeOrdenada())
        {
            menor = left;
        }
        if (right < this._qtElementos &&
        this._arranjo[right].getPropriedadeOrdenada() < this._arranjo[menor].getPropriedadeOrdenada())
        {
            menor = right;
        }

        if (indexRoot != menor)
        {
            ObjetoOrdenado t = this._arranjo[indexRoot];
            this._arranjo [indexRoot] = this._arranjo [menor];
            this._arranjo [menor] = t;

            this.heapfy(menor);
        }
    }

    public void insert ()
    {
    }

    public int extract ()
    {
        return 0;
    }

    public void increase ()
    {
    }

    @Override
    public String toString ()
    {
        String tmp = new String ();
        for (int i = 0; i < this._qtElementos; i++)
        {
            tmp = tmp + "|" + this._arranjo [i];
            if (i == this._qtElementos - 1)
            {
                tmp += "|";
            }
        }
        return tmp;
    }

    public void printHeap ()
    {
        System.out.println ("A = " + this.toString ());
    }
}

