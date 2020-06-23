package Data;

import Interfaces.IDataStructure;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataSource implements IDataStructure
{
   @Override
   public List<Champion> getChampions() throws FileNotFoundException {
      return readJson();
   }

   @Override
   public Champion getRandomChampion() throws IOException
   {
      return setRandomChampion();
   }

   private List<Champion> readJson() throws FileNotFoundException
   {
      Gson g = new Gson();
      JsonReader reader = new JsonReader(new FileReader("Files/champions.json"));
      Champion[] champions = new Gson().fromJson(reader, Champion[].class);

      return Arrays.asList(champions);
   }

   private Champion setRandomChampion() throws FileNotFoundException {
      List<Champion> cList = readJson();
      Random rand = new Random();
      int iRand = rand.nextInt(cList.size());
      return cList.get(iRand);
   }
}
