
public class HeapSort {
	private Heap heapBase;
	private ObjetoOrdenado[] maxHeap;
	
	public HeapSort(){
		this.maxHeap = null;
		this.heapBase = new MaxHeap();
	}

	public ObjetoOrdenado[] getMaxHeap() {
		return maxHeap;
	}

	public void HeapSortOrdenacao(ObjetoOrdenado[] arranjo){
		this.maxHeap = new ObjetoOrdenado[20];
		this.heapBase.buildHeap(arranjo);
		maxHeap = this.heapBase.getHeap();
    	for(int i = 19; i > 0; i--){
    		ObjetoOrdenado t = maxHeap[i];
    		maxHeap[i] = maxHeap[0];
            maxHeap[0] = t;
            this.heapBase.set_qtElementos(this.heapBase.get_qtElementos() - 1);
            this.heapBase.heapfy(0);
            this.maxHeap = this.heapBase.getHeap();
    	}
    }
}
