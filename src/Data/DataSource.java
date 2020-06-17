package Data;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataSource
{
   public List<Champion> readJson() throws IOException
   {
      Gson g = new Gson();
      JsonReader reader = new JsonReader(new FileReader("Files/champions.json"));
      Champion[] champions = new Gson().fromJson(reader, Champion[].class);

      return Arrays.asList(champions);
   }

   public Champion randomChamp() throws IOException
   {
      List<Champion> cList = readJson();
      Random rand = new Random();
      int iRand = rand.nextInt(cList.size());
      return cList.get(iRand);
   }
}
