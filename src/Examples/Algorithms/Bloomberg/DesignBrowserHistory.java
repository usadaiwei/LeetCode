package Examples.Algorithms.Bloomberg;

/*
You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 */
public class DesignBrowserHistory {
    Node node;
    Node current;

    public DesignBrowserHistory(String homepage) {
        node = new Node(homepage);
        current = node;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        node.next = newNode;
        newNode.prev = node;
        node = node.next;
    }

    public String back(int steps) {
        while (steps != 0 && node.prev != null){
            node = node.prev;
            steps--;
        }
        return node.url;
    }

    public String forward(int steps) {
        while (steps != 0 && node.next != null){
            node = node.next;
            steps--;
        }
        return node.url;
    }
}
// Make a doubly linked list
    class Node{

    public Node next;
    public Node prev;

    public String url;

    public Node(){}

    public Node(String url){
        this.url = url;
    }
}
