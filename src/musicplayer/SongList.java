/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicplayer;

import java.io.File;


class Node{
    
    File songPath;
    String songName;
    Node prevNode;
    Node nextNode;
    
}

public class SongList extends Node {
    
    Node head=null;
    Node tail=null;
    int count=0;
    
    public File getSong(){
        System.out.println(this.head.songPath);
        System.out.println(this.head.songName);
        return this.tail.songPath;
        
    }
     public void insertFirst(File songPath,String songName)//insert song to the front of the list
     {
        if (head == null) {
            Node newNode = new Node();  

            newNode.songPath = songPath;
            newNode.songName=songName;
             

            head = newNode;
            tail = newNode;
        } else {
            Node newNode = new Node(); //new node

            newNode.songPath = songPath;
            newNode.songName=songName;

            head.prevNode = newNode;
            newNode.nextNode = head;

            head = newNode; //transfer head to new node
            head.prevNode = tail; //linking first node to last node's previous_node

        }
    }
     public void insertLast(File songPath,String songName) //Adding a node at end of the linked list
    {
        if (head == null) //if there is no node
        {
            Node newNode = new Node();
            newNode.songPath = songPath;
            newNode.songName=songName;

            head = newNode;
            tail = newNode;
            
            head.nextNode=head=newNode;
            head.prevNode=head=newNode;
            
            count++;
        } else {
        
            Node newNode = new Node();

            newNode.songPath = songPath;
            newNode.songName=songName;

            tail.nextNode = newNode;
            newNode.prevNode = tail;

            tail = newNode;
            tail.nextNode = head;
            head.prevNode=tail;
            count++;
        }
    } 
    
    
    public void display(){
        if(head!=null){
            Node currentNode=head;
           while(currentNode.nextNode!=head){
                
                currentNode=currentNode.nextNode;
            }
            System.out.println(currentNode.songName);
        }else{
            System.out.println("Linked list is empty");
        }

    }
    
    public File playNextSong(File currentSongPath){
        File nextSongPath=null;
         
        if(head!=null){
           
           Node currentNode=head;
           //Node lastNode=tail;
           
           while(true){
                      
                if(currentNode.songPath==currentSongPath){
                    nextSongPath=currentNode.nextNode.songPath;
                    currentNode=currentNode.nextNode;
                     
                    break;
                    
                }
                 currentNode=currentNode.nextNode;
                
            }
           
        }else{
            System.out.println("Linked list is empty");
        }
        
        return nextSongPath;
    }
    public File playPreviousSong(File currentSongPath){
        File previousSongPath=null;
      
        if(head!=null){
           
            Node currentNode=head;
            while(true){
                 
                
                if(currentNode.songPath==currentSongPath){
                    //System.out.println("Donr");
                    previousSongPath=currentNode.prevNode.songPath;
                    currentNode=currentNode.nextNode;
                     
                    break;
                    
                }
                currentNode=currentNode.nextNode;
                
            }
            
        }else{
            System.out.println("Linked List is empty");
        }
        return previousSongPath;
    }
    
    public int deleteFromBegining(){
    
        if (head == null) {
            return 0;
        } else {
            if (head == tail) {
                head = tail = null;
                count--;
            } else {
                head = head.nextNode;
                head.prevNode = tail;
                tail.nextNode = head;
                count--;
            }
            
            return 1;
        }
    }
    
    public int deleteFromEnd(){
        if (head == null)
        {
            return 0;
        } else {
            if (head == tail) {
                head = tail = null;
                count--;
            } else {
                tail = tail.prevNode;
                tail.nextNode = head;
                count--;
            }
            return 1;
        }
    
    }
    
   /* public File[] getAllNodes(){
        File[] songList={};
        if(head!=null){
            Node currentNode=head;
           while(currentNode.nextNode!=null){
                songList[1]=currentNode.songPath;
                currentNode=currentNode.nextNode;
            }
            System.out.println(currentNode.songPath);
        }else{
            System.out.println("Linked list is empty");
        }
        
    }*/
    
    public void getCountOfAllSongs(){
        
        System.out.println("Number Of Songs"+count);
    }
    public File[] getSortedSongListPath(){
        int run=0;
        
        File[] sortedSongPath= new File[count];
        if(head!=null){
           Node currentNode=head;
           //System.out.println("Current Node :"+currentNode.songName);
           while(currentNode.nextNode!=head){
               
                if(run!=count){
                   
                    sortedSongPath[run]=currentNode.songPath;
                   // System.out.println("Done ;"+sortedSongPath[run]);
                    run++;
                }
                
                currentNode=currentNode.nextNode;
           }
           sortedSongPath[count-1]=currentNode.songPath;
           //System.out.println("Done ;"+sortedSongPath[count-1]);
           
            
        }else{
            System.out.println("Linked list is empty");
        }
       
        return sortedSongPath;
    }
    public String[] getSortedSongListName(){
        int run=0;
        String[] sortedSongName= new String[count];
        if(head!=null){
           Node currentNode=head;
           while(currentNode.nextNode!=head){
               
                if(run!=count){
                   
                    sortedSongName[run]=currentNode.songName;
                    //System.out.println("Done ;"+sortedSongPath[run]);
                    run++;
                }
                
                currentNode=currentNode.nextNode;
           }
           sortedSongName[count-1]=currentNode.songName;
           //System.out.println("Done ;"+sortedSongPath[count-1]);
           
            
        }else{
            System.out.println("Linked list is empty");
        }
       
        return sortedSongName;
    
    }
    
    public void sort(int order)
    {
        //String nextNodeFirstLetter,currentNodeFirstLetter;
        int count = 1;
        Node countNode = head;
        while (countNode != tail) //Find the number of songs in the CircularDoublyLinkedList
        {
            countNode = countNode.nextNode;
            count++;
        }
        for (int counter = 1; counter <= count; counter++) //Number of rounds for songs
        {
            Node currentNode = head;
            char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

            for (int x = 1; x < count; x++) // Loop for each song
            {
                int currentNodeLetterVal = 0;
                int nextNodeLetterVal = 0;

                Node nextNode = currentNode.nextNode;

                char currentNodeFirstLetter = Character.toUpperCase(currentNode.songName.charAt(0));
                char nextNodeFirstLetter = Character.toUpperCase(nextNode.songName.charAt(0));

                for (int no = 0; no < 26; no++) // Find the number
                {
                    if (currentNodeFirstLetter == letters[no]) {
                        currentNodeLetterVal = no;
                    }
                    if (nextNodeFirstLetter == letters[no]) {
                        nextNodeLetterVal = no;
                    }
                }
                if (order == 0) {
                    if (currentNodeLetterVal > nextNodeLetterVal) //comapre number of first song's first letter and next song's first letter (A-Z)
                    {
                        Node tempCurrentNode = new Node();
                        Node tempNextNode = new Node();

                        tempCurrentNode.songName = currentNode.songName;// Storing node's values in temp Nodes
                        tempCurrentNode.songPath = currentNode.songPath;
                        tempNextNode.songName = nextNode.songName;
                        tempNextNode.songPath = nextNode.songPath;

                        currentNode.songName = tempNextNode.songName;//Swap
                        currentNode.songPath = tempNextNode.songPath;
                        nextNode.songName = tempCurrentNode.songName;
                        nextNode.songPath = tempCurrentNode.songPath;
                    }
                } else if (order == 1) {
                    if (currentNodeLetterVal < nextNodeLetterVal) //comapre number of first song's first letter and next song's first letter (Z - A)
                    {
                        Node tempCurrentNode = new Node();
                        Node tempNextNode = new Node();

                        tempCurrentNode.songName = currentNode.songName;// Storing node's values in temp Nodes
                        tempCurrentNode.songPath = currentNode.songPath;
                        tempNextNode.songName = nextNode.songName;
                        tempNextNode.songPath = nextNode.songPath;

                        currentNode.songName = tempNextNode.songName;//Swap
                        currentNode.songPath = tempNextNode.songPath;
                        nextNode.songName = tempCurrentNode.songName;
                        nextNode.songPath = tempCurrentNode.songPath;
                    }
                }
                currentNode = currentNode.nextNode; //go to next song
            }
        }
    }
    
    public void deleteAllSongs(){
        tail=head=null;
        
    }
    public int deleteSongToGivenSongPath(File songPathToDelete){
        int returnVal=0;
        Node nodeToDelete=null;
        if(head!=null){
           
            Node currentNode=head;
            while(true){
                 
                
                if(currentNode.songPath==songPathToDelete){
                    
                    nodeToDelete=currentNode;
                    
                    nodeToDelete.prevNode.nextNode=currentNode.nextNode;
                    currentNode.nextNode.prevNode=currentNode.prevNode;
                    
                    //currentNode=currentNode.nextNode;
                    returnVal=1;
                    break;
                     
                    
                    
                }
                currentNode=currentNode.nextNode;
                
            }
            
        }else{
            System.out.println("Linked List is empty");
        }
        return returnVal;
    }
    
    
    
}
