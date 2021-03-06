package com.pengu.lostthaumaturgy.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Predicate;
import com.mrdimka.hammercore.bookAPI.BookCategory;
import com.mrdimka.hammercore.bookAPI.BookEntry;
import com.mrdimka.hammercore.client.utils.RenderUtil;
import com.mrdimka.hammercore.gui.book.GuiBook;
import com.mrdimka.hammercore.gui.book.GuiBookCategory;
import com.mrdimka.hammercore.gui.book.GuiBookEntry;
import com.pengu.lostthaumaturgy.LTInfo;
import com.pengu.lostthaumaturgy.api.RecipesInfuser;
import com.pengu.lostthaumaturgy.api.tiles.IInfuser;
import com.pengu.lostthaumaturgy.custom.research.Research;
import com.pengu.lostthaumaturgy.custom.research.ResearchPredicate;
import com.pengu.lostthaumaturgy.custom.thaumonomicon.BookThaumonomicon;
import com.pengu.lostthaumaturgy.custom.thaumonomicon.CategoryThaumonomicon;
import com.pengu.lostthaumaturgy.custom.thaumonomicon.EntryThaumonomicon;
import com.pengu.lostthaumaturgy.inventory.ContainerInfuserDark;
import com.pengu.lostthaumaturgy.items.ItemResearch;
import com.pengu.lostthaumaturgy.items.ItemResearch.EnumResearchItemType;
import com.pengu.lostthaumaturgy.items.ItemUpgrade;
import com.pengu.lostthaumaturgy.tile.TileInfuserDark;

public class GuiInfuserDark extends GuiContainer
{
	public final TileInfuserDark tile;
	public final ResourceLocation gui = new ResourceLocation(LTInfo.MOD_ID, "textures/gui/gui_dark_infuser.png");
	
	public GuiInfuserDark(TileInfuserDark tile, EntityPlayer player)
	{
		super(new ContainerInfuserDark(tile, player));
		this.tile = tile;
		xSize = 176;
		ySize = 240;
	}
	
	private List<String> lastTooltip = new ArrayList<>();
	private ItemStack[] currentDiscoveries = null;
	private int currentEntry = -1;
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		fontRenderer.drawString("Dark Infuser", 8, 5, 6307936);
		
		try
		{
			mouseX -= guiLeft;
			mouseY -= guiTop;
			
			if(currentDiscoveries != null)
			{
				int xStart = 80 - (currentDiscoveries.length - 1) * 8;
				
				for(int i = 0; i < currentDiscoveries.length; ++i)
				{
					GL11.glPushMatrix();
					GL11.glTranslated(0, .5, 0);
					itemRender.renderItemAndEffectIntoGUI(currentDiscoveries[i], xStart + i * 16, 36);
					GL11.glPopMatrix();
					
					if(mouseX >= xStart + i * 16 && mouseY >= 36 && mouseX < xStart + i * 16 + 16 && mouseY < 36 + 16)
					{
						lastTooltip.add(ItemResearch.getFromStack(currentDiscoveries[i]).getTitle());
						lastTooltip.add(I18n.translateToLocal("gui." + LTInfo.MOD_ID + ":click_to_read"));
					}
				}
			}
		} catch(Throwable err)
		{
		}
		
		if(!lastTooltip.isEmpty())
		{
			drawHoveringText(lastTooltip, mouseX, mouseY);
			lastTooltip.clear();
		}
		
		if(tile.getUpgrades()[0] >= 0)
		{
			int x = 8;
			int y = 128;
			ItemStack stack = new ItemStack(ItemUpgrade.byId(tile.getUpgrades()[0]));
			itemRender.renderItemAndEffectIntoGUI(stack, x, y);
			if(mouseX >= x && mouseX < x + 16 && mouseY >= y && mouseY < y + 16)
				drawHoveringText(stack.getTooltip(mc.player, false), mouseX, mouseY);
		}
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		// Reduce RAM usage, because earlier we ran through this code each
		// render tick. Now we check if the recipe has changed.
		if(tile.entry != currentEntry)
		{
			currentEntry = tile.entry;
			if(currentEntry == -1)
			{
				currentDiscoveries = null;
			} else
			{
				Predicate<IInfuser> predicate = RecipesInfuser.getPredicate(tile.entry);
				if(predicate instanceof ResearchPredicate)
				{
					ResearchPredicate pred = (ResearchPredicate) predicate;
					currentDiscoveries = pred.getResearchItems(EnumResearchItemType.DISCOVERY);
				} else
					currentDiscoveries = null;
			}
		}
		
		mc.getTextureManager().bindTexture(gui);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(tile.isCooking())
		{
			float i1 = tile.getCookProgressScaled(46);
			float i2 = tile.infuserCookTimeDark / tile.currentItemCookCostDark * 46F;
			RenderUtil.drawTexturedModalRect(guiLeft + 158, guiTop + 151 - i1, 176, 46 - i1, 6, i1);
			RenderUtil.drawTexturedModalRect(guiLeft + 164, guiTop + 151 - i2, 182, 46 - i2, 6, i2);
		}
		
		int phase = tile.getWorld().getMoonPhase();
		drawTexturedModalRect(guiLeft + 160, guiTop + 8, 188, phase * 8, 8, 8);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	{
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
		try
		{
			mouseX -= guiLeft;
			mouseY -= guiTop;
			
			if(currentDiscoveries != null)
			{
				int xStart = 80 - (currentDiscoveries.length - 1) * 8;
				
				for(int i = 0; i < currentDiscoveries.length; ++i)
					if(mouseX >= xStart + i * 16 && mouseY >= 36 && mouseX < xStart + i * 16 + 16 && mouseY < 36 + 16)
					{
						Research res = ItemResearch.getFromStack(currentDiscoveries[i]);
						
						CategoryThaumonomicon tc = null;
						EntryThaumonomicon te = null;
						
						for(BookCategory cat : BookThaumonomicon.instance.categories)
							if(cat instanceof CategoryThaumonomicon && cat.categoryId.equals(res.category))
								tc = (CategoryThaumonomicon) cat;
						
						for(BookEntry be : tc.entries)
							if(be.entryId.equals(res.uid) && be instanceof EntryThaumonomicon)
								te = (EntryThaumonomicon) be;
						
						mc.displayGuiScreen(new GuiBookEntry(new GuiBookCategory(new GuiBook(BookThaumonomicon.instance), tc), te));
					}
			}
		} catch(Throwable err)
		{
		}
	}
}