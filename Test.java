public class Test{
	public static void main(String[] args) {
		Integer array[];
		array = new Integer[16];
		array[0] = 3;
		array[1] = 8;
		array[2] = 6;
		array[3] = 7;
		array[4] = 2;
		array[5] = 1;
		array[6] = 9;
		array[7] = 15;
		array[8] = 45;
		array[9] = 30;
		array[10] = 5;
		array[11] = 16;
		array[12] = 17;
		array[13] = 14;
		array[14] = 19;
		array[15] = 32;
		//Abb heap = new Abb();
		HeapDyn.heapSort(array,16);
		//System.out.println("pipipipipipipip");

		//for (int i = 0; i < 10; i++) {
			//System.out.println(array[i]);
		//}
		//for (int i = 0; i<10; i++){System.out.println(array[i]);}

	}
}
