package sort;

/**
 * @Classname MaxPQ
 * @Description 基于堆的优先队列
 * @Date 2019/7/6 7:59
 * @Created by xww
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0 ;
    }

    private void exch(int i,int j){
        Key t =pq[i];
        pq[i] = pq[j];
        pq[j]  = t;
    }


    public MaxPQ(int maxN) {
        this.pq = (Key[])new Comparable[maxN +1];
    }

    private void swim(int k){
        while(k>1 && less(k,k/2)){
            exch(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(k*2 <= N){
            int j= k*2;
            if(j<N && less(j,j+1)){
                j = j+1;
            }
            if(!less(k,j)){
                break;
            }
            exch(k,j);
            k = j;
        }
    }



    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];// 从根节点得到最大的元素
        exch(1, N--);// 将其和最后一个元素交换
        pq[N + 1] = null;// 防止对象游离
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void show(){
        for(int i=1;i<=N;i++){
            System.out.println(pq[i]);
        }
    }

    public static void main(String[] args) {
        MaxPQ<Integer> mPq = new MaxPQ<Integer>(10);
        mPq.insert(4);
        mPq.insert(100);
        mPq.insert(0);
        mPq.insert(99);
//        mPq.show();

        while (!mPq.isEmpty()) {
            System.out.println(mPq.delMax());
        }
    }

}
