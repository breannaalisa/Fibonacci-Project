public class Fibonacci {
    public static void main(String[] args) {
        // handling command line arg
        if (args.length != 2){
            throw new IllegalArgumentException("Provide 2 interger arguments");
    }
        int maxInput = 0;
        int maxTime = 0;

        try {
            maxInput = Integer.parseInt(args[0]);
            maxTime = Integer.parseInt(args[1]);   
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments must be integers.");
        }
        boolean run_recursive = true; // set flag 
        boolean run_dynamic = true;
        boolean run_closed = true;

        for (int i = 0; i <= maxInput; i++) {
        
            if (run_recursive) {
            long start_time_r = System.currentTimeMillis(); // calculate time 
            long r_result = recursive(i); // store fibonacci result
            long end_time_r = System.currentTimeMillis();
            long total_time_r = end_time_r - start_time_r;
            System.out.println("RECURSE\t" + i + "\t" + r_result + "\t" + total_time_r);
            if (total_time_r > maxTime) {
                run_recursive = false;
            }}
           
            if (run_dynamic) {
            long start_time_d = System.currentTimeMillis();
            long d_result = dynamic(i);
            long end_time_d = System.currentTimeMillis();
            long total_time_d = end_time_d - start_time_d;
            System.out.println("DYNAMIC\t" + i + "\t" + d_result + "\t" + total_time_d);

            if (total_time_d > maxTime) {
                run_dynamic = false;
            }}
            
            if (run_closed) {
            long start_time_c = System.currentTimeMillis();
            long c_result = closed(i);
            long end_time_c = System.currentTimeMillis();
            long total_time_c = end_time_c - start_time_c;
            System.out.println("CLOSED\t" + i + "\t" + c_result + "\t" + total_time_c);
            if (total_time_c > maxTime){
                run_closed = false;
            }}}

        }
    // Methods
    public static long recursive (long n) {
        if(n == 0) return 0;
        if (n == 1) return 1;
        return recursive(n - 1) + recursive(n - 2);
    }

    public static long dynamic (long n) {
       long prev = 0;
       long curr = 1;
       for (int i = 2; i <= n; i++) {
            long new_fib = prev + curr;
            prev = curr;
            curr = new_fib;
       } return curr;
    }
    public static long closed (long n) {
        double golden = ((1+ Math.sqrt(5))/2);
        // breakdown equation into parts
        double first_term = Math.pow(golden, n);
        double second_term = Math.pow(1-golden, n);
        double combine_term = (first_term - second_term)/Math.sqrt(5);

        long result = Math.round(combine_term);
        return result;

    }

    
    
}