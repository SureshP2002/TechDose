//TC-O(logN)using list//TC-O(N) using array
//approach-top down (percolate down)

package heappop;
import java.util.*;


public class HeapPop {

    static void Heapify(List<Integer> l,int i)
    {
        int lar=i;
        int L=2*i;
        int r=2*i+1;
        if(L>=l.size()||r>=l.size()) return ;
           if(L<l.size()&&l.get(L)>l.get(lar))lar=L;
           if(r<l.size()&&l.get(r)>l.get(lar))lar=r;
           if(lar!=i)
           {
               Collections.swap(l, i, lar);
               Heapify(l,lar);
           }
    }
    
    static int  HeapPOP(List<Integer> l)
    {
        int n=l.size();//finding size
        int max=l.get(1);//keepinf max as curr index
        l.set(1,l.get(n-1));//swaping curr index with last element
        l.remove(n-1);//removing the last element
        Heapify(l,1);//funcion call
        return max;//max found
    }
    
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       List<Integer> l=new ArrayList<>();//creating an list
       l.add(0);
       l.add(17);//adding elements
       l.add(15);
       l.add(13);
       l.add(9);
       l.add(6);
       l.add(5);
       l.add(10);
       l.add(4);
       l.add(8);
       l.add(3);
       l.add(1);
       System.out.println(l);
       System.out.println(HeapPOP(l));
       
       
    }
    
}
