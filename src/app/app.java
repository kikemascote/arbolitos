package app;

import tree.btree;

public class app {

    public static void main(String[] args)throws Exception {
        btree<Integer> num = new btree<>();

 //       for (int i = 0; i < 1000; i++) {
   //         num.add((int) (Math.random() * 1000)+1);
     //   }

//        while (num.remove(10)) ;

//        num.PrintInorder();


        num.add(40);
        num.add(20);
        num.add(10);
        num.add(30);
        num.add(60);
        num.add(50);
        num.add(70);

        System.out.println(num.MaxDepth());
		System.out.println(num.breadthSearch(50).getValue());
//		num.PrintPostOrder();
//		num.PrintPreOrder();
//		num.PrintInorder();
//		num.Clear();
    }

}
