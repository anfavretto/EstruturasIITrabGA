package src;

public class MaxHeap implements Heap
{
    private int _qtElementos;
    private int[] _arranjo;

    public int parent (int index)
    {
        return _arranjo [index/2];
    }

    public int left (int index)
    {
        return 2 * index;
    }

    public int right (int index)
    {
        return 2 * i + index
    }

    public void buildHeap ()
    {
    }

    public void heapfy (int indexRoot)
    {
        int left = this.left (indexRoot);
        int reight = this.reight (indexroot);
        int maior = indexRoot;

        if (left <= this._qtElementos &&
        this.arranjo[left] > this.arranjo[indexRoot])
        {
            maior = left;
        }
        if (ritgh <= this._qtElementos &&
        this.arranjo[right] > this.arranjo[maior])
        {
            maior = right;
        }

        if (indexRoot != maior)
        {
            // Swap de pai com filho
            int t = this._arranjo [indexRoot];
            this._arranjo [indexRoot] = this._arranjo [maior];
            this._arranjo [maior] = t;

            this.heapfy (maior);
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
}

