package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Solution)) return false;
//        Solution solution = (Solution) o;
//        return Objects.equals(first, solution.first) &&
//                Objects.equals(last, solution.last);
//    }
//

//    public boolean equals(Object n) {
//        if(this == n)
//            return true;
//        if(n == null)
//            return false;
//        if( this.getClass() != n.getClass())
//            return false;
//        Solution other = (Solution) n;
//        return this.first.equals(other.first) && this.last.equals(other.last);
//    }
//
//    public int hashCode() {
//        int res = 11;
//        return 31 * res + (first == null ? 0 : first.hashCode()) + (last == null ? 0 : last.hashCode());
//    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
