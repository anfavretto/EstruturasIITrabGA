public class MaxHeap implements Heap
{
    private int _qtElementos;
    private ObjetoOrdenado[] _arranjo;
    private int _xfactor;

    public MaxHeap ()
    {
        this._qtElementos = 0;
        this._xfactor = 1;
    }

    public ObjetoOrdenado[] getHeap(){
    	return this._arranjo;
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

    public void buildHeap (ObjetoOrdenado[] arranjo)
    {
        this._arranjo = new ObjetoOrdenado[arranjo.length];
        System.arraycopy (arranjo, 
                          0,
                          this._arranjo, 
                          0, 
                          arranjo.length); 

        this._qtElementos = this._arranjo.length;
        int limite = ((this._arranjo.length / 2) - this._xfactor);
        for (int i = limite;i >= 0; i--)
        {
            this.heapfy(i);
        }
    }

    public void heapfy (int indexRoot)
    {
        int left = this.left(indexRoot);
        int right = this.right(indexRoot);
        int maior = indexRoot;

        if (left < this._qtElementos &&
        this._arranjo[left].getPropriedadeOrdenada() > this._arranjo[indexRoot].getPropriedadeOrdenada())
        {
            maior = left;
        }
        if (right < this._qtElementos &&
        this._arranjo[right].getPropriedadeOrdenada() > this._arranjo[maior].getPropriedadeOrdenada())
        {
            maior = right;
        }

        if (indexRoot != maior)
        {
            ObjetoOrdenado t = this._arranjo[indexRoot];
            this._arranjo[indexRoot] = this._arranjo[maior];
            this._arranjo[maior] = t;

            this.heapfy(maior);
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

    public int get_qtElementos() {
		return _qtElementos;
	}

	public void set_qtElementos(int _qtElementos) {
		this._qtElementos = _qtElementos;
	}

	@Override
    public String toString ()
    {
        String tmp = new String ();
        for (int i = 0; i < this._qtElementos; i++)
        {
            tmp = tmp + "|" + this._arranjo [i];
            if (i == (this._qtElementos - 1))
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

