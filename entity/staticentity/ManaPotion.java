package saga.progetto.tesi.entity.staticentity;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.AssetWatcher;
import playn.core.Font;
import playn.core.Image;
import saga.progetto.tesi.media.Text;

public class ManaPotion extends Potion
{
	private static final String ICON_PATH = "images/static_objects/mana_potion.png";
	private static final String TOOLTIP_PATH = "images/static_objects/tooltip.png";

	private static Image iconImage;
	private PotionType type;
	
	public ManaPotion(PotionType type, int index)
	{
		super(type, index, iconImage);
		this.type = type;
		setTooltipLayer(graphics().createImageLayer(assets().getImage(TOOLTIP_PATH)));
		getTooltipLayer().setVisible(false);
		getTooltipLayer().setDepth(7.0f);
		graphics().rootLayer().add(getTooltipLayer());
		initText();
	}
	
	public static void loadAssets(AssetWatcher watcher)
	{
		iconImage = assets().getImage(ICON_PATH);
		watcher.add(iconImage);
	}
	
	public void initText()
	{
		setTooltipText(new Text("Increase the mana by " + type.getValue(), Font.Style.PLAIN, 12, 0xFFFFFFFF));
		getTooltipText().setVisible(false);
		getTooltipText().setTranslation(TEXT_POINT.add(0.0f, index() * 30.0f));
		getTooltipText().setDepth(8.0f);
		getTooltipText().setAlpha(0.8f);
		getTooltipText().init();
	}
	
	public PotionType getPotionType()
	{
		return type;
	}

	@Override
	public void showItem(boolean visible)
	{
		super.setVisible(visible);
		hideTooltip(!visible);
	}
	
	@Override
	public float getManaAmount()
	{
		return type.getValue();
	}
	
	@Override
	public String toString()
	{
		return type.toString();
	}
}