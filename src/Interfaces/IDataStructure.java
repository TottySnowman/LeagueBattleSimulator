package Interfaces;

import Data.Champion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IDataStructure
{
    List<Champion> getChampions() throws FileNotFoundException;
    Champion getRandomChampion() throws IOException;
}
