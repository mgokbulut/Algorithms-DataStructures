package Tutorial_3;

import java.util.*;

public class assignment1 {

}

class CookieList {

  Street street;

  public CookieList(Street street) {
    this.street = street;
  }

  /**
   * Prunes the street, to remove all mean people.
   * @param meanPeople - the list of mean people that will need to be removed from the array of street
   */
  public void pruneStreet(List<String> meanPeople) {
    for(int t = 0; t < street.size(); t++) {
      for(int i = 0; i < meanPeople.size(); i++) {
        if(street.getNeighbour(t) == meanPeople.get(i)) {
          street.removeNeighbour(t);
        }
      }
    }
  }

  /**
   * Turns the sparse array containing all nice people in the street into a list,
   * where each element is a House object that stores the house number and name of the inhabitant.
   * @return a list of houses with all the nice people
   */
  public List<House> listAllFriendlyHouses() {
    List<House> result = new ArrayList<>();
    for(int t = 0; t < street.size(); t++) {
      if(street.getNeighbour(t) != null) {
        result.add(new House(t, street.getNeighbour(t)));
      }
    }
    return result;
  }
}

class Street {

	  private String[] inhabitants;

	  public Street(int n) {
	    this.inhabitants = new String[n];
	  }

	  public Street(List<String> inhabitants) {
	    this.inhabitants = new String[inhabitants.size()];
	    for (int i = 0; i < inhabitants.size(); i++) {
	      this.inhabitants[i] = inhabitants.get(i);
	    }
	  }

	  public String getNeighbour(int i) throws IllegalArgumentException {
	    if (i < 0 || i >= inhabitants.length) {
	      throw new IllegalArgumentException("No neighbour at that index.");
	    }
	    return this.inhabitants[i];
	  }

	  public void removeNeighbour(int i) throws IllegalArgumentException {
	    if (i < 0 || i >= inhabitants.length) {
	      throw new IllegalArgumentException("No neighbour at that index.");
	    }
	    this.inhabitants[i] = null;
	  }

	  public void addNeighbour(int i, String neighbour) throws IllegalArgumentException {
	    if (i < 0 || i >= inhabitants.length) {
	      throw new IllegalArgumentException("No neighbour at that index.");
	    }
	    this.inhabitants[i] = neighbour;
	  }

	  public int size() {
	    return this.inhabitants.length;
	  }

	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < this.inhabitants.length; i++) {
	      sb.append(i);
	      sb.append(": ");
	      sb.append(this.inhabitants[i]);
	      sb.append("\n");
	    }
	    return sb.toString();
	  }
	}

	class House {

	  private int houseNumber;

	  private String owner;

	  public House(int houseNumber, String owner) {
	    this.houseNumber = houseNumber;
	    this.owner = owner;
	  }

	  public String toString() {
	    return this.houseNumber + ": " + owner;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || this.getClass() != o.getClass())
	      return false;
	    House house = (House) o;
	    return houseNumber == house.houseNumber && Objects.equals(owner, house.owner);
	  }
	}
