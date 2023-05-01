package market;

import datastructures.Stock;
import datastructures.StockImpl;
import domain.Agent;
import domain.producttypes.Product;
import domain.producttypes.RawMaterial;
import goods.Laptop;
import goods.RawAluminium;
import goods.RawGlass;

import java.util.Optional;

public class MarketImpl implements Market {

  private final Stock<RawGlass> newRawGlass = new StockImpl<>();
  private final Stock<RawGlass> recycledRawGlass = new StockImpl<>();
  private final Stock<RawAluminium> newRawAluminium = new StockImpl<>();
  private final Stock<RawAluminium> recycledRawAluminium = new StockImpl<>();
  private final Stock<Laptop> newLaptop = new StockImpl<>();
  private final Stock<Laptop> disposedLaptop = new StockImpl<>();

  @Override
  public void sellRawAluminium(RawAluminium item, Agent agent) {
    if (item.origin == RawMaterial.Origin.NEW)
      newRawAluminium.push(item, agent);
    else
      recycledRawAluminium.push(item, agent);
  }

  @Override
  public Optional<RawAluminium> buyRawAluminium() {
    Optional<RawAluminium> recycled = recycledRawAluminium.pop();
    return recycled.isPresent() ? recycled : newRawAluminium.pop();
  }

  @Override
  public void sellRawGlass(RawGlass item, Agent agent) {
    if (item.origin == RawMaterial.Origin.NEW)
      newRawGlass.push(item, agent);
    else
      recycledRawGlass.push(item, agent);
  }

  @Override
  public Optional<RawGlass> buyRawGlass() {
    Optional<RawGlass> recycled = recycledRawGlass.pop();
    return recycled.isPresent() ? recycled : newRawGlass.pop();
  }

  @Override
  public void sellLaptop(Laptop item, Agent agent) {
    newLaptop.push(item, agent);
  }

  @Override
  public Optional<Laptop> buyLaptop() {
    return newLaptop.pop();
  }

  @Override
  public void disposeLaptop(Laptop item, Agent agent) {
    disposedLaptop.push(item, agent);
  }

  @Override
  public Optional<Product> collectDisposedGood() {
    Optional<Laptop> laptop = disposedLaptop.pop();
    if (laptop.isEmpty())
      return Optional.empty();

    Product p = laptop.get();
    return Optional.of(p);
  }
}
