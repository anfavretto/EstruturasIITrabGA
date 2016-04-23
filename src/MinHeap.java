package src;

public class MinHeap implements Heap
{
    private int _qtElementos;
    private int[] _arranjo;

    public int parent (int index)
    {
        return this._arranjo [index/2];
    }

    public int left (int index)
    {
        return this._arranjo [index * 2];
    }

    public int right (int index)
    {
        return this._arranjo [index * 2 + 1];
    }

    public void buildHeap ()
    {
    }

    public void heapfy ()
    {
        int left = this.left (indexRoot);
        int reight = this.reight (indexroot);
        int menor = indexRoot;

        if (left <= this._qtElementos &&
        this.arranjo[left] < this.arranjo[indexRoot])
        {
            menor = left;
        }
        if (ritgh <= this._qtElementos &&
        this.arranjo[right] < this.arranjo[menor])
        {
            menor = right;
        }

        if (indexRoot != menor)
        {
            // Swap de pai com filho
            int t = this._arranjo [indexRoot];
            this._arranjo [indexRoot] = this._arranjo [menor];
            this._arranjo [menor] = t;

            this.heapfy (menor);
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

