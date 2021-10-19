import java.util.*;

public class Schedule {

    List<Order> orders;
    int view;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public void removeFromOrders(Order order){
        this.orders.remove(order);
    }

    public void sortByStartDate(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.startDate.compareTo(o2.startDate);
            }
        });
    }

    public void sortByComplexity(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.complexity - o1.complexity;
            }
        });
    }

    public void sortByWorkers(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.workers.size() - o2.workers.size();
            }
        });
    }

    public void sortByEndDate(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.endDate.compareTo(o2.endDate);
            }
        });
    }

    public void sortByPrice(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.price - o2.price;
            }
        });
    }
}
