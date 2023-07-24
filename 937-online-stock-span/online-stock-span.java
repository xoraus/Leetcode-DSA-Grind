import java.util.Stack;

class StockSpanner {
    class StockData {
        int price;
        int index;

        StockData(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    Stack<StockData> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().index;
        }

        stack.push(new StockData(price, span));
        return span;
    }
}
