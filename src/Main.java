import java.util.*;

public class Main
{
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args)
    {


       Album album1 = new Album("Moosa", "Sidhu Mossevala");
       album1.addSongtoAlbum("295",4.05);
       album1.addSongtoAlbum("LastRide",5.5);
       album1.addSongtoAlbum("So High", 3.05);

       Album album2 = new Album("Arijit's Song", "Arigit Singh");
       album2.addSongtoAlbum("Kesariya",5);
       album2.addSongtoAlbum("Jeena Jeena",4.05);
       album2.addSongtoAlbum("Gerua", 6 );

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("295"));

        LinkedList<Songs> myPlaylist = new LinkedList<>();
        album1.addToPlayListFromAlbum("295",myPlaylist);
        album2.addToPlayListFromAlbum(2,myPlaylist);
        album1.addToPlayListFromAlbum("LastRide",myPlaylist);
        album2.addToPlayListFromAlbum("Kesariya",myPlaylist);

        play(myPlaylist);


    }

    public static void play(LinkedList<Songs> playList)
    {
        Scanner sc = new Scanner(System.in);
        ListIterator<Songs> itr = playList.listIterator();

        boolean isForward = false;

        if(playList.size()>0)
        {
            System.out.print("Currently Playing: ");
            System.out.println(itr.next());
            isForward = true;
        }
        else
        {
            System.out.println("Palylist is empty");
            return;
        }
        System.out.println("Enter your Choice: ");
        printMenu();

        boolean quit = false;
        while(!quit)
        {
            int choice  = sc.nextInt();
            switch (choice)
            {
                case 1:
                    if (isForward==false)
                    {
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext())
                    {
                        System.out.println(itr.next());
                    }
                    else
                    {
                        System.out.println("You have reached the end of your PlayList");
                    }
                    break;
                case 2:
                    if (isForward==true)
                    {
                        itr.previous();
                        isForward=true;
                    }
                    if (itr.hasPrevious())
                    {
                        System.out.println(itr.previous());
                    }
                    else
                    {
                        System.out.println("you are at the Start of PlayList");
                    }
                    break;
                case 3:
                     if (isForward==true)
                     {
                         if (itr.hasPrevious())
                         {
                             System.out.println(itr.previous());
                             isForward=false;
                         }
                         else
                         {
                             System.out.println("Song doesnt exit");
                         }
                     }
                     else
                     {
                         if (itr.hasNext())
                         {
                             System.out.println(itr.next());
                             isForward=true;
                         }
                         else
                         {
                             System.out.println("Song is not present");
                         }
                     }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:

                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }

    public static void printSongs(LinkedList<Songs> playList)
    {
        for (Songs song: playList)
        {
            System.out.println(song);
            return;
        }
    }

    public static void printMenu()
    {
        //System.out.println("Select your Choice");
        System.out.println("1 - Play next Song");
        System.out.println("2 - Play Previous Song");
        System.out.println("3 - Play Current Song");
        System.out.println("4 - show Menu Again");
        System.out.println("5 - Delete the Current Song");
        System.out.println("6 - Print all the Songs in Playlist");
        System.out.println("7 - Exit");

        return;
    }
}