import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album
{
    private String name;
    private String artist;
    private List<Songs> songs;

    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();

    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public List<Songs> getSongs()
    {
        return songs;
    }

    public void setSongs(List<Songs> songs)
    {
        this.songs = songs;
    }

    public boolean findSong(String title)
    {
        for(Songs s : songs)
        {
            if (s.getTitle().equals(title))
            {
                return true;
            }

        }
        return false;
    }

    public void addSongtoAlbum(String name, double duration)
    {
        Songs s = new Songs(name,duration);
        //songs.add(s);
        if (findSong(s.getTitle())==true)
        {
            System.out.println("Song is already present in album");
        }
        else
        {
            songs.add(s);
            System.out.println("New Song is Added");
        }
        return;
    }

    //Polymorphism
    public void addToPlayListFromAlbum(String title, LinkedList<Songs> playList)
    {
        if (findSong(title)==true)
        {
            for(Songs song : songs)
            {
                if (song.getTitle().equals(title))
                {
                    playList.add(song);
                    System.out.println("Song is added to your playList");
                    break;
                }
            }
        }
        else
        {
            System.out.println("Song is not present in the Album");
        }
        return;
    }

    public void addToPlayListFromAlbum(int trackNo,LinkedList<Songs> playList)
    {
         int index = trackNo-1;
         if(index>=0 && index < songs.size())
         {
            playList.add(songs.get(index));
         }
         else
         {
             System.out.println("Invalid track number");
         }
         return;
    }

}
