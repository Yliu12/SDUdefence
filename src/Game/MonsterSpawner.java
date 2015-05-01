package Game;




import monsters.Pirhana;
import monsters.TestMonster;
 public class MonsterSpawner {

//	private static Logger logger=Logger.getLogger(MonsterSpawner.class);
	double random = Math.random();
	
	public static void spawnWave(int difficulty, int ID)
	{
		if (ID==100)
			spawnWaveDifficulty100();
		else if (ID==0)
		addRandom(difficulty);
		else if(ID>=1 &&ID<=3)
			addID(difficulty, ID);
		
	
	}

	private static void addRandom(int i)
	{
		for( int n=0; n<i; n++)
		{
		double rand=	Math.random();
		if (rand<0.75)
			Game.monsterTestList.add(new TestMonster(TestMonster.getRandomSpawnLocation()));
		else 
			Game.monsterTestList.add(new Pirhana(Pirhana.getRandomSpawnLocation()));
			//Game.monsterTestList.add(new TestMonster(TestMonster.getRandomSpawnLocation()));
		}
	}
	
	private static void addID(int i, int ID)
	{
		for(int n=0; n<i; n++)
		{
		if(ID==1)
			Game.monsterTestList.add(new Pirhana(Pirhana.getRandomSpawnLocation()));
		else if (ID==2)
			Game.monsterTestList.add(new TestMonster(TestMonster.getRandomSpawnLocation()));
		
		}
	}
	private static void spawnWaveDifficulty100() {
		//if(!Game.bossList.isEmpty())
		{
			//Game.monsterTestList.add(new TestMonster(Game.bossList.get(0).getMonsterSpawnPoint()));
		}
	
	}
	
}
