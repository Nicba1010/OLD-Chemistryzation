package nicba1010.chemistryzation.common.worldGeneration;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import nicba1010.chemistryzation.common.Chemistryzation;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {

		
		for (int i = 0; i < 24; i++) {
			int Xcoord = blockX+random.nextInt(16);
			int Ycoord = random.nextInt(68);
			int Zcoord = blockZ+random.nextInt(16);
			new WorldGenMinable(Chemistryzation.NaClBlock.blockID, random.nextInt(8)+5).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
		
		for (int i = 0; i < 12; i++) {
			int Xcoord = blockX+random.nextInt(16);
			int Ycoord = random.nextInt(68);
			int Zcoord = blockZ+random.nextInt(16);
			new WorldGenMinable(Chemistryzation.CuFeS2.blockID, random.nextInt(7)+1).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub

	}
}
