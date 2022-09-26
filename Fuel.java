import java.security.Principal;

public class Fuel {

  private int fuelCount;
  private int addValue;

  public Fuel(){
    this.fuelCount = 100;
  }

  public String printFuel(){
    return "  ||  Combustivel: " + fuelCount + "%";
  }

  public void reduceFuel(){
    int minValue = 5;
    int maxValue = 15;

    int randomValue = (int)Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);

    fuelCount -= randomValue;

    if(fuelCount < 0){
      fuelCount = 0;
    }
  }

  public void addFuel(){
    int minValue = 5;
    int maxValue = 15;

    int randomValue = (int)Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);

    addValue = randomValue;

    fuelCount += randomValue;

    if(fuelCount > 100){
      fuelCount = 100;
    }
  }

  public int valueAcc(){
    return addValue;
  }

  public void upRoomStats(Room currentRoom){
    currentRoom.upRoom();
  }

  public int getFuel(){
    return fuelCount;
  }
  
}
