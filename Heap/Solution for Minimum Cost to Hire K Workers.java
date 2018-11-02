class Worker {
    int quality;
    int wage;
    double ratio;

    public Worker(int q, int w) {
        quality = q;
        wage = w;
        ratio = w*1.0 / q;
    }
}

class Solution {
    // O(N^2logN)
    // public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
    //     double min = 1e9;
    //     for (int i = 0; i < wage.length; i++) {
    //         double ratio = wage[i]*1.0 / quality[i];
    //         double arr[] = new double[wage.length];
    //         int idx = 0;
    //         for (int j = 0; j < quality.length; j++) {
    //             double salary = ratio * quality[j];
    //             if (salary >= wage[j]) arr[idx++] = salary;
    //         }
    //         if (idx >= K) {
    //             Arrays.sort(arr, 0, idx);
    //             double sum = 0;
    //             for (int t = 0; t < K; t++) {
    //                 sum += arr[t];
    //             }
    //             min = Math.min(min, sum);
    //         } 
    //     }
    //     return min;
    // }
    
    //    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, new Comparator<Worker>(){
            @Override
            public int compare(Worker w1, Worker w2) {
                if (w1.ratio > w2.ratio) return 1;
                else if (w1.ratio < w2.ratio) return -1;
                else return 0;
            }
        });
        Queue<Integer> Q = new PriorityQueue<>(workers.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        double min = 1e9;
        int sumq = 0;
        for (Worker worker : workers) {
            Q.offer(worker.quality);
            sumq += worker.quality;
            if (Q.size() > K) {
                sumq -= Q.poll();
            }
            if (Q.size() == K) {
                min = Math.min(min, sumq * worker.ratio);
            }
        }
        return min;
    }
}