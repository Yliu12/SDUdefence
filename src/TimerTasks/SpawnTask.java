package TimerTasks;
import java.util.TimerTask;
import Game.Game;
import Game.MonsterSpawner;
public class SpawnTask extends TimerTask {

	@Override
	public void run() {
		if (Game.phase==1)
		{
			MonsterSpawner.spawnWave(1, 0);
		}
	}
}
