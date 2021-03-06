package saga.progetto.tesi.map.cell;

import static playn.core.PlayN.*;
import playn.core.AssetWatcher;
import playn.core.Image;
import playn.core.ImageLayer;
import saga.progetto.tesi.map.GameMap;

// un muro è una cella che non è accessibile.
public class TenthTowerWall extends Wall 
{
	private static final String WALL_PATH = "images/cell/third_tower_wall.png";
	private static Image wallImage;
	
	private ImageLayer wallLayer;
	
	public TenthTowerWall(float x, float y, GameMap map)
	{
		this(x, y, map, false);
	}
	
	public TenthTowerWall(float x, float y, GameMap map, boolean isHiddenPath)
	{
		super(x, y, Material.STONE, map, isHiddenPath);
	}
	
	// carica gli assets della cella attraverso la classe Tile.
	public static void loadAssets(AssetWatcher watcher) 
	{
		wallImage = assets().getImage(WALL_PATH);
		watcher.add(wallImage);
	}
	
	// ritorna il layer associato al muro.
	@Override
	public ImageLayer getLayer()
	{
		return wallLayer;
	}
	
	// ritorna il layer associato al muro.
	@Override
	public void setLayer(ImageLayer wallLayer)
	{
		this.wallLayer = wallLayer;
	}
	
	@Override
	// ritorna il layer associato al muro.
	public Image getImage()
	{
		return wallImage;
	}
}
