package net.buzzy.tutorialmod.block;

import net.buzzy.tutorialmod.TutorialMod;
import net.buzzy.tutorialmod.block.custom.SoundBlock;
import net.buzzy.tutorialmod.item.ModItems;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.http.impl.cookie.RFC2965PortAttributeHandler;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

   public static final RegistryObject<Block> SAPPHIRE_BLOCK=registerBlock("sapphire_block",
           () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

  public static final RegistryObject<Block> SAPPHIRE_ORE=registerBlock("sapphire_ore",
           () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                   .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

  public static final RegistryObject<Block> SOUND_BLOCK=registerBlock("sound_block",
           () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject <Item> registerBlockItem(String name, RegistryObject<T>block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
