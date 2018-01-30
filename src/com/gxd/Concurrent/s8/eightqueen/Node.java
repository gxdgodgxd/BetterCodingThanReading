package com.gxd.Concurrent.s8.eightqueen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxdgodgxd on 18/1/26.
 */
public class Node<P, M> {
    final P pos;
    final M move;
    final Node<P, M> prev;

    public Node(P pos, M move, Node<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<P> ps = asPosList();
        for (int i = ps.size() - 1; i >= 0; i--) {
            sb.append(ps.get(i).toString());
            sb.append("->");
        }
        return sb.toString();
    }

    public List<P> asPosList() {
        ArrayList<P> list = new ArrayList<>();
        Node node = this;
        while (node != null) {
            list.add((P) node.pos);
            node = node.prev;
        }
        //移除起始dummy节点坐标
        list.remove(list.size() - 1);
        return list;
    }

}
