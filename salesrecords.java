package ���;
import java.util.*;
import java.io.*;

public class salesrecords {
	public static void main(String[] args) {
		readData();
	}
	public static void readData() {
		File infile = new File("itemData.txt");
		String itemName = new String();

		ArrayList<String> lst_item = new ArrayList<>();
		ArrayList<Integer> lst_price = new ArrayList<>();
		int amount;
		try {
			Scanner data = new Scanner(infile);
			while (data.hasNext()) {
				itemName = data.next();
				amount = data.nextInt();
				if (lst_item.contains(itemName)) {
					int I = lst_item.indexOf(itemName);
					int total = lst_price.get(I) + amount;
					lst_price.set(I, total);
				} else {
					lst_item.add(itemName);
					lst_price.add(amount);
				}
			}
			data.close();
			//OUTPUT
			System.out.println("�C�ӳf���W�٥H�θӳf���`�P��q�G");
			for (int i = 0; i < lst_item.size(); i++) {
				System.out.print(lst_item.get(i) + " ");
				System.out.println("����G" + lst_price.get(i));
				System.out.println("=============");
			}
			System.out.println("�̰��P��q�f���W�ٻP�P��q�G");
			int temp = lst_price.indexOf(MaxPrice(lst_item,lst_price));
			System.out.print(lst_item.get(temp) + " ");
			System.out.println(lst_price.get(temp));
			
			System.out.println("�̧C�P��q�f���W�ٻP�P��q�G");
			int temp2 = lst_price.indexOf(MinPrice(lst_item,lst_price));
			System.out.print(lst_item.get(temp2) + " ");
			System.out.println(lst_price.get(temp2));
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	public static int MaxPrice(ArrayList a,ArrayList b){
		ArrayList<String> A = new ArrayList<String>(a);
		ArrayList<Integer> B = new ArrayList<Integer>(b);
		int max = B.get(0);
		for (int i = 1; i < A.size(); i++) {
			if(B.get(i) > B.get(i-1)){
				max = B.get(i);
			}
		}
		return max;
	}
	public static int MinPrice(ArrayList a,ArrayList b){
		ArrayList<String> A = new ArrayList<String>(a);
		ArrayList<Integer> B = new ArrayList<Integer>(b);
		int min = B.get(0);
		for (int i = 1; i < A.size(); i++) {
			if(B.get(i) < B.get(i-1)){
				min = B.get(i);
			}
		}
		return min;
	}
}
