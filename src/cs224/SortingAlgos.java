package cs224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAlgos {
    private void swap(List<Employee> employees, int i, int j){
        Employee temp=employees.get(i);
        employees.set(i,employees.get(j));
        employees.set(j,temp);
    } //Close swap method

    public void bubble_sort(List<Employee> employees){
        for (int i=0; i<employees.size(); i++){
            for (int j=employees.size()-1; j>i; j--){
                if (employees.get(j).getAge() < employees.get(j-1).getAge())
                {
                    swap(employees, j, j-1);
                }
            }   //inner loop
        }    //outside loop

    }//Close bubble_sort method

    public void insertion_sort(List<Employee> employees){
        for (int i=0; i <employees.size(); ++i){
            for (int j=i; j>0; --j){
                if (employees.get(j).getAge()> employees.get(j-1).getAge()){
                    break;
                }
                swap(employees, j,j-1);
            }//Close inner loop
        }//Close outside loop
    }//Close insertion_Sort method

    public void selection_sort(List<Employee> employees) {
        for (int i = 0; i < employees.size(); ++i) {
            Employee min = employees.get(i);
            int pos = i;
            for (int j = i + 1; j < employees.size(); ++j) {
                if (employees.get(j).getAge() < min.getAge()) {
                    min = employees.get(j);
                    pos = j;
                }
            }
            swap(employees, i, pos);
        }
    } //Close selection_sort

    public void quick_sort(List<Employee> employees){
        quick_sort(employees, 0, employees.size()-1);
    }//Close quick_sort method

    private void quick_sort(List<Employee> employees, int lo, int hi){
        if (lo < hi) {
            int pi = partition(employees, lo, hi);

            quick_sort(employees, lo, pi - 1);
            quick_sort(employees, pi + 1, hi);
        }
    }//Close quick_sort sub

    private int partition(List<Employee>employees, int lo, int hi){
        int pivot = employees.get(hi).getAge();
        int i = lo - 1;

        for (int j = lo; j <= hi - 1; j++) {
            if (employees.get(j).getAge() < pivot) {
                i++;
                swap(employees, i, j);
            }
        }

        swap(employees, i + 1, hi);
        return i + 1;
    }//Close partition

    //(5). Method 5: merge _sort
    public void merge_sort(List<Employee> employees){
        List<Employee> res = merge_sort(employees, 0,
                employees.size() - 1);
        for (int i = 0; i < employees.size(); ++i) {
            employees.set(i, res.get(i));
        } //Close loop
    }//Close publiic merge_sort

    private List<Employee> merge_sort(List<Employee> employees
            ,int lo, int hi){
        if (lo==hi){
            return Arrays.asList(employees.get(lo));
        }//Close if
        int mid=lo+(hi-lo)/2;
        List<Employee>   left=merge_sort(employees, lo,mid);
        List<Employee> right=merge_sort(employees, mid+1, hi);
        return merge_sort_merge(left, right);
    }//close merge_sort
    private List<Employee> merge_sort_merge(List<Employee> left,
                                            List<Employee> right) {
        List<Employee> res = new ArrayList<>();
        for (int i = 0, j = 0; i < left.size()
                || j < right.size(); ) {//Start for loop
            if (i < left.size() && j < right.size()) {//big if
                if (left.get(i).getAge() <= right.get(j).getAge()) {
                    res.add(left.get(i++));
                } else {
                    res.add(right.get(j++));
                }
            }//Close big if
            else if (i < left.size()) {
                res.add(left.get(i++));
            } else {
                res.add(right.get(j++));
            }//Close else
        }//Close for loop
        return res;
    }//Close merge_sort_merge

}  //Close class
