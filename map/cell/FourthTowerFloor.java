package saga.progetto.tesi.map.cell;

import static playn.core.PlayN.*;
import playn.core.AssetWatcher;
import playn.core.Image;
import playn.core.ImageLayer;
import saga.progetto.tesi.map.GameMap;

// un muro è una cella che non è accessibile.
public class FourthTowerFloor extends Cell 
{
	private static final String FLOOR_PATH = "images/cell/fourth_tower_floor.png";
	private static Image floorImage;
	
	private ImageLayer floorLayer;
	
	public FourthTowerFloor(float x, float y, GameMap map)
	{
		super(x, y, Material.STONE, map);
	}

	// carica gli assets della cella attraverso la classe Tile.
	public static void loadAssets(AssetWatcher watcher) 
	{
		floorImage = assets().getImage(FLOOR_PATH);
		watcher.add(floorImage);
	}
	
	// ritorna il layer associato al muro.
	@Override
	public ImageLayer getLayer()
	{
		return floorLayer;
	}
	
	// ritorna il layer associato al muro.
	@Override
	public void setLayer(ImageLayer floorLayer)
	{
		this.floorLayer = floorLayer;
	}
	
	@Override
	// ritorna il layer associato al muro.
	public Image getImage()
	{
		return floorImage;
	}
}
