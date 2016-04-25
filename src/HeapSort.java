
public class HeapSort {

	public static ObjetoOrdenado[] HeapSort (ObjetoOrdenado[] arranjo){
		Heap hp1 = new MaxHeap();
		ObjetoOrdenado[] maxHeap = new ObjetoOrdenado[20];
		hp1.buildHeap(arranjo);
		maxHeap = hp1.getHeap();
    	for(int i = 19; i > 0; i--){
    		ObjetoOrdenado t = maxHeap[i];
    		maxHeap[i] = maxHeap[0];
            maxHeap[0] = t;
            hp1.set_qtElementos(hp1.get_qtElementos() - 1);
            hp1.heapfy(0);
            maxHeap = hp1.getHeap();
    	}
    	return maxHeap;
    }
}
