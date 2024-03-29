package models;

import exceptions.InvalidPathNameException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {

  public static final List<Character> validNames =
      new ArrayList<Character>() {
        {
          add('A');
          add('B');
          add('C');
          add('D');
          add('E');
        }
      };

  private HashMap<Character, Edge> edges;
  private char name;

  public Node() {
    this.edges = new HashMap<>();
  }

  public Node(char name) throws InvalidPathNameException {
    this();

    if (validNames.contains(name)) {
      this.name = name;
    } else {
      throw new InvalidPathNameException("This node name is not allowed.");
    }
  }

  public void addEdge(Edge edge) throws InvalidPathNameException {
    if (pointsToItself(edge)) {
      throw new InvalidPathNameException("The node can't point to itself.");
    } else if (edgeExists(edge)) {
      throw new InvalidPathNameException("This route already exists.");
    } else {
      edges.put(edge.getDestination().getName(), edge);
    }
  }

  private boolean pointsToItself(Edge edge) {
    return this.name == edge.getDestination().getName();
  }

  private boolean edgeExists(Edge edge) {
    return edges.containsValue(edge);
  }

  public char getName() {
    return this.name;
  }

  public HashMap<Character, Edge> getEdges() {
    return this.edges;
  }

  public int getDistanceToNodeByName(char destination) throws InvalidPathNameException {
    int distance;

    if (edges.get(destination) != null) {
      distance = edges.get(destination).getLength();
    } else {
      throw new InvalidPathNameException("NO SUCH ROUTE");
    }

    return distance;
  }

  public Node getAdjacentNodeByName(char nodeName) {
    return edges.get(nodeName).getDestination();
  }
}
