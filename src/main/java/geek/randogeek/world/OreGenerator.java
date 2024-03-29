package geek.randogeek.world;

import java.util.Random;

import geek.randogeek.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0) {
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}

	}

	private void generateOverworld(Random random, int chunkX, int chunkY, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		generateOre(ModBlocks.CoffeeOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.CakeOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.CaramelOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.CookieOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.FriedChickenOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.FrostedCookieOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.IcecreamSandwichOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.IceOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.PopcornOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);
		generateOre(ModBlocks.WaffleOre.getDefaultState(), world, random, chunkX * 16, chunkY * 16, 5, 100,
				1 + random.nextInt(16), 10);

	}

	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size,
			int chances) {
		int deltaY = maxY - minY;

		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}

}
